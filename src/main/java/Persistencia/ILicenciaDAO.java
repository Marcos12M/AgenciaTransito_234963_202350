/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.Licencia;
import Entidades.Persona;
import Entidades.Tramite;
import java.util.List;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public interface ILicenciaDAO {
    public Licencia agregarLicencia(Licencia licencia, boolean insertarPersona);
    
    public Licencia agregarLicenciaMismaPersona(Licencia licencia); 
    
    public Licencia bajaLicencia(Licencia licencia); 
    
    public List<Licencia> listaLicenciasVigentes(Persona persona);
}
