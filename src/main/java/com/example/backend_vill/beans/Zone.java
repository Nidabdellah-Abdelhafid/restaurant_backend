package com.example.backend_vill.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="zone")
@DynamicUpdate
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zone_id", nullable = false)
    private Integer zone_id;
    private String nom_zone;

    @ManyToOne
    @JoinColumn(name = "ville_id")
    private Ville ville;

    @JsonIgnore
    @OneToMany()
    @JoinColumn(name = "zone_id")
    private List<Restaurant> restaurants;

    public Zone(String nom_zone,Ville ville) {
        this.nom_zone = nom_zone;
        this.ville=ville;
    }

    public Zone() {
    }

    public Integer getZone_id() {
        return zone_id;
    }

    public void setZone_id(Integer zone_id) {
        this.zone_id = zone_id;
    }

    public String getNom_zone() {
        return nom_zone;
    }

    public void setNom_zone(String nom_zone) {
        this.nom_zone = nom_zone;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
