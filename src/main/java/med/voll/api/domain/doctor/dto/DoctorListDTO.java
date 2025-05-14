package med.voll.api.domain.doctor.dto;

import med.voll.api.domain.doctor.Doctor;
import med.voll.api.domain.doctor.Specialty;

public record DoctorListDTO(
    String name,
    String email,
    String crm,
    Specialty specialty
) {

    public DoctorListDTO(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
