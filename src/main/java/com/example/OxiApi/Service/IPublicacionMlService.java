package com.example.OxiApi.Service;

import com.example.OxiApi.Model.PublicacionMl;

import java.util.List;

public interface IPublicacionMlService {
    public List<PublicacionMl> getPublicacionMl ();
    public void savePublicacionMl(PublicacionMl publicacionMl);
    public void deletePublicacionMl (Long id);
    public PublicacionMl findPublicacionMl(Long id);
}
