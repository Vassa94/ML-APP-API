package com.example.OxiApi.Repository;

import com.example.OxiApi.Model.PublicacionWeb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionWebRepository extends JpaRepository<PublicacionWeb,Long> {
}
