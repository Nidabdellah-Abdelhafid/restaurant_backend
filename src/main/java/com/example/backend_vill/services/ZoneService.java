package com.example.backend_vill.services;


import com.example.backend_vill.beans.Zone;
import com.example.backend_vill.controllers.AddResponse;
import com.example.backend_vill.repositories.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class ZoneService {
    @Autowired
    ZoneRepository zoneRepository;

    public List<Zone> findAll(){
        return zoneRepository.findAll();
    }

    public Zone findById(int id){
        return zoneRepository.findById(id).get();
    }

    public Zone create(Zone zone){
        zoneRepository.save(zone);
        return zone;
    }

    public Zone update(Zone zone){
        zoneRepository.save(zone);
        return zone;
    }

    public AddResponse delete(int id){
        zoneRepository.delete(zoneRepository.findById(id).get());
        AddResponse res=new AddResponse();
        res.setMsg("House factory deleted ...");
        res.setId(id);
        return res;
    }
    public int getMaxId(){
        return zoneRepository.findAll().size()+1;
    }

}
