package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.address.DataListDoctor;
import med.voll.api.doctor.DataDoctor;
import med.voll.api.doctor.DataUpdateDoctor;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorRepository;
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
    public void createDoctor(@RequestBody @Valid DataDoctor data) {
        repository.save(new Doctor(data));
    }

    @GetMapping()
    public Page<DataListDoctor> listDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return repository.findAll(pageable).map(DataListDoctor::new);
    }

    @PutMapping
    @Transactional
    public void updateDoctor(@RequestBody DataUpdateDoctor data) {
        var doctor = repository.getReferenceById(data.id());
        System.out.println(doctor);
        doctor.update(data);

    }
}
