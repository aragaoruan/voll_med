package med.voll.api.domain.client.dto;

import med.voll.api.domain.client.Client;

public record ClientListDTO(

    String name,
    String email,
    String document

) {
    public ClientListDTO(Client client) {
        this(client.getName(), client.getEmail(), client.getDocument());
    }
}
