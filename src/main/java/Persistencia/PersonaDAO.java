/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Persona;
import GUI.PantallaLicencia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public class PersonaDAO implements IPersonaDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
    EntityManager em = emf.createEntityManager();

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
        try {
            Query query = em.createQuery("SELECT p FROM Persona p WHERE p.RFC = :RFC");
            query.setParameter("RFC", RFC);
            Persona persona = (Persona) query.getSingleResult();
            JOptionPane.showMessageDialog(null, "La persona con la RFC: " + RFC + " existe", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return persona;
        } catch (NoResultException ex) {
            // La RFC ingresada no se encontró en la base de datos
            return null;
        }
    }
}
