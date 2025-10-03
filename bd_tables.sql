
-- Database: knife-and-mustache

-- DROP DATABASE IF EXISTS "knife-and-mustache";

-- BARBEARIAS
CREATE TABLE IF NOT EXISTS barbershops (
	id SERIAL PRIMARY KEY,
	barbershops_name VARCHAR(80) NOT NULL,
	barbershops_opening_hours TIME NOT NULL,
	barbershops_closing_hours TIME NOT NULL
);

-- ENDEREÇOS 
CREATE TABLE IF NOT EXISTS address (
	id SERIAL PRIMARY KEY,
	address_cep VARCHAR(9) NOT NULL,
	address_road VARCHAR(80) NOT NULL,
	address_neighborhood VARCHAR(50) NOT NULL,
	address_number INT NOT NULL,
	address_complement VARCHAR(50),
	address_city VARCHAR(40),
	address_state VARCHAR(2),
	address_barbershop_id INT NOT NULL,

	CONSTRAINT fk_address
		FOREIGN KEY (address_barbershop_id)
		REFERENCES barbershops(id)
		ON DELETE CASCADE
);

-- ACOMODAÇÕES DA BARBEARIA
CREATE TABLE IF NOT EXISTS accommodations (
	id SERIAL PRIMARY KEY,
	accommodations_wifi BOOLEAN NOT NULL,
	accommodations_parking BOOLEAN NOT NULL,
	accommodations_bath BOOLEAN NOT NULL,
	accommodations_air_conditioner BOOLEAN NOT NULL,
	accomodations_barbershop_id INT NOT NULL,

	CONSTRAINT fk_barbershop
		FOREIGN KEY (accomodations_barbershop_id)
		REFERENCES barbershops(id)
		ON DELETE CASCADE
);


-- BARBEIROS
CREATE TABLE IF NOT EXISTS barbers (
	id SERIAL PRIMARY KEY,
	barber_name VARCHAR(45) NOT NULL,
	barber_url_social VARCHAR(120),
	barber_is_hair BOOLEAN NOT NULL,
	barber_is_beard BOOLEAN NOT NULL,
	barber_barbershop_id INT NOT NULL,
	
	CONSTRAINT fk_barbershop
		FOREIGN KEY (barber_barbershop_id)
		REFERENCES barbershops(id)
		ON DELETE CASCADE
);

-- CATEGORIAS DE SERVIÇOS
CREATE TABLE IF NOT EXISTS service_categories (
	id SERIAL PRIMARY KEY,
	service_categories_description VARCHAR(45) NOT NULL
);

-- SERVIÇOS
CREATE TABLE IF NOT EXISTS services (
	id SERIAL PRIMARY KEY,
	service_description VARCHAR(45) NOT NULL,
	service_duration INT NOT NULL,
	service_value FLOAT NOT NULL,
	service_category_id INT NOT NULL,
	service_barbershop_id INT NOT NULL,
	
	CONSTRAINT fk_barbershop
		FOREIGN KEY (service_barbershop_id)
		REFERENCES barbershops(id)
		ON DELETE CASCADE,
		
	CONSTRAINT fk_categories
		FOREIGN KEY (service_category_id)
		REFERENCES service_categories(id)
		ON DELETE CASCADE
);

-- AGENDAMENTO DO CLIENTE E HORÁRIO
CREATE TABLE IF NOT EXISTS appointments (
	id SERIAL PRIMARY KEY,
	appointment_client_name VARCHAR(100) NOT NULL,
	appointment_time TIMESTAMP NOT NULL,
	appointment_barbershop_id INT NOT NULL,

	CONSTRAINT fk_barbershop
		FOREIGN KEY (appointment_barbershop_id)
		REFERENCES barbershops(id)
		ON DELETE CASCADE
);

-- ITENS DE UM AGENDAMENTO
CREATE TABLE IF NOT EXISTS service_appointments (
	id SERIAL PRIMARY KEY,
	service_appointments_barber_id INT NOT NULL,
	service_appointments_service_id INT NOT NULL,
	service_appointments_appointment_id INT NOT NULL,
	
	CONSTRAINT fk_barber 
		FOREIGN KEY (service_appointments_barber_id)
		REFERENCES barbers(id)
		ON DELETE CASCADE,
		
	CONSTRAINT fk_appointment 
		FOREIGN KEY (service_appointments_appointment_id)
		REFERENCES appointments(id)
		ON DELETE CASCADE,

	CONSTRAINT fk_service 
		FOREIGN KEY (service_appointments_service_id)
		REFERENCES services(id)
		ON DELETE CASCADE
);

-- ##################
-- AGENDA DO BARBEIRO
-- ##################

CREATE TABLE IF NOT EXISTS agenda (
	id SERIAL PRIMARY KEY,
	agenda_service_appointments_id INT,
	agenda_barber_id INT NOT NULL,

	CONSTRAINT fk_service_appointment
		FOREIGN KEY (agenda_service_appointments_id)
		REFERENCES service_appointments(id)
		ON DELETE CASCADE,

	CONSTRAINT fk_barber
		FOREIGN KEY (agenda_barber_id)
		REFERENCES barbers(id)
		ON DELETE CASCADE
);

-- MÉTODOS DE PAGAMENTO
CREATE TABLE IF NOT EXISTS payment_methods (
	id SERIAL PRIMARY KEY,
	payment_methods_description VARCHAR(25) NOT NULL
);

-- PAGAMENTOS
CREATE TABLE IF NOT EXISTS payments (
	payments_appointments_id INT NOT NULL,
	payments_method_id INT NOT NULL,
	payments_status BOOLEAN NOT NULL,

	CONSTRAINT fk_appointment
		FOREIGN KEY (payments_appointments_id)
		REFERENCES appointments(id),

	CONSTRAINT fk_payment_methods
		FOREIGN KEY (payments_method_id)
		REFERENCES payment_methods(id)
);










