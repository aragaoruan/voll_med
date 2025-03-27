package med.voll.api.doctor;

import med.voll.api.address.DataAddress;

public record DataDoctor(String name, String email, String crm, Specialty specialty, DataAddress address ) {

}
