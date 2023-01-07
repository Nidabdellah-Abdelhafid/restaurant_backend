package com.example.backend_vill.repositories;

import com.example.backend_vill.beans.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {


    @Query("SELECT count(restaurant_id),zone.ville.nom_ville FROM Restaurant GROUP BY zone.ville.nom_ville")
    public List Nombre_Resturant_Ville();

    @Query("SELECT count(restaurant_id),zone.nom_zone FROM Restaurant GROUP BY zone.nom_zone")
    public List Nombre_Resturant_Zone();

}
