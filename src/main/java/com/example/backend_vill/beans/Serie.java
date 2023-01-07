package com.example.backend_vill.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="serie")
@DynamicUpdate
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serie_id", nullable = false)
    private Integer serie_id;
    private String nom_serie;

    @JsonIgnore
    @OneToMany()
    @JoinColumn(name = "serie_id")
    private List<Restaurant> restaurants;

    public Serie() {
    }

    public Serie(String nom_serie) {
        this.nom_serie = nom_serie;
    }

    public Integer getSerie_id() {
        return serie_id;
    }

    public void setSerie_id(Integer serie_id) {
        this.serie_id = serie_id;
    }

    public String getNom_serie() {
        return nom_serie;
    }

    public void setNom_serie(String nom_serie) {
        this.nom_serie = nom_serie;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
