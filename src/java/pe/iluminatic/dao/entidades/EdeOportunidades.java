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
 * @author JBugarinP
 */
@Entity
@Table(name = "ede_oportunidades")
@NamedQueries({
    @NamedQuery(name = "EdeOportunidades.findAll", query = "SELECT e FROM EdeOportunidades e"),
    @NamedQuery(name = "EdeOportunidades.findByIdEvaluacion", query = "SELECT e FROM EdeOportunidades e WHERE e.edeOportunidadesPK.idEvaluacion = :idEvaluacion"),
    @NamedQuery(name = "EdeOportunidades.findByItem", query = "SELECT e FROM EdeOportunidades e WHERE e.edeOportunidadesPK.item = :item"),
    @NamedQuery(name = "EdeOportunidades.findByDescripcion", query = "SELECT e FROM EdeOportunidades e WHERE e.descripcion = :descripcion")})
public class EdeOportunidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EdeOportunidadesPK edeOportunidadesPK;
    @Size(max = 250)
    @Column(name = "Descripcion")
    private String descripcion;

    public EdeOportunidades() {
    }

    public EdeOportunidades(EdeOportunidadesPK edeOportunidadesPK) {
        this.edeOportunidadesPK = edeOportunidadesPK;
    }

    public EdeOportunidades(int idEvaluacion, int item) {
        this.edeOportunidadesPK = new EdeOportunidadesPK(idEvaluacion, item);
    }

    public EdeOportunidadesPK getEdeOportunidadesPK() {
        return edeOportunidadesPK;
    }

    public void setEdeOportunidadesPK(EdeOportunidadesPK edeOportunidadesPK) {
        this.edeOportunidadesPK = edeOportunidadesPK;
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
        hash += (edeOportunidadesPK != null ? edeOportunidadesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdeOportunidades)) {
            return false;
        }
        EdeOportunidades other = (EdeOportunidades) object;
        if ((this.edeOportunidadesPK == null && other.edeOportunidadesPK != null) || (this.edeOportunidadesPK != null && !this.edeOportunidadesPK.equals(other.edeOportunidadesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdeOportunidades[ edeOportunidadesPK=" + edeOportunidadesPK + " ]";
    }
    
}
