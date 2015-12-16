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
@Table(name = "edem_estado")
@NamedQueries({
    @NamedQuery(name = "EdemEstado.findAll", query = "SELECT e FROM EdemEstado e"),
    @NamedQuery(name = "EdemEstado.findByEstado", query = "SELECT e FROM EdemEstado e WHERE e.estado = :estado"),
    @NamedQuery(name = "EdemEstado.findByDescripcion", query = "SELECT e FROM EdemEstado e WHERE e.descripcion = :descripcion")})
public class EdemEstado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Estado")
    private String estado;
    @Size(max = 100)
    @Column(name = "Descripcion")
    private String descripcion;

    public EdemEstado() {
    }

    public EdemEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estado != null ? estado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdemEstado)) {
            return false;
        }
        EdemEstado other = (EdemEstado) object;
        if ((this.estado == null && other.estado != null) || (this.estado != null && !this.estado.equals(other.estado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdemEstado[ estado=" + estado + " ]";
    }
    
}
