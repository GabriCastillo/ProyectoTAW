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
import javax.validation.constraints.Size;

/**
 *  @author Javier
 *  DONE: 100%
 *
 */
@Embeddable
public class EstadisticaHasCompradorProductoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "COMPRADOR_PRODUCTO_IDCOMPRA")
    private String compradorProductoIdcompra;
    @Basic(optional = false)
    @NotNull
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
