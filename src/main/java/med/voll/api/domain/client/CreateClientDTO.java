package med.voll.api.domain.client;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.address.CreateAddressDTO;

public record CreateClientDTO(
    @NotBlank(message = "Name is required")
    String name,

    @NotBlank(message = "Name is required")
    @Email(message = "Email is required and must be valid")
    String email,

    @NotBlank(message = "Phone is required")
    String phone,

    @NotBlank(message = "Document is required")
    @Pattern(regexp = "\\d{11}", message = "Document must be 11 digits")
    String document,

    @NotNull(message = "Address is required")
    @Valid
    CreateAddressDTO address
) {
}
