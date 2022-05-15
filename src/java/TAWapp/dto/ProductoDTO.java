/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dto;

/**
 *
 * @author casti
 */
public class ProductoDTO {
    

   
    private Integer idproducto;
    private String titulo;
    private String descripcion;
    private String imagen;
    private UsuarioDTO usuarioVendedor;
     
    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }
    public UsuarioDTO getUsuarioVendedor() {
        return usuarioVendedor;
    }

    public void setUsuarioVendedor(UsuarioDTO usuarioVendedor) {
        this.usuarioVendedor = usuarioVendedor;
    }
    private CategoriaDTO categoria;
    
    public ProductoDTO(){
        
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen() {
        return imagen;
    }
    
    public CategoriaDTO getCategoriaIdcategoria() {
        return categoria;
    }

    public void setCategoriaIdcategoria(CategoriaDTO categoriaIdcategoria) {
        this.categoria = categoriaIdcategoria;
    }
}
