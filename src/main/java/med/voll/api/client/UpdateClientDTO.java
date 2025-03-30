package med.voll.api.client;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.CreateAddressDTO;

public record UpdateClientDTO(

    @NotNull
    Long id,

    String name,
    String phone,
    CreateAddressDTO address
) {
}
