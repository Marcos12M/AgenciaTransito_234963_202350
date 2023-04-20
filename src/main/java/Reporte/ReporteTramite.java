/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reporte;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public class ReporteTramite {

    String fecha; // Fecha del informe
    String nombreTramite; // Nombre del trámite
    String nombre; // Nombre del informante
    String costo; // Costo del trámite

    /**
     * Constructor de reporte tramite
     *
     * @param fecha
     * @param nombreTramite
     * @param nombre
     * @param costo
     */
    public ReporteTramite(String fecha, String nombreTramite, String nombre, String costo) {
        this.fecha = fecha;
        this.nombreTramite = nombreTramite;
        this.nombre = nombre;
        this.costo = costo;
    }

    // Constructor sin parámetros
    public ReporteTramite() {
        // No realiza ninguna acción ya que es un constructor por defecto
    }

    // Método de acceso para obtener la fecha del informe
    public String getFecha() {
        return fecha;
    }

    // Método de modificación para establecer la fecha del informe
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    // Método de acceso para obtener el nombre del trámite
    public String getNombreTramite() {
        return nombreTramite;
    }

    // Método de modificación para establecer el nombre del trámite
    public void setNombreTramite(String nombreTramite) {
        this.nombreTramite = nombreTramite;
    }

    // Método de acceso para obtener el nombre del informante
    public String getNombre() {
        return nombre;
    }

    // Método de modificación para establecer el nombre del informante
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método de acceso para obtener el costo del trámite
    public String getCosto() {
        return costo;
    }

    // Método de modificación para establecer el costo del trámite
    public void setCosto(String costo) {
        this.costo = costo;
    }

}
