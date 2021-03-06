/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TAWapp.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author casti
 */
@Entity
@Table(name = "ESTADISTICA_HAS_COMPRADOR_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadisticaHasCompradorProducto.findAll", query = "SELECT e FROM EstadisticaHasCompradorProducto e"),
    @NamedQuery(name = "EstadisticaHasCompradorProducto.findByCompradorProductoIdcompra", query = "SELECT e FROM EstadisticaHasCompradorProducto e WHERE e.estadisticaHasCompradorProductoPK.compradorProductoIdcompra = :compradorProductoIdcompra"),
    @NamedQuery(name = "EstadisticaHasCompradorProducto.findByEstadisticaIdestadistica", query = "SELECT e FROM EstadisticaHasCompradorProducto e WHERE e.estadisticaHasCompradorProductoPK.estadisticaIdestadistica = :estadisticaIdestadistica")})
public class EstadisticaHasCompradorProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstadisticaHasCompradorProductoPK estadisticaHasCompradorProductoPK;
    @JoinColumn(name = "ESTADISTICA_IDESTADISTICA", referencedColumnName = "IDESTADISTICA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estadistica estadistica;

    public EstadisticaHasCompradorProducto() {
    }

    public EstadisticaHasCompradorProducto(EstadisticaHasCompradorProductoPK estadisticaHasCompradorProductoPK) {
        this.estadisticaHasCompradorProductoPK = estadisticaHasCompradorProductoPK;
    }

    public EstadisticaHasCompradorProducto(String compradorProductoIdcompra, int estadisticaIdestadistica) {
        this.estadisticaHasCompradorProductoPK = new EstadisticaHasCompradorProductoPK(compradorProductoIdcompra, estadisticaIdestadistica);
    }

    public EstadisticaHasCompradorProductoPK getEstadisticaHasCompradorProductoPK() {
        return estadisticaHasCompradorProductoPK;
    }

    public void setEstadisticaHasCompradorProductoPK(EstadisticaHasCompradorProductoPK estadisticaHasCompradorProductoPK) {
        this.estadisticaHasCompradorProductoPK = estadisticaHasCompradorProductoPK;
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
        hash += (estadisticaHasCompradorProductoPK != null ? estadisticaHasCompradorProductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadisticaHasCompradorProducto)) {
            return false;
        }
        EstadisticaHasCompradorProducto other = (EstadisticaHasCompradorProducto) object;
        if ((this.estadisticaHasCompradorProductoPK == null && other.estadisticaHasCompradorProductoPK != null) || (this.estadisticaHasCompradorProductoPK != null && !this.estadisticaHasCompradorProductoPK.equals(other.estadisticaHasCompradorProductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TAWapp.entity.EstadisticaHasCompradorProducto[ estadisticaHasCompradorProductoPK=" + estadisticaHasCompradorProductoPK + " ]";
    }
    
}
