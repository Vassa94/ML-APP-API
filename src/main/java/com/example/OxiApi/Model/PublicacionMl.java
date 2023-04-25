package com.example.OxiApi.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;


@Getter
@Setter
@Entity
public class PublicacionMl {

    @Id
    private String itemId;
    @NotNull(message = "El campo Codigo es obligatorio")
    private Long itemSku;
    private Long variationId;
    private Long variationSku;
    @NotNull(message = "El campo Categoria es obligatorio")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "El campo debe ser una cadena de caracteres")
    private String category_id;
    @NotNull(message = "El campo Listing Type es obligatorio")
    private String listing_type;
    @NotNull(message = "El campo Title es obligatorio")
    private String title;
    @NotNull(message = "El campo quantity es obligatorio")
    private Long quantity;
    @NotNull(message = "El campo Price es obligatorio")
    private Long price;
    @NotNull(message = "El campo Status es obligatorio")
    private String status;
    @NotNull(message = "El campo Free Shipping es obligatorio")
    private Boolean free_shipping;
    @NotNull(message = "El campo Full es obligatorio")
    private Boolean full;
    @NotNull(message = "El campo local pickup es obligatorio")
    private Boolean local_pickup;
    @NotNull(message = "El campo warranty es obligatorio")
    private String warranty;
    @NotNull(message = "El campo catalog listing es obligatorio")
    private Boolean catalog_listing;
    private String catalog_product_id;
    @NotNull(message = "El campo Image es obligatorio")
    private String img;
    @NotNull(message = "El campo brand es obligatorio")
    private String brand;
    @NotNull(message = "El campo model es obligatorio")
    private String model;
    private Float weight;

    public PublicacionMl() {
    }

    public PublicacionMl(String itemId, Long itemSku, Long variationId, Long variationSku, String category_id, String listing_type, String title, Long quantity, Long price, String status, Boolean free_shipping, Boolean full, Boolean local_pickup, String warranty, Boolean catalog_listing, String catalog_product_id, String img, String brand, String model, Float weight) {
        this.itemId = itemId;
        this.itemSku = itemSku;
        this.variationId = variationId;
        this.variationSku = variationSku;
        this.category_id = category_id;
        this.listing_type = listing_type;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.free_shipping = free_shipping;
        this.full = full;
        this.local_pickup = local_pickup;
        this.warranty = warranty;
        this.catalog_listing = catalog_listing;
        this.catalog_product_id = catalog_product_id;
        this.img = img;
        this.brand = brand;
        this.model = model;
        this.weight = weight;
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

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getListing_type() {
        return listing_type;
    }

    public void setListing_type(String listing_type) {
        this.listing_type = listing_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getFree_shipping() {
        return free_shipping;
    }

    public void setFree_shipping(Boolean free_shipping) {
        this.free_shipping = free_shipping;
    }

    public Boolean getFull() {
        return full;
    }

    public void setFull(Boolean full) {
        this.full = full;
    }

    public Boolean getLocal_pickup() {
        return local_pickup;
    }

    public void setLocal_pickup(Boolean local_pickup) {
        this.local_pickup = local_pickup;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public Boolean getCatalog_listing() {
        return catalog_listing;
    }

    public void setCatalog_listing(Boolean catalog_listing) {
        this.catalog_listing = catalog_listing;
    }

    public String getCatalog_product_id() {
        return catalog_product_id;
    }

    public void setCatalog_product_id(String catalog_product_id) {
        this.catalog_product_id = catalog_product_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
}
