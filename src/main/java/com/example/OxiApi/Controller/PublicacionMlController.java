package com.example.OxiApi.Controller;

import com.example.OxiApi.Model.PublicacionMl;
import com.example.OxiApi.Service.IPublicacionMlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.TRACE;


@CrossOrigin(origins = "*", methods = {GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE})
@RestController
@Validated
public class PublicacionMlController {

    @Autowired
    private IPublicacionMlService interPublicacionMl;

    @GetMapping("ml/traer")
    public List<PublicacionMl> getPublicacionMl() {
        return interPublicacionMl.getPublicacionMl();
    }

    @PostMapping("ml/crear")
    public String createPubMl(@Valid @RequestBody PublicacionMl pubMl, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError error : result.getFieldErrors()) {
                sb.append("El campo '");
                sb.append(error.getField());
                sb.append("' ");
                sb.append(error.getDefaultMessage());
                sb.append(". ");
            }
            return sb.toString();
        }
        interPublicacionMl.savePublicacionMl(pubMl);
        return "La publicacion fue creada correctamente";
    }

    /*@PostMapping("ml/crear")
    public String createPubMl(@RequestBody PublicacionMl pubMl) {
        interPublicacionMl.savePublicacionMl(pubMl);
        return "La publicacion fue creada correctamente";
    }*/

    @DeleteMapping("ml/borrar/{id}")
    @RequestMapping(value = "ml/borrar/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deletePublicacionMl(@PathVariable String id) {
        interPublicacionMl.deletePublicacionMl(id);
        return "La Publicacion fue borrada correctamente";
    }

    @PutMapping("ml/editar/{id}")
    public PublicacionMl editPubMl(@PathVariable String id,
                                   @RequestParam("itemId") String nuevoItemId,
                                   @RequestParam("itemSku") Long nuevoSku,
                                   @RequestParam("variationId") Long nuevoVariationId,
                                   @RequestParam("variationSku") Long nuevoVariationSku,
                                   @RequestParam("categoria") String nuevoCategoryId,
                                   @RequestParam("type") String nuevoType,
                                   @RequestParam("titulo") String nuevoTitulo,
                                   @RequestParam("cantidad") Long nuevoCantidad,
                                   @RequestParam("precio") Long nuevoPrecio,
                                   @RequestParam("estado") String nuevoEstado,
                                   @RequestParam("envio") Boolean nuevoEnvio,
                                   @RequestParam("full") Boolean nuevoFull,
                                   @RequestParam("local_pickup") Boolean nuevoLocalPickup,
                                   @RequestParam("warranty") String nuevoWarranty,
                                   @RequestParam("catalogList") Boolean nuevoCatalogList,
                                   @RequestParam("catalogId") String nuevoCatalogId,
                                   @RequestParam("img") String nuevoImg,
                                   @RequestParam("marca") String nuevoMarca,
                                   @RequestParam("modelo") String nuevoModelo,
                                   @RequestParam("peso") Float nuevoPeso) {
        PublicacionMl publicacionMl = interPublicacionMl.findPublicacionMl(id);

        publicacionMl.setItemId(nuevoItemId);
        publicacionMl.setItemSku(nuevoSku);
        publicacionMl.setVariationId(nuevoVariationId);
        publicacionMl.setVariationSku(nuevoVariationSku);
        publicacionMl.setCategory_id(nuevoCategoryId);
        publicacionMl.setListing_type(nuevoType);
        publicacionMl.setTitle(nuevoTitulo);
        publicacionMl.setQuantity(nuevoCantidad);
        publicacionMl.setPrice(nuevoPrecio);
        publicacionMl.setStatus(nuevoEstado);
        publicacionMl.setFree_shipping(nuevoEnvio);
        publicacionMl.setFull(nuevoFull);
        publicacionMl.setLocal_pickup(nuevoLocalPickup);
        publicacionMl.setWarranty(nuevoWarranty);
        publicacionMl.setCatalog_listing(nuevoCatalogList);
        publicacionMl.setCatalog_product_id(nuevoCatalogId);
        publicacionMl.setImg(nuevoImg);
        publicacionMl.setBrand(nuevoMarca);
        publicacionMl.setModel(nuevoModelo);
        publicacionMl.setWeight(nuevoPeso);

        interPublicacionMl.savePublicacionMl(publicacionMl);

        return publicacionMl;

    }

    @PatchMapping("ml/editarParcial/{id}")
    public PublicacionMl actualizarParcialPubMl(@PathVariable String id, @RequestBody Map<String, Object> camposActualizados) {
        PublicacionMl publicacionMl = interPublicacionMl.findPublicacionMl(id);

        for (Map.Entry<String, Object> entry : camposActualizados.entrySet()) {
            String campo = entry.getKey();
            Object valor = entry.getValue();

            switch (campo) {
                case "itemId":
                    publicacionMl.setItemId((String) valor);
                    break;
                case "itemSku":
                    publicacionMl.setItemSku((Long) valor);
                    break;
                case "variationId":
                    publicacionMl.setVariationId((Long) valor);
                    break;
                case "variationSku":
                    publicacionMl.setVariationSku((Long) valor);
                    break;
                case "categoria":
                    publicacionMl.setCategory_id((String) valor);
                    break;
                case "type":
                    publicacionMl.setListing_type((String) valor);
                    break;
                case "titulo":
                    publicacionMl.setTitle((String) valor);
                    break;
                case "cantidad":
                    publicacionMl.setQuantity((Long) valor);
                    break;
                case "precio":
                    publicacionMl.setPrice((Long) valor);
                    break;
                case "estado":
                    publicacionMl.setStatus((String) valor);
                    break;
                case "envio":
                    publicacionMl.setFree_shipping((Boolean) valor);
                    break;
                case "full":
                    publicacionMl.setFull((Boolean) valor);
                    break;
                case "local_pickup":
                    publicacionMl.setLocal_pickup((Boolean) valor);
                    break;
                case "warranty":
                    publicacionMl.setWarranty((String) valor);
                    break;
                case "catalogList":
                    publicacionMl.setCatalog_listing((Boolean) valor);
                    break;
                case "catalogId":
                    publicacionMl.setCatalog_product_id((String) valor);
                    break;
                case "img":
                    publicacionMl.setImg((String) valor);
                    break;
                case "marca":
                    publicacionMl.setBrand((String) valor);
                    break;
                case "modelo":
                    publicacionMl.setModel((String) valor);
                    break;
                case "peso":
                    publicacionMl.setWeight((Float) valor);
                    break;
                default:
                    // Si el campo no existe, simplemente lo ignoramos
                    break;
            }
        }

        interPublicacionMl.savePublicacionMl(publicacionMl);

        return publicacionMl;
    }

    @GetMapping("ml/estructura")
    public ResponseEntity<?> getEstructuraPublicacionMl() {
        try {
            Class<?> clazz = Class.forName("com.example.OxiApi.Model.PublicacionMl");
            List<String> fields = new ArrayList<String>();
            for (Field field : clazz.getDeclaredFields()) {
                fields.add(field.getName() + ":" + field.getType().getSimpleName());
            }
            return ResponseEntity.ok(fields);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error al obtener la estructura del modelo");
        }
    }


}
