package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.application.consultation.schedule.ConsultationScheduler;
import med.voll.api.domain.consultation.ConsultationCreateDTO;
import med.voll.api.domain.consultation.ConsultationScheduleDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationScheduler scheduleAppointment;

    @PostMapping
    @Transactional
    public ResponseEntity scheduleConsultation(@RequestBody @Valid ConsultationCreateDTO data) {

        this.scheduleAppointment.toSchedule(data);

        return ResponseEntity.ok(new ConsultationScheduleDetailsDTO(null, null, null, null));

    }
}
