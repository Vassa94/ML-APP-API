package com.example.OxiApi.Controller;


import com.example.OxiApi.Model.Producto;
import com.example.OxiApi.Service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.concurrent.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.TRACE;

@CrossOrigin(origins = "*", methods = {GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE})
@RestController
public class ProductoController {

    @Autowired
    private IProductoService interProducto;

    @GetMapping("/producto/traer")
    public List<Producto> getProductos() {return interProducto.getProductos(); }

    @GetMapping("/")
    public ModelAndView status(){
        ModelAndView mav = new ModelAndView("apiGuide");

        return mav;
    }

    @PostMapping("productos/crear")
    public String createProducto (@RequestBody Producto producto){
        interProducto.saveProducto(producto);
        return "El producto fue creado exitosamente";
    }

    @PostMapping("productos/batch")
    public String createProducto(@RequestBody Producto[] productos) {
        // Crear un objeto ExecutorService con un número de hilos igual al número de productos que se deben cargar.
        ExecutorService executor = Executors.newFixedThreadPool(productos.length);
        // Iterar sobre los productos y crear un hilo para cada uno.
        for (Producto producto : productos) {
            executor.submit(() -> interProducto.saveProducto(producto));
        }
        // Cerrar el ExecutorService.
        executor.shutdown();
        return "Los productos fueron creados exitosamente";
    }


    /*
    @PostMapping("productos/batch")
    public String createProducto (@RequestBody Producto[] productos){
        for (Producto producto : productos) {
            interProducto.saveProducto(producto);
        }
        return "Los productos fueron creados exitosamente";
    }*/

    /**Elimina un producto de la base de datos.*/
    @DeleteMapping("productos/borrar/{id}")
    public String deleteProducto(@PathVariable Long id){
        interProducto.deleteProducto(id);
        return "El producto con codigo "+ id +" fue borrado correctamente";
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

    @PutMapping ("productos/editarbatch")
    @RequestMapping(value = "productos/editarbatch",method = {RequestMethod.GET, RequestMethod.PUT})
    public List<Producto> editProducto(@PathVariable Long id, @RequestBody List<Producto> productos) {
        // Encontrar el producto con el id que se pasa en la url.
        Producto producto = interProducto.findProducto(id);

        // Estableciendo los nuevos valores al objeto producto.
        producto.setCod_Fabrica(productos.get(0).getCod_Fabrica());
        producto.setDescripcion(productos.get(0).getDescripcion());
        producto.setMarca(productos.get(0).getMarca());
        producto.setPrecioPublico(productos.get(0).getPrecioPublico());
        producto.setCosto(productos.get(0).getCosto());

        // Guardando el objeto producto en la base de datos.
        interProducto.saveProducto(producto);

        // Devolver el objeto producto.
        return productos;
    }



}
