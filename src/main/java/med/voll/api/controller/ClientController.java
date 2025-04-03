package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.client.*;
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
    public ResponseEntity createClient(@RequestBody @Valid CreateClientDTO data, UriComponentsBuilder uriBuilder) {

        Client client = new Client(data);
        repository.save(client);

        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailClientDTO(client));

    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailClientDTO> getClient(@PathVariable Long id) {
        Client client = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetailClientDTO(client));
    }

    @GetMapping
    public ResponseEntity<Page<ListClientDTO>> listClients(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        Page<ListClientDTO> page = repository.findAllByIsActiveTrue(pageable).map(ListClientDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateClient(@RequestBody UpdateClientDTO data) {
        Client client = repository.getReferenceById(data.id());
        client.update(data);

        return ResponseEntity.ok(new DetailClientDTO(client));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteClient(@PathVariable Long id) {
        Client client = repository.getReferenceById(id);
        client.delete();

        return ResponseEntity.noContent().build();
    }

}
