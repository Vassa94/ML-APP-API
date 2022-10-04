package com.example.OxiApi.Controller;

import com.example.OxiApi.Model.PublicacionMl;
import com.example.OxiApi.Service.IPublicacionMlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.TRACE;


@CrossOrigin(origins = "*", methods = {GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE})
@RestController
public class PublicacionMlController {

    @Autowired
    private IPublicacionMlService interPublicacionMl;

    @GetMapping("ml/traer")
    public List<PublicacionMl> getPublicacionMl() {return interPublicacionMl.getPublicacionMl();}

    @PostMapping("ml/crear")
    public String createPubMl (@RequestBody PublicacionMl pubMl){
        interPublicacionMl.savePublicacionMl(pubMl);
        return "La publicacion fue creada correctamente";
    }

    @DeleteMapping("ml/borrar/{id}")
    @RequestMapping(value ="ml/borrar/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public  String deletePublicacionMl(@PathVariable Long id) {
        interPublicacionMl.deletePublicacionMl(id);
        return "La Publicacion fue borrada correctamente";
    }

    @PutMapping("ml/editar/{id}")
    public PublicacionMl editPubMl (@PathVariable Long id,
                                      @RequestParam("itemId")String nuevoItemId,
                                      @RequestParam("itemSku")Long nuevoSku,
                                      @RequestParam("variationId")Long nuevoVariationId,
                                      @RequestParam("variationSku")Long nuevoVariationSku,
                                      @RequestParam("titulo")String nuevoTitulo,
                                      @RequestParam("cantidad")Long nuevoCantidad,
                                      @RequestParam("precio")Long nuevoPrecio,
                                      @RequestParam("estado")String nuevoEstado){
        PublicacionMl publicacionMl = interPublicacionMl.findPublicacionMl(id);

        publicacionMl.setItemId(nuevoItemId);
        publicacionMl.setItemSku(nuevoSku);
        publicacionMl.setVariationId(nuevoVariationId);
        publicacionMl.setVariationSku(nuevoVariationSku);
        publicacionMl.setTitulo(nuevoTitulo);
        publicacionMl.setCantidad(nuevoCantidad);
        publicacionMl.setPrecio(nuevoPrecio);
        publicacionMl.setEstado(nuevoEstado);

        interPublicacionMl.savePublicacionMl(publicacionMl);

        return publicacionMl;

    }
}
