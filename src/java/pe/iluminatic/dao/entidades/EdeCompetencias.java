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
@Table(name = "EDE_COMPETENCIAS")
@NamedQueries({
    @NamedQuery(name = "EdeCompetencias.findAll", query = "SELECT e FROM EdeCompetencias e"),
    @NamedQuery(name = "EdeCompetencias.findByIdEvaluacion", query = "SELECT e FROM EdeCompetencias e WHERE e.edeCompetenciasPK.idEvaluacion = :idEvaluacion"),
    @NamedQuery(name = "EdeCompetencias.findByItem", query = "SELECT e FROM EdeCompetencias e WHERE e.edeCompetenciasPK.item = :item"),
    @NamedQuery(name = "EdeCompetencias.findByCodPregunta", query = "SELECT e FROM EdeCompetencias e WHERE e.codPregunta = :codPregunta"),
    @NamedQuery(name = "EdeCompetencias.findByCodRespuesta", query = "SELECT e FROM EdeCompetencias e WHERE e.codRespuesta = :codRespuesta"),
    @NamedQuery(name = "EdeCompetencias.findByComportamientoIdent", query = "SELECT e FROM EdeCompetencias e WHERE e.comportamientoIdent = :comportamientoIdent")})
public class EdeCompetencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EdeCompetenciasPK edeCompetenciasPK;
    @Size(max = 4)
    @Column(name = "cod_Pregunta")
    private String codPregunta;
    @Size(max = 3)
    @Column(name = "cod_Respuesta")
    private String codRespuesta;
    @Size(max = 250)
    @Column(name = "comportamiento_Ident")
    private String comportamientoIdent;

    public EdeCompetencias() {
    }

    public EdeCompetencias(EdeCompetenciasPK edeCompetenciasPK) {
        this.edeCompetenciasPK = edeCompetenciasPK;
    }

    public EdeCompetencias(int idEvaluacion, int item) {
        this.edeCompetenciasPK = new EdeCompetenciasPK(idEvaluacion, item);
    }

    public EdeCompetenciasPK getEdeCompetenciasPK() {
        return edeCompetenciasPK;
    }

    public void setEdeCompetenciasPK(EdeCompetenciasPK edeCompetenciasPK) {
        this.edeCompetenciasPK = edeCompetenciasPK;
    }

    public String getCodPregunta() {
        return codPregunta;
    }

    public void setCodPregunta(String codPregunta) {
        this.codPregunta = codPregunta;
    }

    public String getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(String codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    public String getComportamientoIdent() {
        return comportamientoIdent;
    }

    public void setComportamientoIdent(String comportamientoIdent) {
        this.comportamientoIdent = comportamientoIdent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (edeCompetenciasPK != null ? edeCompetenciasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdeCompetencias)) {
            return false;
        }
        EdeCompetencias other = (EdeCompetencias) object;
        if ((this.edeCompetenciasPK == null && other.edeCompetenciasPK != null) || (this.edeCompetenciasPK != null && !this.edeCompetenciasPK.equals(other.edeCompetenciasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdeCompetencias[ edeCompetenciasPK=" + edeCompetenciasPK + " ]";
    }
    
}
