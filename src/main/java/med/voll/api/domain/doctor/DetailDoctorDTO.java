package med.voll.api.domain.doctor;

import med.voll.api.domain.address.Address;

public record DetailDoctorDTO(
    Long id,
    String name,
    String email,
    String crm,
    String phone,
    Address address,
    Specialty specialty
) {
    public DetailDoctorDTO(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getPhone(), doctor.getAddress(), doctor.getSpecialty());
    }
}
