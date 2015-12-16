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
@Table(name = "edem_periodo")
@NamedQueries({
    @NamedQuery(name = "EdemPeriodo.findAll", query = "SELECT e FROM EdemPeriodo e"),
    @NamedQuery(name = "EdemPeriodo.findByPeriodo", query = "SELECT e FROM EdemPeriodo e WHERE e.periodo = :periodo"),
    @NamedQuery(name = "EdemPeriodo.findByDescripcion", query = "SELECT e FROM EdemPeriodo e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EdemPeriodo.findByEstado", query = "SELECT e FROM EdemPeriodo e WHERE e.estado = :estado")})
public class EdemPeriodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Periodo")
    private String periodo;
    @Size(max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Estado")
    private Character estado;

    public EdemPeriodo() {
    }

    public EdemPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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
        hash += (periodo != null ? periodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdemPeriodo)) {
            return false;
        }
        EdemPeriodo other = (EdemPeriodo) object;
        if ((this.periodo == null && other.periodo != null) || (this.periodo != null && !this.periodo.equals(other.periodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdemPeriodo[ periodo=" + periodo + " ]";
    }
    
}
