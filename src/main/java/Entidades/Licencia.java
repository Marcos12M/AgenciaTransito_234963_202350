/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marcos Toledo 00000234963
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_tramite")
public class Licencia implements Serializable {

    @Id
    @Column(name = "id_licencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "tipo")
    private String Tipo;

    @Basic
    @Column(name = "vigencia")
    private int Vigencia;

    @Basic
    @Column(name = "costo")
    private int costo;

    @Column(name = "vigenciaFecha")
    @Temporal(TemporalType.DATE)
    private Date VigenciaF;

    @ManyToOne()
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Licencia() {
    }

    public Licencia(Integer id, String Tipo, int Vigencia, Date VigenciaF, Persona persona) {
        this.id = id;
        this.Tipo = Tipo;
        this.Vigencia = Vigencia;
        this.VigenciaF = VigenciaF;
        this.persona = persona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public Date getVigenciaF() {
        return VigenciaF;
    }

    public void setVigenciaF(Date VigenciaF) {
        this.VigenciaF = VigenciaF;
    }

    public int getVigencia() {
        return Vigencia;
    }

    public void setVigencia(int Vigencia) {
        this.Vigencia = Vigencia;
    }

    public int obtenerCosto() {
        if (Vigencia == 1 && Tipo.equals("Discapacitado")) {
            return 200;
        } else if (Vigencia == 2 && Tipo.equals("Discapacitado")) {
            return 500;
        } else if (Vigencia == 3 && Tipo.equals("Discapacitado")) {
            return 700;
        } else if (Vigencia == 1 && Tipo.equals("Normal")) {
            return 600;
        } else if (Vigencia == 2 && Tipo.equals("Normal")) {
            return 900;
        } else if (Vigencia == 3 && Tipo.equals("Normal")) {
            return 1100;
        } else {
            // En caso de que no se cumpla ninguna condición, puedes lanzar una excepción o devolver un valor por defecto
            throw new IllegalArgumentException("Vigencia o tipo inválido");
        }
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
    public int getCosto(int Costo) {
        return costo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.Tipo);
        hash = 83 * hash + this.Vigencia;
        hash = 83 * hash + this.costo;
        hash = 83 * hash + Objects.hashCode(this.VigenciaF);
        hash = 83 * hash + Objects.hashCode(this.persona);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Licencia other = (Licencia) obj;
        if (this.Vigencia != other.Vigencia) {
            return false;
        }
        if (this.costo != other.costo) {
            return false;
        }
        if (!Objects.equals(this.Tipo, other.Tipo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.VigenciaF, other.VigenciaF)) {
            return false;
        }
        return Objects.equals(this.persona, other.persona);
    }
    
    

}
