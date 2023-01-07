package com.example.backend_vill.beans;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Entity
@Table(name="photo")
@DynamicUpdate
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id", nullable = false)
    private Integer photo_id;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String url;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public Photo() {
    }

    public Photo(String url, Restaurant restaurant) {
        this.url = url;
        this.restaurant = restaurant;
    }

    public Integer getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(Integer photo_id) {
        this.photo_id = photo_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
