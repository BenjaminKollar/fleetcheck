package com.example.gestion_flota.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculos")

public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Validación básica: la patente no puede ser nula y no se puede repetir
    @Column(unique = true, nullable = false)
    private String patente;

    @Column(nullable = false)
    private String tipo;

    @Column(name = "responsable_asignado")
    private String responsable;

    // Constructor vacío obligatorio para Spring Boot
    public Vehiculo() {
    }

    // --- Getters y Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente = patente; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }
}
