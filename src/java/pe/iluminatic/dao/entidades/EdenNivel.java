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
@Table(name = "eden_nivel")
@NamedQueries({
    @NamedQuery(name = "EdenNivel.findAll", query = "SELECT e FROM EdenNivel e"),
    @NamedQuery(name = "EdenNivel.findByCodNivelEva", query = "SELECT e FROM EdenNivel e WHERE e.codNivelEva = :codNivelEva"),
    @NamedQuery(name = "EdenNivel.findByDescripcion", query = "SELECT e FROM EdenNivel e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EdenNivel.findByRequiereComp", query = "SELECT e FROM EdenNivel e WHERE e.requiereComp = :requiereComp"),
    @NamedQuery(name = "EdenNivel.findByEstado", query = "SELECT e FROM EdenNivel e WHERE e.estado = :estado")})
public class EdenNivel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cod_Nivel_Eva")
    private String codNivelEva;
    @Size(max = 100)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Requiere_Comp")
    private Character requiereComp;
    @Column(name = "Estado")
    private Character estado;

    public EdenNivel() {
    }

    public EdenNivel(String codNivelEva) {
        this.codNivelEva = codNivelEva;
    }

    public String getCodNivelEva() {
        return codNivelEva;
    }

    public void setCodNivelEva(String codNivelEva) {
        this.codNivelEva = codNivelEva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getRequiereComp() {
        return requiereComp;
    }

    public void setRequiereComp(Character requiereComp) {
        this.requiereComp = requiereComp;
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
        hash += (codNivelEva != null ? codNivelEva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdenNivel)) {
            return false;
        }
        EdenNivel other = (EdenNivel) object;
        if ((this.codNivelEva == null && other.codNivelEva != null) || (this.codNivelEva != null && !this.codNivelEva.equals(other.codNivelEva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdenNivel[ codNivelEva=" + codNivelEva + " ]";
    }
    
}
