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
 * Done: 100%
 */
@Stateless
public class CategoriaService {
    
    @EJB CategoriaFacade categoriaFacade;
    
     public List<CategoriaDTO> listarCategorias(String filtroTitulo) {
        List<Categoria> categorias;

        if (filtroTitulo == null || filtroTitulo.isEmpty()) {
            categorias = this.categoriaFacade.findAll();        
        } else {
            categorias = this.categoriaFacade.findByTitulo(filtroTitulo);
        }
        
        return this.listaEntityADTO(categorias);
    }

    private List<CategoriaDTO> listaEntityADTO(List<Categoria> lista) {
        List<CategoriaDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (Categoria r : lista) {
                listaDTO.add(r.toDTO());
            }
        }
        return listaDTO;
    }

    public CategoriaDTO buscarCategoria(Integer id) {
        Categoria categoria = this.categoriaFacade.find(id);
        return categoria.toDTO();
    }

    public void borrarCategoria(Integer id) {
        Categoria categoria = this.categoriaFacade.find(id);

        this.categoriaFacade.remove(categoria);
    }

    private void rellenarCategoria(Categoria categoria,
            String tipo) {

        categoria.setTipo(tipo);

    }

    public void crearCategoria(String tipo) {
        Categoria categoria = new Categoria();
        this.rellenarCategoria(categoria, tipo);

        this.categoriaFacade.create(categoria);

    }

    public void modificarCategoria(Integer id,
            String tipo) {

        Categoria categoria = this.categoriaFacade.find(id);

        this.rellenarCategoria(categoria, tipo);

        this.categoriaFacade.edit(categoria);
    }
    
}
