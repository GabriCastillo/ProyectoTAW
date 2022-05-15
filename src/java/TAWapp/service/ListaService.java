/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.service;

import TAWapp.dao.ListaFacade;
import TAWapp.dao.UsuarioFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import TAWapp.dto.ListaDTO;
import TAWapp.dto.UsuarioDTO;
import TAWapp.entity.Lista;
import TAWapp.entity.Usuario;

/**
 *  @author Javier
 *  DONE: 100%
 *
 */
@Stateless
public class ListaService {
    @EJB ListaFacade listaFacade;
    @EJB UsuarioFacade usuarioFacade;
    
    private List<ListaDTO> listaEntityADTO (List<Lista> listas) {
        List<ListaDTO> listaDTO = null;
        if (listas != null) {
            listaDTO = new ArrayList<>();
            for (Lista lista : listas) {
                listaDTO.add(lista.toDTO());
            }
        }
        return listaDTO;
    }
    
    public List<ListaDTO> listarListas (String filtroNombre) {
        List<Lista> listas = null;

        if (filtroNombre == null || filtroNombre.isEmpty()) {
            listas = this.listaFacade.findAll();        
        } else {
            listas = this.listaFacade.findByNombre(filtroNombre);
        }
        
        return this.listaEntityADTO(listas);  
    }
    
    public void crearLista (String nombre) {
        if(!nombre.isEmpty()) {
            Lista lista = new Lista();
            lista.setNombre(nombre);  
            this.listaFacade.create(lista);
        }
    }
    
    public void borrarListasNombres (String nombreListaBorrar) {
        List<Lista> listas = this.listaFacade.findByNombre(nombreListaBorrar);  
        listas.forEach((lista) -> {
            this.listaFacade.remove(lista);
        });
    }
    
    public void anadirUsuarioLista (int idLista, int idUsuario) {
        Lista listaByID = this.listaFacade.find(idLista);
        Usuario usuarioByID = this.usuarioFacade.find(idUsuario);
        
        if(listaByID.getUsuarioLista() == null) {
            listaByID.setUsuarioLista(usuarioByID);
            this.listaFacade.edit(listaByID);
        } else {
            List<Lista> listasByNombre = this.listaFacade.findByNombre(listaByID.getNombre()); 
            Boolean usuarioExiste = false;
            for(Lista lista : listasByNombre) {
                if(lista.getUsuarioLista().getIdusuario() == idUsuario) {
                    usuarioExiste = true;
                }
            }
            
            if(!usuarioExiste) {
                Lista lista = new Lista();
                lista.setNombre(listaByID.getNombre());
                lista.setUsuarioLista(usuarioByID);
                this.listaFacade.create(lista);
            }
        }
    }
    
    public void borrarUsuarioLista (String nombreLista, int idUsuario) {
        List<Lista> listasByNombre = this.listaFacade.findByNombre(nombreLista);
        Usuario usuarioByID = this.usuarioFacade.find(idUsuario);
        
        if(listasByNombre.size() == 1) {
            Lista listaUnica = listasByNombre.get(0);
            listaUnica.setUsuarioLista(null);
            this.listaFacade.edit(listaUnica);
        } else {
            for(Lista lista : listasByNombre) {
                if(Objects.equals(lista.getUsuarioLista().getIdusuario(), usuarioByID.getIdusuario())) {
                    this.listaFacade.remove(lista);
                    break;
                }
            }
        }
        
    }
}
