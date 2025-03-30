package med.voll.api.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.CreateAddressDTO;

public record UpdateDoctorDTO(

    @NotNull
    Long id,

    String name,
    String phone,
    CreateAddressDTO address

) {
}
