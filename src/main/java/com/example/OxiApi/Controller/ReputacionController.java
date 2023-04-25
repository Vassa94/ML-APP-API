package com.example.OxiApi.Controller;

import com.example.OxiApi.Model.Reputacion;
import com.example.OxiApi.Service.IReputacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.TRACE;

@CrossOrigin(origins = "*", methods = {GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE})
@RestController
@Validated
public class ReputacionController {

    @Autowired
    private IReputacionService interReputacion;

    @PostMapping("reputacion")
    public ResponseEntity<Object> createReputacion(@RequestBody Reputacion reputacion) {
        interReputacion.saveReputacion(reputacion);
        return new ResponseEntity<>("Reputacion creada correctamente", HttpStatus.CREATED);
    }

    @GetMapping("reputacion/datos")
    public List<Reputacion> getReputacion() {
        return interReputacion.getReputacion();
    }

    @PutMapping("reputacion/editar")
    public void updateReputacion(@Valid @RequestBody Reputacion reputacion) {
        Reputacion currentReputacion = interReputacion.findReputacion(reputacion.getId());

        if (currentReputacion != null) {
            currentReputacion.setUltimos60Dias(reputacion.getUltimos60Dias());
            currentReputacion.setMercadoenvios(reputacion.getMercadoenvios());
            currentReputacion.setColor(reputacion.getColor());

            interReputacion.saveReputacion(currentReputacion);
        }
    }

    @PostMapping("reputacion/reclamos")
    public void addReclamo(@Valid @RequestBody Reputacion.Reclamo[] reclamos) {
        Reputacion reputacionActual = interReputacion.getReputacion().get(0);
        reputacionActual.setReclamos(new ArrayList<>(Arrays.asList(reclamos)));
        interReputacion.saveReputacion(reputacionActual);
    }

    @PostMapping("reputacion/mediaciones")
    public void addMediacion(@Valid @RequestBody Reputacion.Mediacion[] mediaciones) {
        Reputacion reputacionActual = interReputacion.getReputacion().get(0);
        reputacionActual.setMediaciones(new ArrayList<>(Arrays.asList(mediaciones)));
        interReputacion.saveReputacion(reputacionActual);
    }

    @PostMapping("reputacion/cancelaciones")
    public void addCancelacion(@Valid @RequestBody Reputacion.Cancelacion[] cancelaciones) {
        Reputacion reputacionActual = interReputacion.getReputacion().get(0);
        reputacionActual.setCancelaciones(new ArrayList<>(Arrays.asList(cancelaciones)));
        interReputacion.saveReputacion(reputacionActual);
    }

    @PostMapping("reputacion/demoras")
    public void addDemora(@Valid @RequestBody Reputacion.Demora[] demoras) {
        Reputacion reputacionActual = interReputacion.getReputacion().get(0);
        reputacionActual.setDemoras(new ArrayList<>(Arrays.asList(demoras)));
        interReputacion.saveReputacion(reputacionActual);
    }


}
