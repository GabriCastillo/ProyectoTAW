/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.entity;

import TAWapp.entity.EstadisticaHasCompradorProducto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author casti
 */
@Entity
@Table(name = "COMPRADOR_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompradorProducto.findAll", query = "SELECT c FROM CompradorProducto c")
    , @NamedQuery(name = "CompradorProducto.findByIdcompra", query = "SELECT c FROM CompradorProducto c WHERE c.idcompra = :idcompra")
    , @NamedQuery(name = "CompradorProducto.findByPrecioSalida", query = "SELECT c FROM CompradorProducto c WHERE c.precioSalida = :precioSalida")
    , @NamedQuery(name = "CompradorProducto.findByPrecioCompra", query = "SELECT c FROM CompradorProducto c WHERE c.precioCompra = :precioCompra")})
public class CompradorProducto implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compradorProducto")
    private List<EstadisticaHasCompradorProducto> estadisticaHasCompradorProductoList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "IDCOMPRA")
    private String idcompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_SALIDA")
    private int precioSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_COMPRA")
    private int precioCompra;
    @JoinTable(name = "ESTADISTICA_HAS_COMPRADOR_PRODUCTO", joinColumns = {
        @JoinColumn(name = "COMPRADOR_PRODUCTO_IDCOMPRA", referencedColumnName = "IDCOMPRA")}, inverseJoinColumns = {
        @JoinColumn(name = "ESTADISTICA_IDESTADISTICA", referencedColumnName = "IDESTADISTICA")})
    @ManyToMany
    private List<Estadistica> estadisticaList;
    @JoinColumn(name = "PRODUCTO_IDPRODUCTO", referencedColumnName = "IDPRODUCTO")
    @ManyToOne(optional = false)
    private Producto productoIdproducto;
    @JoinColumn(name = "USUARIO_COMPRADOR", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario usuarioComprador;

    public CompradorProducto() {
    }

    public CompradorProducto(String idcompra) {
        this.idcompra = idcompra;
    }

    public CompradorProducto(String idcompra, int precioSalida, int precioCompra) {
        this.idcompra = idcompra;
        this.precioSalida = precioSalida;
        this.precioCompra = precioCompra;
    }

    public String getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(String idcompra) {
        this.idcompra = idcompra;
    }

    public int getPrecioSalida() {
        return precioSalida;
    }

    public void setPrecioSalida(int precioSalida) {
        this.precioSalida = precioSalida;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    @XmlTransient
    public List<Estadistica> getEstadisticaList() {
        return estadisticaList;
    }

    public void setEstadisticaList(List<Estadistica> estadisticaList) {
        this.estadisticaList = estadisticaList;
    }

    public Producto getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(Producto productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }

    public Usuario getUsuarioComprador() {
        return usuarioComprador;
    }

    public void setUsuarioComprador(Usuario usuarioComprador) {
        this.usuarioComprador = usuarioComprador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompra != null ? idcompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompradorProducto)) {
            return false;
        }
        CompradorProducto other = (CompradorProducto) object;
        if ((this.idcompra == null && other.idcompra != null) || (this.idcompra != null && !this.idcompra.equals(other.idcompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TAWapp.entity.CompradorProducto[ idcompra=" + idcompra + " ]";
    }

    @XmlTransient
    public List<EstadisticaHasCompradorProducto> getEstadisticaHasCompradorProductoList() {
        return estadisticaHasCompradorProductoList;
    }

    public void setEstadisticaHasCompradorProductoList(List<EstadisticaHasCompradorProducto> estadisticaHasCompradorProductoList) {
        this.estadisticaHasCompradorProductoList = estadisticaHasCompradorProductoList;
    }

    
}
