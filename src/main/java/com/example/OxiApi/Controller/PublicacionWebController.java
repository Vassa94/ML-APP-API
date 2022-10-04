package com.example.OxiApi.Controller;

import com.example.OxiApi.Model.PublicacionWeb;
import com.example.OxiApi.Service.IPublicacionWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
                                      @RequestParam("SKU")Long nuevoSKU,
                                      @RequestParam("mostrar")Boolean nuevoMostrar,
                                      @RequestParam("envio")Boolean nuevoEnvio,
                                      @RequestParam("tags")String nuevoTags,
                                      @RequestParam("marca")String nuevoMarca){
        PublicacionWeb publicacionWeb = interPublicacionWeb.findPublicacionWeb(id);

        publicacionWeb.setIdentificador(nuevoIdentificador);
        publicacionWeb.setNombre(nuevoNombre);
        publicacionWeb.setCategoria(nuevoCategoria);
        publicacionWeb.setPrecio(nuevoPrecio);
        publicacionWeb.setPrecioProm(nuevoPrecioProm);
        publicacionWeb.setPeso(nuevoPeso);
        publicacionWeb.setAlto(nuevoAlto);
        publicacionWeb.setAncho(nuevoAncho);
        publicacionWeb.setProfundidad(nuevoProfundidad);
        publicacionWeb.setStock(nuevoStock);
        publicacionWeb.setSKU(nuevoSKU);
        publicacionWeb.setMostrar(nuevoMostrar);
        publicacionWeb.setEnvio(nuevoEnvio);
        publicacionWeb.setTags(nuevoTags);
        publicacionWeb.setMarca(nuevoMarca);

        interPublicacionWeb.savePublicacionWeb(publicacionWeb);

        return publicacionWeb;

    }

}
