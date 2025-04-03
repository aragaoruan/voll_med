package med.voll.api.domain.client;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.address.CreateAddressDTO;

public record UpdateClientDTO(

    @NotNull
    Long id,

    String name,
    String phone,
    CreateAddressDTO address
) {
}
