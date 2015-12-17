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
@Table(name = "EDEM_TIPOEVA")
@NamedQueries({
    @NamedQuery(name = "EdemTipoeva.findAll", query = "SELECT e FROM EdemTipoeva e"),
    @NamedQuery(name = "EdemTipoeva.findByTipoEvaluacion", query = "SELECT e FROM EdemTipoeva e WHERE e.tipoEvaluacion = :tipoEvaluacion"),
    @NamedQuery(name = "EdemTipoeva.findByDescripcion", query = "SELECT e FROM EdemTipoeva e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EdemTipoeva.findByPeriodo", query = "SELECT e FROM EdemTipoeva e WHERE e.periodo = :periodo"),
    @NamedQuery(name = "EdemTipoeva.findByEstado", query = "SELECT e FROM EdemTipoeva e WHERE e.estado = :estado")})
public class EdemTipoeva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Tipo_Evaluacion")
    private String tipoEvaluacion;
    @Size(max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 4)
    @Column(name = "Periodo")
    private String periodo;
    @Column(name = "Estado")
    private Character estado;

    public EdemTipoeva() {
    }

    public EdemTipoeva(String tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public String getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(String tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoEvaluacion != null ? tipoEvaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdemTipoeva)) {
            return false;
        }
        EdemTipoeva other = (EdemTipoeva) object;
        if ((this.tipoEvaluacion == null && other.tipoEvaluacion != null) || (this.tipoEvaluacion != null && !this.tipoEvaluacion.equals(other.tipoEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdemTipoeva[ tipoEvaluacion=" + tipoEvaluacion + " ]";
    }
    
}
