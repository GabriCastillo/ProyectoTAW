/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RaulDF
 */
@Entity
@Table(name = "ESTADISTICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadistica.findAll", query = "SELECT e FROM Estadistica e")
    , @NamedQuery(name = "Estadistica.findByIdestadistica", query = "SELECT e FROM Estadistica e WHERE e.idestadistica = :idestadistica")})
public class Estadistica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDESTADISTICA")
    private Integer idestadistica;
    @ManyToMany(mappedBy = "estadisticaList")
    private List<CompradorProducto> compradorProductoList;
    @JoinColumn(name = "USUARIO_ANALISTA", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario usuarioAnalista;

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

    @XmlTransient
    public List<CompradorProducto> getCompradorProductoList() {
        return compradorProductoList;
    }

    public void setCompradorProductoList(List<CompradorProducto> compradorProductoList) {
        this.compradorProductoList = compradorProductoList;
    }

    public Usuario getUsuarioAnalista() {
        return usuarioAnalista;
    }

    public void setUsuarioAnalista(Usuario usuarioAnalista) {
        this.usuarioAnalista = usuarioAnalista;
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
    
}
