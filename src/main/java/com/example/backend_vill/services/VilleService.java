package com.example.backend_vill.services;


import com.example.backend_vill.beans.Ville;
import com.example.backend_vill.controllers.AddResponse;
import com.example.backend_vill.repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class VilleService {
    @Autowired
    VilleRepository villeRepository;

    public List<Ville> findAll(){
        return villeRepository.findAll();
    }

    public Ville findById(int id){
        return villeRepository.findById(id).get();
    }

    public Ville create(Ville ville){
        villeRepository.save(ville);
        return ville;
    }

    public Ville update(Ville ville){
        villeRepository.save(ville);
        return ville;
    }

    public AddResponse delete(int id){
        villeRepository.delete(villeRepository.findById(id).get());
        AddResponse res=new AddResponse();
        res.setMsg("House factory deleted ...");
        res.setId(id);
        return res;
    }
    public int getMaxId(){
        return villeRepository.findAll().size()+1;
    }

}
