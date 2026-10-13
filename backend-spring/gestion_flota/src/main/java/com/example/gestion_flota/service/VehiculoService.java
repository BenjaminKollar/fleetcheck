package com.example.gestion_flota.service;

import com.example.gestion_flota.entity.Vehiculo;
import com.example.gestion_flota.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    // Listar todos los vehículos
    public List<Vehiculo> obtenerTodos() {
        return vehiculoRepository.findAll();
    }

    // Registrar o guardar vehículo con validación preventiva de duplicidad
    public Vehiculo registrarVehiculo(Vehiculo vehiculo) {
        if (vehiculoRepository.existsByPatente(vehiculo.getPatente())) {
            throw new IllegalArgumentException("La patente " + vehiculo.getPatente() + " ya está registrada en el sistema.");
        }
        return vehiculoRepository.save(vehiculo);
    }
}