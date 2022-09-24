package com.example.OxiApi.Controller;


import com.example.OxiApi.Model.Producto;
import com.example.OxiApi.Service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.TRACE;

@CrossOrigin(origins = "*", methods = {GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE})
@RestController
public class ProductoController {

    @Autowired
    private IProductoService interProducto;

    @GetMapping("/producto/traer")
    public List<Producto> getProductos() {return interProducto.getProductos(); }

    @PostMapping("productos/crear")
    public String createProducto (@RequestBody Producto producto){
        interProducto.saveProducto(producto);
        return "El producto fue creado exitosamente";
    }

    /**Elimina un producto de la base de datos.*/
    @DeleteMapping("productos/borrar/{id}")
    public String deleteProducto(@PathVariable Long id){
        interProducto.deleteProducto(id);
        return "El producto fue borrado correctamente";
    }


     // Esta función recibe la identificación de un producto y los nuevos valores para los atributos del producto, y luego
     // actualiza el producto en la base de datos con los nuevos valores.

    @PutMapping ("productos/editar/{id}")
    @RequestMapping(value = "productos/editar/{id}",method = {RequestMethod.GET, RequestMethod.PUT})
    public Producto editProducto (@PathVariable Long id,
                                  @RequestParam("codFabrica")String nuevoCodFabrica,
                                  @RequestParam("descripcion")String nuevaDescripcion,
                                  @RequestParam("marca")String nuevaMarca,
                                  @RequestParam("precioPub")Long nuevoPrecioPub,
                                  @RequestParam("costo")Long nuevoCosto){

        // Encontrar el producto con el id que se pasa en la url.
        Producto producto=interProducto.findProducto(id);

        // Estableciendo los nuevos valores al objeto producto.
        producto.setCod_Fabrica(nuevoCodFabrica);
        producto.setDescripcion(nuevaDescripcion);
        producto.setMarca(nuevaMarca);
        producto.setPrecioPublico(nuevoPrecioPub);
        producto.setCosto(nuevoCosto);

        // Guardando el objeto producto en la base de datos.
        interProducto.saveProducto(producto);

        // Devolver el objeto producto.
        return producto;
    }



}
