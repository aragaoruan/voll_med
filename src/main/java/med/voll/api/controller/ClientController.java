package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.client.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientRepository repository;

    @PostMapping
    @Transactional
    public void createClient(@RequestBody @Valid CreateClientDTO data) {
        repository.save(new Client(data));
    }

    @GetMapping
    public Page<ListClientDTO> listClients(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return repository.findAllByIsActiveTrue(pageable).map(ListClientDTO::new);
    }

    @PutMapping
    @Transactional
    public void updateClient(@RequestBody UpdateClientDTO data) {
        var client = repository.getReferenceById(data.id());
        client.update(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteClient(@PathVariable Long id) {
        var client = repository.getReferenceById(id);
        client.delete();
    }
}
