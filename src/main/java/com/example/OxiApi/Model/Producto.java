package com.example.OxiApi.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

    @Getter
    @Setter
    @Entity
    public class Producto {

        @Id
        private Long codigo;
        private String cod_Fabrica;
        private String descripcion;
        private String marca;
        private Long precioPublico;
        private Long stock;

        public Producto() {
        }

        public Producto(Long codigo, String cod_Fabrica, String descripcion, String marca, Long precioPublico, Long stock) {
            this.codigo = codigo;
            this.cod_Fabrica = cod_Fabrica;
            this.descripcion = descripcion;
            this.marca = marca;
            this.precioPublico = precioPublico;
            this.stock = stock;
        }


        public Long getCodigo() {
            return codigo;
        }

        public void setCodigo(Long codigo) {
            this.codigo = codigo;
        }

        public String getCod_Fabrica() {
            return cod_Fabrica;
        }

        public void setCod_Fabrica(String cod_Fabrica) {
            this.cod_Fabrica = cod_Fabrica;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public Long getPrecioPublico() {
            return precioPublico;
        }

        public void setPrecioPublico(Long precioPublico) {
            this.precioPublico = precioPublico;
        }

        public Long getStock() {
            return stock;
        }

        public void setStock(Long stock) {
            this.stock = stock;
        }
    }
