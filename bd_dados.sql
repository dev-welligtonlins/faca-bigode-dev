


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
		VALUES ('MONDAY', '08:00', '11:00', '13:00', '18:30', 1);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('TUESDAY', '08:00', '11:00', '13:00', '18:30', 1);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('WEDNESDAY', '08:00', '11:00', '13:00', '18:30', 1);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('THURSDAY', '08:00', '11:00', '13:00', '18:30', 1);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('FRIDAY', '08:00', '11:00', '13:00', '18:30', 1);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('SUNDAY', '08:00', '11:00', '13:00', '18:30', 1);

    

INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('MONDAY', '07:00', '11:00', '13:00', '18:30', 2);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('TUESDAY', '07:00', '11:00', '13:00', '18:30', 2);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('WEDNESDAY', '07:00', '11:00', '13:00', '18:30', 2);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('THURSDAY', '07:00', '11:00', '13:00', '18:30', 2);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('FRIDAY', '07:00', '11:00', '13:00', '21:30', 2);
INSERT INTO barbershop_schedules (day_week, opening_time, lunch_start_time, lunch_end_time, closing_time, barbershop_id)
		VALUES ('SUNDAY', '07:00', '11:00', '11:30', '2:30', 2);

-- BARBEIROS
INSERT INTO barbers (barber_name, url_social, is_hair, is_beard, barber_active, barbershop_id) VALUES ('João Gomes', '@joaotesoura', TRUE, TRUE, TRUE, 1);
INSERT INTO barbers (barber_name, url_social, is_hair, is_beard, barber_active, barbershop_id) VALUES ('Mario BK', '@BK_Silva', TRUE, TRUE, TRUE, 1);
INSERT INTO barbers (barber_name, url_social, is_hair, is_beard, barber_active, barbershop_id) VALUES ('Cleber', '@Clebertesoura', TRUE, FALSE, TRUE, 1);
INSERT INTO barbers (barber_name, url_social, is_hair, is_beard, barber_active, barbershop_id) VALUES ('Brito', '@BritoCortes', TRUE, FALSE, TRUE, 2);
INSERT INTO barbers (barber_name, url_social, is_hair, is_beard, barber_active, barbershop_id) VALUES ('Rafa', '@CortesRafa', FALSE, TRUE, TRUE, 2);



-- ########
-- SERVICOS
-- ########
INSERT INTO services (service_description, duration, service_value, category, service_active, barbershop_id) 
		VALUES ('Barba Lenhador', 20, 30.00, 'BARBA', TRUE, 1);
INSERT INTO services (service_description, duration, service_value, category, service_active, barbershop_id) 
		VALUES ('Barba Cerrada', 25, 30.00, 'BARBA', TRUE, 1);
INSERT INTO services (service_description, duration, service_value, category, service_active, barbershop_id) 
		VALUES ('Barba Cheia', 20, 25.00, 'BARBA', TRUE, 1);

INSERT INTO services (service_description, duration, service_value, category, service_active, barbershop_id) 
		VALUES ('Degradê', 50, 50.00, 'CABELO', TRUE, 1);
INSERT INTO services (service_description, duration, service_value, category, service_active, barbershop_id) 
		VALUES ('Corte Americano', 50, 45.00, 'CABELO', TRUE, 1);
INSERT INTO services (service_description, duration, service_value, category, service_active, barbershop_id) 
		VALUES ('Corte Militar', 30, 35.00, 'CABELO', TRUE, 1);
INSERT INTO services (service_description, duration, service_value, category, service_active, barbershop_id) 
		VALUES ('Corte Social', 40, 39.99, 'CABELO', TRUE, 1);
INSERT INTO services (service_description, duration, service_value, category, service_active, barbershop_id) 
		VALUES ('Moicano', 50, 33.00, 'CABELO', TRUE, 1);

INSERT INTO services (service_description, duration, service_value, category, service_active, barbershop_id) 
		VALUES ('Corte Social + Barba Cerrada', 65, 60, 'COMBO', TRUE, 2);
INSERT INTO services (service_description, duration, service_value, category, service_active, barbershop_id) 
		VALUES ('Degradê + Barba Cheia', 60, 68.00, 'COMBO', TRUE, 2);



-- ###########
-- AGENDAMENTO
-- ###########
INSERT INTO appointments (client_name, appointment_time, appointment_status, value_total, barbershop_id)
		VALUES ('Yuri Vinicius', '2025-10-25 14:00:00', 'FINALIZADO', 0.1, 1);

INSERT INTO appointments (client_name, appointment_time, appointment_status, value_total, barbershop_id)
		VALUES ('Welligton Bob', '2025-10-25 15:00:00', 'CANCELADO', 0.1, 1);

INSERT INTO appointments (client_name, appointment_time, appointment_status, value_total, barbershop_id)
		VALUES ('Welligton Bob', '2025-10-26 09:00:00', 'FINALIZADO', 0.1, 1);

INSERT INTO appointments (client_name, appointment_time, appointment_status, value_total, barbershop_id)
		VALUES ('Welligton Bob', '2025-10-26 13:00:00', 'AGENDADO', 0.1, 1);


INSERT INTO appointments (client_name, appointment_time, appointment_status, value_total, barbershop_id)
		VALUES ('Aleson Aberto', '2025-10-26 16:00:00', 'AGENDADO', 0.1, 2);

INSERT INTO appointments (client_name, appointment_time, appointment_status, value_total, barbershop_id)
		VALUES ('Gideão', '2025-09-18 14:00:00', 'AGENDADO', 0.1, 2);



-- ##########################
-- SERVICOS DE UM AGENDAMENTO
-- ##########################

INSERT INTO service_appointments (barber_id, service_id, appointment_id, service_time)
		VALUES (1, 1, 1, '14:00');
INSERT INTO service_appointments (barber_id, service_id, appointment_id, service_time)
		VALUES (1, 4, 1, '14:30');
INSERT INTO service_appointments (barber_id, service_id, appointment_id, service_time)
		VALUES (2, 2, 2, '15:00');
INSERT INTO service_appointments (barber_id, service_id, appointment_id, service_time)
		VALUES (2, 6, 2, '15:30');
INSERT INTO service_appointments (barber_id, service_id, appointment_id, service_time)
		VALUES (2, 4, 3, '09:00');
INSERT INTO service_appointments (barber_id, service_id, appointment_id, service_time)
		VALUES (2, 7, 3, '09:30');
INSERT INTO service_appointments (barber_id, service_id, appointment_id, service_time)
		VALUES (1, 5, 4, '13:00');



INSERT INTO service_appointments (barber_id, service_id, appointment_id, service_time)
		VALUES (4, 9, 5, '16:00');

INSERT INTO service_appointments (barber_id, service_id, appointment_id, service_time)
		VALUES (5, 10, 6, '14:00');



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


INSERT INTO payments (appointment_id, payment_value, payment_method, payment_status)
		VALUES (5, 1, 'PIX', FALSE);

INSERT INTO payments (appointment_id, payment_value, payment_method, payment_status)
		VALUES (6, 1, 'PIX', FALSE);









		
