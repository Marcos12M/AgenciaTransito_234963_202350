/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Placa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author gerar
 */
public class PlacaDAO implements IPlacaDAO {

    /**
     * Agrega una nueva Placa a la base de datos.
     *
     * @param placa La Placa a ser agregada.
     * @return La Placa agregada con el ID generado por la base de datos.
     */
    @Override
    public Placa agregarPlaca(Placa placa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexionPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(placa);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return placa;
    }

    /**
     * Busca una Placa en la base de datos en función de su número de Placa.
     *
     * @param numPlaca El número de Placa a buscar.
     * @return La Placa encontrada, o null si no se encuentra ninguna Placa con
     * el número dado.
     */
    @Override
    public Placa buscarPlacaNum(String numPlaca) {
        return null;
    }

}
