package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

	public Address(DataAddress address) {
		this.street = address.street();
		this.neighborhood = address.neighborhood();
		this.zipCode = address.zipCode();
		this.city = address.city();
		this.uf = address.uf();
		this.complement = address.complement();
		this.number = address.number();
	}
}
