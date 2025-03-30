package med.voll.api.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public Health health() {
        // Aqui você pode incluir verificações mais específicas, como verificar a conexão com o banco de dados
        return Health.up().withDetail("status", "UP").build();
    }
}
