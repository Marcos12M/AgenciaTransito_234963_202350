/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.Placa;
import Entidades.Vehiculo;

/**
 *
 * @author gerar
 */
public interface IVehiculoDAO {

    /**
     * Agrega un vehículo a la base de datos.
     *
     * @param vehiculo Objeto de tipo Vehiculo a agregar a la base de datos.
     * @return Objeto de tipo Vehiculo que se ha agregado a la base de datos.
     */
    public Vehiculo agregaVehiculo(Vehiculo vehiculo);

    /**
     * Busca un vehículo en la base de datos por su número de serie.
     *
     * @param numSerie Número de serie del vehículo a buscar.
     * @return Objeto de tipo Vehiculo que corresponde al número de serie
     * especificado, o null si no se encuentra ningún vehículo con ese número de
     * serie.
     */
    public Vehiculo buscarVehiculo(String numSerie);

    /**
     * Asigna una placa a un vehículo en la base de datos.
     *
     * @param placa Objeto de tipo Placa que se desea asignar al vehículo.
     * @param vehiculo Objeto de tipo Vehiculo al que se desea asignar la placa.
     */
    public void setPlaca(Placa placa, Vehiculo vehiculo);
}
