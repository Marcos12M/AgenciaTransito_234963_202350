/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Tramite;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public class LicenciaDAO implements ILicenciaDAO {

    @Override
    public Licencia agregarLicencia(Licencia licencia, boolean insertarPersona) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (insertarPersona){
            em.persist(licencia.getPersona());
        }
        em.persist(licencia);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return licencia;
    }

    public Licencia agregarLicenciaMismaPersona(Licencia licencia) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(licencia.getPersona());
        em.persist(licencia);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return licencia;
    }

    @Override
    public Licencia bajaLicencia(Licencia licencia) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(licencia);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return licencia;
    }

    @Override
    public List<Licencia> listaLicenciasVigentes(Persona persona) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Licencia> query = em.createQuery("SELECT l FROM Licencia l "
                + "WHERE l.persona.id = :idPersona AND l.VigenciaF > CURRENT_DATE", Licencia.class);
        query.setParameter("idPersona", persona.getId());
        List<Licencia> listaLicencia = query.getResultList();
        em.getTransaction().commit();
        return listaLicencia;
    }
}
