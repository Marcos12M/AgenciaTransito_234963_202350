/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Licencia;
import Entidades.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public class LicenciaDAO implements ILicenciaDAO {

    @Override
    public Licencia agregarLicencia(Licencia licencia) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(licencia.getPersona());
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
}
