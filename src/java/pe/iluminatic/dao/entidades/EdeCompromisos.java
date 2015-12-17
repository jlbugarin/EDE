/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.iluminatic.dao.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author JBugarinP
 */
@Entity
@Table(name = "EDE_COMPROMISOS")
@NamedQueries({
    @NamedQuery(name = "EdeCompromisos.findAll", query = "SELECT e FROM EdeCompromisos e"),
    @NamedQuery(name = "EdeCompromisos.findByIdEvaluacion", query = "SELECT e FROM EdeCompromisos e WHERE e.edeCompromisosPK.idEvaluacion = :idEvaluacion"),
    @NamedQuery(name = "EdeCompromisos.findByItem", query = "SELECT e FROM EdeCompromisos e WHERE e.edeCompromisosPK.item = :item"),
    @NamedQuery(name = "EdeCompromisos.findByDescripcion", query = "SELECT e FROM EdeCompromisos e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EdeCompromisos.findByPeriodo", query = "SELECT e FROM EdeCompromisos e WHERE e.periodo = :periodo"),
    @NamedQuery(name = "EdeCompromisos.findByFechaFinal", query = "SELECT e FROM EdeCompromisos e WHERE e.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "EdeCompromisos.findByCodNivelEva", query = "SELECT e FROM EdeCompromisos e WHERE e.codNivelEva = :codNivelEva"),
    @NamedQuery(name = "EdeCompromisos.findByComentarioEvaluacion", query = "SELECT e FROM EdeCompromisos e WHERE e.comentarioEvaluacion = :comentarioEvaluacion")})
public class EdeCompromisos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EdeCompromisosPK edeCompromisosPK;
    @Size(max = 250)
    @Column(name = "Descripcion")
    private String descripcion;
    @Size(max = 2)
    @Column(name = "Periodo")
    private String periodo;
    @Column(name = "Fecha_Final")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @Size(max = 2)
    @Column(name = "cod_Nivel_Eva")
    private String codNivelEva;
    @Size(max = 250)
    @Column(name = "Comentario_Evaluacion")
    private String comentarioEvaluacion;

    public EdeCompromisos() {
    }

    public EdeCompromisos(EdeCompromisosPK edeCompromisosPK) {
        this.edeCompromisosPK = edeCompromisosPK;
    }

    public EdeCompromisos(int idEvaluacion, int item) {
        this.edeCompromisosPK = new EdeCompromisosPK(idEvaluacion, item);
    }

    public EdeCompromisosPK getEdeCompromisosPK() {
        return edeCompromisosPK;
    }

    public void setEdeCompromisosPK(EdeCompromisosPK edeCompromisosPK) {
        this.edeCompromisosPK = edeCompromisosPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getCodNivelEva() {
        return codNivelEva;
    }

    public void setCodNivelEva(String codNivelEva) {
        this.codNivelEva = codNivelEva;
    }

    public String getComentarioEvaluacion() {
        return comentarioEvaluacion;
    }

    public void setComentarioEvaluacion(String comentarioEvaluacion) {
        this.comentarioEvaluacion = comentarioEvaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (edeCompromisosPK != null ? edeCompromisosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdeCompromisos)) {
            return false;
        }
        EdeCompromisos other = (EdeCompromisos) object;
        if ((this.edeCompromisosPK == null && other.edeCompromisosPK != null) || (this.edeCompromisosPK != null && !this.edeCompromisosPK.equals(other.edeCompromisosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdeCompromisos[ edeCompromisosPK=" + edeCompromisosPK + " ]";
    }
    
}
