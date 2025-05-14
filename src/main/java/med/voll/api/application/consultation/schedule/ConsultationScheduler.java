package med.voll.api.application.consultation.schedule;

import med.voll.api.domain.client.Client;
import med.voll.api.domain.client.ClientRepository;
import med.voll.api.domain.consultation.Consultation;
import med.voll.api.domain.consultation.ConsultationCreateDTO;
import med.voll.api.domain.consultation.ConsultationRepository;
import med.voll.api.domain.consultation.exception.ConsultationValidationException;
import med.voll.api.domain.doctor.Doctor;
import med.voll.api.domain.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultationScheduler {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ClientRepository clientRepository;

    public void toSchedule(ConsultationCreateDTO data) {

        if (clientRepository.existsById(data.doctorId())) {
            throw new ConsultationValidationException("Client not found");
        }


        if (data.doctorId() != null && doctorRepository.existsById(data.clientId())) {
            throw new ConsultationValidationException("Doctor not found");
        }

        Client client = clientRepository.getReferenceById(data.clientId());
        Doctor doctor = this.chooseDoctor(data);

        Consultation consultation = new Consultation(
            null,
            doctor,
            client,
            data.dateConsultation()
        );

        consultationRepository.save(consultation);
    }

    private Doctor chooseDoctor(ConsultationCreateDTO data) {
        if (data.doctorId() != null) {
            return doctorRepository.getReferenceById(data.doctorId());
        }
        if (data.specialty() == null) {
            throw new ConsultationValidationException("Obligatory specialty when doctor is not chosen");
        }

        return doctorRepository.chooseDoctor(data.specialty(), data.dateConsultation());
    }
}
