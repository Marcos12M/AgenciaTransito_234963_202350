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

    public List<Tramite> listaTramite(boolean LicenciasS, boolean PlacasS, Date fechaInicio, Date fechaFin, String Nombre);

    public List<Tramite> listaConsulta(Date fechaNacimiento, String RFC, String Nombre);
    
}
