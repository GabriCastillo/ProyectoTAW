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
import javax.persistence.ManyToOne;
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
    , @NamedQuery(name = "EstadisticaHasProductosFavoritos.findByEstadisticaIdestadistica", query = "SELECT e FROM EstadisticaHasProductosFavoritos e WHERE e.estadisticaIdestadistica = :estadisticaIdestadistica")})
public class EstadisticaHasProductosFavoritos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADISTICA_IDESTADISTICA")
    private Integer estadisticaIdestadistica;
    @JoinColumn(name = "ESTADISTICA_IDESTADISTICA", referencedColumnName = "IDESTADISTICA", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Estadistica estadistica;
    @JoinColumn(name = "PRODUCTOS_FAVORITOS_ID", referencedColumnName = "IDFAVORITO")
    @ManyToOne(optional = false)
    private ProductosFavoritos productosFavoritosId;

    public EstadisticaHasProductosFavoritos() {
    }

    public EstadisticaHasProductosFavoritos(Integer estadisticaIdestadistica) {
        this.estadisticaIdestadistica = estadisticaIdestadistica;
    }

    public Integer getEstadisticaIdestadistica() {
        return estadisticaIdestadistica;
    }

    public void setEstadisticaIdestadistica(Integer estadisticaIdestadistica) {
        this.estadisticaIdestadistica = estadisticaIdestadistica;
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(Estadistica estadistica) {
        this.estadistica = estadistica;
    }

    public ProductosFavoritos getProductosFavoritosId() {
        return productosFavoritosId;
    }

    public void setProductosFavoritosId(ProductosFavoritos productosFavoritosId) {
        this.productosFavoritosId = productosFavoritosId;
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
