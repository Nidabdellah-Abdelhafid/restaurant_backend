package com.example.backend_vill.controllers;

import com.example.backend_vill.beans.*;
import com.example.backend_vill.repositories.PhotoRepository;
import com.example.backend_vill.repositories.RestaurantRepository;
import com.example.backend_vill.repositories.SerieRepository;
import com.example.backend_vill.repositories.ZoneRepository;
import com.example.backend_vill.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RestController
@RequestMapping("/Vill_Zone")
public class PageController {
    @Autowired
    VilleService villeService;
    @Autowired
    ZoneService zoneService;

    @Autowired
    SerieService serieService;
    @Autowired
    RestaurantService restaurantService;
    @Autowired
    SpecialiteService specialiteService;

    @Autowired
    PhotoService photoService;
    @Autowired
    PhotoRepository photoRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

//----Zone----

    @GetMapping("/zone/allzone")
    public List<Zone> Zone(){
        return zoneService.findAll();
    }

    @PostMapping("/ville/{ville_id}/addZone")
    public Zone AddZone(@PathVariable(name="ville_id") int ville_id,@RequestBody Zone zone){
        Ville ville=villeService.findById(ville_id);
        zone.setVille(ville);
        return zoneService.create(zone);
    }

    @PutMapping("/ville/{ville_id}/updateZone/{zone_id}")
    public ResponseEntity<Zone> updateHouse(@PathVariable(name="ville_id") int user_id, @PathVariable(value = "zone_id")int zone_id , @RequestBody Zone zone){
        try {

            Ville user=villeService.findById(user_id);
            Zone existZone=zoneService.findById(zone_id);
            existZone.setNom_zone(zone.getNom_zone());
            existZone.setVille(user);
            Zone update_zone=zoneService.update(existZone);
            return new ResponseEntity<Zone>(update_zone, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }

    }

    @GetMapping("/zone/{zone_id}")
    public ResponseEntity<Zone> getZoneById(@PathVariable(value = "zone_id") int zone_id){
        try {
            Zone zone=zoneService.findById(zone_id);
            return new ResponseEntity<Zone>(zone, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

    @DeleteMapping("/zone/deleteZone/{id}")
    public AddResponse deleteZone(@PathVariable(value = "id") int id){
        return zoneService.delete(id);
    }

    //----------Ville---------

    @GetMapping("/ville/allVille")
    public  List<Ville> Ville(){
        return villeService.findAll();
    }

    @GetMapping("/ville/{ville_id}")
    public ResponseEntity<Ville> getVilleById(@PathVariable(value = "ville_id") int user_id){
        try {
            Ville country=villeService.findById(user_id);
            return new ResponseEntity<Ville>(country, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

    @PostMapping("/ville/addVille")
    public Ville addVille(@RequestBody Ville ville){
        return villeService.create(ville);
    }
    @PutMapping("/updateVille/{ville_id}")
    public ResponseEntity<Ville> updateVille(@PathVariable(value = "ville_id")int ville_id,@RequestBody Ville ville){
        try {
            Ville existVille=villeService.findById(ville_id);
            existVille.setNom_ville(ville.getNom_ville());
            Ville update_ville=villeService.update(existVille);
            return new ResponseEntity<Ville>(update_ville,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }

    }
    @DeleteMapping("/deleteVille/{ville_id}")
    public AddResponse deleteVille(@PathVariable(value = "ville_id") int ville_id){
        return villeService.delete(ville_id);
    }


//----------Serie---------

@GetMapping("/serie/allSerie")
public  List<Serie> Serie(){
    return serieService.findAll();
}

    @GetMapping("/serie/{serie_id}")
    public ResponseEntity<Serie> getSerieById(@PathVariable(value = "serie_id") int serie_id){
        try {
            Serie country=serieService.findById(serie_id);
            return new ResponseEntity<Serie>(country, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/serie/addSerie")
    public Serie addSerie(@RequestBody Serie serie){
        return serieService.create(serie);
    }
    @PutMapping("/updateSerie/{serie_id}")
    public ResponseEntity<Serie> updateSerie(@PathVariable(value = "serie_id")int serie_id,@RequestBody Serie serie){
        try {
            Serie existSerie=serieService.findById(serie_id);
            existSerie.setNom_serie(serie.getNom_serie());
            Serie update_ville=serieService.update(existSerie);
            return new ResponseEntity<Serie>(update_ville,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }

    }
    @DeleteMapping("/deleteSerie/{serie_id}")
    public AddResponse deleteSerie(@PathVariable(value = "serie_id") int serie_id){
        return serieService.delete(serie_id);
    }
//----------Specialite---------

@GetMapping("/specialite/allSpecialite")
public  List<Specialite> Specialite(){
    return specialiteService.findAll();
}

    @GetMapping("/specialite/{specialite_id}")
    public ResponseEntity<Specialite> getSpecialiteById(@PathVariable(value = "specialite_id") int specialite_id){
        try {
            Specialite country=specialiteService.findById(specialite_id);
            return new ResponseEntity<Specialite>(country, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

    @PostMapping("/specialite/addSpecialite")
    public Specialite addSpecialite(@RequestBody Specialite specialite){
        return specialiteService.create(specialite);
    }
    @PutMapping("/updateSpecialite/{specialite_id}")
    public ResponseEntity<Specialite> updateSpecialite(@PathVariable(value = "specialite_id")int specialite_id,@RequestBody Specialite specialite){
        try {
            Specialite existspecialite=specialiteService.findById(specialite_id);
            existspecialite.setNom_specialite(specialite.getNom_specialite());
            Specialite update_specialite=specialiteService.update(existspecialite);
            return new ResponseEntity<Specialite>(update_specialite,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }

    }
    @DeleteMapping("/deleteSpecialite/{specialite_id}")
    public AddResponse deleteSpecialite(@PathVariable(value = "specialite_id") int specialite_id){
        return specialiteService.delete(specialite_id);
    }


//----------Photo---------


@GetMapping("/photo/allPhoto")
public List<Photo> Photo(){
    return photoService.findAll();
}

    @PostMapping("/restaurant/{restaurant_id}/addPhoto")
    public void AddPhoto(@PathVariable(name="restaurant_id") int restaurant_id,
                          @RequestParam("url") MultipartFile url
                          ){

        Photo photo=new Photo();
        String fileName = StringUtils.cleanPath(url.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            photo.setUrl(Base64.getEncoder().encodeToString(url.getBytes()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Restaurant restaurant=restaurantService.findById(restaurant_id);
        photo.setRestaurant(restaurant);
         photoRepository.save(photo);

    }

    @PutMapping("/restaurant/{restaurant_id}/updatePhoto/{photo_id}")
    public ResponseEntity<Photo> updatePhoto(@PathVariable(name="restaurant_id") int restaurant_id,
                                             @PathVariable(value = "photo_id")int photo_id ,
                                             @RequestParam("url") MultipartFile url){
        try {

            Restaurant restaurant=restaurantService.findById(restaurant_id);
            Photo existPhoto=photoService.findById(photo_id);
            String fileName = StringUtils.cleanPath(url.getOriginalFilename());
            if(fileName.contains(".."))
            {
                System.out.println("not a a valid file");
            }
            try {
                existPhoto.setUrl(Base64.getEncoder().encodeToString(url.getBytes()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            existPhoto.setRestaurant(restaurant);
            Photo update_Photo=photoService.update(existPhoto);
            return new ResponseEntity<Photo>(update_Photo, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }

    }

    @GetMapping("/photo/{photo_id}")
    public ResponseEntity<Photo> getPhotoById(@PathVariable(value = "photo_id") int photo_id){
        try {
            Photo photo=photoService.findById(photo_id);
            return new ResponseEntity<Photo>(photo, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

    @DeleteMapping("/photo/deletePhoto/{id}")
    public AddResponse deletePhoto(@PathVariable(value = "id") int id){
        return photoService.delete(id);
    }

//----------byRs----------------------------


    @GetMapping("/findPhotoResrById/{restaurant_id}")
    public  List finphoto(@PathVariable(value = "restaurant_id") int restaurant_id){
        return photoRepository.findByRestaurant_idDesPhoto(restaurant_id);
    }

    @GetMapping("/findPhotoResrPT")
    public  List findph(){
        return photoRepository.findByRestaurantPT();
    }

    @GetMapping("/DachRZone")
    public  List DachRZone(){
        return restaurantRepository.Nombre_Resturant_Zone();
    }
    @GetMapping("/DachRVile")
    public  List DachRVile(){
        return restaurantRepository.Nombre_Resturant_Ville();
    }

//----------Restaurant---------

    @GetMapping("/restaurant/allrestaurant")
    public  List<Restaurant> Restaurant(){
        return restaurantService.findAll();
    }

    @PostMapping("/specialite/{specialite_id}/serie/{serie_id}/zone/{zone_id}/addRestaurant")
    public Restaurant AddInsuranceRestaurant(@RequestBody Restaurant restaurant,
                                   @PathVariable(name="specialite_id") int specialite_id,
                                   @PathVariable(name="serie_id") int serie_id,
                                   @PathVariable(name="zone_id") int zone_id){
        Specialite specialite=specialiteService.findById(specialite_id);
        Serie serie=serieService.findById(serie_id);
        Zone zone=zoneService.findById(zone_id);
        restaurant.setSpecialite(specialite);
        restaurant.setSerie(serie);
        restaurant.setZone(zone);
        return restaurantService.create(restaurant);
    }

    @PutMapping("/specialite/{specialite_id}/serie/{serie_id}/zone/{zone_id}/updateRestaurant/{restaurant_id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable(name="specialite_id") int specialite_id,
                                             @PathVariable(value = "serie_id")int serie_id ,
                                             @PathVariable(name="zone_id") int zone_id,
                                             @PathVariable(name="restaurant_id") int restaurant_id,
                                             @RequestBody Restaurant restaurant){
        try {

            Specialite specialite=specialiteService.findById(specialite_id);
            Serie serie=serieService.findById(serie_id);
            Zone zone=zoneService.findById(zone_id);
            Restaurant existRestaurant=restaurantService.findById(restaurant_id);
            existRestaurant.setNom_restaurant(restaurant.getNom_restaurant());
            existRestaurant.setAddresse(restaurant.getAddresse());
            existRestaurant.setLat(restaurant.getLat());
            existRestaurant.setLog(restaurant.getLog());
            existRestaurant.setWeek(restaurant.getWeek());
            existRestaurant.setEtat(restaurant.getEtat());
            existRestaurant.setHeure_close(restaurant.getHeure_close());
            existRestaurant.setHeure_open(restaurant.getHeure_open());
            existRestaurant.setSerie(serie);
            existRestaurant.setSpecialite(specialite);
            existRestaurant.setZone(zone);
            Restaurant update_restaurant=restaurantService.update(existRestaurant);
            return new ResponseEntity<Restaurant>(update_restaurant,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }

    }


    @GetMapping("/restaurant/{restaurant_id}")
    public ResponseEntity<Restaurant> getHouseById(@PathVariable(value = "restaurant_id") int restaurant_id){
        try {
            Restaurant restaurant=restaurantService.findById(restaurant_id);
            return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

    @DeleteMapping("/restaurant/deleteRestaurant/{id}")
    public AddResponse deleteHouse(@PathVariable(value = "id") int id){
        return restaurantService.delete(id);
    }

    @PutMapping("/restaurant/changeEtat/{restaurant_id}")
    public ResponseEntity<Restaurant> updateRestaurantEtat(
            @PathVariable(value = "restaurant_id")int restaurant_id ,
            @RequestBody Restaurant restaurant){
        try {

            Restaurant existRestaurant=restaurantService.findById(restaurant_id);
            existRestaurant.setEtat(restaurant.getEtat());
            Restaurant update_Restaurant=restaurantService.update(existRestaurant);
            return new ResponseEntity<Restaurant>(update_Restaurant,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }

    }


}
