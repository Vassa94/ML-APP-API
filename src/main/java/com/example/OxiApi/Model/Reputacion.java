package com.example.OxiApi.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Reputacion {
    @Id
    private Long id;
    private int ultimos60Dias;
    private int mercadoenvios;
    private String color;
    @ElementCollection(targetClass = Reclamo.class)
    private List<Reclamo> reclamos;

    @ElementCollection(targetClass = Mediacion.class)
    private List<Mediacion> mediaciones;

    @ElementCollection(targetClass = Cancelacion.class)
    private List<Cancelacion> cancelaciones;

    @ElementCollection(targetClass = Demora.class)
    private List<Demora> demoras;

    public Reputacion() {
    }

    public Reputacion(Long id, int ultimos60Dias, int mercadoenvios, String color, List<Reclamo> reclamos, List<Mediacion> mediaciones, List<Cancelacion> cancelaciones, List<Demora> demoras) {
        this.id = id;
        this.ultimos60Dias = ultimos60Dias;
        this.mercadoenvios = mercadoenvios;
        this.color = color;
        this.reclamos = reclamos;
        this.mediaciones = mediaciones;
        this.cancelaciones = cancelaciones;
        this.demoras = demoras;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUltimos60Dias() {
        return ultimos60Dias;
    }

    public void setUltimos60Dias(int ultimos60Dias) {
        this.ultimos60Dias = ultimos60Dias;
    }

    public int getMercadoenvios() {
        return mercadoenvios;
    }

    public void setMercadoenvios(int mercadoenvios) {
        this.mercadoenvios = mercadoenvios;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Reclamo> getReclamos() {
        return reclamos;
    }

    public void setReclamos(List<Reclamo> reclamos) {
        this.reclamos = reclamos;
    }

    public List<Mediacion> getMediaciones() {
        return mediaciones;
    }

    public void setMediaciones(List<Mediacion> mediaciones) {
        this.mediaciones = mediaciones;
    }

    public List<Cancelacion> getCancelaciones() {
        return cancelaciones;
    }

    public void setCancelaciones(List<Cancelacion> cancelaciones) {
        this.cancelaciones = cancelaciones;
    }

    public List<Demora> getDemoras() {
        return demoras;
    }

    public void setDemoras(List<Demora> demoras) {
        this.demoras = demoras;
    }

    @Embeddable
    public static class Reclamo {
        private String Fecha_reclamo;
        private long Numero_reclamo;
        private String venta;
        private String Fecha_venta;
        private String Titulo;
        private String Usuario;
        private String Tipo_de_reclamo;
        private String Detalle;

        public Reclamo() {
        }

        public Reclamo(String fecha_reclamo, long numero_reclamo, String venta, String fecha_venta, String titulo, String usuario, String tipo_de_reclamo, String detalle) {
            Fecha_reclamo = fecha_reclamo;
            Numero_reclamo = numero_reclamo;
            this.venta = venta;
            Fecha_venta = fecha_venta;
            Titulo = titulo;
            Usuario = usuario;
            Tipo_de_reclamo = tipo_de_reclamo;
            Detalle = detalle;
        }

        public String getFecha_reclamo() {
            return Fecha_reclamo;
        }

        public void setFecha_reclamo(String fecha_reclamo) {
            Fecha_reclamo = fecha_reclamo;
        }

        public long getNumero_reclamo() {
            return Numero_reclamo;
        }

        public void setNumero_reclamo(long numero_reclamo) {
            Numero_reclamo = numero_reclamo;
        }

        public String getVenta() {
            return venta;
        }

        public void setVenta(String venta) {
            this.venta = venta;
        }

        public String getFecha_venta() {
            return Fecha_venta;
        }

        public void setFecha_venta(String fecha_venta) {
            Fecha_venta = fecha_venta;
        }

        public String getTitulo() {
            return Titulo;
        }

        public void setTitulo(String titulo) {
            Titulo = titulo;
        }

        public String getUsuario() {
            return Usuario;
        }

        public void setUsuario(String usuario) {
            Usuario = usuario;
        }

        public String getTipo_de_reclamo() {
            return Tipo_de_reclamo;
        }

        public void setTipo_de_reclamo(String tipo_de_reclamo) {
            Tipo_de_reclamo = tipo_de_reclamo;
        }

        public String getDetalle() {
            return Detalle;
        }

        public void setDetalle(String detalle) {
            Detalle = detalle;
        }
    }

    @Embeddable
    public static class Mediacion {
        private String Fecha_venta;
        private String venta;
        private String Título;
        private String Usuario;

        public Mediacion() {
        }

        public Mediacion(String fecha_venta, String venta, String título, String usuario) {
            Fecha_venta = fecha_venta;
            this.venta = venta;
            Título = título;
            Usuario = usuario;
        }

        public String getFecha_venta() {
            return Fecha_venta;
        }

        public void setFecha_venta(String fecha_venta) {
            Fecha_venta = fecha_venta;
        }

        public String getVenta() {
            return venta;
        }

        public void setVenta(String venta) {
            this.venta = venta;
        }

        public String getTítulo() {
            return Título;
        }

        public void setTítulo(String título) {
            Título = título;
        }

        public String getUsuario() {
            return Usuario;
        }

        public void setUsuario(String usuario) {
            Usuario = usuario;
        }
    }

    @Embeddable
    public static class Cancelacion {
        private String Fecha_venta;
        private String venta;
        private String Titulo;
        private String Usuario;

        public Cancelacion() {
        }

        public Cancelacion(String fecha_venta, String venta, String titulo, String usuario) {
            Fecha_venta = fecha_venta;
            this.venta = venta;
            Titulo = titulo;
            Usuario = usuario;
        }

        public String getFecha_venta() {
            return Fecha_venta;
        }

        public void setFecha_venta(String fecha_venta) {
            Fecha_venta = fecha_venta;
        }

        public String getVenta() {
            return venta;
        }

        public void setVenta(String venta) {
            this.venta = venta;
        }

        public String getTitulo() {
            return Titulo;
        }

        public void setTitulo(String titulo) {
            Titulo = titulo;
        }

        public String getUsuario() {
            return Usuario;
        }

        public void setUsuario(String usuario) {
            Usuario = usuario;
        }
    }

    @Embeddable
    public static class Demora {
        private String Fecha_venta;
        private String venta;
        private String Titulo;
        private String Usuario;
        private String Forma_de_envio;
        private String Tiempo_despachar;
        private String Tiempo_despachado;

        public Demora() {
        }

        public Demora(String fecha_venta, String venta, String titulo, String usuario, String forma_de_envio, String tiempo_despachar, String tiempo_despachado) {
            Fecha_venta = fecha_venta;
            this.venta = venta;
            Titulo = titulo;
            Usuario = usuario;
            Forma_de_envio = forma_de_envio;
            Tiempo_despachar = tiempo_despachar;
            Tiempo_despachado = tiempo_despachado;
        }

        public String getFecha_venta() {
            return Fecha_venta;
        }

        public void setFecha_venta(String fecha_venta) {
            Fecha_venta = fecha_venta;
        }

        public String getVenta() {
            return venta;
        }

        public void setVenta(String venta) {
            this.venta = venta;
        }

        public String getTitulo() {
            return Titulo;
        }

        public void setTitulo(String titulo) {
            Titulo = titulo;
        }

        public String getUsuario() {
            return Usuario;
        }

        public void setUsuario(String usuario) {
            Usuario = usuario;
        }

        public String getForma_de_envio() {
            return Forma_de_envio;
        }

        public void setForma_de_envio(String forma_de_envio) {
            Forma_de_envio = forma_de_envio;
        }

        public String getTiempo_despachar() {
            return Tiempo_despachar;
        }

        public void setTiempo_despachar(String tiempo_despachar) {
            Tiempo_despachar = tiempo_despachar;
        }

        public String getTiempo_despachado() {
            return Tiempo_despachado;
        }

        public void setTiempo_despachado(String tiempo_despachado) {
            Tiempo_despachado = tiempo_despachado;
        }
    }
}

