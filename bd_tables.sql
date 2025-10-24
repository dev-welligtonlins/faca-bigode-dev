
-- Database: knifeandmustache

-- DROP DATABASE IF EXISTS "knifeandmustache";

-- BARBEARIAS
CREATE TABLE IF NOT EXISTS barbershops (
	id SERIAL PRIMARY KEY,
	barbershops_name VARCHAR(80) NOT NULL
);

-- HORÁRIOS (ABERTURA INTERVALO E FECHAMENTO)
CREATE TABLE IF NOT EXISTS barbershop_schedules (
	id SERIAL PRIMARY KEY,
	day_week VARCHAR(15) NOT NULL,
	opening_time TIME NOT NULL,
	lunch_start_time TIME,
	lunch_end_time TIME,
	closing_time TIME NOT NULL,
	barbershop_id INT NOT NULL,

	CONSTRAINT fk_barbershop
		FOREIGN KEY (barbershop_id)
		REFERENCES barbershops(id)
		ON DELETE CASCADE
);


-- ENDEREÇOS 
CREATE TABLE IF NOT EXISTS address (
	id SERIAL PRIMARY KEY,
	cep VARCHAR(9) NOT NULL,
	road VARCHAR(80) NOT NULL,
	neighborhood VARCHAR(50) NOT NULL,
	address_number INT NOT NULL,
	complement VARCHAR(50),
	city VARCHAR(40),
	address_state VARCHAR(2),
	barbershop_id INT NOT NULL,

	CONSTRAINT fk_barbershop
		FOREIGN KEY (barbershop_id)
		REFERENCES barbershops(id)
		ON DELETE CASCADE
);

-- ACOMODAÇÕES DA BARBEARIA
CREATE TABLE IF NOT EXISTS accommodations (
	id SERIAL PRIMARY KEY,
	wifi BOOLEAN NOT NULL,
	parking BOOLEAN NOT NULL,
	bath BOOLEAN NOT NULL,
	air_conditioner BOOLEAN NOT NULL,
	barbershop_id INT NOT NULL,

	CONSTRAINT fk_barbershop
		FOREIGN KEY (barbershop_id)
		REFERENCES barbershops(id)
		ON DELETE CASCADE
);


-- BARBEIROS
CREATE TABLE IF NOT EXISTS barbers (
	id SERIAL PRIMARY KEY,
	barber_name VARCHAR(45) NOT NULL,
	url_social VARCHAR(120),
	is_hair BOOLEAN NOT NULL,
	is_beard BOOLEAN NOT NULL,
	barbershop_id INT NOT NULL,
	
	CONSTRAINT fk_barbershop
		FOREIGN KEY (barbershop_id)
		REFERENCES barbershops(id)
		ON DELETE CASCADE
);



-- SERVIÇOS
CREATE TABLE IF NOT EXISTS services (
	id SERIAL PRIMARY KEY,
	service_description VARCHAR(45) NOT NULL,
	duration INT NOT NULL,
	service_value FLOAT NOT NULL,
	category VARCHAR(45) NOT NULL,
	barbershop_id INT NOT NULL,
	
	CONSTRAINT fk_barbershop
		FOREIGN KEY (barbershop_id)
		REFERENCES barbershops(id)
		ON DELETE CASCADE
);

-- AGENDAMENTO DO CLIENTE E HORÁRIO
CREATE TABLE IF NOT EXISTS appointments (
	id SERIAL PRIMARY KEY,
	client_name VARCHAR(100) NOT NULL,
	appointment_time TIMESTAMP NOT NULL,
	barbershop_id INT NOT NULL,

	CONSTRAINT fk_barbershop
		FOREIGN KEY (barbershop_id)
		REFERENCES barbershops(id)
		ON DELETE CASCADE
);

-- ITENS DE UM AGENDAMENTO
CREATE TABLE IF NOT EXISTS service_appointments (
	id SERIAL PRIMARY KEY,
	service_time TIME NOT NULL,
	barber_id INT,
	service_id INT,
	appointment_id INT NOT NULL,
	
	CONSTRAINT fk_barber 
		FOREIGN KEY (barber_id)
		REFERENCES barbers(id)
		ON DELETE SET NULL,
		
	CONSTRAINT fk_service 
		FOREIGN KEY (service_id)
		REFERENCES services(id)
		ON DELETE SET NULL,

	CONSTRAINT fk_appointment 
		FOREIGN KEY (appointment_id)
		REFERENCES appointments(id)
		ON DELETE CASCADE

);

-- ##################
-- AGENDA DO BARBEIRO
-- ##################

CREATE TABLE IF NOT EXISTS agenda (
	id SERIAL PRIMARY KEY,
	service_appointments_id INT,
	barber_id INT NOT NULL,

	CONSTRAINT fk_service_appointment
		FOREIGN KEY (service_appointments_id)
		REFERENCES service_appointments(id)
		ON DELETE CASCADE,

	CONSTRAINT fk_barber
		FOREIGN KEY (barber_id)
		REFERENCES barbers(id)
		ON DELETE CASCADE
);

-- PAGAMENTOS
CREATE TABLE IF NOT EXISTS payments (
	appointment_id INT NOT NULL,
	payment_value FLOAT NOT NULL,
	payment_method VARCHAR(15) NOT NULL,
	payment_status BOOLEAN NOT NULL,

	CONSTRAINT fk_appointment
		FOREIGN KEY (appointment_id)
		REFERENCES appointments(id)
		ON DELETE CASCADE
);