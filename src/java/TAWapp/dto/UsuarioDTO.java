/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dto;

/**
 *
 * @author casti
 * Done: 100%
 */
public class UsuarioDTO {
    
    private Integer idusuario;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String ciudadResidencia;
    private int edad;
    private String sexo;
    private String password;
    private RolDTO rolIdrol;
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer idusuario) {
        this.idusuario = idusuario;
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


    public RolDTO getRolIdrol() {
        return rolIdrol;
    }

    public void setRolIdrol(RolDTO rolIdrol) {
        this.rolIdrol = rolIdrol;
    }
    
}
