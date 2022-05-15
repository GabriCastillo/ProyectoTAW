/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.entity;

import TAWapp.dto.CorreoDTO;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author capta
 */
@Entity
@Table(name = "CORREO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Correo.findAll", query = "SELECT c FROM Correo c")
    , @NamedQuery(name = "Correo.findByIdpromo", query = "SELECT c FROM Correo c WHERE c.idpromo = :idpromo")
    , @NamedQuery(name = "Correo.findByMensaje", query = "SELECT c FROM Correo c WHERE c.mensaje = :mensaje")})
public class Correo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPROMO")
    private Integer idpromo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "MENSAJE")
    private String mensaje;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "IDPRODUCTO")
    @ManyToOne
    private Producto idProducto;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Correo() {
    }

    public Correo(Integer idpromo) {
        this.idpromo = idpromo;
    }

    public Correo(Integer idpromo, String mensaje) {
        this.idpromo = idpromo;
        this.mensaje = mensaje;
    }

    public Integer getIdpromo() {
        return idpromo;
    }

    public void setIdpromo(Integer idpromo) {
        this.idpromo = idpromo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpromo != null ? idpromo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correo)) {
            return false;
        }
        Correo other = (Correo) object;
        if ((this.idpromo == null && other.idpromo != null) || (this.idpromo != null && !this.idpromo.equals(other.idpromo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TAWapp.entity.Correo[ idpromo=" + idpromo + " ]";
    }
    
     public CorreoDTO toDTO () {    
        CorreoDTO dto = new CorreoDTO();
        dto.setIdpromo(this.idpromo);
        dto.setMensaje(this.mensaje);
        dto.setIdProducto(this.idProducto);
        dto.setIdUsuario(this.idUsuario);
                
        return dto;        
    } 
}
