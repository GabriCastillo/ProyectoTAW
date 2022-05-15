/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author frees
 */
@Entity
@Table(name = "PRODUCTOS_FAVORITOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductosFavoritos.findAll", query = "SELECT p FROM ProductosFavoritos p")
    , @NamedQuery(name = "ProductosFavoritos.findByUsuarioComprador", query = "SELECT p FROM ProductosFavoritos p WHERE p.productosFavoritosPK.usuarioComprador = :usuarioComprador")
    , @NamedQuery(name = "ProductosFavoritos.findByProductoIdproducto", query = "SELECT p FROM ProductosFavoritos p WHERE p.productosFavoritosPK.productoIdproducto = :productoIdproducto")})
public class ProductosFavoritos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductosFavoritosPK productosFavoritosPK;
    @JoinColumn(name = "PRODUCTO_IDPRODUCTO", referencedColumnName = "IDPRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "USUARIO_COMPRADOR", referencedColumnName = "IDUSUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    

    public ProductosFavoritos() {
    }

    public ProductosFavoritos(ProductosFavoritosPK productosFavoritosPK) {
        this.productosFavoritosPK = productosFavoritosPK;
    }

    public ProductosFavoritos(int usuarioComprador, int productoIdproducto) {
        this.productosFavoritosPK = new ProductosFavoritosPK(usuarioComprador, productoIdproducto);
    }

    public ProductosFavoritosPK getProductosFavoritosPK() {
        return productosFavoritosPK;
    }

    public void setProductosFavoritosPK(ProductosFavoritosPK productosFavoritosPK) {
        this.productosFavoritosPK = productosFavoritosPK;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productosFavoritosPK != null ? productosFavoritosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosFavoritos)) {
            return false;
        }
        ProductosFavoritos other = (ProductosFavoritos) object;
        if ((this.productosFavoritosPK == null && other.productosFavoritosPK != null) || (this.productosFavoritosPK != null && !this.productosFavoritosPK.equals(other.productosFavoritosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TAWapp.dao.ProductosFavoritos[ productosFavoritosPK=" + productosFavoritosPK + " ]";
    }
    
}
