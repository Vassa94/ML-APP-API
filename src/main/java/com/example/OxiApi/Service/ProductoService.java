package com.example.OxiApi.Service;


import com.example.OxiApi.Model.Producto;
import com.example.OxiApi.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getProductos(){
        List<Producto> ListaProductos=productoRepository.findAll();
        return ListaProductos;
    }

    @Override
    public Producto getProducto(Long id) { return (Producto) productoRepository.findById(id).orElse( null);}

    @Override
    public void saveProducto(Producto producto){
        productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(Long id){
        productoRepository.deleteById(id);
    }

    @Override
    public Producto findProducto(Long id){
        Producto producto = productoRepository.findById(id).orElse(null);
        return producto;
    }

}
