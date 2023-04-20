/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Persona;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public class PersonaDAO implements IPersonaDAO {

    @Override
    public Persona agregarPersona(Persona persona) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return persona;
    }

    @Override
    public Persona buscarPersona(String RFC) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Persona p WHERE p.RFC = :RFC");
            query.setParameter("RFC", RFC);
            Persona persona = (Persona) query.getSingleResult();
            return persona;
        } catch (NoResultException ex) {
            // La RFC ingresada no se encontró en la base de datos
            return null;
        }
    }

    @Override
    public List<Persona> generarListaPersonas() {

        String[] nombres = {"Brad Pitt", "Angelina Jolie", "Tom Hanks", "Meryl Streep", "Leonardo DiCaprio",
            "Jennifer Aniston", "Johnny Depp", "Natalie Portman", "Robert Downey Jr.", "Charlize Theron",
            "Denzel Washington", "Cate Blanchett", "Chris Evans", "Anne Hathaway", "Hugh Jackman",
            "Julia Roberts", "Ryan Gosling", "Kate Winslet", "Dwayne Johnson", "Scarlett Johansson"};

        String[] telefonos = {"6414629920", "6414629921", "6414629922", "6414629923", "6414629924",
            "6414629925", "6414629926", "6414629927", "6414629928", "6414629929",
            "6414629930", "6414629931", "6414629932", "6414629933", "6414629934",
            "6414629935", "6414629936", "6414629937", "6414629938", "6414629939"};

        boolean[] discapacitados = {true, false, true, false, true,
            false, true, false, true, false,
            true, false, true, false, true,
            false, true, false, true, false};

        String[] rfcs = {"BEFJ831218123", "SJLO750604456", "SJKM560709789", "KJOP490622234", "DABJ741111567",
            "EOIR690211890", "QWER630609012", "TYUI810609345", "JKLM650404678", "SFJL750807901",
            "LLQP541228234", "POKI690514567", "KSNW810613890", "MNOP821112123", "QWEN681012456",
            "WERI671028789", "LSJK801112012", "JKLI751005345", "POQR720502678", "DCMN841122901"};

        String[] fechasNacimiento = {"1983-12-18", "1975-06-04", "1956-07-09", "1949-06-22", "1974-11-11",
            "1969-02-11", "1963-06-09", "1981-06-09", "1965-04-04", "1975-08-07",
            "1954-12-28", "1969-05-14", "1981-06-13", "1982-11-12", "1968-10-12",
            "1967-10-28", "1980-11-12", "1975-10-05", "1972-05-02", "1984-11-22"};

        Date[] fechasNacimientoDate = new Date[fechasNacimiento.length];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < fechasNacimiento.length; i++) {
            try {
                fechasNacimientoDate[i] = sdf.parse(fechasNacimiento[i]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        List<Persona> personas = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Persona persona = new Persona();
            persona.setNombre(nombres[i]);
            persona.setRFC(rfcs[i]);
            persona.setTelefono(telefonos[i]);
            persona.setDiscapacitado(discapacitados[i]);
            persona.setFechaNacimiento(fechasNacimientoDate[i]);

            personas.add(persona);
        }

        return personas;
    }
    
    @Override
    public void agregarPersonas(List<Persona> personas) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            for (Persona persona : personas) {
                em.persist(persona);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
