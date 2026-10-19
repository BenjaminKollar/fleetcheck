package com.example.gestion_flota.controller;

import com.example.gestion_flota.entity.Vehiculo;
import com.example.gestion_flota.entity.Vencimiento;
import com.example.gestion_flota.repository.VehiculoRepository;
import com.example.gestion_flota.repository.VencimientoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vencimientos")
@CrossOrigin(origins = "*")
public class VencimientoController {

    private final VencimientoRepository vencimientoRepository;
    private final VehiculoRepository vehiculoRepository;

    public VencimientoController(VencimientoRepository vencimientoRepository, VehiculoRepository vehiculoRepository) {
        this.vencimientoRepository = vencimientoRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    @GetMapping
    public List<Vencimiento> listarTodos() {
        return vencimientoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> registrarVencimiento(@RequestBody Map<String, Object> payload) {
        String tipoTramite = (String) payload.get("tipoTramite");
        String fechaStr = (String) payload.get("fechaLimite");
        Long vehiculoId = Long.valueOf(payload.get("vehiculoId").toString());

        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId).orElse(null);
        if (vehiculo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El vehículo con ID " + vehiculoId + " no existe.");
        }

        LocalDate fechaLimite = LocalDate.parse(fechaStr);
        Vencimiento nuevo = new Vencimiento(tipoTramite, fechaLimite, vehiculo);
        Vencimiento guardado = vencimientoRepository.save(nuevo);

        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }
}