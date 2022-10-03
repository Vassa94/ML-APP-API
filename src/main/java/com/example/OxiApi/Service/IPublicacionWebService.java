package com.example.OxiApi.Service;

import com.example.OxiApi.Model.PublicacionWeb;

import java.util.List;

public interface IPublicacionWebService {

    public List<PublicacionWeb> getPublicacionWeb ();
    public void savePublicacionWeb(PublicacionWeb publicacionWeb);
    public void deletePublicacionWeb (Long id);
    public PublicacionWeb findPublicacionWeb(Long id);
}
