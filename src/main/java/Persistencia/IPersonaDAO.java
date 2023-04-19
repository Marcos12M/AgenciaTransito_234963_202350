/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.Persona;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public interface IPersonaDAO {

    public Persona agregarPersona(Persona persona);

    public Persona buscarPersona(String RFC);

}
