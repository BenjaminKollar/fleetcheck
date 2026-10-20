package com.example.gestion_flota.controller;

import com.example.gestion_flota.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Endpoint para probar el Error 401 (Credenciales Inválidas)
    @PostMapping("/login")
    public ResponseEntity<?> iniciarSesion(@RequestBody Map<String, String> credenciales) {
        String correo = credenciales.get("correo");
        String password = credenciales.get("password");

        if (authService.validarCredenciales(correo, password)) {
            String token = authService.generarToken(correo);
            return ResponseEntity.ok(Map.of("token", token, "rol", "COORDINADOR"));
        } else {
            // Flujo Alterno 4a: Retorna HTTP 401 (GRABA ESTO EN TU VIDEO)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Error 401: Credenciales inválidas. Verifique su correo y contraseña.");
        }
    }

    // Endpoint para probar el Error 403 (Roles y Permisos)
    @PostMapping("/accion-restringida")
    public ResponseEntity<?> probarPermisos(@RequestHeader(value="Rol", defaultValue="EMPRESARIO") String rol) {
        if ("EMPRESARIO".equalsIgnoreCase(rol)) {
            // Bloqueo por rol: Retorna HTTP 403 (GRABA ESTO EN TU VIDEO)
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Error 403 Forbidden: Acceso denegado. El rol EMPRESARIO no tiene permisos de modificación.");
        }
        return ResponseEntity.ok("Acción guardada exitosamente por el rol: " + rol);
    }
}