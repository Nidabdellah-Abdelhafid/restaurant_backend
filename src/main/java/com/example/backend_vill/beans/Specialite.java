package com.example.backend_vill.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="specialite")
@DynamicUpdate
public class Specialite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialite_id", nullable = false)
    private Integer specialite_id;
    private String nom_specialite;

    @JsonIgnore
    @OneToMany()
    @JoinColumn(name = "specialite_id")
    private List<Restaurant> restaurants;

    public Specialite() {
    }

    public Specialite(String nom_specialite) {
        this.nom_specialite = nom_specialite;
    }

    public Integer getSpecialite_id() {
        return specialite_id;
    }

    public void setSpecialite_id(Integer specialite_id) {
        this.specialite_id = specialite_id;
    }

    public String getNom_specialite() {
        return nom_specialite;
    }

    public void setNom_specialite(String nom_specialite) {
        this.nom_specialite = nom_specialite;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
