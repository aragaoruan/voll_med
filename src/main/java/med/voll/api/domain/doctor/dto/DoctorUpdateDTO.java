package med.voll.api.domain.doctor.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.dto.CreateAddressDTO;

public record DoctorUpdateDTO(

    @NotNull
    Long id,

    String name,
    String phone,
    CreateAddressDTO address

) {
}
