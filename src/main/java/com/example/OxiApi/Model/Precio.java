package com.example.OxiApi.Model;

import javax.persistence.Id;

public class Precio {
    @Id
    private Long codigo;
    private Long precio;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setStock(Long precio) {
        this.precio = precio;
    }
}

