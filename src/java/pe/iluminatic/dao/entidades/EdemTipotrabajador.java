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
@Table(name = "EDEM_TIPOTRABAJADOR")
@NamedQueries({
    @NamedQuery(name = "EdemTipotrabajador.findAll", query = "SELECT e FROM EdemTipotrabajador e"),
    @NamedQuery(name = "EdemTipotrabajador.findByTipoEmpleado", query = "SELECT e FROM EdemTipotrabajador e WHERE e.tipoEmpleado = :tipoEmpleado"),
    @NamedQuery(name = "EdemTipotrabajador.findByDescripcion", query = "SELECT e FROM EdemTipotrabajador e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EdemTipotrabajador.findByEstado", query = "SELECT e FROM EdemTipotrabajador e WHERE e.estado = :estado")})
public class EdemTipotrabajador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Tipo_Empleado")
    private String tipoEmpleado;
    @Size(max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Estado")
    private Character estado;

    public EdemTipotrabajador() {
    }

    public EdemTipotrabajador(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
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
        hash += (tipoEmpleado != null ? tipoEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdemTipotrabajador)) {
            return false;
        }
        EdemTipotrabajador other = (EdemTipotrabajador) object;
        if ((this.tipoEmpleado == null && other.tipoEmpleado != null) || (this.tipoEmpleado != null && !this.tipoEmpleado.equals(other.tipoEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdemTipotrabajador[ tipoEmpleado=" + tipoEmpleado + " ]";
    }
    
}
