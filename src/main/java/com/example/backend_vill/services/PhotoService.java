package com.example.backend_vill.services;


import com.example.backend_vill.beans.Photo;
import com.example.backend_vill.beans.Restaurant;
import com.example.backend_vill.controllers.AddResponse;
import com.example.backend_vill.repositories.PhotoRepository;
import com.example.backend_vill.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class PhotoService {
    @Autowired
    PhotoRepository photoRepository;

    public List<Photo> findAll(){
        return photoRepository.findAll();
    }

    public Photo findById(int id){
        return photoRepository.findById(id).get();
    }

    public Photo create(Photo photo){
        photoRepository.save(photo);
        return photo;
    }

    public Photo update(Photo photo){
        photoRepository.save(photo);
        return photo;
    }

    public AddResponse delete(int id){
        photoRepository.delete(photoRepository.findById(id).get());
        AddResponse res=new AddResponse();
        res.setMsg("House factory deleted ...");
        res.setId(id);
        return res;
    }

    public int getMaxId(){
        return photoRepository.findAll().size()+1;
    }

}
