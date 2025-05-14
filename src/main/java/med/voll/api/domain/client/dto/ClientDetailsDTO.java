package med.voll.api.domain.client.dto;

import med.voll.api.domain.address.Address;
import med.voll.api.domain.client.Client;

public record ClientDetailsDTO(
    Long id,
    String name,
    String email,
    String phone,
    String document,
    Address address
) {
    public ClientDetailsDTO(Client client) {
        this(client.getId(), client.getName(), client.getEmail(), client.getPhone(), client.getDocument(), client.getAddress());
    }
}
