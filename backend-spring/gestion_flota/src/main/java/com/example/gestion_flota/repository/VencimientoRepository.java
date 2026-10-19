package com.example.gestion_flota.repository;

import com.example.gestion_flota.entity.Vencimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VencimientoRepository extends JpaRepository<Vencimiento, Long> {

    // Busca los vencimientos pendientes para una fecha exacta (ej: hoy + 7 días o hoy + 1 día)
    List<Vencimiento> findByFechaLimiteAndAlertaEnviadaFalse(LocalDate fechaLimite);

    // Lista los vencimientos asociados a un vehículo específico
    List<Vencimiento> findByVehiculoId(Long vehiculoId);
}