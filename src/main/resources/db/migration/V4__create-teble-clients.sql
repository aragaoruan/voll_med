CREATE TABLE clients (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    document VARCHAR(12) NOT NULL,

    street VARCHAR(255) NOT NULL,
    neighborhood VARCHAR(255) NOT NULL,
    zip_code VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    uf VARCHAR(255) NOT NULL,
    complement VARCHAR(255),
    number VARCHAR(255),
    is_active boolean default true,

    PRIMARY KEY (id)
);
