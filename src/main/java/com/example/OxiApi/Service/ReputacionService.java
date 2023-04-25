package com.example.OxiApi.Service;

import com.example.OxiApi.Model.Reputacion;
import com.example.OxiApi.Repository.ReputacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReputacionService implements IReputacionService {

    @Autowired
    private ReputacionRepository reputacionRepository;

    @Override
    public List<Reputacion> getReputacion() {
        List<Reputacion> ListaReputacion = reputacionRepository.findAll();
        return ListaReputacion;
    }

    @Override
    public void saveReputacion(Reputacion reputacion) {
        reputacionRepository.save(reputacion);
    }

    @Override
    public void deleteReputacion(Long id) {
        reputacionRepository.deleteById(id);
    }

    @Override
    public Reputacion findReputacion(Long id) {
        Reputacion reputacion = reputacionRepository.findById(id).orElse(null);
        return reputacion;
    }
}
