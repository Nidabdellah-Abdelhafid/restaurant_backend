package com.example.backend_vill.services;

import com.example.backend_vill.beans.Restaurant;
import com.example.backend_vill.beans.Ville;
import com.example.backend_vill.controllers.AddResponse;
import com.example.backend_vill.repositories.RestaurantRepository;
import com.example.backend_vill.repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Restaurant> findAll(){
        return restaurantRepository.findAll();
    }

    public Restaurant findById(int id){
        return restaurantRepository.findById(id).get();
    }

    public Restaurant create(Restaurant restaurant){
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    public Restaurant update(Restaurant restaurant){
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    public AddResponse delete(int id){
        restaurantRepository.delete(restaurantRepository.findById(id).get());
        AddResponse res=new AddResponse();
        res.setMsg("House factory deleted ...");
        res.setId(id);
        return res;
    }
    public int getMaxId(){
        return restaurantRepository.findAll().size()+1;
    }

}
