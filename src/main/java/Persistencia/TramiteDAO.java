/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Placa;
import Entidades.Tramite;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public class TramiteDAO implements ITramiteDAO {

    /**
     * Obtiene una lista de trámites de acuerdo a los criterios de búsqueda
     * especificados.
     *
     * @param LicenciasS Un booleano que indica si se deben incluir trámites de
     * licencias (true) o no (false) en la búsqueda.
     * @param PlacasS Un booleano que indica si se deben incluir trámites de
     * placas (true) o no (false) en la búsqueda.
     * @param fechaInicio La fecha de inicio del rango de fechas de búsqueda.
     * @param fechaFin La fecha de fin del rango de fechas de búsqueda.
     * @param Nombre El nombre de la persona asociada a los trámites a buscar.
     * @return Una lista de objetos Tramite que cumplen con los criterios de
     * búsqueda especificados.
     */
    @Override
    public List<Tramite> listaTramite(boolean LicenciasS, boolean PlacasS, Date fechaInicio, Date fechaFin, String Nombre) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Tramite> criteriaQuery = criteriaBuilder.createQuery(Tramite.class);
        Root<Tramite> tramite = criteriaQuery.from(Tramite.class);
        criteriaQuery.select(tramite);

        Join<Tramite, Persona> persona = tramite.join("persona");

        List<Predicate> predicados = new ArrayList<Predicate>();

        if (LicenciasS && !PlacasS) {
            Predicate p1 = criteriaBuilder.equal(criteriaBuilder.literal(Licencia.class), tramite.type());
            predicados.add(p1);
        } else if (PlacasS && !LicenciasS) {
            Predicate p2 = criteriaBuilder.equal(criteriaBuilder.literal(Placa.class), tramite.type());
            predicados.add(p2);
        } else if (LicenciasS && PlacasS) {
            Predicate p1 = criteriaBuilder.equal(criteriaBuilder.literal(Licencia.class), tramite.type());
            Predicate p2 = criteriaBuilder.equal(criteriaBuilder.literal(Placa.class), tramite.type());
            predicados.add(criteriaBuilder.or(p1, p2));
        }
        if (fechaInicio != null && fechaFin != null) {
            predicados.add(criteriaBuilder.between(tramite.get("Fecha"), fechaInicio, fechaFin));
        }

        if (Nombre != null) {
            predicados.add(criteriaBuilder.like(persona.get("nombre"), "%" + Nombre + "%"));
        }

        if (!predicados.isEmpty()) {
            criteriaQuery.where(criteriaBuilder.and(predicados.toArray(new Predicate[predicados.size()])));
        }

        TypedQuery<Tramite> query = em.createQuery(criteriaQuery);
        List<Tramite> listaTramites = query.getResultList();
        em.getTransaction().commit();

        return listaTramites;
    }

    /**
     * Obtiene una lista de Tramite en función de un RFC dado.
     *
     * @param RFC El RFC de la Persona asociada al Tramite a buscar.
     * @return Una lista de objetos Tramite que cumplen con el RFC dado.
     */
    @Override
    public List<Tramite> listaConsulta(String RFC) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Tramite> criteriaQuery = criteriaBuilder.createQuery(Tramite.class);
        Root<Tramite> tramite = criteriaQuery.from(Tramite.class);
        criteriaQuery.select(tramite);

        Join<Tramite, Persona> persona = tramite.join("persona");

        List<Predicate> predicados = new ArrayList<Predicate>();

        if (!RFC.equals("")) {
            predicados.add(criteriaBuilder.equal(persona.get("RFC"), RFC));
        }

        if (!predicados.isEmpty()) {
            criteriaQuery.where(criteriaBuilder.and(predicados.toArray(new Predicate[predicados.size()])));
        }

        TypedQuery<Tramite> query = em.createQuery(criteriaQuery);
        List<Tramite> listaTramites = query.getResultList();
        em.getTransaction().commit();

        return listaTramites;
    }

}
