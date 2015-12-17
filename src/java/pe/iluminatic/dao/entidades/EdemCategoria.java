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
@Table(name = "EDEM_CATEGORIA")
@NamedQueries({
    @NamedQuery(name = "EdemCategoria.findAll", query = "SELECT e FROM EdemCategoria e"),
    @NamedQuery(name = "EdemCategoria.findByCodCategoria", query = "SELECT e FROM EdemCategoria e WHERE e.codCategoria = :codCategoria"),
    @NamedQuery(name = "EdemCategoria.findByDescripcion", query = "SELECT e FROM EdemCategoria e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EdemCategoria.findByEstado", query = "SELECT e FROM EdemCategoria e WHERE e.estado = :estado")})
public class EdemCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cod_Categoria")
    private String codCategoria;
    @Size(max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Estado")
    private Character estado;

    public EdemCategoria() {
    }

    public EdemCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
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
        hash += (codCategoria != null ? codCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdemCategoria)) {
            return false;
        }
        EdemCategoria other = (EdemCategoria) object;
        if ((this.codCategoria == null && other.codCategoria != null) || (this.codCategoria != null && !this.codCategoria.equals(other.codCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdemCategoria[ codCategoria=" + codCategoria + " ]";
    }
    
}
