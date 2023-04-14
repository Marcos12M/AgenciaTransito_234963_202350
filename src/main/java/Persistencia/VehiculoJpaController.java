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
public class VehiculoJpaController implements Serializable {

    public VehiculoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vehiculo vehiculo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Placa placa = vehiculo.getPlaca();
            if (placa != null) {
                placa = em.getReference(placa.getClass(), placa.getId());
                vehiculo.setPlaca(placa);
            }
            Persona persona = vehiculo.getPersona();
            if (persona != null) {
                persona = em.getReference(persona.getClass(), persona.getId());
                vehiculo.setPersona(persona);
            }
            em.persist(vehiculo);
            if (placa != null) {
                Vehiculo oldVehiculoOfPlaca = placa.getVehiculo();
                if (oldVehiculoOfPlaca != null) {
                    oldVehiculoOfPlaca.setPlaca(null);
                    oldVehiculoOfPlaca = em.merge(oldVehiculoOfPlaca);
                }
                placa.setVehiculo(vehiculo);
                placa = em.merge(placa);
            }
            if (persona != null) {
                persona.getVehiculos().add(vehiculo);
                persona = em.merge(persona);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vehiculo vehiculo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vehiculo persistentVehiculo = em.find(Vehiculo.class, vehiculo.getId());
            Placa placaOld = persistentVehiculo.getPlaca();
            Placa placaNew = vehiculo.getPlaca();
            Persona personaOld = persistentVehiculo.getPersona();
            Persona personaNew = vehiculo.getPersona();
            if (placaNew != null) {
                placaNew = em.getReference(placaNew.getClass(), placaNew.getId());
                vehiculo.setPlaca(placaNew);
            }
            if (personaNew != null) {
                personaNew = em.getReference(personaNew.getClass(), personaNew.getId());
                vehiculo.setPersona(personaNew);
            }
            vehiculo = em.merge(vehiculo);
            if (placaOld != null && !placaOld.equals(placaNew)) {
                placaOld.setVehiculo(null);
                placaOld = em.merge(placaOld);
            }
            if (placaNew != null && !placaNew.equals(placaOld)) {
                Vehiculo oldVehiculoOfPlaca = placaNew.getVehiculo();
                if (oldVehiculoOfPlaca != null) {
                    oldVehiculoOfPlaca.setPlaca(null);
                    oldVehiculoOfPlaca = em.merge(oldVehiculoOfPlaca);
                }
                placaNew.setVehiculo(vehiculo);
                placaNew = em.merge(placaNew);
            }
            if (personaOld != null && !personaOld.equals(personaNew)) {
                personaOld.getVehiculos().remove(vehiculo);
                personaOld = em.merge(personaOld);
            }
            if (personaNew != null && !personaNew.equals(personaOld)) {
                personaNew.getVehiculos().add(vehiculo);
                personaNew = em.merge(personaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vehiculo.getId();
                if (findVehiculo(id) == null) {
                    throw new NonexistentEntityException("The vehiculo with id " + id + " no longer exists.");
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
            Vehiculo vehiculo;
            try {
                vehiculo = em.getReference(Vehiculo.class, id);
                vehiculo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vehiculo with id " + id + " no longer exists.", enfe);
            }
            Placa placa = vehiculo.getPlaca();
            if (placa != null) {
                placa.setVehiculo(null);
                placa = em.merge(placa);
            }
            Persona persona = vehiculo.getPersona();
            if (persona != null) {
                persona.getVehiculos().remove(vehiculo);
                persona = em.merge(persona);
            }
            em.remove(vehiculo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vehiculo> findVehiculoEntities() {
        return findVehiculoEntities(true, -1, -1);
    }

    public List<Vehiculo> findVehiculoEntities(int maxResults, int firstResult) {
        return findVehiculoEntities(false, maxResults, firstResult);
    }

    private List<Vehiculo> findVehiculoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vehiculo.class));
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

    public Vehiculo findVehiculo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vehiculo.class, id);
        } finally {
            em.close();
        }
    }

    public int getVehiculoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vehiculo> rt = cq.from(Vehiculo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
