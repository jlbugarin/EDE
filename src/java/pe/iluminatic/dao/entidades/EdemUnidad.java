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
@Table(name = "EDEM_UNIDAD")
@NamedQueries({
    @NamedQuery(name = "EdemUnidad.findAll", query = "SELECT e FROM EdemUnidad e"),
    @NamedQuery(name = "EdemUnidad.findByUnidad", query = "SELECT e FROM EdemUnidad e WHERE e.unidad = :unidad"),
    @NamedQuery(name = "EdemUnidad.findByClasificacion", query = "SELECT e FROM EdemUnidad e WHERE e.clasificacion = :clasificacion"),
    @NamedQuery(name = "EdemUnidad.findByDescripcion", query = "SELECT e FROM EdemUnidad e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EdemUnidad.findByEstado", query = "SELECT e FROM EdemUnidad e WHERE e.estado = :estado")})
public class EdemUnidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Unidad")
    private String unidad;
    @Size(max = 2)
    @Column(name = "Clasificacion")
    private String clasificacion;
    @Size(max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Estado")
    private Character estado;

    public EdemUnidad() {
    }

    public EdemUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
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
        hash += (unidad != null ? unidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdemUnidad)) {
            return false;
        }
        EdemUnidad other = (EdemUnidad) object;
        if ((this.unidad == null && other.unidad != null) || (this.unidad != null && !this.unidad.equals(other.unidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdemUnidad[ unidad=" + unidad + " ]";
    }
    
}
