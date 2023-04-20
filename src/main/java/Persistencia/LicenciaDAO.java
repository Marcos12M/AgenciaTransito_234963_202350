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

    /**
     * Agrega una licencia a la base de datos. Si se establece el flag
     * insertarPersona a true, también se inserta la persona asociada a la
     * licencia en la base de datos.
     *
     * @param licencia Objeto de tipo Licencia a agregar a la base de datos.
     * @param insertarPersona Flag que indica si se debe insertar también la
     * persona asociada a la licencia en la base de datos.
     * @return Objeto de tipo Licencia que se ha agregado a la base de datos.
     */
    @Override
    public Licencia agregarLicencia(Licencia licencia, boolean insertarPersona) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if (insertarPersona) {
            em.persist(licencia.getPersona());
        }
        em.persist(licencia);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return licencia;
    }

    /**
     * Agrega una licencia a la base de datos para una persona que ya existe en
     * la base de datos.
     *
     * @param licencia Objeto de tipo Licencia a agregar a la base de datos.
     * @return Objeto de tipo Licencia que se ha agregado a la base de datos.
     */
    @Override
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

    /**
     * Realiza la baja de una licencia en la base de datos.
     *
     * @param licencia Objeto de tipo Licencia a dar de baja en la base de
     * datos.
     * @return Objeto de tipo Licencia que se ha dado de baja en la base de
     * datos.
     */
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

    /**
     * Obtiene una lista de licencias vigentes asociadas a una persona en la
     * base de datos.
     *
     * @param persona Objeto de tipo Persona para la cual se obtendrán las
     * licencias vigentes.
     * @return Lista de objetos del tipo Licencia que están vigentes para la
     * persona en la base de datos.
     */
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
