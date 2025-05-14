package med.voll.api.domain.consultation;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    boolean existsByClientIdAndDateBetween(@NotNull Long clientId, LocalDateTime firstHour, LocalDateTime lastHour);
//    boolean existsByDoctorAndDateConsultation(Doctor doctor, LocalDateTime dateConsultation);
}
