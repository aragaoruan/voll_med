package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.client.Client;
import med.voll.api.client.ClientRepository;
import med.voll.api.client.CreateClientDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
