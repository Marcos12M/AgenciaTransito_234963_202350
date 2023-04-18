/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Licencia;
import Entidades.Placa;
import Entidades.Tramite;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public class TramiteDAO implements ITramiteDAO{
    
   @Override
   public void llenarTablaTramites(JTable table, EntityManager entityManager) {
        // Crear el modelo de tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Fecha");
        model.addColumn("Tipo de Trámite");
        model.addColumn("Nombre Solicitante");
        model.addColumn("Costo");
        table.setModel(model);

        // Realizar la consulta
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tramite> query = cb.createQuery(Tramite.class);
        List<Tramite> results = entityManager.createQuery(query).getResultList();
        for (Tramite tramite : results) {
            System.out.println(tramite.getFecha());
            if (tramite instanceof Licencia) {
                System.out.println("Licencia");
            }
            if (tramite instanceof Placa) {
                System.out.println("Placa");
            }
            System.out.println(tramite.getPersona().getNombre());
            System.out.println(tramite.getCosto());
        }

        // Llenar la tabla con los resultados
        for (Tramite tramite : results) {
            Object[] rowData = new Object[4];
            rowData[0] = tramite.getFecha();
            if (tramite instanceof Licencia) {
                rowData[1] = "Licencia";
            }
            if (tramite instanceof Placa) {
                rowData[1] = "Placa";
            }
            rowData[2] = tramite.getPersona().getNombre();
            rowData[3] = tramite.getCosto();
            model.addRow(rowData);
        }
        
    }
}
