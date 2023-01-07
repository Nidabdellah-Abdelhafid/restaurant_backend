package com.example.backend_vill.services;

import com.example.backend_vill.beans.Specialite;
import com.example.backend_vill.beans.Ville;
import com.example.backend_vill.controllers.AddResponse;
import com.example.backend_vill.repositories.SpecialiteRepository;
import com.example.backend_vill.repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class SpecialiteService {
    @Autowired
    SpecialiteRepository specialiteRepository;

    public List<Specialite> findAll(){
        return specialiteRepository.findAll();
    }

    public Specialite findById(int id){
        return specialiteRepository.findById(id).get();
    }

    public Specialite create(Specialite specialite){
        specialiteRepository.save(specialite);
        return specialite;
    }

    public Specialite update(Specialite specialite){
        specialiteRepository.save(specialite);
        return specialite;
    }

    public AddResponse delete(int id){
        specialiteRepository.delete(specialiteRepository.findById(id).get());
        AddResponse res=new AddResponse();
        res.setMsg("House factory deleted ...");
        res.setId(id);
        return res;
    }
    public int getMaxId(){
        return specialiteRepository.findAll().size()+1;
    }

}
