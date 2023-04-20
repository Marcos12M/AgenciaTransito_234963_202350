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

    /**
     * Agrega una nueva Persona a la base de datos.
     *
     * @param persona La Persona a ser agregada.
     * @return La Persona agregada con el ID generado por la base de datos.
     */
    public Persona agregarPersona(Persona persona);

    /**
     * Busca una Persona en la base de datos en función de su RFC.
     *
     * @param RFC El RFC de la Persona a buscar.
     * @return La Persona encontrada, o null si no se encuentra ninguna Persona
     * con el RFC dado.
     */
    public Persona buscarPersona(String RFC);

    /**
     * Genera una lista de personas con datos predefinidos.
     *
     * @return Una lista de objetos Persona.
     */
    public List<Persona> generarListaPersonas();

    /**
     * Agrega personas a la base de datos.
     *
     * @param personas Lista de objetos del tipo Persona a agregar.
     */
    public void agregarPersonas(List<Persona> personas);

    /**
     * Realiza una consulta en la base de datos de personas basada en los
     * criterios de búsqueda.
     *
     * @param fechaNacimiento Fecha de nacimiento de las personas a buscar.
     * Puede ser nulo.
     * @param RFC RFC de las personas a buscar. Puede ser una cadena vacía.
     * @param Nombre Nombre de las personas a buscar. Puede ser una cadena
     * vacía.
     * @return Lista de objetos del tipo Persona que cumplen con los criterios
     * de búsqueda.
     */
    public List<Persona> listaConsulta(Date fechaNacimiento, String RFC, String Nombre);

}
