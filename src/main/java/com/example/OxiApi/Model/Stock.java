package com.example.OxiApi.Model;

import javax.persistence.Id;

public class Stock {

    @Id
    private Long codigo;
    private Long stock;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}
