/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *  @author Javier
 *  DONE: 100%
 *
 */
@Embeddable
public class ProductosFavoritosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_COMPRADOR")
    private int usuarioComprador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCTO_IDPRODUCTO")
    private int productoIdproducto;

    public ProductosFavoritosPK() {
    }

    public ProductosFavoritosPK(int usuarioComprador, int productoIdproducto) {
        this.usuarioComprador = usuarioComprador;
        this.productoIdproducto = productoIdproducto;
    }

    public int getUsuarioComprador() {
        return usuarioComprador;
    }

    public void setUsuarioComprador(int usuarioComprador) {
        this.usuarioComprador = usuarioComprador;
    }

    public int getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(int productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioComprador;
        hash += (int) productoIdproducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosFavoritosPK)) {
            return false;
        }
        ProductosFavoritosPK other = (ProductosFavoritosPK) object;
        if (this.usuarioComprador != other.usuarioComprador) {
            return false;
        }
        if (this.productoIdproducto != other.productoIdproducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProductosFavoritosPK[ usuarioComprador=" + usuarioComprador + ", productoIdproducto=" + productoIdproducto + " ]";
    }
    
}
