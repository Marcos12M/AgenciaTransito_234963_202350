/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.Persona;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public interface IPersonaDAO {

    public Persona agregarPersona(Persona persona);

    public Persona buscarPersona(String RFC);
    
    public List<Persona> generarListaPersonas();

    public void agregarPersonas(List<Persona> personas);
    
    public List<Persona> listaConsulta(Date fechaNacimiento, String RFC, String Nombre);
    
}
