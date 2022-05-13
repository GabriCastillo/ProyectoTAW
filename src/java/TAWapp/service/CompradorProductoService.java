/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.service;

import TAWapp.dao.CompradorProductoFacade;
import TAWapp.dao.ProductoFacade;
import TAWapp.dao.UsuarioFacade;
import TAWapp.dto.CompradorProductoDTO;
import TAWapp.dto.ProductoDTO;
import TAWapp.entity.CompradorProducto;
import TAWapp.entity.Producto;
import TAWapp.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateless;
/**
 *
 * @author RaulDF
 * Done: 100%
 */
@Stateless
public class CompradorProductoService {
    @EJB CompradorProductoFacade cpFacade;
    @EJB UsuarioFacade usuarioFacade;
    @EJB ProductoFacade productoFacade;
    
    public List<CompradorProductoDTO> listaPropiasSubastas(String nombreUsuario){
        List<CompradorProducto> list = this.cpFacade.findAll();
        List<CompradorProducto> listaMisSubastas = new ArrayList<>();
        for(CompradorProducto cp : list){
            if(cp.getUsuarioVendedor().getNombre().equals(nombreUsuario)){
                listaMisSubastas.add(cp);
            }
        }
        return this.listaEntityADTO(listaMisSubastas);
    } 
    private List<CompradorProductoDTO> listaEntityADTO (List<CompradorProducto> lista) {
        List<CompradorProductoDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (CompradorProducto r :lista) {
                listaDTO.add(r.toDTO());
            }
        }
        return listaDTO;
    }

    public void crearSubasta(ProductoDTO producto,Integer precioInicial, Integer precioLimite,  int user) {
        CompradorProducto subasta = new CompradorProducto();
        this.rellenarSubasta(producto,subasta,precioInicial,precioLimite,user);
        this.cpFacade.create(subasta);
    }

    private void rellenarSubasta(ProductoDTO producto,CompradorProducto cp,Integer 
            precioInicial, Integer precioLimite,  int user) {
        cp.setPrecioSalida(precioInicial);
        cp.setPrecioCompra(precioLimite);
        Producto pro = this.productoFacade.find(producto.getIdproducto());
        cp.setProductoIdproducto(pro);
        Usuario usuario = this.usuarioFacade.find(user);
        cp.setUsuarioVendedor(usuario);
        cp.setUsuarioComprador(usuario);

        usuario.getCompradorProductoList().add(cp);
    }


    public void cerrarSubasta(Integer Id) {
        CompradorProducto subasta = this.cpFacade.find(Id);

        subasta.setPrecioCompra(0);

        this.cpFacade.edit(subasta);
    }
    
}

