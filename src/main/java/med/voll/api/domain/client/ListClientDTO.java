package med.voll.api.domain.client;

public record ListClientDTO(

    String name,
    String email,
    String document

) {
    public ListClientDTO(Client client) {
        this(client.getName(), client.getEmail(), client.getDocument());
    }
}
