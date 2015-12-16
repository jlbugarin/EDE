/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.iluminatic.dao.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JBugarinP
 */
@Embeddable
public class EdeCompetenciasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_Evaluacion")
    private int idEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Item")
    private int item;

    public EdeCompetenciasPK() {
    }

    public EdeCompetenciasPK(int idEvaluacion, int item) {
        this.idEvaluacion = idEvaluacion;
        this.item = item;
    }

    public int getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEvaluacion;
        hash += (int) item;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdeCompetenciasPK)) {
            return false;
        }
        EdeCompetenciasPK other = (EdeCompetenciasPK) object;
        if (this.idEvaluacion != other.idEvaluacion) {
            return false;
        }
        if (this.item != other.item) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdeCompetenciasPK[ idEvaluacion=" + idEvaluacion + ", item=" + item + " ]";
    }
    
}
