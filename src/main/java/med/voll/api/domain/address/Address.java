package med.voll.api.domain.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.dto.CreateAddressDTO;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String uf;
    private String complement;
    private String number;

    public Address(CreateAddressDTO address) {
        this.street = address.street();
        this.neighborhood = address.neighborhood();
        this.zipCode = address.zipCode();
        this.city = address.city();
        this.uf = address.uf();
        this.complement = address.complement();
        this.number = address.number();
    }

    public void update(CreateAddressDTO address) {
        if (address == null) return;

        this.street = address.street() != null ? address.street() : this.street;
        this.neighborhood = address.neighborhood() != null ? address.neighborhood() : this.neighborhood;
        this.zipCode = address.zipCode() != null ? address.zipCode() : this.zipCode;
        this.city = address.city() != null ? address.city() : this.city;
        this.uf = address.uf() != null ? address.uf() : this.uf;
        this.complement = address.complement() != null ? address.complement() : this.complement;
        this.number = address.number() != null ? address.number() : this.number;
    }
}
