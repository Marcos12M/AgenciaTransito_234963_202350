/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Licencia;
import Entidades.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public class LicenciaDAO implements ILicenciaDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
    EntityManager em = emf.createEntityManager();

    @Override
    public Licencia agregarLicencia(Licencia licencia) {
        em.getTransaction().begin();
        em.persist(licencia);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return licencia;
    }
}
