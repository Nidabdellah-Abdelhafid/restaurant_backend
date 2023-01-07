package com.example.backend_vill.services;

import com.example.backend_vill.beans.Serie;
import com.example.backend_vill.beans.Specialite;
import com.example.backend_vill.controllers.AddResponse;
import com.example.backend_vill.repositories.SerieRepository;
import com.example.backend_vill.repositories.SpecialiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepository;

    public List<Serie> findAll(){
        return serieRepository.findAll();
    }

    public Serie findById(int id){
        return serieRepository.findById(id).get();
    }

    public Serie create(Serie serie){
        serieRepository.save(serie);
        return serie;
    }

    public Serie update(Serie serie){
        serieRepository.save(serie);
        return serie;
    }

    public AddResponse delete(int id){
        serieRepository.delete(serieRepository.findById(id).get());
        AddResponse res=new AddResponse();
        res.setMsg("House factory deleted ...");
        res.setId(id);
        return res;
    }
    public int getMaxId(){
        return serieRepository.findAll().size()+1;
    }

}
