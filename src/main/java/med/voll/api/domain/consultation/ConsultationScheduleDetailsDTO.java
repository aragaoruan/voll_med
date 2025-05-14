package med.voll.api.domain.consultation;

import java.time.LocalDateTime;

public record ConsultationScheduleDetailsDTO(
    Long id,
    Long doctorId,
    Long clientId,
    LocalDateTime dateConsultation
) {
}
