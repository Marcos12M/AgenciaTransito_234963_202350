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
    public Vehiculo agregaVehiculo(Vehiculo vehiculo);
    public Vehiculo buscarVehiculo(String numSerie);
    public void setPlaca(Placa placa, Vehiculo vehiculo);
}
