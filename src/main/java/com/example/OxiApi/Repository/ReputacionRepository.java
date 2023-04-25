package com.example.OxiApi.Repository;

import com.example.OxiApi.Model.Reputacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReputacionRepository extends JpaRepository<Reputacion, Long> {
}
