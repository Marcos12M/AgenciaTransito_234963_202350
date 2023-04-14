/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Marcos Toledo 00000234963
 */

@Entity
public class LicenciaNormal extends Licencia {
    @Basic
    @Column(name = "costo")
    private Integer costo;
    
    // Getter y Setter para costos
    public Integer getCosto() {
        if (getVigencia() == 1) {
            return 600;
        } else if (getVigencia() == 2) {
            return 900;
        } else if (getVigencia() == 3) {
            return 1100;
        } else {
            return costo;
        }
    }
}
