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
    String fecha;
    String nombreTramite;
    String nombre;
    String costo;

    public ReporteTramite(String fecha, String nombreTramite, String nombre, String costo) {
        this.fecha = fecha;
        this.nombreTramite = nombreTramite;
        this.nombre = nombre;
        this.costo = costo;
    }

    public ReporteTramite() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreTramite() {
        return nombreTramite;
    }

    public void setNombreTramite(String nombreTramite) {
        this.nombreTramite = nombreTramite;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

}


