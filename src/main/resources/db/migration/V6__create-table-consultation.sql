CREATE TABLE consultations (
    id BIGINT NOT NULL AUTO_INCREMENT,
    doctor_id BIGINT NOT NULL,
    client_id BIGINT NOT NULL,
    date_consultation datetime NOT NULL,


    PRIMARY KEY (id),
    CONSTRAINT fk_doctor_consultation FOREIGN KEY (doctor_id) REFERENCES doctors(id),
    CONSTRAINT fk_client_consultation FOREIGN KEY (client_id) REFERENCES clients(id)
);
