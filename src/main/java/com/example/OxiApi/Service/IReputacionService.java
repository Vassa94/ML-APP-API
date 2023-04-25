package com.example.OxiApi.Service;

import com.example.OxiApi.Model.Reputacion;

import java.util.List;

public interface IReputacionService {
    public List<Reputacion> getReputacion();

    public void saveReputacion(Reputacion reputacion);

    public void deleteReputacion(Long id);

    public Reputacion findReputacion(Long id);
}
