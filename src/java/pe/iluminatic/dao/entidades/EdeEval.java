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
 * @author jlbugarin
 */
@Entity
@Table(name = "EEE_EVAL")
@NamedQueries({
    @NamedQuery(name = "EdeEval.findAll", query = "SELECT e FROM EdeEval e"),
    @NamedQuery(name = "EdeEval.findByIdEvaluacion", query = "SELECT e FROM EdeEval e WHERE e.edeEvalPK.idEvaluacion = :idEvaluacion"),
    @NamedQuery(name = "EdeEval.findByCodEvaluador", query = "SELECT e FROM EdeEval e WHERE e.edeEvalPK.codEvaluador = :codEvaluador"),
    @NamedQuery(name = "EdeEval.findByTipoEvaluacion", query = "SELECT e FROM EdeEval e WHERE e.edeEvalPK.tipoEvaluacion = :tipoEvaluacion"),
    @NamedQuery(name = "EdeEval.findByRolEvaluacion", query = "SELECT e FROM EdeEval e WHERE e.edeEvalPK.rolEvaluacion = :rolEvaluacion"),
    @NamedQuery(name = "EdeEval.findByCodEvaluado", query = "SELECT e FROM EdeEval e WHERE e.edeEvalPK.codEvaluado = :codEvaluado"),
    @NamedQuery(name = "EdeEval.findByNombresEvaluador", query = "SELECT e FROM EdeEval e WHERE e.nombresEvaluador = :nombresEvaluador"),
    @NamedQuery(name = "EdeEval.findByPosicionEvaluador", query = "SELECT e FROM EdeEval e WHERE e.posicionEvaluador = :posicionEvaluador"),
    @NamedQuery(name = "EdeEval.findByNombreEvaluado", query = "SELECT e FROM EdeEval e WHERE e.nombreEvaluado = :nombreEvaluado"),
    @NamedQuery(name = "EdeEval.findByPosicionEvaluado", query = "SELECT e FROM EdeEval e WHERE e.posicionEvaluado = :posicionEvaluado"),
    @NamedQuery(name = "EdeEval.findByTipoEmpleado", query = "SELECT e FROM EdeEval e WHERE e.tipoEmpleado = :tipoEmpleado"),
    @NamedQuery(name = "EdeEval.findByFechaIngresoEvaluado", query = "SELECT e FROM EdeEval e WHERE e.fechaIngresoEvaluado = :fechaIngresoEvaluado"),
    @NamedQuery(name = "EdeEval.findByNumDefiObjetivos", query = "SELECT e FROM EdeEval e WHERE e.numDefiObjetivos = :numDefiObjetivos"),
    @NamedQuery(name = "EdeEval.findByNumDefiCompromisos", query = "SELECT e FROM EdeEval e WHERE e.numDefiCompromisos = :numDefiCompromisos"),
    @NamedQuery(name = "EdeEval.findByEstadoDefi", query = "SELECT e FROM EdeEval e WHERE e.estadoDefi = :estadoDefi"),
    @NamedQuery(name = "EdeEval.findByNumReIntObjetivos", query = "SELECT e FROM EdeEval e WHERE e.numReIntObjetivos = :numReIntObjetivos"),
    @NamedQuery(name = "EdeEval.findByNumReIntCompromisos", query = "SELECT e FROM EdeEval e WHERE e.numReIntCompromisos = :numReIntCompromisos"),
    @NamedQuery(name = "EdeEval.findByEstadoReInt", query = "SELECT e FROM EdeEval e WHERE e.estadoReInt = :estadoReInt"),
    @NamedQuery(name = "EdeEval.findByNumReFinObjetivos", query = "SELECT e FROM EdeEval e WHERE e.numReFinObjetivos = :numReFinObjetivos"),
    @NamedQuery(name = "EdeEval.findByNumReFinCompromisos", query = "SELECT e FROM EdeEval e WHERE e.numReFinCompromisos = :numReFinCompromisos"),
    @NamedQuery(name = "EdeEval.findByEstadoEval", query = "SELECT e FROM EdeEval e WHERE e.estadoEval = :estadoEval"),
    @NamedQuery(name = "EdeEval.findByEstadoCompe", query = "SELECT e FROM EdeEval e WHERE e.estadoCompe = :estadoCompe"),
    @NamedQuery(name = "EdeEval.findByNumEvaForta", query = "SELECT e FROM EdeEval e WHERE e.numEvaForta = :numEvaForta"),
    @NamedQuery(name = "EdeEval.findByNumEvaOpor", query = "SELECT e FROM EdeEval e WHERE e.numEvaOpor = :numEvaOpor"),
    @NamedQuery(name = "EdeEval.findByEstadoEvaForta", query = "SELECT e FROM EdeEval e WHERE e.estadoEvaForta = :estadoEvaForta"),
    @NamedQuery(name = "EdeEval.findByRevIntermediaCompromiso", query = "SELECT e FROM EdeEval e WHERE e.revIntermediaCompromiso = :revIntermediaCompromiso"),
    @NamedQuery(name = "EdeEval.findByRevIntermediaExpectativa", query = "SELECT e FROM EdeEval e WHERE e.revIntermediaExpectativa = :revIntermediaExpectativa"),
    @NamedQuery(name = "EdeEval.findByRevFinalCompromiso", query = "SELECT e FROM EdeEval e WHERE e.revFinalCompromiso = :revFinalCompromiso"),
    @NamedQuery(name = "EdeEval.findByRevFinalExpectativa", query = "SELECT e FROM EdeEval e WHERE e.revFinalExpectativa = :revFinalExpectativa")})
public class EdeEval implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EdeEvalPK edeEvalPK;
    @Size(max = 100)
    @Column(name = "Nombres_Evaluador")
    private String nombresEvaluador;
    @Size(max = 45)
    @Column(name = "Posicion_Evaluador")
    private String posicionEvaluador;
    @Size(max = 100)
    @Column(name = "Nombre_Evaluado")
    private String nombreEvaluado;
    @Size(max = 45)
    @Column(name = "Posicion_Evaluado")
    private String posicionEvaluado;
    @Size(max = 2)
    @Column(name = "Tipo_Empleado")
    private String tipoEmpleado;
    @Column(name = "Fecha_Ingreso_Evaluado")
    @Temporal(TemporalType.DATE)
    private Date fechaIngresoEvaluado;
    @Column(name = "Num_Defi_Objetivos")
    private Integer numDefiObjetivos;
    @Column(name = "Num_Defi_Compromisos")
    private Integer numDefiCompromisos;
    @Size(max = 2)
    @Column(name = "Estado_Defi")
    private String estadoDefi;
    @Column(name = "Num_ReInt_Objetivos")
    private Integer numReIntObjetivos;
    @Column(name = "Num_ReInt_Compromisos")
    private Integer numReIntCompromisos;
    @Size(max = 2)
    @Column(name = "Estado_ReInt")
    private String estadoReInt;
    @Column(name = "Num_ReFin_Objetivos")
    private Integer numReFinObjetivos;
    @Column(name = "Num_ReFin_Compromisos")
    private Integer numReFinCompromisos;
    @Size(max = 2)
    @Column(name = "Estado_Eval")
    private String estadoEval;
    @Size(max = 2)
    @Column(name = "Estado_Compe")
    private String estadoCompe;
    @Column(name = "Num_Eva_Forta")
    private Integer numEvaForta;
    @Column(name = "Num_Eva_Opor")
    private Integer numEvaOpor;
    @Size(max = 2)
    @Column(name = "Estado_Eva_Forta")
    private String estadoEvaForta;
    @Size(max = 250)
    @Column(name = "Rev_Intermedia_Compromiso")
    private String revIntermediaCompromiso;
    @Size(max = 250)
    @Column(name = "Rev_Intermedia_Expectativa")
    private String revIntermediaExpectativa;
    @Size(max = 250)
    @Column(name = "Rev_Final_Compromiso")
    private String revFinalCompromiso;
    @Size(max = 250)
    @Column(name = "Rev_Final_Expectativa")
    private String revFinalExpectativa;

    public EdeEval() {
    }

    public EdeEval(EdeEvalPK edeEvalPK) {
        this.edeEvalPK = edeEvalPK;
    }

    public EdeEval(int idEvaluacion, String codEvaluador, String tipoEvaluacion, String rolEvaluacion, String codEvaluado) {
        this.edeEvalPK = new EdeEvalPK(idEvaluacion, codEvaluador, tipoEvaluacion, rolEvaluacion, codEvaluado);
    }

    public EdeEvalPK getEdeEvalPK() {
        return edeEvalPK;
    }

    public void setEdeEvalPK(EdeEvalPK edeEvalPK) {
        this.edeEvalPK = edeEvalPK;
    }

    public String getNombresEvaluador() {
        return nombresEvaluador;
    }

    public void setNombresEvaluador(String nombresEvaluador) {
        this.nombresEvaluador = nombresEvaluador;
    }

    public String getPosicionEvaluador() {
        return posicionEvaluador;
    }

    public void setPosicionEvaluador(String posicionEvaluador) {
        this.posicionEvaluador = posicionEvaluador;
    }

    public String getNombreEvaluado() {
        return nombreEvaluado;
    }

    public void setNombreEvaluado(String nombreEvaluado) {
        this.nombreEvaluado = nombreEvaluado;
    }

    public String getPosicionEvaluado() {
        return posicionEvaluado;
    }

    public void setPosicionEvaluado(String posicionEvaluado) {
        this.posicionEvaluado = posicionEvaluado;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public Date getFechaIngresoEvaluado() {
        return fechaIngresoEvaluado;
    }

    public void setFechaIngresoEvaluado(Date fechaIngresoEvaluado) {
        this.fechaIngresoEvaluado = fechaIngresoEvaluado;
    }

    public Integer getNumDefiObjetivos() {
        return numDefiObjetivos;
    }

    public void setNumDefiObjetivos(Integer numDefiObjetivos) {
        this.numDefiObjetivos = numDefiObjetivos;
    }

    public Integer getNumDefiCompromisos() {
        return numDefiCompromisos;
    }

    public void setNumDefiCompromisos(Integer numDefiCompromisos) {
        this.numDefiCompromisos = numDefiCompromisos;
    }

    public String getEstadoDefi() {
        return estadoDefi;
    }

    public void setEstadoDefi(String estadoDefi) {
        this.estadoDefi = estadoDefi;
    }

    public Integer getNumReIntObjetivos() {
        return numReIntObjetivos;
    }

    public void setNumReIntObjetivos(Integer numReIntObjetivos) {
        this.numReIntObjetivos = numReIntObjetivos;
    }

    public Integer getNumReIntCompromisos() {
        return numReIntCompromisos;
    }

    public void setNumReIntCompromisos(Integer numReIntCompromisos) {
        this.numReIntCompromisos = numReIntCompromisos;
    }

    public String getEstadoReInt() {
        return estadoReInt;
    }

    public void setEstadoReInt(String estadoReInt) {
        this.estadoReInt = estadoReInt;
    }

    public Integer getNumReFinObjetivos() {
        return numReFinObjetivos;
    }

    public void setNumReFinObjetivos(Integer numReFinObjetivos) {
        this.numReFinObjetivos = numReFinObjetivos;
    }

    public Integer getNumReFinCompromisos() {
        return numReFinCompromisos;
    }

    public void setNumReFinCompromisos(Integer numReFinCompromisos) {
        this.numReFinCompromisos = numReFinCompromisos;
    }

    public String getEstadoEval() {
        return estadoEval;
    }

    public void setEstadoEval(String estadoEval) {
        this.estadoEval = estadoEval;
    }

    public String getEstadoCompe() {
        return estadoCompe;
    }

    public void setEstadoCompe(String estadoCompe) {
        this.estadoCompe = estadoCompe;
    }

    public Integer getNumEvaForta() {
        return numEvaForta;
    }

    public void setNumEvaForta(Integer numEvaForta) {
        this.numEvaForta = numEvaForta;
    }

    public Integer getNumEvaOpor() {
        return numEvaOpor;
    }

    public void setNumEvaOpor(Integer numEvaOpor) {
        this.numEvaOpor = numEvaOpor;
    }

    public String getEstadoEvaForta() {
        return estadoEvaForta;
    }

    public void setEstadoEvaForta(String estadoEvaForta) {
        this.estadoEvaForta = estadoEvaForta;
    }

    public String getRevIntermediaCompromiso() {
        return revIntermediaCompromiso;
    }

    public void setRevIntermediaCompromiso(String revIntermediaCompromiso) {
        this.revIntermediaCompromiso = revIntermediaCompromiso;
    }

    public String getRevIntermediaExpectativa() {
        return revIntermediaExpectativa;
    }

    public void setRevIntermediaExpectativa(String revIntermediaExpectativa) {
        this.revIntermediaExpectativa = revIntermediaExpectativa;
    }

    public String getRevFinalCompromiso() {
        return revFinalCompromiso;
    }

    public void setRevFinalCompromiso(String revFinalCompromiso) {
        this.revFinalCompromiso = revFinalCompromiso;
    }

    public String getRevFinalExpectativa() {
        return revFinalExpectativa;
    }

    public void setRevFinalExpectativa(String revFinalExpectativa) {
        this.revFinalExpectativa = revFinalExpectativa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (edeEvalPK != null ? edeEvalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdeEval)) {
            return false;
        }
        EdeEval other = (EdeEval) object;
        if ((this.edeEvalPK == null && other.edeEvalPK != null) || (this.edeEvalPK != null && !this.edeEvalPK.equals(other.edeEvalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdeEval[ edeEvalPK=" + edeEvalPK + " ]";
    }
    
}
