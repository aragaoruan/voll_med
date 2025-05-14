package med.voll.api.domain.consultation.validator.rules;

import med.voll.api.domain.consultation.ConsultationCreateDTO;
import med.voll.api.domain.consultation.validator.AppointmentValidator;
import med.voll.api.domain.doctor.DoctorRepository;

public class DoctorActiveValidator implements AppointmentValidator {

    private DoctorRepository doctorRepository;

    public void validate(ConsultationCreateDTO data) {

        Long doctorId = data.doctorId();

        if (doctorId == null) {
            return;
        }

        boolean doctorIsActive = this.doctorRepository.findIsActiveById(doctorId);

        if (!doctorIsActive) {
            throw new IllegalArgumentException("Doctor is not active");
        }
    }
}
