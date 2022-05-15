/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dto;

import TAWapp.entity.Usuario;

/**
 * 
 * @author Javier
 */
public class ListaDTO {
    private Integer idLista;
    private String nombre;
    private Usuario usuarioLista;

    public ListaDTO() {
    }

    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuarioLista() {
        return usuarioLista;
    }

    public void setUsuarioLista(Usuario usuarioLista) {
        this.usuarioLista = usuarioLista;
    }
}
