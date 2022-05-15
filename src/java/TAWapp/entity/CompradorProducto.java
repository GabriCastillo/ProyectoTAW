/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.entity;

import TAWapp.dto.CompradorProductoDTO;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author frees
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compradorProducto")
    private Collection<EstadisticaHasCompradorProducto> estadisticaHasCompradorProductoCollection;
    @JoinColumn(name = "PRODUCTO_IDPRODUCTO", referencedColumnName = "IDPRODUCTO")
    @ManyToOne(optional = false)
    private Producto productoIdproducto;
    @JoinColumn(name = "USUARIO_VENDEDOR", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario usuarioVendedor;
    @JoinColumn(name = "USUARIO_COMPRADOR", referencedColumnName = "IDUSUARIO")
    @ManyToOne
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
    
    public Usuario getcomprador() {
        return usuarioComprador;
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
    public Collection<EstadisticaHasCompradorProducto> getEstadisticaHasCompradorProductoCollection() {
        return estadisticaHasCompradorProductoCollection;
    }

    public void setEstadisticaHasCompradorProductoCollection(Collection<EstadisticaHasCompradorProducto> estadisticaHasCompradorProductoCollection) {
        this.estadisticaHasCompradorProductoCollection = estadisticaHasCompradorProductoCollection;
    }

    public Producto getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(Producto productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }

    public Usuario getUsuarioVendedor() {
        return usuarioVendedor;
    }

    public void setUsuarioVendedor(Usuario usuarioVendedor) {
        this.usuarioVendedor = usuarioVendedor;
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
        return "TAWapp.dao.CompradorProducto[ idcompra=" + idcompra + " ]";
    }

    public CompradorProductoDTO toDTO() {
        CompradorProductoDTO dto = new CompradorProductoDTO();
        
          dto.setIdCompradorProductoDTO(idcompra);
          dto.setPrecio_Compra(precioCompra);
          dto.setPrecio_salida(precioSalida);
          dto.setProducto(productoIdproducto.toDTO());
          dto.setVendedor(usuarioVendedor.toDTO());
          dto.setComprador(usuarioComprador.toDTO());
          return dto;
    }
    
}
