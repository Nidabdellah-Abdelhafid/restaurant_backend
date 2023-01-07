package com.example.backend_vill.repositories;

import com.example.backend_vill.beans.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    @Query("SELECT p.photo_id as id_p,p.url as u_p FROM Photo p WHERE p.restaurant.restaurant_id=:restaurant_id")
    public List findByRestaurant_idDesPhoto(@Param("restaurant_id") int restaurant_id);



    @Query("SELECT url FROM Photo GROUP BY restaurant.restaurant_id")
    public List findByRestaurantPT();

}
