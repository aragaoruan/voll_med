package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.domain.client.Client;
import med.voll.api.domain.client.ClientRepository;
import med.voll.api.domain.client.dto.ClientCreateDTO;
import med.voll.api.domain.client.dto.ClientDetailsDTO;
import med.voll.api.domain.client.dto.ClientListDTO;
import med.voll.api.domain.client.dto.ClientUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity createClient(@RequestBody @Valid ClientCreateDTO data, UriComponentsBuilder uriBuilder) {

        Client client = new Client(data);
        repository.save(client);

        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();

        return ResponseEntity.created(uri).body(new ClientDetailsDTO(client));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDetailsDTO> getClient(@PathVariable Long id) {
        Client client = repository.getReferenceById(id);
        return ResponseEntity.ok(new ClientDetailsDTO(client));
    }

    @GetMapping
    public ResponseEntity<Page<ClientListDTO>> listClients(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        Page<ClientListDTO> page = repository.findAllByIsActiveTrue(pageable).map(ClientListDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateClient(@RequestBody ClientUpdateDTO data) {
        Client client = repository.getReferenceById(data.id());
        client.update(data);

        return ResponseEntity.ok(new ClientDetailsDTO(client));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteClient(@PathVariable Long id) {
        Client client = repository.getReferenceById(id);
        client.delete();

        return ResponseEntity.noContent().build();
    }

}
