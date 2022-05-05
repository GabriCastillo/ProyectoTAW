/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.entity;

import TAWapp.dto.ProductoDTO;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * @author RaulDF
 */
@Entity
@Table(name = "PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdproducto", query = "SELECT p FROM Producto p WHERE p.idproducto = :idproducto")
    , @NamedQuery(name = "Producto.findByTitulo", query = "SELECT p FROM Producto p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Producto.findByUrlImagen", query = "SELECT p FROM Producto p WHERE p.urlImagen = :urlImagen")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPRODUCTO")
    private Integer idproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TITULO")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "URL_IMAGEN")
    private String urlImagen;
    @JoinTable(name = "PRODUCTOS_FAVORITOS", joinColumns = {
        @JoinColumn(name = "PRODUCTO_IDPRODUCTO", referencedColumnName = "IDPRODUCTO")}, inverseJoinColumns = {
        @JoinColumn(name = "USUARIO_COMPRADOR", referencedColumnName = "IDUSUARIO")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @JoinColumn(name = "CATEGORIA_IDCATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne(optional = false)
    private Categoria categoriaIdcategoria;
    @JoinColumn(name = "USUARIO_VENDEDOR", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario usuarioVendedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoIdproducto")
    private List<CompradorProducto> compradorProductoList;

    public Producto() {
    }

    public Producto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Producto(Integer idproducto, String titulo, String descripcion, String urlImagen) {
        this.idproducto = idproducto;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Categoria getCategoriaIdcategoria() {
        return categoriaIdcategoria;
    }

    public void setCategoriaIdcategoria(Categoria categoriaIdcategoria) {
        this.categoriaIdcategoria = categoriaIdcategoria;
    }

    public Usuario getUsuarioVendedor() {
        return usuarioVendedor;
    }

    public void setUsuarioVendedor(Usuario usuarioVendedor) {
        this.usuarioVendedor = usuarioVendedor;
    }

    @XmlTransient
    public List<CompradorProducto> getCompradorProductoList() {
        return compradorProductoList;
    }

    public void setCompradorProductoList(List<CompradorProducto> compradorProductoList) {
        this.compradorProductoList = compradorProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TAWapp.entity.Producto[ idproducto=" + idproducto + " ]";
    }
    public ProductoDTO toDTO() {
        ProductoDTO dto = new ProductoDTO();
        dto.setIdproducto(idproducto);
        dto.setTitulo(titulo);
        dto.setDescripcion(descripcion);
        dto.setImagen(urlImagen);
        dto.setCategoriaIdcategoria(categoriaIdcategoria.toDTO());
        dto.setUsuarioVendedor(usuarioVendedor.toDTO());
        
        return dto;
    }
}
