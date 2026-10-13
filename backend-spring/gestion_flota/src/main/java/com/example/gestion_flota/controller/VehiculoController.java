package com.example.gestion_flota.controller;

import com.example.gestion_flota.entity.Vehiculo;
import com.example.gestion_flota.service.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
@CrossOrigin(origins = "*") // Permite el consumo posterior desde el frontend en Vue.js
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    // GET: /api/vehiculos (Listar vehículos)
    @GetMapping
    public ResponseEntity<List<Vehiculo>> listarVehiculos() {
        return ResponseEntity.ok(vehiculoService.obtenerTodos());
    }

    // POST: /api/vehiculos (Crear nuevo vehículo)
    @PostMapping
    public ResponseEntity<?> crearVehiculo(@RequestBody Vehiculo vehiculo) {
        try {
            Vehiculo nuevoVehiculo = vehiculoService.registrarVehiculo(vehiculo);
            return new ResponseEntity<>(nuevoVehiculo, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            // Manejo de conflicto por patente duplicada
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
