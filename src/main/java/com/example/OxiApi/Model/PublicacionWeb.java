package com.example.OxiApi.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class PublicacionWeb {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publicacionesWeb")
    @SequenceGenerator(name = "publicacionesWeb", sequenceName = "id", allocationSize = 1)
    private Long id;
    private String URL;
    private String nombre;
    private String categorias;
    private String nomProp1;
    private String valProp1;
    private String nomProp2;
    private String valProp2;
    private String nomProp3;
    private String valProp3;
    private Long pack;
    private Long precio;
    private Long precioProm;
    private Float peso;
    private Float alto;
    private Float ancho;
    private Float profundidad;
    private Long stock;
    @Column
    @ElementCollection(targetClass = Long.class)
    private List<Long> codigo;
    private String EAN;
    private Boolean mostrar;
    private Boolean envio;
    private String tags;
    private String marca;


    public PublicacionWeb() {
    }

    public PublicacionWeb(Long id, String URL, String nombre, String categorias, String nomProp1, String valProp1, String nomProp2, String valProp2, String nomProp3, String valProp3, Long pack, Long precio, Long precioProm, Float peso, Float alto, Float ancho, Float profundidad, Long stock, List<Long> codigo, String EAN, Boolean mostrar, Boolean envio, String tags, String marca) {
        this.id = id;
        this.URL = URL;
        this.nombre = nombre;
        this.categorias = categorias;
        this.nomProp1 = nomProp1;
        this.valProp1 = valProp1;
        this.nomProp2 = nomProp2;
        this.valProp2 = valProp2;
        this.nomProp3 = nomProp3;
        this.valProp3 = valProp3;
        this.pack = pack;
        this.precio = precio;
        this.precioProm = precioProm;
        this.peso = peso;
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.stock = stock;
        this.codigo = codigo;
        this.EAN = EAN;
        this.mostrar = mostrar;
        this.envio = envio;
        this.tags = tags;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    public String getNomProp1() {
        return nomProp1;
    }

    public void setNomProp1(String nomProp1) {
        this.nomProp1 = nomProp1;
    }

    public String getValProp1() {
        return valProp1;
    }

    public void setValProp1(String valProp1) {
        this.valProp1 = valProp1;
    }

    public String getNomProp2() {
        return nomProp2;
    }

    public void setNomProp2(String nomProp2) {
        this.nomProp2 = nomProp2;
    }

    public String getValProp2() {
        return valProp2;
    }

    public void setValProp2(String valProp2) {
        this.valProp2 = valProp2;
    }

    public String getNomProp3() {
        return nomProp3;
    }

    public void setNomProp3(String nomProp3) {
        this.nomProp3 = nomProp3;
    }

    public String getValProp3() {
        return valProp3;
    }

    public void setValProp3(String valProp3) {
        this.valProp3 = valProp3;
    }

    public Long getPack() {
        return pack;
    }

    public void setPack(Long pack) {
        this.pack = pack;
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

    public List<Long> getCodigo() {
        return codigo;
    }

    public void setCodigo(List<Long> codigo) {
        this.codigo = codigo;
    }

    public String getEAN() {
        return EAN;
    }

    public void setEAN(String EAN) {
        this.EAN = EAN;
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
