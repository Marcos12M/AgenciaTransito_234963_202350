/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.Vehiculo;

/**
 *
 * @author gerar
 */
public interface IVehiculoDAO {
    public Vehiculo agregaVehiculo(Vehiculo vehiculo);
    public Vehiculo buscarVehiculo(long numSerie);
}
