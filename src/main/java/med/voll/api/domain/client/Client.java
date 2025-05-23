package med.voll.api.domain.client;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.Address;
import med.voll.api.domain.client.dto.ClientCreateDTO;
import med.voll.api.domain.client.dto.ClientUpdateDTO;

@Table(name = "clients")
@Entity(name = "Client")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String document;

    @Embedded
    private Address address;

    private Boolean isActive;


    public Client(@Valid ClientCreateDTO data) {
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.document = data.document();
        this.address = new Address(data.address());
        this.isActive = true;
    }

    public void update(ClientUpdateDTO data) {
        if (data.name() != null) this.name = data.name();
        if (data.phone() != null) this.phone = data.phone();
        if (data.address() != null) this.address.update(data.address());
    }

    /**
     * Marks the client as inactive.
     */
    public void delete() {
        isActive = Boolean.FALSE;
    }
}
