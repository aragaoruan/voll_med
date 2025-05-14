package med.voll.api.domain.consultation;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.doctor.Specialty;

import java.time.LocalDateTime;

public record ConsultationCreateDTO(

    Long doctorId,

    @NotNull
    Long clientId,

    Specialty specialty,

    @NotNull
    @Future
    LocalDateTime dateConsultation

) {
}
