package com.example.OxiApi.Service;

import com.example.OxiApi.Model.Producto;
import java.util.List;

public interface IProductoService {

        public List<Producto> getProductos ();
        Producto getProducto(Long id);
        public void saveProducto(Producto producto);
        public void deleteProducto (Long id);
        public Producto findProducto(Long id);


}
