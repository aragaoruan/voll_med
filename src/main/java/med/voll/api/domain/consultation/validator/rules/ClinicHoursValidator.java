package med.voll.api.domain.consultation.validator.rules;

import med.voll.api.domain.consultation.ConsultationCreateDTO;
import med.voll.api.domain.consultation.exception.ConsultationValidationException;
import med.voll.api.domain.consultation.validator.AppointmentValidator;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ClinicHoursValidator implements AppointmentValidator {
    public void validate(ConsultationCreateDTO data) {

        LocalDateTime date = data.dateConsultation();

        boolean isSunday = date.getDayOfWeek().equals(DayOfWeek.SUNDAY);

        boolean isFirstHourOpeningTime = date.getHour() < 7;
        boolean isAfterClosingTime = date.getHour() > 18;

        if (isSunday || isFirstHourOpeningTime || isAfterClosingTime) {
            throw new ConsultationValidationException("The clinic is closed on Sundays and only works from 7am to 6pm");
        }

    }
}
