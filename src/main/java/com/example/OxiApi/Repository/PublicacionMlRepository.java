package com.example.OxiApi.Repository;

import com.example.OxiApi.Model.PublicacionMl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionMlRepository extends JpaRepository <PublicacionMl,Long> {
}
