/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.service;

import TAWapp.dao.ProductosFavoritosFacade;
import TAWapp.dto.CompradorProductoDTO;
import TAWapp.dto.FavoritoDTO;
import TAWapp.entity.CompradorProducto;
import TAWapp.entity.ProductosFavoritos;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ruben 
 * Done: 100%
 */
@Stateless
public class FavoritoService {
    @EJB ProductosFavoritosFacade FavoritoFacade;
     private List<FavoritoDTO> listaEntityADTO (List<ProductosFavoritos> lista) {
        List<FavoritoDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (ProductosFavoritos f :lista) {
                listaDTO.add(f.toDTO());
            }
        }
        return listaDTO;
    }
    public boolean Esfavorito (int idp,int idc) {
        boolean esta = false;
        List<ProductosFavoritos> favoritos = this.FavoritoFacade.findAll();
        
            for (ProductosFavoritos f :favoritos) {
                if(f.getProductoIdproducto().getIdproducto().equals(idp)&&f.getUsuarioComprador().getIdusuario().equals(idc)){
                   esta= true; 
              
            }
        }
        return esta;
    } 

    public List<FavoritoDTO> listaPropiosFavoritos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<FavoritoDTO> listaPropiosFavoritos(Integer idusuario) {
        List<ProductosFavoritos> favoritos = null;   
        if (idusuario == null) {
            favoritos = this.FavoritoFacade.finduser(idusuario); 
            return this.listaEntityADTO(favoritos);  
        }else{
            favoritos = this.FavoritoFacade.findAll();
            return this.listaEntityADTO(favoritos);  
        }    
          
}

    public void quitarfavorito(Integer idusuario, String strId) {
        ProductosFavoritos q = this.FavoritoFacade.finduserproducto(idusuario,strId);
        this.FavoritoFacade.remove(q);
    }
}