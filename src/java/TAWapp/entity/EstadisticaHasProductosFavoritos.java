/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author casti
 */
@Entity
@Table(name = "ESTADISTICA_HAS_PRODUCTOS_FAVORITOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadisticaHasProductosFavoritos.findAll", query = "SELECT e FROM EstadisticaHasProductosFavoritos e")
    , @NamedQuery(name = "EstadisticaHasProductosFavoritos.findByEstadisticaIdestadistica", query = "SELECT e FROM EstadisticaHasProductosFavoritos e WHERE e.estadisticaIdestadistica = :estadisticaIdestadistica")
    , @NamedQuery(name = "EstadisticaHasProductosFavoritos.findByProductosFavoritosUsuarioComprador", query = "SELECT e FROM EstadisticaHasProductosFavoritos e WHERE e.productosFavoritosUsuarioComprador = :productosFavoritosUsuarioComprador")
    , @NamedQuery(name = "EstadisticaHasProductosFavoritos.findByProductosFavoritosProductoIdproducto", query = "SELECT e FROM EstadisticaHasProductosFavoritos e WHERE e.productosFavoritosProductoIdproducto = :productosFavoritosProductoIdproducto")})
public class EstadisticaHasProductosFavoritos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADISTICA_IDESTADISTICA")
    private Integer estadisticaIdestadistica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCTOS_FAVORITOS_USUARIO_COMPRADOR")
    private int productosFavoritosUsuarioComprador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCTOS_FAVORITOS_PRODUCTO_IDPRODUCTO")
    private int productosFavoritosProductoIdproducto;
    @JoinColumn(name = "ESTADISTICA_IDESTADISTICA", referencedColumnName = "IDESTADISTICA", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Estadistica estadistica;

    public EstadisticaHasProductosFavoritos() {
    }

    public EstadisticaHasProductosFavoritos(Integer estadisticaIdestadistica) {
        this.estadisticaIdestadistica = estadisticaIdestadistica;
    }

    public EstadisticaHasProductosFavoritos(Integer estadisticaIdestadistica, int productosFavoritosUsuarioComprador, int productosFavoritosProductoIdproducto) {
        this.estadisticaIdestadistica = estadisticaIdestadistica;
        this.productosFavoritosUsuarioComprador = productosFavoritosUsuarioComprador;
        this.productosFavoritosProductoIdproducto = productosFavoritosProductoIdproducto;
    }

    public Integer getEstadisticaIdestadistica() {
        return estadisticaIdestadistica;
    }

    public void setEstadisticaIdestadistica(Integer estadisticaIdestadistica) {
        this.estadisticaIdestadistica = estadisticaIdestadistica;
    }

    public int getProductosFavoritosUsuarioComprador() {
        return productosFavoritosUsuarioComprador;
    }

    public void setProductosFavoritosUsuarioComprador(int productosFavoritosUsuarioComprador) {
        this.productosFavoritosUsuarioComprador = productosFavoritosUsuarioComprador;
    }

    public int getProductosFavoritosProductoIdproducto() {
        return productosFavoritosProductoIdproducto;
    }

    public void setProductosFavoritosProductoIdproducto(int productosFavoritosProductoIdproducto) {
        this.productosFavoritosProductoIdproducto = productosFavoritosProductoIdproducto;
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(Estadistica estadistica) {
        this.estadistica = estadistica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadisticaIdestadistica != null ? estadisticaIdestadistica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadisticaHasProductosFavoritos)) {
            return false;
        }
        EstadisticaHasProductosFavoritos other = (EstadisticaHasProductosFavoritos) object;
        if ((this.estadisticaIdestadistica == null && other.estadisticaIdestadistica != null) || (this.estadisticaIdestadistica != null && !this.estadisticaIdestadistica.equals(other.estadisticaIdestadistica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TAWapp.entity.EstadisticaHasProductosFavoritos[ estadisticaIdestadistica=" + estadisticaIdestadistica + " ]";
    }
    
}
