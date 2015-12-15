/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.iluminatic.dao.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author jlbugarin
 */
@Entity
@Table(name = "ede_fortalezas")
@NamedQueries({
    @NamedQuery(name = "EdeFortalezas.findAll", query = "SELECT e FROM EdeFortalezas e"),
    @NamedQuery(name = "EdeFortalezas.findByIdEvaluacion", query = "SELECT e FROM EdeFortalezas e WHERE e.edeFortalezasPK.idEvaluacion = :idEvaluacion"),
    @NamedQuery(name = "EdeFortalezas.findByItem", query = "SELECT e FROM EdeFortalezas e WHERE e.edeFortalezasPK.item = :item"),
    @NamedQuery(name = "EdeFortalezas.findByDescripcion", query = "SELECT e FROM EdeFortalezas e WHERE e.descripcion = :descripcion")})
public class EdeFortalezas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EdeFortalezasPK edeFortalezasPK;
    @Size(max = 250)
    @Column(name = "Descripcion")
    private String descripcion;

    public EdeFortalezas() {
    }

    public EdeFortalezas(EdeFortalezasPK edeFortalezasPK) {
        this.edeFortalezasPK = edeFortalezasPK;
    }

    public EdeFortalezas(int idEvaluacion, int item) {
        this.edeFortalezasPK = new EdeFortalezasPK(idEvaluacion, item);
    }

    public EdeFortalezasPK getEdeFortalezasPK() {
        return edeFortalezasPK;
    }

    public void setEdeFortalezasPK(EdeFortalezasPK edeFortalezasPK) {
        this.edeFortalezasPK = edeFortalezasPK;
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
        hash += (edeFortalezasPK != null ? edeFortalezasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdeFortalezas)) {
            return false;
        }
        EdeFortalezas other = (EdeFortalezas) object;
        if ((this.edeFortalezasPK == null && other.edeFortalezasPK != null) || (this.edeFortalezasPK != null && !this.edeFortalezasPK.equals(other.edeFortalezasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdeFortalezas[ edeFortalezasPK=" + edeFortalezasPK + " ]";
    }
    
}
