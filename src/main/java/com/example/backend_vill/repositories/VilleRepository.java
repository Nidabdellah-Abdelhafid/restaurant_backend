package com.example.backend_vill.repositories;
import com.example.backend_vill.beans.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VilleRepository extends JpaRepository<Ville, Integer> {
}
