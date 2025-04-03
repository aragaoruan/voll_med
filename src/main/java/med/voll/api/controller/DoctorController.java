package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping()
    @Transactional
    public ResponseEntity createDoctor(@RequestBody @Valid CreateDoctorDTO data, UriComponentsBuilder uriBuilder) {

        Doctor doctor = new Doctor(data);

        repository.save(doctor);

        var uri = uriBuilder.path("/doctor/{id}").buildAndExpand(doctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailDoctorDTO(doctor));

    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailDoctorDTO> getDoctor(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetailDoctorDTO(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<ListDoctorDTO>> listDoctors(
        @PageableDefault(size = 10, sort = "name") Pageable pageable) {
        Page<ListDoctorDTO> page = repository.findAllByIsActiveTrue(pageable).map(ListDoctorDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateDoctor(@RequestBody UpdateDoctorDTO data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.update(data);

        return ResponseEntity.ok(new DetailDoctorDTO(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<ResponseEntity> deleteDoctor(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.delete();

        return ResponseEntity.noContent().build();
    }

}
