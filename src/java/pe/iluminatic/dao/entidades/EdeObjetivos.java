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
@Table(name = "EDE_OBJETIVOS")
@NamedQueries({
    @NamedQuery(name = "EdeObjetivos.findAll", query = "SELECT e FROM EdeObjetivos e"),
    @NamedQuery(name = "EdeObjetivos.findByIdEvaluacion", query = "SELECT e FROM EdeObjetivos e WHERE e.edeObjetivosPK.idEvaluacion = :idEvaluacion"),
    @NamedQuery(name = "EdeObjetivos.findByItem", query = "SELECT e FROM EdeObjetivos e WHERE e.edeObjetivosPK.item = :item"),
    @NamedQuery(name = "EdeObjetivos.findByCodCategoria", query = "SELECT e FROM EdeObjetivos e WHERE e.codCategoria = :codCategoria"),
    @NamedQuery(name = "EdeObjetivos.findByPorPeso", query = "SELECT e FROM EdeObjetivos e WHERE e.porPeso = :porPeso"),
    @NamedQuery(name = "EdeObjetivos.findByDefinicionObjetivo", query = "SELECT e FROM EdeObjetivos e WHERE e.definicionObjetivo = :definicionObjetivo"),
    @NamedQuery(name = "EdeObjetivos.findByNombreIndicador", query = "SELECT e FROM EdeObjetivos e WHERE e.nombreIndicador = :nombreIndicador"),
    @NamedQuery(name = "EdeObjetivos.findByUnidad", query = "SELECT e FROM EdeObjetivos e WHERE e.unidad = :unidad"),
    @NamedQuery(name = "EdeObjetivos.findByTipo", query = "SELECT e FROM EdeObjetivos e WHERE e.tipo = :tipo"),
    @NamedQuery(name = "EdeObjetivos.findByFuenteValidacion", query = "SELECT e FROM EdeObjetivos e WHERE e.fuenteValidacion = :fuenteValidacion"),
    @NamedQuery(name = "EdeObjetivos.findByMetaMinimo", query = "SELECT e FROM EdeObjetivos e WHERE e.metaMinimo = :metaMinimo"),
    @NamedQuery(name = "EdeObjetivos.findByMetaMaximo", query = "SELECT e FROM EdeObjetivos e WHERE e.metaMaximo = :metaMaximo"),
    @NamedQuery(name = "EdeObjetivos.findByPresiciones", query = "SELECT e FROM EdeObjetivos e WHERE e.presiciones = :presiciones"),
    @NamedQuery(name = "EdeObjetivos.findByEscalaMinMeta", query = "SELECT e FROM EdeObjetivos e WHERE e.escalaMinMeta = :escalaMinMeta"),
    @NamedQuery(name = "EdeObjetivos.findByEscalaMeta", query = "SELECT e FROM EdeObjetivos e WHERE e.escalaMeta = :escalaMeta"),
    @NamedQuery(name = "EdeObjetivos.findByEscalaMaxMeta", query = "SELECT e FROM EdeObjetivos e WHERE e.escalaMaxMeta = :escalaMaxMeta"),
    @NamedQuery(name = "EdeObjetivos.findByPorAvanceRevIntermedia", query = "SELECT e FROM EdeObjetivos e WHERE e.porAvanceRevIntermedia = :porAvanceRevIntermedia"),
    @NamedQuery(name = "EdeObjetivos.findByComentarioRevIntermedia", query = "SELECT e FROM EdeObjetivos e WHERE e.comentarioRevIntermedia = :comentarioRevIntermedia"),
    @NamedQuery(name = "EdeObjetivos.findByIndRevObjetivosIntermedia", query = "SELECT e FROM EdeObjetivos e WHERE e.indRevObjetivosIntermedia = :indRevObjetivosIntermedia"),
    @NamedQuery(name = "EdeObjetivos.findByPorAvanceRevFinal", query = "SELECT e FROM EdeObjetivos e WHERE e.porAvanceRevFinal = :porAvanceRevFinal"),
    @NamedQuery(name = "EdeObjetivos.findByComentarioRevFinal", query = "SELECT e FROM EdeObjetivos e WHERE e.comentarioRevFinal = :comentarioRevFinal"),
    @NamedQuery(name = "EdeObjetivos.findByIndRevObjetivosFinal", query = "SELECT e FROM EdeObjetivos e WHERE e.indRevObjetivosFinal = :indRevObjetivosFinal"),
    @NamedQuery(name = "EdeObjetivos.findByResultado", query = "SELECT e FROM EdeObjetivos e WHERE e.resultado = :resultado"),
    @NamedQuery(name = "EdeObjetivos.findByPorCumplimiento", query = "SELECT e FROM EdeObjetivos e WHERE e.porCumplimiento = :porCumplimiento"),
    @NamedQuery(name = "EdeObjetivos.findByLogroporPeso", query = "SELECT e FROM EdeObjetivos e WHERE e.logroporPeso = :logroporPeso"),
    @NamedQuery(name = "EdeObjetivos.findByComentarioEvaluacion", query = "SELECT e FROM EdeObjetivos e WHERE e.comentarioEvaluacion = :comentarioEvaluacion")})
public class EdeObjetivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EdeObjetivosPK edeObjetivosPK;
    @Size(max = 2)
    @Column(name = "cod_Categoria")
    private String codCategoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Por_Peso")
    private Double porPeso;
    @Size(max = 250)
    @Column(name = "Definicion_Objetivo")
    private String definicionObjetivo;
    @Size(max = 200)
    @Column(name = "Nombre_Indicador")
    private String nombreIndicador;
    @Size(max = 3)
    @Column(name = "Unidad")
    private String unidad;
    @Column(name = "Tipo")
    private Character tipo;
    @Size(max = 250)
    @Column(name = "Fuente_Validacion")
    private String fuenteValidacion;
    @Column(name = "Meta_Minimo")
    private Integer metaMinimo;
    @Column(name = "Meta_Maximo")
    private Integer metaMaximo;
    @Size(max = 200)
    @Column(name = "Presiciones")
    private String presiciones;
    @Column(name = "Escala_Min_Meta")
    private Double escalaMinMeta;
    @Column(name = "Escala_Meta")
    private Double escalaMeta;
    @Column(name = "Escala_Max_Meta")
    private Double escalaMaxMeta;
    @Column(name = "Por_Avance_Rev_Intermedia")
    private Double porAvanceRevIntermedia;
    @Size(max = 250)
    @Column(name = "Comentario_Rev_Intermedia")
    private String comentarioRevIntermedia;
    @Column(name = "ind_Rev_Objetivos_Intermedia")
    private Character indRevObjetivosIntermedia;
    @Column(name = "Por_Avance_Rev_Final")
    private Double porAvanceRevFinal;
    @Size(max = 250)
    @Column(name = "Comentario_Rev_Final")
    private String comentarioRevFinal;
    @Column(name = "ind_Rev_Objetivos_Final")
    private Character indRevObjetivosFinal;
    @Column(name = "Resultado")
    private Double resultado;
    @Column(name = "Por_Cumplimiento")
    private Double porCumplimiento;
    @Column(name = "Logro_por_Peso")
    private Double logroporPeso;
    @Size(max = 250)
    @Column(name = "Comentario_Evaluacion")
    private String comentarioEvaluacion;

    public EdeObjetivos() {
    }

    public EdeObjetivos(EdeObjetivosPK edeObjetivosPK) {
        this.edeObjetivosPK = edeObjetivosPK;
    }

    public EdeObjetivos(int idEvaluacion, int item) {
        this.edeObjetivosPK = new EdeObjetivosPK(idEvaluacion, item);
    }

    public EdeObjetivosPK getEdeObjetivosPK() {
        return edeObjetivosPK;
    }

    public void setEdeObjetivosPK(EdeObjetivosPK edeObjetivosPK) {
        this.edeObjetivosPK = edeObjetivosPK;
    }

    public String getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
    }

    public Double getPorPeso() {
        return porPeso;
    }

    public void setPorPeso(Double porPeso) {
        this.porPeso = porPeso;
    }

    public String getDefinicionObjetivo() {
        return definicionObjetivo;
    }

    public void setDefinicionObjetivo(String definicionObjetivo) {
        this.definicionObjetivo = definicionObjetivo;
    }

    public String getNombreIndicador() {
        return nombreIndicador;
    }

    public void setNombreIndicador(String nombreIndicador) {
        this.nombreIndicador = nombreIndicador;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public String getFuenteValidacion() {
        return fuenteValidacion;
    }

    public void setFuenteValidacion(String fuenteValidacion) {
        this.fuenteValidacion = fuenteValidacion;
    }

    public Integer getMetaMinimo() {
        return metaMinimo;
    }

    public void setMetaMinimo(Integer metaMinimo) {
        this.metaMinimo = metaMinimo;
    }

    public Integer getMetaMaximo() {
        return metaMaximo;
    }

    public void setMetaMaximo(Integer metaMaximo) {
        this.metaMaximo = metaMaximo;
    }

    public String getPresiciones() {
        return presiciones;
    }

    public void setPresiciones(String presiciones) {
        this.presiciones = presiciones;
    }

    public Double getEscalaMinMeta() {
        return escalaMinMeta;
    }

    public void setEscalaMinMeta(Double escalaMinMeta) {
        this.escalaMinMeta = escalaMinMeta;
    }

    public Double getEscalaMeta() {
        return escalaMeta;
    }

    public void setEscalaMeta(Double escalaMeta) {
        this.escalaMeta = escalaMeta;
    }

    public Double getEscalaMaxMeta() {
        return escalaMaxMeta;
    }

    public void setEscalaMaxMeta(Double escalaMaxMeta) {
        this.escalaMaxMeta = escalaMaxMeta;
    }

    public Double getPorAvanceRevIntermedia() {
        return porAvanceRevIntermedia;
    }

    public void setPorAvanceRevIntermedia(Double porAvanceRevIntermedia) {
        this.porAvanceRevIntermedia = porAvanceRevIntermedia;
    }

    public String getComentarioRevIntermedia() {
        return comentarioRevIntermedia;
    }

    public void setComentarioRevIntermedia(String comentarioRevIntermedia) {
        this.comentarioRevIntermedia = comentarioRevIntermedia;
    }

    public Character getIndRevObjetivosIntermedia() {
        return indRevObjetivosIntermedia;
    }

    public void setIndRevObjetivosIntermedia(Character indRevObjetivosIntermedia) {
        this.indRevObjetivosIntermedia = indRevObjetivosIntermedia;
    }

    public Double getPorAvanceRevFinal() {
        return porAvanceRevFinal;
    }

    public void setPorAvanceRevFinal(Double porAvanceRevFinal) {
        this.porAvanceRevFinal = porAvanceRevFinal;
    }

    public String getComentarioRevFinal() {
        return comentarioRevFinal;
    }

    public void setComentarioRevFinal(String comentarioRevFinal) {
        this.comentarioRevFinal = comentarioRevFinal;
    }

    public Character getIndRevObjetivosFinal() {
        return indRevObjetivosFinal;
    }

    public void setIndRevObjetivosFinal(Character indRevObjetivosFinal) {
        this.indRevObjetivosFinal = indRevObjetivosFinal;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public Double getPorCumplimiento() {
        return porCumplimiento;
    }

    public void setPorCumplimiento(Double porCumplimiento) {
        this.porCumplimiento = porCumplimiento;
    }

    public Double getLogroporPeso() {
        return logroporPeso;
    }

    public void setLogroporPeso(Double logroporPeso) {
        this.logroporPeso = logroporPeso;
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
        hash += (edeObjetivosPK != null ? edeObjetivosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdeObjetivos)) {
            return false;
        }
        EdeObjetivos other = (EdeObjetivos) object;
        if ((this.edeObjetivosPK == null && other.edeObjetivosPK != null) || (this.edeObjetivosPK != null && !this.edeObjetivosPK.equals(other.edeObjetivosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.iluminatic.dao.entidades.EdeObjetivos[ edeObjetivosPK=" + edeObjetivosPK + " ]";
    }
    
}
