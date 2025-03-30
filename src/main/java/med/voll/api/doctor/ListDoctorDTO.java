package med.voll.api.doctor;

public record ListDoctorDTO(
    String name,
    String email,
    String crm,
    Specialty specialty
) {

    public ListDoctorDTO(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
