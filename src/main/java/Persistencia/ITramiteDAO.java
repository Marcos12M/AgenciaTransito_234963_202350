/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import javax.persistence.EntityManager;
import javax.swing.JTable;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public interface ITramiteDAO {
    public void llenarTablaTramites(JTable table, EntityManager entityManager);
}
