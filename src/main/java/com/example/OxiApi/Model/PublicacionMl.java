package com.example.OxiApi.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class PublicacionMl {

    @Id
    private String itemId;
    private Long itemSku;
    private Long variationId;
    private Long variationSku;
    private String titulo;
    private Long cantidad;
    private Long precio;
    private String estado;


    public PublicacionMl() {
    }

    public PublicacionMl(String itemId, Long itemSku, Long variationId, Long variationSku, String titulo, Long cantidad, Long precio, String estado) {
        this.itemId = itemId;
        this.itemSku = itemSku;
        this.variationId = variationId;
        this.variationSku = variationSku;
        this.titulo = titulo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.estado = estado;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Long getItemSku() {
        return itemSku;
    }

    public void setItemSku(Long itemSku) {
        this.itemSku = itemSku;
    }

    public Long getVariationId() {
        return variationId;
    }

    public void setVariationId(Long variationId) {
        this.variationId = variationId;
    }

    public Long getVariationSku() {
        return variationSku;
    }

    public void setVariationSku(Long variationSku) {
        this.variationSku = variationSku;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
