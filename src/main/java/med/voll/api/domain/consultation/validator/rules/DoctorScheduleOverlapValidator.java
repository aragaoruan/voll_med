package med.voll.api.domain.consultation.validator.rules;

import med.voll.api.domain.consultation.ConsultationCreateDTO;
import med.voll.api.domain.consultation.ConsultationRepository;
import med.voll.api.domain.consultation.validator.AppointmentValidator;

public class DoctorScheduleOverlapValidator implements AppointmentValidator {

    private ConsultationRepository consultationRepository;

    public void validate(ConsultationCreateDTO data) {

    }
}
