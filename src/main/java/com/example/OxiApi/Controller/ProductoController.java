package com.example.OxiApi.Controller;


import com.example.OxiApi.Model.Precio;
import com.example.OxiApi.Model.Producto;
import com.example.OxiApi.Model.Stock;
import com.example.OxiApi.Service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.System.out;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.TRACE;

@CrossOrigin(origins = "*", methods = {GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE})
@RestController
public class ProductoController {

    @Autowired
    private IProductoService interProducto;

    @GetMapping("/productos/traer")
    public List<Producto> getProductos() {
        List<Producto> productos = interProducto.getProductos();

        // Ordenar la lista de productos por el campo "marca".
        Collections.sort(productos, (p1, p2) -> p1.getMarca().compareTo(p2.getMarca()));

        return productos;
    }

    @GetMapping("/")
    public ModelAndView status() {
        ModelAndView mav = new ModelAndView("apiGuide");

        return mav;
    }

    @PostMapping("productos/crear")
    public String createProducto(@RequestBody Producto producto) {
        interProducto.saveProducto(producto);
        return "El producto fue creado exitosamente";
    }

    @PostMapping("productos/batch")
    public String createProductos(@RequestBody Producto[] productos) {
        // Dividir el array de productos en varias partes.
        int numPartes = (int) Math.ceil((double) productos.length / 5);
        Producto[][] productosPartidos = new Producto[numPartes][];
        for (int i = 0; i < numPartes; i++) {
            int inicio = i * 5;
            int fin = Math.min(inicio + 5, productos.length);
            productosPartidos[i] = Arrays.copyOfRange(productos, inicio, fin);
        }
        // Crear un ExecutorService con un número fijo de 5 hilos.
        ExecutorService executor = Executors.newFixedThreadPool(5);
        // Iterar sobre cada parte y crear un hilo para cada producto.
        for (Producto[] parte : productosPartidos) {
            for (Producto producto : parte) {
                executor.submit(() -> interProducto.saveProducto(producto));
            }
        }
        // Cerrar el ExecutorService y esperar a que se completen todos los hilos.
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            // Manejar la excepción si es necesario.
        }

        return "Los productos fueron creados exitosamente";
    }

    @DeleteMapping("productos/borrar/{id}")
    public String deleteProducto(@PathVariable Long id) {
        interProducto.deleteProducto(id);
        return "El producto con codigo " + id + " fue borrado correctamente";
    }

    @PutMapping("productos/editar/{id}")
    @RequestMapping(value = "productos/editar/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public Producto editProducto(@PathVariable Long id,
                                 @RequestParam("codFabrica") String nuevoCodFabrica,
                                 @RequestParam("descripcion") String nuevaDescripcion,
                                 @RequestParam("marca") String nuevaMarca,
                                 @RequestParam("precioPub") Long nuevoPrecioPub,
                                 @RequestParam("stock") Long nuevoStock) {

        // Encontrar el producto con el id que se pasa en la url.
        Producto producto = interProducto.findProducto(id);

        // Estableciendo los nuevos valores al objeto producto.
        producto.setCod_Fabrica(nuevoCodFabrica);
        producto.setDescripcion(nuevaDescripcion);
        producto.setMarca(nuevaMarca);
        producto.setPrecioPublico(nuevoPrecioPub);
        producto.setStock(nuevoStock);

        // Guardando el objeto producto en la base de datos.
        interProducto.saveProducto(producto);
        // Devolver el objeto producto.
        return producto;
    }


    @PutMapping("productos/actualizar/stock")
    @RequestMapping(value = "productos/actualizar/stock", method = {RequestMethod.GET, RequestMethod.PUT})
    public String editProductosS(@RequestBody Stock[] stocks) {
        // Crear un ExecutorService con un número fijo de 5 hilos.
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Iterar sobre el array de stocks y crear un hilo para cada stock.
        for (Stock stock : stocks) {
            Long codigo = stock.getCodigo();
            Long stockValue = stock.getStock();
            executor.submit(() -> {
                // Buscar el objeto Producto correspondiente.
                Producto p = interProducto.findProducto(codigo);
                if (p != null) {
                    // Establecer el nuevo valor del campo "stock" del objeto Producto.
                    p.setStock(Long.valueOf(stockValue));

                    // Guardar el producto en la base de datos.
                    interProducto.saveProducto(p);
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            // Manejar la excepción si es necesario.
        }
        out.println("Ya termine de procesar");
        return "Los productos fueron actualizados exitosamente";
    }

    @PutMapping("productos/actualizar/precio")
    @RequestMapping(value = "productos/actualizar/precio", method = {RequestMethod.GET, RequestMethod.PUT})
    public String editProductosP(@RequestBody Precio[] precios) {
        // Crear un ExecutorService con un número fijo de 5 hilos.
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Iterar sobre el array de stocks y crear un hilo para cada stock.
        for (Precio precio : precios) {
            Long codigo = precio.getCodigo();
            Long precioValue = precio.getPrecio();
            executor.submit(() -> {
                // Buscar el objeto Producto correspondiente.
                Producto p = interProducto.findProducto(codigo);
                if (p != null) {
                    // Establecer el nuevo valor del campo "stock" del objeto Producto.
                    p.setPrecioPublico(Long.valueOf(precioValue));

                    // Guardar el producto en la base de datos.
                    interProducto.saveProducto(p);
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            // Manejar la excepción si es necesario.
        }

        return "Los productos fueron actualizados exitosamente";
    }


}
