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
import javax.validation.constraints.Size;

/**
 *
 * @author JBugarinP
 */
@Embeddable
public class EdemEvaluadosConfPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Tipo_Evaluacion")
    private String tipoEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Cod_Evaluado")
    private String codEvaluado;

    public EdemEvaluadosConfPK() {
    }

    public EdemEvaluadosConfPK(String tipoEvaluacion, String codEvaluado) {
        this.tipoEvaluacion = tipoEvaluacion;
        this.codEvaluado = codEvaluado;
    }

    public String getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(String tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public String getCodEvaluado() {
        return codEvaluado;
    }

    public void setCodEvaluado(String codEvaluado) {
        this.codEvaluado = codEvaluado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoEvaluacion != null ? tipoEvaluacion.hashCode() : 0);
        hash += (codEvaluado != null ? codEvaluado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdemEvaluadosConfPK)) {
            return false;
        }
        EdemEvaluadosConfPK other = (EdemEvaluadosConfPK) object;
        if ((this.tipoEvaluacion == null && other.tipoEvaluacion != null) || (this.tipoEvaluacion != null && !this.tipoEvaluacion.equals(other.tipoEvaluacion))) {
            return false;
        }
        if ((this.codEvaluado == null && other.codEvaluado != null) || (this.codEvaluado != null && !this.codEvaluado.equals(other.codEvaluado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdemEvaluadosConfPK[ tipoEvaluacion=" + tipoEvaluacion + ", codEvaluado=" + codEvaluado + " ]";
    }
    
}
