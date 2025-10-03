


-- BARBEARIAS
INSERT INTO barbershops (barbershops_name, barbershops_opening_hours, barbershops_closing_hours) 
		VALUES ('Barbearia do Bigode', '08:00:00', '18:00:00');
INSERT INTO barbershops (barbershops_name, barbershops_opening_hours, barbershops_closing_hours) 
		VALUES ('Barbearia do Careca', '10:00:00', '20:00:00');



-- ENDEREÇOS
INSERT INTO address (address_cep, address_road, address_neighborhood, address_number, address_complement, address_city, address_state, address_barbershop_id)
		VALUES ('88131180', 'Cajú', 'Flores', 11, 'sala 01', 'Palhoça', 'SC', 1);
INSERT INTO address (address_cep, address_road, address_neighborhood, address_number, address_complement, address_city, address_state, address_barbershop_id)
		VALUES ('88134110', 'Rei Carlo', 'Flamengo', 456, 'sala 06', 'Palhoça', 'SC', 2);



-- ACOMODAÇÕES
INSERT INTO accommodations (accommodations_wifi, accommodations_parking, accommodations_bath, accommodations_air_conditioner, accomodations_barbershop_id)
		VALUES (TRUE, TRUE, TRUE, FALSE, 1);
INSERT INTO accommodations (accommodations_wifi, accommodations_parking, accommodations_bath, accommodations_air_conditioner, accomodations_barbershop_id)
		VALUES (TRUE, TRUE, TRUE, TRUE, 2); 



-- BARBEIROS
INSERT INTO barbers (barber_name, barber_url_social, barber_is_hair, barber_is_beard, barber_barbershop_id) 
		VALUES ('João Gomes', '@joaotesoura', TRUE, TRUE, 1);
INSERT INTO barbers (barber_name, barber_url_social, barber_is_hair, barber_is_beard, barber_barbershop_id) VALUES ('Mario BK', '@BK_Silva', TRUE, TRUE, 1);
INSERT INTO barbers (barber_name, barber_url_social, barber_is_hair, barber_is_beard, barber_barbershop_id) VALUES ('Cleber', '@Clebertesoura', TRUE, FALSE, 1);
INSERT INTO barbers (barber_name, barber_url_social, barber_is_hair, barber_is_beard, barber_barbershop_id) VALUES ('Brito', '@BritoCortes', TRUE, FALSE, 2);
INSERT INTO barbers (barber_name, barber_url_social, barber_is_hair, barber_is_beard, barber_barbershop_id) VALUES ('Rafa', '@CortesRafa', FALSE, TRUE, 2);



-- CATEGORIAS DE SERVICO
INSERT INTO service_categories (service_categories_description) VALUES ('Barba');
INSERT INTO service_categories (service_categories_description) VALUES ('Cabelo');
INSERT INTO service_categories (service_categories_description) VALUES ('Combo');



-- ########
-- SERVICOS
-- ########
INSERT INTO services (service_description, service_duration, service_value, service_category_id, service_barbershop_id) 
		VALUES ('Barba Lenhador', 20, 30.00, 1, 1);
INSERT INTO services (service_description, service_duration, service_value, service_category_id, service_barbershop_id) 
		VALUES ('Barba Cerrada', 25, 30.00, 1, 1);
INSERT INTO services (service_description, service_duration, service_value, service_category_id, service_barbershop_id) 
		VALUES ('Barba Cheia', 20, 25.00, 1, 1);

INSERT INTO services (service_description, service_duration, service_value, service_category_id, service_barbershop_id) 
		VALUES ('Degradê', 50, 50.00, 2, 1);
INSERT INTO services (service_description, service_duration, service_value, service_category_id, service_barbershop_id) 
		VALUES ('Corte Americano', 50, 45.00, 2, 1);
INSERT INTO services (service_description, service_duration, service_value, service_category_id, service_barbershop_id) 
		VALUES ('Corte Militar', 30, 35.00, 2, 1);
INSERT INTO services (service_description, service_duration, service_value, service_category_id, service_barbershop_id) 
		VALUES ('Corte Social', 40, 39.99, 2, 1);
INSERT INTO services (service_description, service_duration, service_value, service_category_id, service_barbershop_id) 
		VALUES ('Moicano', 50, 33.00, 2, 1);

INSERT INTO services (service_description, service_duration, service_value, service_category_id, service_barbershop_id) 
		VALUES ('Corte Social + Barba Cerrada', 65, 60, 3, 2);
INSERT INTO services (service_description, service_duration, service_value, service_category_id, service_barbershop_id) 
		VALUES ('Degradê + Barba Cheia', 60, 68.00, 3, 2);



-- ###########
-- AGENDAMENTO
-- ###########
INSERT INTO appointments (appointment_client_name, appointment_time, appointment_barbershop_id)
		VALUES ('Yuri Vinicius', '2025-09-17 14:00:00', 1);

INSERT INTO appointments (appointment_client_name, appointment_time, appointment_barbershop_id)
		VALUES ('Welligton Bob', '2025-09-17 15:00:00', 1);

INSERT INTO appointments (appointment_client_name, appointment_time, appointment_barbershop_id)
		VALUES ('Aleson Aberto', '2025-09-17 16:00:00', 2);

INSERT INTO appointments (appointment_client_name, appointment_time, appointment_barbershop_id)
		VALUES ('Gideão', '2025-09-18 14:00:00', 2);



-- ##########################
-- SERVICOS DE UM AGENDAMENTO
-- ##########################
INSERT INTO service_appointments (service_appointments_barber_id, service_appointments_service_id, service_appointments_appointment_id)
		VALUES (1, 1, 1);

INSERT INTO service_appointments (service_appointments_barber_id, service_appointments_service_id, service_appointments_appointment_id)
		VALUES (1, 2, 1);

INSERT INTO service_appointments (service_appointments_barber_id, service_appointments_service_id, service_appointments_appointment_id)
		VALUES (2, 5, 3);

INSERT INTO service_appointments (service_appointments_barber_id, service_appointments_service_id, service_appointments_appointment_id)
		VALUES (1, 4, 4);

INSERT INTO service_appointments (service_appointments_barber_id, service_appointments_service_id, service_appointments_appointment_id)
		VALUES (3, 6, 2);

-- ###################
-- AGENDA DE BARBEIROS
-- ###################
INSERT INTO agenda (agenda_service_appointments_id, agenda_barber_id)
		VALUES (1, 1);

INSERT INTO agenda (agenda_service_appointments_id, agenda_barber_id)
		VALUES (2, 1);

INSERT INTO agenda (agenda_service_appointments_id, agenda_barber_id)
		VALUES (3, 2);

INSERT INTO agenda (agenda_service_appointments_id, agenda_barber_id)
		VALUES (4, 1);

INSERT INTO agenda (agenda_service_appointments_id, agenda_barber_id)
		VALUES (5, 3);



-- ##########
-- MÉTODOS DE PAGAMENTO
-- ##########
INSERT INTO payment_methods (payment_methods_description)
		VALUES ('CARTÃO DE CRÉDITO');

INSERT INTO payment_methods (payment_methods_description)
		VALUES ('CARTÃO DE DÉBITO');

INSERT INTO payment_methods (payment_methods_description)
		VALUES ('DINHEIRO');

INSERT INTO payment_methods (payment_methods_description)
		VALUES ('PIX');


-- ##########
-- PAGAMENTOS
-- ##########
INSERT INTO payments (payments_appointments_id, payments_method_id, payments_status)
		VALUES (1, 4, FALSE);

INSERT INTO payments (payments_appointments_id, payments_method_id, payments_status)
		VALUES (2, 3, FALSE);

INSERT INTO payments (payments_appointments_id, payments_method_id, payments_status)
		VALUES (3, 4, FALSE);

INSERT INTO payments (payments_appointments_id, payments_method_id, payments_status)
		VALUES (4, 1, FALSE);










		
