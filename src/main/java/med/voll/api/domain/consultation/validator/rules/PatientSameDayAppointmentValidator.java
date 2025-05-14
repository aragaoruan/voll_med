package med.voll.api.domain.consultation.validator.rules;

import med.voll.api.domain.consultation.ConsultationCreateDTO;
import med.voll.api.domain.consultation.ConsultationRepository;
import med.voll.api.domain.consultation.validator.AppointmentValidator;

import java.time.LocalDateTime;

public class PatientSameDayAppointmentValidator implements AppointmentValidator {
    private ConsultationRepository consultationRepository;

    public void validate(ConsultationCreateDTO data) {

        LocalDateTime firstHour = data.dateConsultation().withHour(7).withMinute(0);
        LocalDateTime lastHour = data.dateConsultation().withHour(18).withMinute(0);

        boolean existsClient = this.consultationRepository.existsByClientIdAndDateBetween(
            data.clientId(),
            firstHour,
            lastHour
        );

        if (existsClient) {
            throw new IllegalArgumentException("Client already has an appointment on this day");
        }
    }
}
