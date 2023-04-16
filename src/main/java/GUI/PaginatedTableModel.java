/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public class PaginatedTableModel extends AbstractTableModel {

    private Object[][] data; // Datos de la tabla
    private String[] columnNames; // Nombres de las columnas
    private int rowsPerPage; // Filas por página
    private int currentPage; // Página actual

    public PaginatedTableModel(Object[][] data, String[] columnNames, int rowsPerPage) {
        this.data = data;
        this.columnNames = columnNames;
        this.rowsPerPage = rowsPerPage;
        this.currentPage = 0; // Inicializar la página actual en 0
    }

    public PaginatedTableModel(Object[][] data, String[] columnNames, int rowsPerPage, int currentPage) {
        this.data = data;
        this.columnNames = columnNames;
        this.rowsPerPage = rowsPerPage;
        this.currentPage = currentPage;
    }

    @Override
    public int getRowCount() {
        int totalRows = data.length;
        int pageCount = (int) Math.ceil((double) totalRows / rowsPerPage);
        return Math.min(rowsPerPage, totalRows - currentPage * rowsPerPage);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row + currentPage * rowsPerPage][col];
    }

    /**
     * Método para obtener el número total de páginas en el modelo.
     *
     * @return El número total de páginas.
     */
    public int getPageCount() {
        int totalRows = data.length;
        return (int) Math.ceil((double) totalRows / rowsPerPage);
    }
}
