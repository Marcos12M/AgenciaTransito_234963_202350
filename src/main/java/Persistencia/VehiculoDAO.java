/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Placa;
import Entidades.Vehiculo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author gerar
 */
public class VehiculoDAO implements IVehiculoDAO {

    @Override
    public Vehiculo agregaVehiculo(Vehiculo vehiculo) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(vehiculo);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return vehiculo;
    }

    @Override
    public Vehiculo buscarVehiculo(String numSerie) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
            EntityManager em = emf.createEntityManager();
            Query query = em.createQuery("SELECT p FROM Vehiculo p WHERE p.numSerie = :numSerie");
            query.setParameter("numSerie", numSerie);
            Vehiculo vehiculo = (Vehiculo) query.getSingleResult();
            return vehiculo;
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    @Override
   public void setPlaca(Placa placa, Vehiculo vehiculo) {
      try {  
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        vehiculo.setPlaca(placa);
        vehiculo = em.merge(vehiculo);
        em.getTransaction().commit();
        em.close();
        emf.close();
         } catch (NoResultException ex) {
             
        }
    }

}
