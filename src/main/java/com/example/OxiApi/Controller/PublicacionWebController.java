package com.example.OxiApi.Controller;

import com.example.OxiApi.Model.Precio;
import com.example.OxiApi.Model.Producto;
import com.example.OxiApi.Model.PublicacionWeb;
import com.example.OxiApi.Service.IPublicacionWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.TRACE;


@CrossOrigin(origins = "*", methods = {GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE})
@RestController
public class PublicacionWebController {

    @Autowired
    private IPublicacionWebService interPublicacionWeb;

    @GetMapping("web/traer")
    public List<PublicacionWeb> getPublicacionWeb() {return interPublicacionWeb.getPublicacionWeb();}



    @PostMapping("web/crear")
    public String createPubWeb (@RequestBody PublicacionWeb pubWeb){
        interPublicacionWeb.savePublicacionWeb(pubWeb);
        return "La publicacion fue creada correctamente";
    }

    @PostMapping("web/batch")
    public String createPubWeb(@RequestBody PublicacionWeb[] publicacionWebs) {
        // Dividir el array de productos en varias partes.
        int numPartes = (int) Math.ceil((double) publicacionWebs.length / 5);
        PublicacionWeb[][] publicacionWebPartidos = new PublicacionWeb[numPartes][];
        for (int i = 0; i < numPartes; i++) {
            int inicio = i * 5;
            int fin = Math.min(inicio + 5, publicacionWebs.length);
            publicacionWebPartidos[i] = Arrays.copyOfRange(publicacionWebs, inicio, fin);
        }
        // Crear un ExecutorService con un número fijo de 5 hilos.
        ExecutorService executor = Executors.newFixedThreadPool(4);
        // Iterar sobre cada parte y crear un hilo para cada producto.
        for (PublicacionWeb[] parte : publicacionWebPartidos) {
            for (PublicacionWeb publicacion : parte) {
                executor.submit(() -> interPublicacionWeb.savePublicacionWeb(publicacion));
            }
        }
        // Cerrar el ExecutorService y esperar a que se completen todos los hilos.
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            // Manejar la excepción si es necesario.
        }

        return "Las publicaciones fueron creados exitosamente";
    }

    @DeleteMapping("web/borrar/{id}")
    @RequestMapping(value ="web/borrar/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public  String deletePublicacionWeb(@PathVariable Long id) {
        interPublicacionWeb.deletePublicacionWeb(id);
        return "La Publicacion fue borrada correctamente";
    }

    @PutMapping("web/editar/{id}")
    public PublicacionWeb editPubWeb (@PathVariable Long id,
                                      @RequestParam("identificador")String nuevoIdentificador,
                                      @RequestParam("Nombre")String nuevoNombre,
                                      @RequestParam("categoria")String nuevoCategoria,
                                      @RequestParam("precio")Long nuevoPrecio,
                                      @RequestParam("precioProm")Long nuevoPrecioProm,
                                      @RequestParam("peso")Float nuevoPeso,
                                      @RequestParam("alto")Float nuevoAlto,
                                      @RequestParam("ancho")Float nuevoAncho,
                                      @RequestParam("produndidad")Float nuevoProfundidad,
                                      @RequestParam("stock")Long nuevoStock,
                                      @RequestParam("SKU") List<Long> nuevoSKU,
                                      @RequestParam("mostrar")Boolean nuevoMostrar,
                                      @RequestParam("envio")Boolean nuevoEnvio,
                                      @RequestParam("tags")String nuevoTags,
                                      @RequestParam("marca")String nuevoMarca){
        PublicacionWeb publicacionWeb = interPublicacionWeb.findPublicacionWeb(id);

        publicacionWeb.setURL(nuevoIdentificador);
        publicacionWeb.setNombre(nuevoNombre);
        publicacionWeb.setCategorias(nuevoCategoria);
        publicacionWeb.setPrecio(nuevoPrecio);
        publicacionWeb.setPrecioProm(nuevoPrecioProm);
        publicacionWeb.setPeso(nuevoPeso);
        publicacionWeb.setAlto(nuevoAlto);
        publicacionWeb.setAncho(nuevoAncho);
        publicacionWeb.setProfundidad(nuevoProfundidad);
        publicacionWeb.setStock(nuevoStock);
        publicacionWeb.setCodigo(nuevoSKU);
        publicacionWeb.setMostrar(nuevoMostrar);
        publicacionWeb.setEnvio(nuevoEnvio);
        publicacionWeb.setTags(nuevoTags);
        publicacionWeb.setMarca(nuevoMarca);

        interPublicacionWeb.savePublicacionWeb(publicacionWeb);

        return publicacionWeb;

    }

    @PutMapping ("web/actualizar/precio")
    @RequestMapping(value = "web/actualizar/precio",method = {RequestMethod.GET, RequestMethod.PUT})
    public String editPubicacionP(@RequestBody Precio[] precios) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Map<Long, Long> preciosProductos = new HashMap<>();
        for (Precio precio : precios) {
            preciosProductos.put(precio.getCodigo(), precio.getPrecio());
        }
        List<PublicacionWeb> publicacionWebs =  getPublicacionWeb();
        for (PublicacionWeb publicacionWeb : publicacionWebs) {
            executor.submit(() -> {
                Long precioAct = 0L;
                List<Long> cods = publicacionWeb.getCodigo();
                for (Long cod : cods) {
                    if (preciosProductos.get(cod) != null) {
                        precioAct += preciosProductos.getOrDefault(cod,0L);
                    }
                }
                publicacionWeb.setPrecio((precioAct+200));
                interPublicacionWeb.savePublicacionWeb(publicacionWeb);
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




}
