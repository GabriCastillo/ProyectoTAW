/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.service;

import TAWapp.dao.CategoriaFacade;
import TAWapp.dto.CategoriaDTO;
import TAWapp.entity.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author casti
 */
@Stateless
public class CategoriaService {
    
    @EJB CategoriaFacade categoriaFacade;
    
    public List<CategoriaDTO> listarCategorias () {
        List<Categoria> lista = this.categoriaFacade.findAll();
        return this.listaEntityADTO(lista);
    }
    
     private List<CategoriaDTO> listaEntityADTO (List<Categoria> lista) {
        List<CategoriaDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (Categoria r :lista) {
                listaDTO.add(r.toDTO());
            }
        }
        return listaDTO;
    }
    
}
