package com.example.OxiApi.Service;

import com.example.OxiApi.Model.PublicacionMl;
import com.example.OxiApi.Repository.PublicacionMlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionMlService implements IPublicacionMlService {

    @Autowired
    private PublicacionMlRepository publicacionMlRepository;

    @Override
    public List<PublicacionMl> getPublicacionMl(){
        List<PublicacionMl> ListaPublicacionMl=publicacionMlRepository.findAll();
        return ListaPublicacionMl;
    }

    @Override
    public void savePublicacionMl(PublicacionMl publicacionMl){
        publicacionMlRepository.save(publicacionMl);
    }

    @Override
    public void deletePublicacionMl(Long id){
        publicacionMlRepository.deleteById(id);
    }

    @Override
    public PublicacionMl findPublicacionMl(Long id){
        PublicacionMl publicacionMl = publicacionMlRepository.findById(id).orElse(null);
        return publicacionMl;
    }

}
