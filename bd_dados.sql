


-- BARBEARIAS
INSERT INTO barbershops (barbershops_name) 
		VALUES ('Barbearia do Bigode');
INSERT INTO barbershops (barbershops_name) 
		VALUES ('Barbearia do Careca');



-- ENDEREÇOS
INSERT INTO address (cep, road, neighborhood, address_number, complement, city, address_state, barbershop_id)
		VALUES ('88131180', 'Cajú', 'Flores', 11, 'sala 01', 'Palhoça', 'SC', 1);
INSERT INTO address (cep, road, neighborhood, address_number, complement, city, address_state, barbershop_id)
		VALUES ('88134110', 'Rei Carlo', 'Flamengo', 456, 'sala 06', 'Palhoça', 'SC', 2);



-- ACOMODAÇÕES
INSERT INTO accommodations (wifi, parking, bath, air_conditioner, barbershop_id)
		VALUES (TRUE, TRUE, TRUE, FALSE, 1);
INSERT INTO accommodations (wifi, parking, bath, air_conditioner, barbershop_id)
		VALUES (TRUE, TRUE, TRUE, TRUE, 2); 



-- HORÁRIOS DE FUNCIONAMENTO DA BARBEARIA
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('SEGUNDA', '08:00', '11:00', '13:00', '18:30', 1);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('TERÇA', '08:00', '11:00', '13:00', '18:30', 1);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('QUARTA', '08:00', '11:00', '13:00', '18:30', 1);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('QUINTA', '08:00', '11:00', '13:00', '18:30', 1);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('SEXTA', '08:00', '11:00', '13:00', '18:30', 1);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('SÁBADO', '08:00', '11:00', '13:00', '18:30', 1);

INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('SEGUNDA', '07:00', '11:00', '13:00', '18:30', 2);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('TERÇA', '07:00', '11:00', '13:00', '18:30', 2);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('QUARTA', '07:00', '11:00', '13:00', '18:30', 2);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('QUINTA', '07:00', '11:00', '13:00', '18:30', 2);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('SEXTA', '07:00', '11:00', '13:00', '21:30', 2);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('SÁBADO', '07:00', '11:00', '11:30', '2:30', 2);

-- BARBEIROS
INSERT INTO barbers (barber_name, url_social, is_hair, is_beard, barbershop_id) VALUES ('João Gomes', '@joaotesoura', TRUE, TRUE, 1);
INSERT INTO barbers (barber_name, url_social, is_hair, is_beard, barbershop_id) VALUES ('Mario BK', '@BK_Silva', TRUE, TRUE, 1);
INSERT INTO barbers (barber_name, url_social, is_hair, is_beard, barbershop_id) VALUES ('Cleber', '@Clebertesoura', TRUE, FALSE, 1);
INSERT INTO barbers (barber_name, url_social, is_hair, is_beard, barbershop_id) VALUES ('Brito', '@BritoCortes', TRUE, FALSE, 2);
INSERT INTO barbers (barber_name, url_social, is_hair, is_beard, barbershop_id) VALUES ('Rafa', '@CortesRafa', FALSE, TRUE, 2);



-- ########
-- SERVICOS
-- ########
INSERT INTO services (service_description, duration, service_value, category, barbershop_id) 
		VALUES ('Barba Lenhador', 20, 30.00, 'BARBA', 1);
INSERT INTO services (service_description, duration, service_value, category, barbershop_id) 
		VALUES ('Barba Cerrada', 25, 30.00, 'BARBA', 1);
INSERT INTO services (service_description, duration, service_value, category, barbershop_id) 
		VALUES ('Barba Cheia', 20, 25.00, 'BARBA', 1);

INSERT INTO services (service_description, duration, service_value, category, barbershop_id) 
		VALUES ('Degradê', 50, 50.00, 'CABELO', 1);
INSERT INTO services (service_description, duration, service_value, category, barbershop_id) 
		VALUES ('Corte Americano', 50, 45.00, 'CABELO', 1);
INSERT INTO services (service_description, duration, service_value, category, barbershop_id) 
		VALUES ('Corte Militar', 30, 35.00, 'CABELO', 1);
INSERT INTO services (service_description, duration, service_value, category, barbershop_id) 
		VALUES ('Corte Social', 40, 39.99, 'CABELO', 1);
INSERT INTO services (service_description, duration, service_value, category, barbershop_id) 
		VALUES ('Moicano', 50, 33.00, 'CABELO', 1);

INSERT INTO services (service_description, duration, service_value, category, barbershop_id) 
		VALUES ('Corte Social + Barba Cerrada', 65, 60, 'COMBO', 2);
INSERT INTO services (service_description, duration, service_value, category, barbershop_id) 
		VALUES ('Degradê + Barba Cheia', 60, 68.00, 'COMBO', 2);



-- ###########
-- AGENDAMENTO
-- ###########
INSERT INTO appointments (client_name, appointment_time, barbershop_id)
		VALUES ('Yuri Vinicius', '2025-09-17 14:00:00', 1);

INSERT INTO appointments (client_name, appointment_time, barbershop_id)
		VALUES ('Welligton Bob', '2025-09-17 15:00:00', 1);

INSERT INTO appointments (client_name, appointment_time, barbershop_id)
		VALUES ('Aleson Aberto', '2025-09-17 16:00:00', 2);

INSERT INTO appointments (client_name, appointment_time, barbershop_id)
		VALUES ('Gideão', '2025-09-18 14:00:00', 2);



-- ##########################
-- SERVICOS DE UM AGENDAMENTO
-- ##########################
INSERT INTO service_appointments (barber_id, service_id, appointment_id, service_time)
		VALUES (1, 1, 1, '14:30');

INSERT INTO service_appointments (barber_id, service_id, appointment_id, service_time)
		VALUES (1, 2, 1, '15:00');

INSERT INTO service_appointments (barber_id, service_id, appointment_id, service_time)
		VALUES (2, 5, 3, '15:30');

INSERT INTO service_appointments (barber_id, service_id, appointment_id, service_time)
		VALUES (1, 4, 4, '16:00');

INSERT INTO service_appointments (barber_id, service_id, appointment_id, service_time)
		VALUES (3, 6, 2, '16:30');

INSERT INTO service_appointments (barber_id, service_id, appointment_id, service_time)
		VALUES (2, 1, 3, '17:00');

INSERT INTO service_appointments (barber_id, service_id, appointment_id, service_time)
		VALUES (2, 4, 3, '17:30');

INSERT INTO service_appointments (barber_id, service_id, appointment_id, service_time)
		VALUES (3, 2, 4, '18:00');



-- ###################
-- AGENDA DE BARBEIROS
-- ###################
INSERT INTO agenda (service_appointments_id, barber_id)
		VALUES (1, 1);

INSERT INTO agenda (service_appointments_id, barber_id)
		VALUES (2, 1);

INSERT INTO agenda (service_appointments_id, barber_id)
		VALUES (3, 2);

INSERT INTO agenda (service_appointments_id, barber_id)
		VALUES (4, 1);

INSERT INTO agenda (service_appointments_id, barber_id)
		VALUES (5, 3);



-- ##########
-- PAGAMENTOS
-- ##########
INSERT INTO payments (appointment_id, payment_value, payment_method, payment_status)
		VALUES (1, 4, 'PIX', FALSE);

INSERT INTO payments (appointment_id, payment_value, payment_method, payment_status)
		VALUES (2, 3, 'PIX', FALSE);

INSERT INTO payments (appointment_id, payment_value, payment_method, payment_status)
		VALUES (3, 4, 'PIX', FALSE);

INSERT INTO payments (appointment_id, payment_value, payment_method, payment_status)
		VALUES (4, 1, 'PIX', FALSE);










		
