/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Persona;
import Entidades.Placa;
import Entidades.Vehiculo;
import Entidades.exceptions.NonexistentEntityException;
import Entidades.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public class PlacaJpaController implements Serializable {

    public PlacaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Placa placa) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona persona = placa.getPersona();
            if (persona != null) {
                persona = em.getReference(persona.getClass(), persona.getId());
                placa.setPersona(persona);
            }
            Vehiculo vehiculo = placa.getVehiculo();
            if (vehiculo != null) {
                vehiculo = em.getReference(vehiculo.getClass(), vehiculo.getId());
                placa.setVehiculo(vehiculo);
            }
            em.persist(placa);
            if (persona != null) {
                persona.getPlacas().add(placa);
                persona = em.merge(persona);
            }
            if (vehiculo != null) {
                Placa oldPlacaOfVehiculo = vehiculo.getPlaca();
                if (oldPlacaOfVehiculo != null) {
                    oldPlacaOfVehiculo.setVehiculo(null);
                    oldPlacaOfVehiculo = em.merge(oldPlacaOfVehiculo);
                }
                vehiculo.setPlaca(placa);
                vehiculo = em.merge(vehiculo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Placa placa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Placa persistentPlaca = em.find(Placa.class, placa.getId());
            Persona personaOld = persistentPlaca.getPersona();
            Persona personaNew = placa.getPersona();
            Vehiculo vehiculoOld = persistentPlaca.getVehiculo();
            Vehiculo vehiculoNew = placa.getVehiculo();
            if (personaNew != null) {
                personaNew = em.getReference(personaNew.getClass(), personaNew.getId());
                placa.setPersona(personaNew);
            }
            if (vehiculoNew != null) {
                vehiculoNew = em.getReference(vehiculoNew.getClass(), vehiculoNew.getId());
                placa.setVehiculo(vehiculoNew);
            }
            placa = em.merge(placa);
            if (personaOld != null && !personaOld.equals(personaNew)) {
                personaOld.getPlacas().remove(placa);
                personaOld = em.merge(personaOld);
            }
            if (personaNew != null && !personaNew.equals(personaOld)) {
                personaNew.getPlacas().add(placa);
                personaNew = em.merge(personaNew);
            }
            if (vehiculoOld != null && !vehiculoOld.equals(vehiculoNew)) {
                vehiculoOld.setPlaca(null);
                vehiculoOld = em.merge(vehiculoOld);
            }
            if (vehiculoNew != null && !vehiculoNew.equals(vehiculoOld)) {
                Placa oldPlacaOfVehiculo = vehiculoNew.getPlaca();
                if (oldPlacaOfVehiculo != null) {
                    oldPlacaOfVehiculo.setVehiculo(null);
                    oldPlacaOfVehiculo = em.merge(oldPlacaOfVehiculo);
                }
                vehiculoNew.setPlaca(placa);
                vehiculoNew = em.merge(vehiculoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = placa.getId();
                if (findPlaca(id) == null) {
                    throw new NonexistentEntityException("The placa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Placa placa;
            try {
                placa = em.getReference(Placa.class, id);
                placa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The placa with id " + id + " no longer exists.", enfe);
            }
            Persona persona = placa.getPersona();
            if (persona != null) {
                persona.getPlacas().remove(placa);
                persona = em.merge(persona);
            }
            Vehiculo vehiculo = placa.getVehiculo();
            if (vehiculo != null) {
                vehiculo.setPlaca(null);
                vehiculo = em.merge(vehiculo);
            }
            em.remove(placa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Placa> findPlacaEntities() {
        return findPlacaEntities(true, -1, -1);
    }

    public List<Placa> findPlacaEntities(int maxResults, int firstResult) {
        return findPlacaEntities(false, maxResults, firstResult);
    }

    private List<Placa> findPlacaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Placa.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Placa findPlaca(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Placa.class, id);
        } finally {
            em.close();
        }
    }

    public int getPlacaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Placa> rt = cq.from(Placa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
