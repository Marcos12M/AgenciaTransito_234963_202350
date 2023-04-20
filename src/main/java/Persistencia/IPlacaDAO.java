/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.Placa;

/**
 *
 * @author gerar
 */
public interface IPlacaDAO {

    /**
     * Agrega una nueva Placa a la base de datos.
     *
     * @param placa La Placa a ser agregada.
     * @return La Placa agregada con el ID generado por la base de datos.
     */
    public Placa agregarPlaca(Placa placa);

    /**
     * Busca una Placa en la base de datos en función de su número de Placa.
     *
     * @param numPlaca El número de Placa a buscar.
     * @return La Placa encontrada, o null si no se encuentra ninguna Placa con
     * el número dado.
     */
    public Placa buscarPlacaNum(String numPlaca);

}
