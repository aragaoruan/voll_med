package med.voll.api.domain.client.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.dto.CreateAddressDTO;

public record ClientUpdateDTO(

    @NotNull
    Long id,

    String name,
    String phone,
    CreateAddressDTO address
) {
}
