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

/**
 *
 * @author JBugarinP
 */
@Entity
@Table(name = "EDEM_EVALUADOS_CONF")
@NamedQueries({
    @NamedQuery(name = "EdemEvaluadosConf.findAll", query = "SELECT e FROM EdemEvaluadosConf e"),
    @NamedQuery(name = "EdemEvaluadosConf.findByTipoEvaluacion", query = "SELECT e FROM EdemEvaluadosConf e WHERE e.edemEvaluadosConfPK.tipoEvaluacion = :tipoEvaluacion"),
    @NamedQuery(name = "EdemEvaluadosConf.findByCodEvaluado", query = "SELECT e FROM EdemEvaluadosConf e WHERE e.edemEvaluadosConfPK.codEvaluado = :codEvaluado"),
    @NamedQuery(name = "EdemEvaluadosConf.findByMinCompromisos", query = "SELECT e FROM EdemEvaluadosConf e WHERE e.minCompromisos = :minCompromisos"),
    @NamedQuery(name = "EdemEvaluadosConf.findByAplicaExpectativas", query = "SELECT e FROM EdemEvaluadosConf e WHERE e.aplicaExpectativas = :aplicaExpectativas")})
public class EdemEvaluadosConf implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EdemEvaluadosConfPK edemEvaluadosConfPK;
    @Column(name = "Min_Compromisos")
    private Integer minCompromisos;
    @Column(name = "Aplica_Expectativas")
    private Character aplicaExpectativas;

    public EdemEvaluadosConf() {
    }

    public EdemEvaluadosConf(EdemEvaluadosConfPK edemEvaluadosConfPK) {
        this.edemEvaluadosConfPK = edemEvaluadosConfPK;
    }

    public EdemEvaluadosConf(String tipoEvaluacion, String codEvaluado) {
        this.edemEvaluadosConfPK = new EdemEvaluadosConfPK(tipoEvaluacion, codEvaluado);
    }

    public EdemEvaluadosConfPK getEdemEvaluadosConfPK() {
        return edemEvaluadosConfPK;
    }

    public void setEdemEvaluadosConfPK(EdemEvaluadosConfPK edemEvaluadosConfPK) {
        this.edemEvaluadosConfPK = edemEvaluadosConfPK;
    }

    public Integer getMinCompromisos() {
        return minCompromisos;
    }

    public void setMinCompromisos(Integer minCompromisos) {
        this.minCompromisos = minCompromisos;
    }

    public Character getAplicaExpectativas() {
        return aplicaExpectativas;
    }

    public void setAplicaExpectativas(Character aplicaExpectativas) {
        this.aplicaExpectativas = aplicaExpectativas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (edemEvaluadosConfPK != null ? edemEvaluadosConfPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdemEvaluadosConf)) {
            return false;
        }
        EdemEvaluadosConf other = (EdemEvaluadosConf) object;
        if ((this.edemEvaluadosConfPK == null && other.edemEvaluadosConfPK != null) || (this.edemEvaluadosConfPK != null && !this.edemEvaluadosConfPK.equals(other.edemEvaluadosConfPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdemEvaluadosConf[ edemEvaluadosConfPK=" + edemEvaluadosConfPK + " ]";
    }
    
}
