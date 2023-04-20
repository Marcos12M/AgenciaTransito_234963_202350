/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.Tramite;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JTable;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public interface ITramiteDAO {

    /**
     * Obtiene una lista de trámites de la base de datos, filtrados por opciones
     * de búsqueda.
     *
     * @param LicenciasS Booleano que indica si se deben incluir los trámites de
     * licencias en la lista.
     * @param PlacasS Booleano que indica si se deben incluir los trámites de
     * placas en la lista.
     * @param fechaInicio Fecha de inicio del rango de fechas de búsqueda de
     * trámites.
     * @param fechaFin Fecha de fin del rango de fechas de búsqueda de trámites.
     * @param Nombre Nombre del trámite a buscar.
     * @return Lista de objetos de tipo Tramite que corresponden a los criterios
     * de búsqueda especificados.
     */
    public List<Tramite> listaTramite(boolean LicenciasS, boolean PlacasS, Date fechaInicio, Date fechaFin, String Nombre);

    /**
     * Obtiene una lista de trámites de la base de datos, filtrados por RFC.
     *
     * @param RFC RFC de la persona asociada a los trámites a buscar.
     * @return Lista de objetos de tipo Tramite que corresponden al RFC
     * especificado.
     */
    public List<Tramite> listaConsulta(String RFC);

}
