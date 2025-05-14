package med.voll.api.domain.consultation.validator;

import med.voll.api.domain.consultation.ConsultationCreateDTO;

public interface AppointmentValidator {
    void validate(ConsultationCreateDTO data);
}
