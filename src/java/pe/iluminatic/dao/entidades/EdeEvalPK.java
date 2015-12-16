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
public class EdeEvalPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_Evaluacion")
    private int idEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Cod_Evaluador")
    private String codEvaluador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "Tipo_Evaluacion")
    private String tipoEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Rol_Evaluacion")
    private String rolEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Cod_Evaluado")
    private String codEvaluado;

    public EdeEvalPK() {
    }

    public EdeEvalPK(int idEvaluacion, String codEvaluador, String tipoEvaluacion, String rolEvaluacion, String codEvaluado) {
        this.idEvaluacion = idEvaluacion;
        this.codEvaluador = codEvaluador;
        this.tipoEvaluacion = tipoEvaluacion;
        this.rolEvaluacion = rolEvaluacion;
        this.codEvaluado = codEvaluado;
    }

    public int getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public String getCodEvaluador() {
        return codEvaluador;
    }

    public void setCodEvaluador(String codEvaluador) {
        this.codEvaluador = codEvaluador;
    }

    public String getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(String tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public String getRolEvaluacion() {
        return rolEvaluacion;
    }

    public void setRolEvaluacion(String rolEvaluacion) {
        this.rolEvaluacion = rolEvaluacion;
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
        hash += (int) idEvaluacion;
        hash += (codEvaluador != null ? codEvaluador.hashCode() : 0);
        hash += (tipoEvaluacion != null ? tipoEvaluacion.hashCode() : 0);
        hash += (rolEvaluacion != null ? rolEvaluacion.hashCode() : 0);
        hash += (codEvaluado != null ? codEvaluado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdeEvalPK)) {
            return false;
        }
        EdeEvalPK other = (EdeEvalPK) object;
        if (this.idEvaluacion != other.idEvaluacion) {
            return false;
        }
        if ((this.codEvaluador == null && other.codEvaluador != null) || (this.codEvaluador != null && !this.codEvaluador.equals(other.codEvaluador))) {
            return false;
        }
        if ((this.tipoEvaluacion == null && other.tipoEvaluacion != null) || (this.tipoEvaluacion != null && !this.tipoEvaluacion.equals(other.tipoEvaluacion))) {
            return false;
        }
        if ((this.rolEvaluacion == null && other.rolEvaluacion != null) || (this.rolEvaluacion != null && !this.rolEvaluacion.equals(other.rolEvaluacion))) {
            return false;
        }
        if ((this.codEvaluado == null && other.codEvaluado != null) || (this.codEvaluado != null && !this.codEvaluado.equals(other.codEvaluado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdeEvalPK[ idEvaluacion=" + idEvaluacion + ", codEvaluador=" + codEvaluador + ", tipoEvaluacion=" + tipoEvaluacion + ", rolEvaluacion=" + rolEvaluacion + ", codEvaluado=" + codEvaluado + " ]";
    }
    
}
