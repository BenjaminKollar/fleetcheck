package com.example.gestion_flota.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vencimientos")
public class Vencimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoTramite;

    @Column(nullable = false)
    private LocalDate fechaLimite;

    @Column(nullable = false)
    private boolean alertaEnviada = false;

    // Relación: Muchos vencimientos pertenecen a un vehículo
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;

    public Vencimiento() {
    }

    public Vencimiento(String tipoTramite, LocalDate fechaLimite, Vehiculo vehiculo) {
        this.tipoTramite = tipoTramite;
        this.fechaLimite = fechaLimite;
        this.vehiculo = vehiculo;
        this.alertaEnviada = false;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public boolean isAlertaEnviada() {
        return alertaEnviada;
    }

    public void setAlertaEnviada(boolean alertaEnviada) {
        this.alertaEnviada = alertaEnviada;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
