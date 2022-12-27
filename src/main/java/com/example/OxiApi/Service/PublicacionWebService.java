package com.example.OxiApi.Service;

import com.example.OxiApi.Model.PublicacionWeb;
import com.example.OxiApi.Repository.PublicacionWebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class PublicacionWebService implements IPublicacionWebService {

    @Autowired
    private PublicacionWebRepository publicacionWebRepository;


    @Override
    public List<PublicacionWeb> getPublicacionWeb() {
        List<PublicacionWeb> ListaPublicacionWeb = publicacionWebRepository.findAll();
        return ListaPublicacionWeb;
    }

    @Override
    public void savePublicacionWeb(PublicacionWeb publicacionWeb) {
        publicacionWebRepository.save(publicacionWeb);
    }

    @Override
    public void deletePublicacionWeb(Long id) {
        publicacionWebRepository.deleteById(id);
    }

    @Override
    public PublicacionWeb findPublicacionWeb(Long id) {
        PublicacionWeb publicacionWeb = publicacionWebRepository.findById(id).orElse(null);
        return publicacionWeb;
    }

}
