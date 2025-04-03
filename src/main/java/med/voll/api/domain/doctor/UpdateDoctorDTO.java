package med.voll.api.domain.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.CreateAddressDTO;

public record UpdateDoctorDTO(

    @NotNull
    Long id,

    String name,
    String phone,
    CreateAddressDTO address

) {
}
