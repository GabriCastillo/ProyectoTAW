/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.service;

import TAWapp.dao.EstadisticaFacade;
import TAWapp.dao.UsuarioFacade;
import TAWapp.dto.EstadisticaDTO;
import TAWapp.entity.Estadistica;
import TAWapp.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author pepe_
 * Done: 100%
 */
@Stateless
public class EstadisticaService {
   
    @EJB
    EstadisticaFacade estadisticaFacade;
    
    @EJB
    UsuarioFacade usuarioFacade;
    
    public List<EstadisticaDTO> listaEntityADTO (List<Estadistica> lista){
        List<EstadisticaDTO> listaDTO = null;
        if (lista != null){
            listaDTO = new ArrayList<>();
            for (Estadistica estadistica:lista){
                listaDTO.add(estadistica.toDTO());
            }
        }
        return listaDTO;
    }
    
    public List<EstadisticaDTO> listarEstadisticas (String findByTitulo){
        List<Estadistica> estadisticas;
        
        if (findByTitulo == null || findByTitulo.isEmpty()){
            estadisticas = this.estadisticaFacade.findAll();
        }else{
            estadisticas = this.estadisticaFacade.findByTitulo(findByTitulo);
        }
        return this.listaEntityADTO(estadisticas);
    }
    
    public List<Estadistica> listaEstadisticas (String findByTitulo){
        List<Estadistica> estadisticas;
        
        if (findByTitulo == null || findByTitulo.isEmpty()){
            estadisticas = this.estadisticaFacade.findAll();
        }else{
            estadisticas = this.estadisticaFacade.findByTitulo(findByTitulo);
        }
        return estadisticas;
    }
    
    public EstadisticaDTO buscarEstadistica(Integer id){
        Estadistica estadistica = this.estadisticaFacade.find(id);
        return estadistica.toDTO();
    }
    
    private void rellenarEstadistica(Estadistica estadistica, int usuarioAnalista, String nombre, String descripcion, double valor){
        
        Usuario usuario = this.usuarioFacade.find(usuarioAnalista);
        
        estadistica.setUsuarioAnalista(usuario);
        estadistica.setNombre(nombre);
        estadistica.setDescripcion(descripcion);
        //estadistica.setValor(valor);
    }
    
    public void crearEstadistica(int usuarioAnalista, String nombre, String descripcion, double valor){
        Estadistica estadistica = new Estadistica();
        this.rellenarEstadistica(estadistica, usuarioAnalista, nombre, descripcion, valor);
        
        this.estadisticaFacade.create(estadistica);
    }
    
    public void modifcarEstadistica(Integer id, int usuarioAnalista, String nombre, String descripcion, double valor){
        
        Estadistica estadistica = this.estadisticaFacade.find(id);
        Usuario u = estadistica.getUsuarioAnalista();
        u.getEstadisticaList().remove(estadistica);
        
        this.rellenarEstadistica(estadistica, usuarioAnalista, nombre, descripcion, valor);
        
        this.estadisticaFacade.edit(estadistica);
    }
    
    public void borrarEstadistica(Integer id) {
        Estadistica estadistica = this.estadisticaFacade.find(id);
        Usuario u = estadistica.getUsuarioAnalista();
        u.getEstadisticaList().remove(estadistica);

        this.estadisticaFacade.remove(estadistica);
    }
    
/*    private mediaPrecios(List<double> lista){
        List<double> media = null;
        
        return media;
    }
*/    
    public void MediaVentas(){
        
    }    
}
