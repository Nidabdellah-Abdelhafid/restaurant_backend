package com.example.backend_vill.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ville")
@DynamicUpdate
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ville_id", nullable = false)
    private Integer ville_id;
    private String nom_ville;



    @JsonIgnore
    @OneToMany()
    @JoinColumn(name = "ville_id")
    private List<Zone> zones;

    public Ville(String nom_ville) {
        this.nom_ville = nom_ville;
    }

    public Ville() {
    }

    public Integer getVille_id() {
        return ville_id;
    }

    public void setVille_id(Integer ville_id) {
        this.ville_id = ville_id;
    }

    public String getNom_ville() {
        return nom_ville;
    }

    public void setNom_ville(String nom_ville) {
        this.nom_ville = nom_ville;
    }
    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }
}
