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
@Table(name = "edem_rol_eval")
@NamedQueries({
    @NamedQuery(name = "EdemRolEval.findAll", query = "SELECT e FROM EdemRolEval e"),
    @NamedQuery(name = "EdemRolEval.findByRolEvaluacion", query = "SELECT e FROM EdemRolEval e WHERE e.rolEvaluacion = :rolEvaluacion"),
    @NamedQuery(name = "EdemRolEval.findByDescripcion", query = "SELECT e FROM EdemRolEval e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EdemRolEval.findByEstado", query = "SELECT e FROM EdemRolEval e WHERE e.estado = :estado")})
public class EdemRolEval implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Rol_Evaluacion")
    private String rolEvaluacion;
    @Size(max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Estado")
    private Character estado;

    public EdemRolEval() {
    }

    public EdemRolEval(String rolEvaluacion) {
        this.rolEvaluacion = rolEvaluacion;
    }

    public String getRolEvaluacion() {
        return rolEvaluacion;
    }

    public void setRolEvaluacion(String rolEvaluacion) {
        this.rolEvaluacion = rolEvaluacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (rolEvaluacion != null ? rolEvaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdemRolEval)) {
            return false;
        }
        EdemRolEval other = (EdemRolEval) object;
        if ((this.rolEvaluacion == null && other.rolEvaluacion != null) || (this.rolEvaluacion != null && !this.rolEvaluacion.equals(other.rolEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdemRolEval[ rolEvaluacion=" + rolEvaluacion + " ]";
    }
    
}
