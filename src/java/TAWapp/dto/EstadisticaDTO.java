/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dto;

import TAWapp.entity.Usuario;

/**
 *
 * @author pepe_
 */
public class EstadisticaDTO {
    private String descripcion;
    private String nombre;
    private Integer idestadistica;
    private Usuario usuarioAnalista;
    private Double valor;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdestadistica() {
        return idestadistica;
    }

    public void setIdestadistica(Integer idestadistica) {
        this.idestadistica = idestadistica;
    }

    public Usuario getUsuarioAnalista() {
        return usuarioAnalista;
    }

    public void setUsuarioAnalista(Usuario usuarioAnalista) {
        this.usuarioAnalista = usuarioAnalista;
    }
    
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public EstadisticaDTO() {
   
    }
     
    
}
