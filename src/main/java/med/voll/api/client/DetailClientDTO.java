package med.voll.api.client;

import med.voll.api.address.Address;

public record DetailClientDTO(
    Long id,
    String name,
    String email,
    String phone,
    String document,
    Address address
) {
    public DetailClientDTO(Client client) {
        this(client.getId(), client.getName(), client.getEmail(), client.getPhone(), client.getDocument(), client.getAddress());
    }
}
