/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.entity;

import TAWapp.dto.UsuarioDTO;
import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author frees
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByApellido", query = "SELECT u FROM Usuario u WHERE u.apellido = :apellido")
    , @NamedQuery(name = "Usuario.findByDomicilio", query = "SELECT u FROM Usuario u WHERE u.domicilio = :domicilio")
    , @NamedQuery(name = "Usuario.findByCiudadResidencia", query = "SELECT u FROM Usuario u WHERE u.ciudadResidencia = :ciudadResidencia")
    , @NamedQuery(name = "Usuario.findByEdad", query = "SELECT u FROM Usuario u WHERE u.edad = :edad")
    , @NamedQuery(name = "Usuario.findBySexo", query = "SELECT u FROM Usuario u WHERE u.sexo = :sexo")
    , @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDUSUARIO")
    private Integer idusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DOMICILIO")
    private String domicilio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CIUDAD_RESIDENCIA")
    private String ciudadResidencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EDAD")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "SEXO")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioAnalista")
    private Collection<Estadistica> estadisticaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioVendedor")
    private Collection<Producto> productoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<ProductosFavoritos> productosFavoritosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioVendedor")
    private Collection<CompradorProducto> compradorProductoCollection;
    @OneToMany(mappedBy = "usuarioComprador")
    private Collection<CompradorProducto> compradorProductoCollection1;
    @JoinColumn(name = "ROL_IDROL", referencedColumnName = "ID_ROL")
    @ManyToOne(optional = false)
    private Rol rolIdrol;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(Integer idusuario, String nombre, String apellido, String domicilio, String ciudadResidencia, int edad, String sexo, String password) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.ciudadResidencia = ciudadResidencia;
        this.edad = edad;
        this.sexo = sexo;
        this.password = password;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Estadistica> getEstadisticaCollection() {
        return estadisticaCollection;
    }

    public void setEstadisticaCollection(Collection<Estadistica> estadisticaCollection) {
        this.estadisticaCollection = estadisticaCollection;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @XmlTransient
    public Collection<ProductosFavoritos> getProductosFavoritosCollection() {
        return productosFavoritosCollection;
    }

    public void setProductosFavoritosCollection(Collection<ProductosFavoritos> productosFavoritosCollection) {
        this.productosFavoritosCollection = productosFavoritosCollection;
    }

    @XmlTransient
    public Collection<CompradorProducto> getCompradorProductoCollection() {
        return compradorProductoCollection;
    }

    public void setCompradorProductoCollection(Collection<CompradorProducto> compradorProductoCollection) {
        this.compradorProductoCollection = compradorProductoCollection;
    }

    @XmlTransient
    public Collection<CompradorProducto> getCompradorProductoCollection1() {
        return compradorProductoCollection1;
    }

    public void setCompradorProductoCollection1(Collection<CompradorProducto> compradorProductoCollection1) {
        this.compradorProductoCollection1 = compradorProductoCollection1;
    }

    public Rol getRolIdrol() {
        return rolIdrol;
    }

    public void setRolIdrol(Rol rolIdrol) {
        this.rolIdrol = rolIdrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TAWapp.dao.Usuario[ idusuario=" + idusuario + " ]";
    }

    public Object getProductoList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public UsuarioDTO toDTO() {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdusuario(idusuario);   
        dto.setRolIdrol(rolIdrol.toDTO());
        dto.setNombre(nombre);
        dto.setPassword(password);
        dto.setApellido(apellido);
        dto.setCiudadResidencia(ciudadResidencia);
        dto.setDomicilio(domicilio);
        dto.setEdad(edad);
        dto.setSexo(sexo);
        return dto;        
    }

    public Object getCompradorProductoList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
