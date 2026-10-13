# FleetCheck - Plataforma de Gestion y Control de Flota Vehicular

Sistema web B2B orientado a empresas con flota propia (maquinaria, camiones, camionetas) para el seguimiento centralizado de vencimientos legales y tecnicos (revisiones tecnicas, permisos de circulacion, mantenciones) y emision de alertas preventivas.

## Stack Tecnologico
- Backend: Java 24, Spring Boot 4.1.1, Spring Data JPA / Hibernate
- Base de Datos: PostgreSQL 18.6
- Frontend: Vue.js (Vite)
- Control de Versiones: Git con GitFlow (main, develop, feature/*)

## Requisitos Previos
- Java Development Kit 21 o superior
- PostgreSQL 16+ instalado localmente
- IntelliJ IDEA / Maven

## Instalacion y Puesta en Marcha

### 1. Clonar el repositorio
git clone https://github.com/BenjaminKollar/fleetcheck.git
cd fleetcheck
git checkout develop

### 2. Configurar variables de entorno
Copiar la plantilla de ejemplo y configurar las credenciales locales de base de datos:
cp .env.example .env

### 3. Base de Datos
Crear la base de datos en PostgreSQL:
CREATE DATABASE gestion_flota_db;

### 4. Ejecutar el Backend
Desde la carpeta backend-spring/gestion_flota:
./mvnw spring-boot:run
El servidor iniciara en: http://localhost:8080

## Endpoints Principales (API REST)
- GET /api/vehiculos: Listado de unidades registradas.
- POST /api/vehiculos: Registro de nuevo vehiculo con validacion de patente unica.
