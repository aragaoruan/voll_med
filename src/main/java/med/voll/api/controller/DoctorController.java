package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.doctor.Doctor;
import med.voll.api.domain.doctor.DoctorRepository;
import med.voll.api.domain.doctor.dto.DoctorCreateDTO;
import med.voll.api.domain.doctor.dto.DoctorDetailsDTO;
import med.voll.api.domain.doctor.dto.DoctorListDTO;
import med.voll.api.domain.doctor.dto.DoctorUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping()
    @Transactional
    public ResponseEntity createDoctor(@RequestBody @Valid DoctorCreateDTO data, UriComponentsBuilder uriBuilder) {

        Doctor doctor = new Doctor(data);

        repository.save(doctor);

        URI uri = uriBuilder.path("/doctor/{id}").buildAndExpand(doctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DoctorDetailsDTO(doctor));

    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDetailsDTO> getDoctor(@PathVariable Long id) {
        Doctor doctor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DoctorDetailsDTO(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorListDTO>> listDoctors(
        @PageableDefault(size = 10, sort = "name") Pageable pageable) {
        Page<DoctorListDTO> page = repository.findAllByIsActiveTrue(pageable).map(DoctorListDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateDoctor(@RequestBody DoctorUpdateDTO data) {
        Doctor doctor = repository.getReferenceById(data.id());
        doctor.update(data);

        return ResponseEntity.ok(new DoctorDetailsDTO(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<ResponseEntity> deleteDoctor(@PathVariable Long id) {
        Doctor doctor = repository.getReferenceById(id);
        doctor.delete();

        return ResponseEntity.noContent().build();
    }

}
