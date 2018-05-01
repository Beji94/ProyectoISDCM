/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Beñat
 */
@Entity
@Table(name = "VIDEOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Videos.findAll", query = "SELECT v FROM Videos v")
    , @NamedQuery(name = "Videos.findByIdentificador", query = "SELECT v FROM Videos v WHERE v.identificador = :identificador")
    , @NamedQuery(name = "Videos.findByTitulo", query = "SELECT v FROM Videos v WHERE v.titulo = :titulo")
    , @NamedQuery(name = "Videos.findByAutor", query = "SELECT v FROM Videos v WHERE v.autor = :autor")
    , @NamedQuery(name = "Videos.findByFecha", query = "SELECT v FROM Videos v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Videos.findByDuracion", query = "SELECT v FROM Videos v WHERE v.duracion = :duracion")
    , @NamedQuery(name = "Videos.findByReproduccion", query = "SELECT v FROM Videos v WHERE v.reproduccion = :reproduccion")
    , @NamedQuery(name = "Videos.findByDescripcion", query = "SELECT v FROM Videos v WHERE v.descripcion = :descripcion")
    , @NamedQuery(name = "Videos.findByFormato", query = "SELECT v FROM Videos v WHERE v.formato = :formato")
    , @NamedQuery(name = "Videos.findByUrl", query = "SELECT v FROM Videos v WHERE v.url = :url")
    , @NamedQuery(name = "Videos.findByApubli", query = "SELECT v FROM Videos v WHERE v.apubli = :apubli")})
public class Videos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDENTIFICADOR")
    private Long identificador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TITULO")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "AUTOR")
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DURACION")
    @Temporal(TemporalType.TIME)
    private Date duracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REPRODUCCION")
    private int reproduccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "FORMATO")
    private String formato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "URL")
    private String url;
    @Column(name = "APUBLI")
    private Integer apubli;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "IDENTIFICADOR")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public Videos() {
    }

    public Videos(Long identificador) {
        this.identificador = identificador;
    }

    public Videos(Long identificador, String titulo, String autor, Date fecha, Date duracion, int reproduccion, String descripcion, String formato, String url) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = fecha;
        this.duracion = duracion;
        this.reproduccion = reproduccion;
        this.descripcion = descripcion;
        this.formato = formato;
        this.url = url;
    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    public int getReproduccion() {
        return reproduccion;
    }

    public void setReproduccion(int reproduccion) {
        this.reproduccion = reproduccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getApubli() {
        return apubli;
    }

    public void setApubli(Integer apubli) {
        this.apubli = apubli;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificador != null ? identificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Videos)) {
            return false;
        }
        Videos other = (Videos) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Videos[ identificador=" + identificador + " ]";
    }
    
}
