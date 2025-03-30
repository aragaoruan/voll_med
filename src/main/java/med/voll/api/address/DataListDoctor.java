package med.voll.api.address;

import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.Specialty;

public record DataListDoctor(
    String name,
    String email,
    String crm,
    Specialty specialty
) {

    public DataListDoctor(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
