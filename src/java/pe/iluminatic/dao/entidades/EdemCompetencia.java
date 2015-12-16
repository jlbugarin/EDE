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
@Table(name = "edem_competencia")
@NamedQueries({
    @NamedQuery(name = "EdemCompetencia.findAll", query = "SELECT e FROM EdemCompetencia e"),
    @NamedQuery(name = "EdemCompetencia.findByCodPregunta", query = "SELECT e FROM EdemCompetencia e WHERE e.codPregunta = :codPregunta"),
    @NamedQuery(name = "EdemCompetencia.findByDescripcion", query = "SELECT e FROM EdemCompetencia e WHERE e.descripcion = :descripcion")})
public class EdemCompetencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_Pregunta")
    private String codPregunta;
    @Size(max = 250)
    @Column(name = "Descripcion")
    private String descripcion;

    public EdemCompetencia() {
    }

    public EdemCompetencia(String codPregunta) {
        this.codPregunta = codPregunta;
    }

    public String getCodPregunta() {
        return codPregunta;
    }

    public void setCodPregunta(String codPregunta) {
        this.codPregunta = codPregunta;
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
        hash += (codPregunta != null ? codPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdemCompetencia)) {
            return false;
        }
        EdemCompetencia other = (EdemCompetencia) object;
        if ((this.codPregunta == null && other.codPregunta != null) || (this.codPregunta != null && !this.codPregunta.equals(other.codPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdemCompetencia[ codPregunta=" + codPregunta + " ]";
    }
    
}
