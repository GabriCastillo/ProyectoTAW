/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAWapp.dto;


/**
 *
 * @author RaulDF
 * Done: 100%
 */
public class CompradorProductoDTO {
    private Integer idCompradorProductoDTO;
    private int precio_salida;
    private int precio_Compra;
    private ProductoDTO producto;
    private UsuarioDTO vendedor;
    
    public CompradorProductoDTO(){
        
    }

    public void setIdCompradorProductoDTO(int idCompradorProductoDTO) {
        this.idCompradorProductoDTO = idCompradorProductoDTO;
    }

    public int getIdCompradorProductoDTO() {
        return idCompradorProductoDTO;
    }

    public void setPrecio_salida(int precio_salida) {
        this.precio_salida = precio_salida;
    }

    public void setPrecio_Compra(int precio_Compra) {
        this.precio_Compra = precio_Compra;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public void setVendedor(UsuarioDTO vendedor) {
        this.vendedor = vendedor;
    }

    public int getPrecio_salida() {
        return precio_salida;
    }

    public int getPrecio_Compra() {
        return precio_Compra;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public UsuarioDTO getVendedor() {
        return vendedor;
    }

    
}
