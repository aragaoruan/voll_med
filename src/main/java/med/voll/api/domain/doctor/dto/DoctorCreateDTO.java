package med.voll.api.domain.doctor.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.address.dto.CreateAddressDTO;
import med.voll.api.domain.doctor.Specialty;

public record DoctorCreateDTO(

    @NotBlank(message = "Name is required")
    String name,

    @NotBlank(message = "Email is required")
    @Email
    String email,

    @NotBlank(message = "Phone is required")
    String phone,

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "\\d{4,6}", message = "Crm must be between 4 and 6 digits")
    String crm,

    @NotNull(message = "CRM is required")
    Specialty specialty,

    @NotNull(message = "Address is required")
    @Valid
    CreateAddressDTO address
) {

}
