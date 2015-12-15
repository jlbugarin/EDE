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
@Table(name = "ede_expectativas")
@NamedQueries({
    @NamedQuery(name = "EdeExpectativas.findAll", query = "SELECT e FROM EdeExpectativas e"),
    @NamedQuery(name = "EdeExpectativas.findByIdEvaluacion", query = "SELECT e FROM EdeExpectativas e WHERE e.edeExpectativasPK.idEvaluacion = :idEvaluacion"),
    @NamedQuery(name = "EdeExpectativas.findByItem", query = "SELECT e FROM EdeExpectativas e WHERE e.edeExpectativasPK.item = :item"),
    @NamedQuery(name = "EdeExpectativas.findByExpecDelEvaluado", query = "SELECT e FROM EdeExpectativas e WHERE e.expecDelEvaluado = :expecDelEvaluado"),
    @NamedQuery(name = "EdeExpectativas.findByExpecSobreEvaluado", query = "SELECT e FROM EdeExpectativas e WHERE e.expecSobreEvaluado = :expecSobreEvaluado"),
    @NamedQuery(name = "EdeExpectativas.findByExpecSobreEquipo", query = "SELECT e FROM EdeExpectativas e WHERE e.expecSobreEquipo = :expecSobreEquipo"),
    @NamedQuery(name = "EdeExpectativas.findByLogros", query = "SELECT e FROM EdeExpectativas e WHERE e.logros = :logros"),
    @NamedQuery(name = "EdeExpectativas.findByConocimientoClave", query = "SELECT e FROM EdeExpectativas e WHERE e.conocimientoClave = :conocimientoClave"),
    @NamedQuery(name = "EdeExpectativas.findByFortalezasArea", query = "SELECT e FROM EdeExpectativas e WHERE e.fortalezasArea = :fortalezasArea"),
    @NamedQuery(name = "EdeExpectativas.findByOportunidadesArea", query = "SELECT e FROM EdeExpectativas e WHERE e.oportunidadesArea = :oportunidadesArea"),
    @NamedQuery(name = "EdeExpectativas.findByComentarios", query = "SELECT e FROM EdeExpectativas e WHERE e.comentarios = :comentarios")})
public class EdeExpectativas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EdeExpectativasPK edeExpectativasPK;
    @Size(max = 250)
    @Column(name = "Expec_Del_Evaluado")
    private String expecDelEvaluado;
    @Size(max = 250)
    @Column(name = "Expec_Sobre_Evaluado")
    private String expecSobreEvaluado;
    @Size(max = 250)
    @Column(name = "Expec_Sobre_Equipo")
    private String expecSobreEquipo;
    @Size(max = 250)
    @Column(name = "Logros")
    private String logros;
    @Size(max = 250)
    @Column(name = "Conocimiento_Clave")
    private String conocimientoClave;
    @Size(max = 250)
    @Column(name = "Fortalezas_Area")
    private String fortalezasArea;
    @Size(max = 250)
    @Column(name = "Oportunidades_Area")
    private String oportunidadesArea;
    @Size(max = 250)
    @Column(name = "Comentarios")
    private String comentarios;

    public EdeExpectativas() {
    }

    public EdeExpectativas(EdeExpectativasPK edeExpectativasPK) {
        this.edeExpectativasPK = edeExpectativasPK;
    }

    public EdeExpectativas(int idEvaluacion, int item) {
        this.edeExpectativasPK = new EdeExpectativasPK(idEvaluacion, item);
    }

    public EdeExpectativasPK getEdeExpectativasPK() {
        return edeExpectativasPK;
    }

    public void setEdeExpectativasPK(EdeExpectativasPK edeExpectativasPK) {
        this.edeExpectativasPK = edeExpectativasPK;
    }

    public String getExpecDelEvaluado() {
        return expecDelEvaluado;
    }

    public void setExpecDelEvaluado(String expecDelEvaluado) {
        this.expecDelEvaluado = expecDelEvaluado;
    }

    public String getExpecSobreEvaluado() {
        return expecSobreEvaluado;
    }

    public void setExpecSobreEvaluado(String expecSobreEvaluado) {
        this.expecSobreEvaluado = expecSobreEvaluado;
    }

    public String getExpecSobreEquipo() {
        return expecSobreEquipo;
    }

    public void setExpecSobreEquipo(String expecSobreEquipo) {
        this.expecSobreEquipo = expecSobreEquipo;
    }

    public String getLogros() {
        return logros;
    }

    public void setLogros(String logros) {
        this.logros = logros;
    }

    public String getConocimientoClave() {
        return conocimientoClave;
    }

    public void setConocimientoClave(String conocimientoClave) {
        this.conocimientoClave = conocimientoClave;
    }

    public String getFortalezasArea() {
        return fortalezasArea;
    }

    public void setFortalezasArea(String fortalezasArea) {
        this.fortalezasArea = fortalezasArea;
    }

    public String getOportunidadesArea() {
        return oportunidadesArea;
    }

    public void setOportunidadesArea(String oportunidadesArea) {
        this.oportunidadesArea = oportunidadesArea;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (edeExpectativasPK != null ? edeExpectativasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdeExpectativas)) {
            return false;
        }
        EdeExpectativas other = (EdeExpectativas) object;
        if ((this.edeExpectativasPK == null && other.edeExpectativasPK != null) || (this.edeExpectativasPK != null && !this.edeExpectativasPK.equals(other.edeExpectativasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdeExpectativas[ edeExpectativasPK=" + edeExpectativasPK + " ]";
    }
    
}
