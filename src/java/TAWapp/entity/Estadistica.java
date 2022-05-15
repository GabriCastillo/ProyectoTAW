/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.entity;

import TAWapp.dto.EstadisticaDTO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author capta
 */
@Entity
@Table(name = "ESTADISTICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadistica.findAll", query = "SELECT e FROM Estadistica e")
    , @NamedQuery(name = "Estadistica.findByIdestadistica", query = "SELECT e FROM Estadistica e WHERE e.idestadistica = :idestadistica")
    , @NamedQuery(name = "Estadistica.findByNombre", query = "SELECT e FROM Estadistica e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Estadistica.findByDescripcion", query = "SELECT e FROM Estadistica e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "Estadistica.findByValor", query = "SELECT e FROM Estadistica e WHERE e.valor = :valor")})
public class Estadistica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDESTADISTICA")
    private Integer idestadistica;
    @Size(max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 255)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private Double valor;
    @JoinColumn(name = "USUARIO_ANALISTA", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario usuarioAnalista;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "estadistica")
    private EstadisticaHasProductosFavoritos estadisticaHasProductosFavoritos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadistica")
    private List<EstadisticaHasCompradorProducto> estadisticaHasCompradorProductoList;

    public Estadistica() {
    }

    public Estadistica(Integer idestadistica) {
        this.idestadistica = idestadistica;
    }

    public Integer getIdestadistica() {
        return idestadistica;
    }

    public void setIdestadistica(Integer idestadistica) {
        this.idestadistica = idestadistica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Usuario getUsuarioAnalista() {
        return usuarioAnalista;
    }

    public void setUsuarioAnalista(Usuario usuarioAnalista) {
        this.usuarioAnalista = usuarioAnalista;
    }

    public EstadisticaHasProductosFavoritos getEstadisticaHasProductosFavoritos() {
        return estadisticaHasProductosFavoritos;
    }

    public void setEstadisticaHasProductosFavoritos(EstadisticaHasProductosFavoritos estadisticaHasProductosFavoritos) {
        this.estadisticaHasProductosFavoritos = estadisticaHasProductosFavoritos;
    }

    @XmlTransient
    public List<EstadisticaHasCompradorProducto> getEstadisticaHasCompradorProductoList() {
        return estadisticaHasCompradorProductoList;
    }

    public void setEstadisticaHasCompradorProductoList(List<EstadisticaHasCompradorProducto> estadisticaHasCompradorProductoList) {
        this.estadisticaHasCompradorProductoList = estadisticaHasCompradorProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadistica != null ? idestadistica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadistica)) {
            return false;
        }
        Estadistica other = (Estadistica) object;
        if ((this.idestadistica == null && other.idestadistica != null) || (this.idestadistica != null && !this.idestadistica.equals(other.idestadistica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TAWapp.entity.Estadistica[ idestadistica=" + idestadistica + " ]";
    }
    
    public EstadisticaDTO toDTO(){
        EstadisticaDTO dto = new EstadisticaDTO();
        dto.setIdestadistica(idestadistica);
        dto.setUsuarioAnalista(usuarioAnalista);
        dto.setNombre(nombre);
        dto.setDescripcion(descripcion);
        dto.setValor(valor);
        return dto;        
    }
    
}
