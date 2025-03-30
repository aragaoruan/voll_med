package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.doctor.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {


    private DoctorRepository repository;

    @PostMapping()
    @Transactional
    public void createDoctor(@RequestBody @Valid CreateDoctorDTO data) {
        repository.save(new Doctor(data));
    }

    @GetMapping()
    public Page<ListDoctorDTO> listDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return repository.findAllByIsActiveTrue(pageable).map(ListDoctorDTO::new);
    }

    @PutMapping
    @Transactional
    public void updateDoctor(@RequestBody UpdateDoctorDTO data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.update(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteDoctor(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.delete();
    }

}
