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

    /**
     * Agrega una licencia a la base de datos. Si se establece el flag
     * insertarPersona a true, también se inserta la persona asociada a la
     * licencia en la base de datos.
     *
     * @param licencia Objeto de tipo Licencia a agregar a la base de datos.
     * @param insertarPersona Flag que indica si se debe insertar también la
     * persona asociada a la licencia en la base de datos.
     * @return Objeto de tipo Licencia que se ha agregado a la base de datos.
     */
    public Licencia agregarLicencia(Licencia licencia, boolean insertarPersona);

    /**
     * Agrega una licencia a la base de datos para una persona que ya existe en
     * la base de datos.
     *
     * @param licencia Objeto de tipo Licencia a agregar a la base de datos.
     * @return Objeto de tipo Licencia que se ha agregado a la base de datos.
     */
    public Licencia agregarLicenciaMismaPersona(Licencia licencia);

    /**
     * Realiza la baja de una licencia en la base de datos.
     *
     * @param licencia Objeto de tipo Licencia a dar de baja en la base de
     * datos.
     * @return Objeto de tipo Licencia que se ha dado de baja en la base de
     * datos.
     */
    public Licencia bajaLicencia(Licencia licencia);

    /**
     * Obtiene una lista de licencias vigentes asociadas a una persona en la
     * base de datos.
     *
     * @param persona Objeto de tipo Persona para la cual se obtendrán las
     * licencias vigentes.
     * @return Lista de objetos del tipo Licencia que están vigentes para la
     * persona en la base de datos.
     */
    public List<Licencia> listaLicenciasVigentes(Persona persona);
}
