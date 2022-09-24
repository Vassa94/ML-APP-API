package com.example.OxiApi.Repository;

import com.example.OxiApi.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionWebRepository extends JpaRepository<Producto,Long> {
}
