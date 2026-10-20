package com.example.gestion_flota.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // Método para validar usuario (Pasos 1 al 4 de tu Caso de Uso)
    public boolean validarCredenciales(String correo, String password) {
        // Para la demo, fijamos unas credenciales maestras de administrador
        return "admin@fleetcheck.cl".equals(correo) && "admin123".equals(password);
    }

    // Método para simular la entrega del Token JWT
    public String generarToken(String correo) {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.simulado." + correo.hashCode();
    }
}