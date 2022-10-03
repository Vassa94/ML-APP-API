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
                                      @RequestParam String )

}
