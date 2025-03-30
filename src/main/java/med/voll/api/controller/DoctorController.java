package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.address.DataListDoctor;
import med.voll.api.doctor.CreateDoctorDTO;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorRepository;
import med.voll.api.doctor.UpdateDoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping()
    @Transactional
    public void createDoctor(@RequestBody @Valid CreateDoctorDTO data) {
        repository.save(new Doctor(data));
    }

    @GetMapping()
    public Page<DataListDoctor> listDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return repository.findAllByIsActiveTrue(pageable).map(DataListDoctor::new);
    }

    @PutMapping
    @Transactional
    public void updateDoctor(@RequestBody UpdateDoctorDTO data) {
        var doctor = repository.getReferenceById(data.id());
        System.out.println(doctor);
        doctor.update(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteDoctor(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.delete();
    }

}
