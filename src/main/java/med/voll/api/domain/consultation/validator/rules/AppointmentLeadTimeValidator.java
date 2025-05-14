package med.voll.api.domain.consultation.validator.rules;

import med.voll.api.domain.consultation.ConsultationCreateDTO;
import med.voll.api.domain.consultation.exception.ConsultationValidationException;
import med.voll.api.domain.consultation.validator.AppointmentValidator;

import java.time.LocalDateTime;

public class AppointmentLeadTimeValidator implements AppointmentValidator {
    public void validate(ConsultationCreateDTO data) {

        LocalDateTime date = data.dateConsultation();

        LocalDateTime now = LocalDateTime.now();
        Long differenceInMinutes = java.time.Duration.between(now, date).toMinutes();

        if (differenceInMinutes < 30) {
            throw new ConsultationValidationException("The appointment must be scheduled at least 30 minutes in advance.");
        }
    }
}
