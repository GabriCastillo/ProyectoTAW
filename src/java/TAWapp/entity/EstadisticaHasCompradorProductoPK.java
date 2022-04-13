/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TAWapp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author casti
 */
@Embeddable
public class EstadisticaHasCompradorProductoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "COMPRADOR_PRODUCTO_IDCOMPRA")
    private String compradorProductoIdcompra;
    @Basic(optional = false)
    @Column(name = "ESTADISTICA_IDESTADISTICA")
    private int estadisticaIdestadistica;

    public EstadisticaHasCompradorProductoPK() {
    }

    public EstadisticaHasCompradorProductoPK(String compradorProductoIdcompra, int estadisticaIdestadistica) {
        this.compradorProductoIdcompra = compradorProductoIdcompra;
        this.estadisticaIdestadistica = estadisticaIdestadistica;
    }

    public String getCompradorProductoIdcompra() {
        return compradorProductoIdcompra;
    }

    public void setCompradorProductoIdcompra(String compradorProductoIdcompra) {
        this.compradorProductoIdcompra = compradorProductoIdcompra;
    }

    public int getEstadisticaIdestadistica() {
        return estadisticaIdestadistica;
    }

    public void setEstadisticaIdestadistica(int estadisticaIdestadistica) {
        this.estadisticaIdestadistica = estadisticaIdestadistica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compradorProductoIdcompra != null ? compradorProductoIdcompra.hashCode() : 0);
        hash += (int) estadisticaIdestadistica;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadisticaHasCompradorProductoPK)) {
            return false;
        }
        EstadisticaHasCompradorProductoPK other = (EstadisticaHasCompradorProductoPK) object;
        if ((this.compradorProductoIdcompra == null && other.compradorProductoIdcompra != null) || (this.compradorProductoIdcompra != null && !this.compradorProductoIdcompra.equals(other.compradorProductoIdcompra))) {
            return false;
        }
        if (this.estadisticaIdestadistica != other.estadisticaIdestadistica) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TAWapp.entity.EstadisticaHasCompradorProductoPK[ compradorProductoIdcompra=" + compradorProductoIdcompra + ", estadisticaIdestadistica=" + estadisticaIdestadistica + " ]";
    }
    
}
