# Voll Med API

API REST para gerenciamento de consultas médicas, desenvolvida com Spring Boot. Essa aplicação oferece funcionalidades
de cadastro de médicos, pacientes, autenticação de usuários e agendamento de consultas com regras de negócio bem
definidas.

---

## 📐 Arquitetura

O projeto segue princípios de **DDD (Domain-Driven Design)** e está dividido em camadas bem definidas:

- **Domain**: Entidades, repositórios, DTOs e regras de negócio específicas.
- **Application**: Serviços de aplicação (casos de uso) que orquestram regras de negócio.
- **Controller (Web)**: Camada de interface HTTP (REST API).
- **Infra**: Configurações de segurança, tratamento de exceções, autenticação e integração com infraestrutura.
- **Resources**: Configurações de banco de dados, scripts de migração e templates.

---

## 📁 Estrutura de Pastas

```text
src/main/java/med/voll/api
├── ApiApplication.java            # Classe principal
├── application/                   # Casos de uso (orquestração)
│   └── consultation/
│       └── ScheduleConsultationService.java
├── config/                        # Configurações gerais
│   └── CorsConfiguration.java
├── controller/                    # Interface REST
│   ├── AuthController.java
│   ├── ClientController.java
│   ├── ConsultationController.java
│   ├── DoctorController.java
│   └── HealthController.java
├── domain/                        # Modelo de domínio
│   ├── address/
│   │   ├── Address.java
│   │   └── dto/
│   ├── client/
│   │   ├── Client.java
│   │   ├── ClientRepository.java
│   │   └── dto/
│   ├── consultation/
│   │   ├── Consultation.java
│   │   ├── ConsultationRepository.java
│   │   ├── exception/
│   │   └── validator/
│   │       ├── AppointmentValidator.java
│   │       └── rules/
│   ├── doctor/
│   │   ├── Doctor.java
│   │   ├── DoctorRepository.java
│   │   ├── Specialty.java
│   │   └── dto/
│   └── user/
│       ├── User.java
│       ├── UserRepository.java
│       ├── UserAuthService.java
│       └── dto/
├── infra/                         # Infraestrutura e segurança
│   ├── exception/
│   │   └── GlobalExceptionHandler.java
│   └── security/
│       ├── SecurityConfig.java
│       ├── SecurityFilter.java
│       ├── TokenJWT.java
│       └── TokenService.java
