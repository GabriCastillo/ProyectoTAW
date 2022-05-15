/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.entity;

import TAWapp.dto.FavoritoDTO;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author capta
 */
@Entity
@Table(name = "PRODUCTOS_FAVORITOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductosFavoritos.findAll", query = "SELECT p FROM ProductosFavoritos p")
    , @NamedQuery(name = "ProductosFavoritos.findByIdfavorito", query = "SELECT p FROM ProductosFavoritos p WHERE p.idfavorito = :idfavorito")})
public class ProductosFavoritos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFAVORITO")
    private Integer idfavorito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productosFavoritosId")
    private List<EstadisticaHasProductosFavoritos> estadisticaHasProductosFavoritosList;
    @JoinColumn(name = "PRODUCTO_IDPRODUCTO", referencedColumnName = "IDPRODUCTO")
    @ManyToOne(optional = false)
    private Producto productoIdproducto;
    @JoinColumn(name = "USUARIO_COMPRADOR", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario usuarioComprador;

    public ProductosFavoritos() {
    }

    public ProductosFavoritos(Integer idfavorito) {
        this.idfavorito = idfavorito;
    }

    public Integer getIdfavorito() {
        return idfavorito;
    }

    public void setIdfavorito(Integer idfavorito) {
        this.idfavorito = idfavorito;
    }

    @XmlTransient
    public List<EstadisticaHasProductosFavoritos> getEstadisticaHasProductosFavoritosList() {
        return estadisticaHasProductosFavoritosList;
    }

    public void setEstadisticaHasProductosFavoritosList(List<EstadisticaHasProductosFavoritos> estadisticaHasProductosFavoritosList) {
        this.estadisticaHasProductosFavoritosList = estadisticaHasProductosFavoritosList;
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
        hash += (idfavorito != null ? idfavorito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosFavoritos)) {
            return false;
        }
        ProductosFavoritos other = (ProductosFavoritos) object;
        if ((this.idfavorito == null && other.idfavorito != null) || (this.idfavorito != null && !this.idfavorito.equals(other.idfavorito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TAWapp.entity.Productosfavoritos[ idfavorito=" + idfavorito + " ]";
    }
    
    public FavoritoDTO toDTO(){
        FavoritoDTO dto = new FavoritoDTO();
        dto.setProductoIdproducto(productoIdproducto);
        dto.setUsuarioComprador(usuarioComprador);
        dto.setIdfavorito(idfavorito);
        return dto;
    }
}
