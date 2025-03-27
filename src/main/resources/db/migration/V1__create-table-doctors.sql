CREATE TABLE doctors (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    crm VARCHAR(255) NOT NULL,
    specialty VARCHAR(255) NOT NULL,

    street VARCHAR(255) NOT NULL,
    neighborhood VARCHAR(255) NOT NULL,
    zip_code VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    uf VARCHAR(255) NOT NULL,
    complement VARCHAR(255),
    number VARCHAR(255),

    PRIMARY KEY (id)
);
