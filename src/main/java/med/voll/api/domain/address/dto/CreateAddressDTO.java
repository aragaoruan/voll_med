package med.voll.api.domain.address.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateAddressDTO(
    @NotBlank(message = "Street is required")
    String street,

    @NotBlank(message = "Neighborhood is required")
    String neighborhood,

    @NotBlank(message = "Zip code is required")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Zip code must be in the format 00000-000")
    String zipCode,

    @NotBlank(message = "City is required")
    String city,

    @NotBlank(message = "State is required")
    String uf,

    String complement,
    String number) {
}
