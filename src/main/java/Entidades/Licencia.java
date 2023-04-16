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
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@DiscriminatorValue("Licencia")
public class Licencia extends Reporte implements Serializable {

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
    
    @Basic
    @Column(name = "estado")
    private String Estado; //Esta opción la agregue por esto (- considerar que pasa si me roban o pierdo las licencias o placas)

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

    public Licencia(Integer id, String Tipo, int Vigencia, int costo, Date VigenciaF, String Estado, Persona persona) {
        this.id = id;
        this.Tipo = Tipo;
        this.Vigencia = Vigencia;
        this.costo = costo;
        this.VigenciaF = VigenciaF;
        this.Estado = Estado;
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

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
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
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.Tipo);
        hash = 67 * hash + this.Vigencia;
        hash = 67 * hash + this.costo;
        hash = 67 * hash + Objects.hashCode(this.VigenciaF);
        hash = 67 * hash + Objects.hashCode(this.Estado);
        hash = 67 * hash + Objects.hashCode(this.persona);
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
        if (!Objects.equals(this.Estado, other.Estado)) {
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

    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + ", Tipo=" + Tipo + ", Vigencia=" + Vigencia + ", costo=" + costo + ", VigenciaF=" + VigenciaF + ", Estado=" + Estado + ", persona=" + persona + '}';
    }
    
}
