package com.example.OxiApi.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class PublicacionWeb {

    @Id
    private String identificador;
    private String nombre;
    private String categoria;
    private Long precio;
    private Long precioProm;
    private Float peso;
    private Float alto;
    private Float ancho;
    private Float profundidad;
    private Long stock;
    private Long SKU;
    private Boolean mostrar;
    private Boolean envio;
    private String tags;
    private String marca;


    public PublicacionWeb() {
    }

    public PublicacionWeb(String identificador, String nombre, String categoria, Long precio, Long precioProm, Float peso, Float alto, Float ancho, Float profundidad, Long stock, Long SKU, Boolean mostrar, Boolean envio, String tags, String marca) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.precioProm = precioProm;
        this.peso = peso;
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.stock = stock;
        this.SKU = SKU;
        this.mostrar = mostrar;
        this.envio = envio;
        this.tags = tags;
        this.marca = marca;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Long getPrecioProm() {
        return precioProm;
    }

    public void setPrecioProm(Long precioProm) {
        this.precioProm = precioProm;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getAlto() {
        return alto;
    }

    public void setAlto(Float alto) {
        this.alto = alto;
    }

    public Float getAncho() {
        return ancho;
    }

    public void setAncho(Float ancho) {
        this.ancho = ancho;
    }

    public Float getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Float profundidad) {
        this.profundidad = profundidad;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getSKU() {
        return SKU;
    }

    public void setSKU(Long SKU) {
        this.SKU = SKU;
    }

    public Boolean getMostrar() {
        return mostrar;
    }

    public void setMostrar(Boolean mostrar) {
        this.mostrar = mostrar;
    }

    public Boolean getEnvio() {
        return envio;
    }

    public void setEnvio(Boolean envio) {
        this.envio = envio;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
