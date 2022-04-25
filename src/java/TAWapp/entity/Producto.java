/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author casti
 */
@Entity
@Table(name = "PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdproducto", query = "SELECT p FROM Producto p WHERE p.idproducto = :idproducto")
    , @NamedQuery(name = "Producto.findByTitulo", query = "SELECT p FROM Producto p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Producto.findByUrlImagen", query = "SELECT p FROM Producto p WHERE p.urlImagen = :urlImagen")
    , @NamedQuery(name = "Producto.findByComprado", query = "SELECT p FROM Producto p WHERE p.comprado = :comprado")
    , @NamedQuery(name = "Producto.findByFechaAbierto", query = "SELECT p FROM Producto p WHERE p.fechaAbierto = :fechaAbierto")
    , @NamedQuery(name = "Producto.findByFechaCerrado", query = "SELECT p FROM Producto p WHERE p.fechaCerrado = :fechaCerrado")})
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
    @Size(min = 1, max = 45)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "URL_IMAGEN")
    private String urlImagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMPRADO")
    private Boolean comprado;
    @Column(name = "FECHA_ABIERTO")
    @Temporal(TemporalType.DATE)
    private Date fechaAbierto;
    @Column(name = "FECHA_CERRADO")
    @Temporal(TemporalType.DATE)
    private Date fechaCerrado;
    @JoinColumn(name = "CATEGORIA_IDCATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne(optional = false)
    private Categoria categoriaIdcategoria;
    @JoinColumn(name = "USUARIO_VENDEDOR", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private Usuario usuarioVendedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<ProductosFavoritos> productosFavoritosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoIdproducto")
    private List<CompradorProducto> compradorProductoList;

    public Producto() {
    }

    public Producto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Producto(Integer idproducto, String titulo, String descripcion, String urlImagen, Boolean comprado) {
        this.idproducto = idproducto;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.comprado = comprado;
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

    public Boolean getComprado() {
        return comprado;
    }

    public void setComprado(Boolean comprado) {
        this.comprado = comprado;
    }

    public Date getFechaAbierto() {
        return fechaAbierto;
    }

    public void setFechaAbierto(Date fechaAbierto) {
        this.fechaAbierto = fechaAbierto;
    }

    public Date getFechaCerrado() {
        return fechaCerrado;
    }

    public void setFechaCerrado(Date fechaCerrado) {
        this.fechaCerrado = fechaCerrado;
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
    public List<ProductosFavoritos> getProductosFavoritosList() {
        return productosFavoritosList;
    }

    public void setProductosFavoritosList(List<ProductosFavoritos> productosFavoritosList) {
        this.productosFavoritosList = productosFavoritosList;
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
    
}
