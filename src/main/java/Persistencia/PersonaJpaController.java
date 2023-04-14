/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Placa;
import Entidades.Vehiculo;
import Entidades.exceptions.NonexistentEntityException;
import Entidades.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public class PersonaJpaController implements Serializable {

    public PersonaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Persona persona) {
        if (persona.getLicencias() == null) {
            persona.setLicencias(new ArrayList<Licencia>());
        }
        if (persona.getVehiculos() == null) {
            persona.setVehiculos(new ArrayList<Vehiculo>());
        }
        if (persona.getPlacas() == null) {
            persona.setPlacas(new ArrayList<Placa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Licencia> attachedLicencias = new ArrayList<Licencia>();
            for (Licencia licenciasLicenciaToAttach : persona.getLicencias()) {
                licenciasLicenciaToAttach = em.getReference(licenciasLicenciaToAttach.getClass(), licenciasLicenciaToAttach.getId());
                attachedLicencias.add(licenciasLicenciaToAttach);
            }
            persona.setLicencias(attachedLicencias);
            List<Vehiculo> attachedVehiculos = new ArrayList<Vehiculo>();
            for (Vehiculo vehiculosVehiculoToAttach : persona.getVehiculos()) {
                vehiculosVehiculoToAttach = em.getReference(vehiculosVehiculoToAttach.getClass(), vehiculosVehiculoToAttach.getId());
                attachedVehiculos.add(vehiculosVehiculoToAttach);
            }
            persona.setVehiculos(attachedVehiculos);
            List<Placa> attachedPlacas = new ArrayList<Placa>();
            for (Placa placasPlacaToAttach : persona.getPlacas()) {
                placasPlacaToAttach = em.getReference(placasPlacaToAttach.getClass(), placasPlacaToAttach.getId());
                attachedPlacas.add(placasPlacaToAttach);
            }
            persona.setPlacas(attachedPlacas);
            em.persist(persona);
            for (Licencia licenciasLicencia : persona.getLicencias()) {
                Persona oldPersonaOfLicenciasLicencia = licenciasLicencia.getPersona();
                licenciasLicencia.setPersona(persona);
                licenciasLicencia = em.merge(licenciasLicencia);
                if (oldPersonaOfLicenciasLicencia != null) {
                    oldPersonaOfLicenciasLicencia.getLicencias().remove(licenciasLicencia);
                    oldPersonaOfLicenciasLicencia = em.merge(oldPersonaOfLicenciasLicencia);
                }
            }
            for (Vehiculo vehiculosVehiculo : persona.getVehiculos()) {
                Persona oldPersonaOfVehiculosVehiculo = vehiculosVehiculo.getPersona();
                vehiculosVehiculo.setPersona(persona);
                vehiculosVehiculo = em.merge(vehiculosVehiculo);
                if (oldPersonaOfVehiculosVehiculo != null) {
                    oldPersonaOfVehiculosVehiculo.getVehiculos().remove(vehiculosVehiculo);
                    oldPersonaOfVehiculosVehiculo = em.merge(oldPersonaOfVehiculosVehiculo);
                }
            }
            for (Placa placasPlaca : persona.getPlacas()) {
                Persona oldPersonaOfPlacasPlaca = placasPlaca.getPersona();
                placasPlaca.setPersona(persona);
                placasPlaca = em.merge(placasPlaca);
                if (oldPersonaOfPlacasPlaca != null) {
                    oldPersonaOfPlacasPlaca.getPlacas().remove(placasPlaca);
                    oldPersonaOfPlacasPlaca = em.merge(oldPersonaOfPlacasPlaca);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Persona persona) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona persistentPersona = em.find(Persona.class, persona.getId());
            List<Licencia> licenciasOld = persistentPersona.getLicencias();
            List<Licencia> licenciasNew = persona.getLicencias();
            List<Vehiculo> vehiculosOld = persistentPersona.getVehiculos();
            List<Vehiculo> vehiculosNew = persona.getVehiculos();
            List<Placa> placasOld = persistentPersona.getPlacas();
            List<Placa> placasNew = persona.getPlacas();
            List<Licencia> attachedLicenciasNew = new ArrayList<Licencia>();
            for (Licencia licenciasNewLicenciaToAttach : licenciasNew) {
                licenciasNewLicenciaToAttach = em.getReference(licenciasNewLicenciaToAttach.getClass(), licenciasNewLicenciaToAttach.getId());
                attachedLicenciasNew.add(licenciasNewLicenciaToAttach);
            }
            licenciasNew = attachedLicenciasNew;
            persona.setLicencias(licenciasNew);
            List<Vehiculo> attachedVehiculosNew = new ArrayList<Vehiculo>();
            for (Vehiculo vehiculosNewVehiculoToAttach : vehiculosNew) {
                vehiculosNewVehiculoToAttach = em.getReference(vehiculosNewVehiculoToAttach.getClass(), vehiculosNewVehiculoToAttach.getId());
                attachedVehiculosNew.add(vehiculosNewVehiculoToAttach);
            }
            vehiculosNew = attachedVehiculosNew;
            persona.setVehiculos(vehiculosNew);
            List<Placa> attachedPlacasNew = new ArrayList<Placa>();
            for (Placa placasNewPlacaToAttach : placasNew) {
                placasNewPlacaToAttach = em.getReference(placasNewPlacaToAttach.getClass(), placasNewPlacaToAttach.getId());
                attachedPlacasNew.add(placasNewPlacaToAttach);
            }
            placasNew = attachedPlacasNew;
            persona.setPlacas(placasNew);
            persona = em.merge(persona);
            for (Licencia licenciasOldLicencia : licenciasOld) {
                if (!licenciasNew.contains(licenciasOldLicencia)) {
                    licenciasOldLicencia.setPersona(null);
                    licenciasOldLicencia = em.merge(licenciasOldLicencia);
                }
            }
            for (Licencia licenciasNewLicencia : licenciasNew) {
                if (!licenciasOld.contains(licenciasNewLicencia)) {
                    Persona oldPersonaOfLicenciasNewLicencia = licenciasNewLicencia.getPersona();
                    licenciasNewLicencia.setPersona(persona);
                    licenciasNewLicencia = em.merge(licenciasNewLicencia);
                    if (oldPersonaOfLicenciasNewLicencia != null && !oldPersonaOfLicenciasNewLicencia.equals(persona)) {
                        oldPersonaOfLicenciasNewLicencia.getLicencias().remove(licenciasNewLicencia);
                        oldPersonaOfLicenciasNewLicencia = em.merge(oldPersonaOfLicenciasNewLicencia);
                    }
                }
            }
            for (Vehiculo vehiculosOldVehiculo : vehiculosOld) {
                if (!vehiculosNew.contains(vehiculosOldVehiculo)) {
                    vehiculosOldVehiculo.setPersona(null);
                    vehiculosOldVehiculo = em.merge(vehiculosOldVehiculo);
                }
            }
            for (Vehiculo vehiculosNewVehiculo : vehiculosNew) {
                if (!vehiculosOld.contains(vehiculosNewVehiculo)) {
                    Persona oldPersonaOfVehiculosNewVehiculo = vehiculosNewVehiculo.getPersona();
                    vehiculosNewVehiculo.setPersona(persona);
                    vehiculosNewVehiculo = em.merge(vehiculosNewVehiculo);
                    if (oldPersonaOfVehiculosNewVehiculo != null && !oldPersonaOfVehiculosNewVehiculo.equals(persona)) {
                        oldPersonaOfVehiculosNewVehiculo.getVehiculos().remove(vehiculosNewVehiculo);
                        oldPersonaOfVehiculosNewVehiculo = em.merge(oldPersonaOfVehiculosNewVehiculo);
                    }
                }
            }
            for (Placa placasOldPlaca : placasOld) {
                if (!placasNew.contains(placasOldPlaca)) {
                    placasOldPlaca.setPersona(null);
                    placasOldPlaca = em.merge(placasOldPlaca);
                }
            }
            for (Placa placasNewPlaca : placasNew) {
                if (!placasOld.contains(placasNewPlaca)) {
                    Persona oldPersonaOfPlacasNewPlaca = placasNewPlaca.getPersona();
                    placasNewPlaca.setPersona(persona);
                    placasNewPlaca = em.merge(placasNewPlaca);
                    if (oldPersonaOfPlacasNewPlaca != null && !oldPersonaOfPlacasNewPlaca.equals(persona)) {
                        oldPersonaOfPlacasNewPlaca.getPlacas().remove(placasNewPlaca);
                        oldPersonaOfPlacasNewPlaca = em.merge(oldPersonaOfPlacasNewPlaca);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = persona.getId();
                if (findPersona(id) == null) {
                    throw new NonexistentEntityException("The persona with id " + id + " no longer exists.");
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
            Persona persona;
            try {
                persona = em.getReference(Persona.class, id);
                persona.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The persona with id " + id + " no longer exists.", enfe);
            }
            List<Licencia> licencias = persona.getLicencias();
            for (Licencia licenciasLicencia : licencias) {
                licenciasLicencia.setPersona(null);
                licenciasLicencia = em.merge(licenciasLicencia);
            }
            List<Vehiculo> vehiculos = persona.getVehiculos();
            for (Vehiculo vehiculosVehiculo : vehiculos) {
                vehiculosVehiculo.setPersona(null);
                vehiculosVehiculo = em.merge(vehiculosVehiculo);
            }
            List<Placa> placas = persona.getPlacas();
            for (Placa placasPlaca : placas) {
                placasPlaca.setPersona(null);
                placasPlaca = em.merge(placasPlaca);
            }
            em.remove(persona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Persona> findPersonaEntities() {
        return findPersonaEntities(true, -1, -1);
    }

    public List<Persona> findPersonaEntities(int maxResults, int firstResult) {
        return findPersonaEntities(false, maxResults, firstResult);
    }

    private List<Persona> findPersonaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Persona.class));
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

    public Persona findPersona(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Persona.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersonaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Persona> rt = cq.from(Persona.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
