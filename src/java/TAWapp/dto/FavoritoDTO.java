/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dto;

import TAWapp.entity.Producto;
import TAWapp.entity.Usuario;


/**
 *
 * @author Ruben 
 * Done: 100%
 */
public class FavoritoDTO {
    
    private Integer idfavorito;
   
    private Producto productoIdproducto;
    
    private Usuario usuarioComprador;

    public FavoritoDTO() {
    }
    
     public FavoritoDTO(Integer idfavorito) {
        this.idfavorito = idfavorito;
    }

    public Integer getIdfavorito() {
        return idfavorito;
    }

    public void setIdfavorito(Integer idfavorito) {
        this.idfavorito = idfavorito;
    }

    public Producto getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(Producto productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }

    public Usuario getUsuarioComprador() {
        return usuarioComprador;
    }

    public void setUsuarioComprador(Usuario usuarioComprador) {
        this.usuarioComprador = usuarioComprador;
        
    }
    
}
