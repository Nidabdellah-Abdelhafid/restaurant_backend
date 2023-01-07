package com.example.backend_vill.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="restaurant")
@DynamicUpdate
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id", nullable = false)
    private Integer restaurant_id;
    private String nom_restaurant;
    private String addresse;
    private Double lat;
    private Double log;
    private String heure_open;
    private int etat;
    private String heure_close;
    private Boolean week;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;

    @ManyToOne
    @JoinColumn(name = "specialite_id")
    private Specialite specialite;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    @JsonIgnore
    @OneToMany()
    @JoinColumn(name = "restaurant_id")
    private List<Photo> photos;

    public Restaurant() {
    }

    public Restaurant(String nom_restaurant, String addresse, Double lat, Double log, String heure_open, String heure_close,Boolean week,int etat, Serie serie, Specialite specialite, Zone zone) {
        this.nom_restaurant = nom_restaurant;
        this.addresse = addresse;
        this.lat = lat;
        this.log = log;
        this.heure_open = heure_open;
        this.heure_close = heure_close;
        this.week=week;
        this.serie = serie;
        this.etat=etat;
        this.specialite = specialite;
        this.zone = zone;
    }

    public Integer getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Integer restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getNom_restaurant() {
        return nom_restaurant;
    }

    public void setNom_restaurant(String nom_restaurant) {
        this.nom_restaurant = nom_restaurant;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLog() {
        return log;
    }

    public void setLog(Double log) {
        this.log = log;
    }

    public String getHeure_open() {
        return heure_open;
    }

    public void setHeure_open(String heure_open) {
        this.heure_open = heure_open;
    }

    public String getHeure_close() {
        return heure_close;
    }

    public void setHeure_close(String heure_close) {
        this.heure_close = heure_close;
    }

    public Boolean getWeek() {
        return week;
    }

    public void setWeek(Boolean week) {
        this.week = week;
    }

    public Serie getSerie() {
        return serie;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
