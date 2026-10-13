package com.example.gestion_flota.repository;

import com.example.gestion_flota.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    // Método para validar unicidad de patente y evitar duplicados en la base de datos
    Optional<Vehiculo> findByPatente(String patente);

    boolean existsByPatente(String patente);
}
