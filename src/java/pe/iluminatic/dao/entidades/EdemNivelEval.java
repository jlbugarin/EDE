/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.iluminatic.dao.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author JBugarinP
 */
@Entity
@Table(name = "EDEM_NIVEL_EVAL")
@NamedQueries({
    @NamedQuery(name = "EdemNivelEval.findAll", query = "SELECT e FROM EdemNivelEval e"),
    @NamedQuery(name = "EdemNivelEval.findByCodRespuesta", query = "SELECT e FROM EdemNivelEval e WHERE e.codRespuesta = :codRespuesta"),
    @NamedQuery(name = "EdemNivelEval.findByDescripcion", query = "SELECT e FROM EdemNivelEval e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EdemNivelEval.findByRequiereComp", query = "SELECT e FROM EdemNivelEval e WHERE e.requiereComp = :requiereComp")})
public class EdemNivelEval implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_Respuesta")
    private String codRespuesta;
    @Size(max = 250)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 2)
    @Column(name = "Requiere_Comp")
    private String requiereComp;

    public EdemNivelEval() {
    }

    public EdemNivelEval(String codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    public String getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(String codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRequiereComp() {
        return requiereComp;
    }

    public void setRequiereComp(String requiereComp) {
        this.requiereComp = requiereComp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRespuesta != null ? codRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdemNivelEval)) {
            return false;
        }
        EdemNivelEval other = (EdemNivelEval) object;
        if ((this.codRespuesta == null && other.codRespuesta != null) || (this.codRespuesta != null && !this.codRespuesta.equals(other.codRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdemNivelEval[ codRespuesta=" + codRespuesta + " ]";
    }
    
}
