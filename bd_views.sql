




-- #########################################
-- SERVIÇOS DE UMA BARBEA
-- #########################################
-- CREATE VIEW view_services_barbershop AS 
--     SELECT b.id AS barbershop_id, 
-- 		   s.service_description, 
-- 		   s.service_value, 
-- 		   s.duration, 
-- 		   s.category 
-- 	FROM services s 
-- 	JOIN barbershops b ON b.id = s.barbershop_id 
-- 	WHERE s.service_active = TRUE;

CREATE VIEW view_services_barbershop_dashboard AS
	SELECT
	    bs.id AS barbershop_id,
	
		COALESCE(s.total_services, 0) AS total_services,
		COALESCE(s.avg_value, 0) AS avg_value,
		COALESCE(s.avg_duration, 0) AS avg_duration,		
		service_pop.service_description AS 	service_most_pop

	FROM barbershops bs
	LEFT JOIN (
		SELECT barbershop_id, COUNT(*) AS total_services,
		    ROUND(AVG(service_value)::numeric, 2) AS avg_value,
		    ROUND(AVG(duration))::int AS avg_duration
		FROM services
		WHERE service_active = TRUE
		GROUP BY barbershop_id
	) s ON s.barbershop_id = bs.id
	
	LEFT JOIN (
		SELECT DISTINCT ON (a.barbershop_id) a.barbershop_id, 
			s.service_description, 
			COUNT(sa.id) AS total_use
		FROM appointments a
		JOIN service_appointments sa ON sa.appointment_id = a.id
		JOIN services s ON s.id = sa.service_id
		WHERE a.appointment_status = 'FINALIZADO'
		GROUP BY a.barbershop_id, s.service_description
		ORDER BY a.barbershop_id, COUNT(sa.id) DESC
	) service_pop ON service_pop.barbershop_id = bs.id;




-- CREATE VIEW view_barbers_barbershop_dashboard AS
-- 	SELECT
-- 		bs.id AS barbershop_id,
-- 		COALESCE(b.total_barbers, 0) AS total_barbers,
-- 		COALESCE(total_value_day.total_value, 0) AS total_value_day
-- 	FROM barbershops bs
-- 	LEFT JOIN (
-- 		SELECT barbershop_id, COUNT(*) AS total_barbers
-- 		FROM barbers
-- 		WHERE barber_active = TRUE
-- 		GROUP BY barbershop_id
-- 	) b ON b.barbershop_id = bs.id

-- 	LEFT JOIN (
-- 		SELECT a.barbershop_id, ROUND(SUM(s.service_value)::numeric, 2) AS total_value
-- 			FROM appointments a
-- 			JOIN service_appointments sa ON a.id = sa.appointment_id
-- 			JOIN services s ON s.id = sa.service_id
-- 			WHERE a.appointment_status IN ('FINALIZADO', 'AGENDADO')
-- 			GROUP BY a.barbershop_id
-- 	) total_value_day ON total_value_day.barbershop_id = bs.id;



-- -- AGENDA
-- 		-- info: retona os horário agendados de um barbeiro
-- 		-- 		 com o o nome do cliente e o valor

-- SELECT a.agenda_time AS horario,
-- 		b.barber_name  AS barbeiro,
-- 		sb.service_barbershop_client_name AS cliente,
-- 		bs.barbershop_services_value AS valor,		
-- 		p.payments_status AS status_pagamento
-- 	FROM agenda a   
-- 	JOIN barbers b ON a.agenda_barber_id = b.id
-- 	JOIN barbershop_services bs ON a.agenda_barbershop_services_id = bs.id
-- 	JOIN service_barbershop sb ON bs.barbershop_services_service_barbershop_id = sb.id
-- 	JOIN payments p ON p.payments_service_barbershop_id = sb.id
-- 	WHERE a.agenda_barber_id = 1;

-- -- AGENDA
-- 		-- info: retona os serviços de um barbeiro
-- 		-- 		 com a data e o valor, quando pagamento_status == true
		
-- SELECT b.barber_name AS barbeiro,
-- 		bs.barbershop_services_value AS valor,
-- 		sb.service_barbershop_time AS quando,
-- 		pm.payment_methods_description AS tipo_pagamento
-- 	FROM barbershop_services bs
-- 	JOIN barbers b ON bs.barbershop_services_barber_id = b.id
-- 	JOIN service_barbershop sb ON sb.id = bs.barbershop_services_service_barbershop_id
-- 	JOIN payments p ON p.payments_service_barbershop_id = bs.id
-- 	JOIN payment_methods pm ON p.payments_method_id = pm.id
-- 	WHERE bs.barbershop_services_barber_id = 1
-- 			AND p.payments_status = TRUE;

-- -- AGENDA
-- 		-- info: retorna as barbearias e os
-- 		-- 		 horários de funcionamento
		
-- SELECT bs.barber_shops_name AS barbearia,
-- 		bs.barber_shops_opening_hours AS horario_abertura,
-- 		bs.barber_shops_closing_hours AS horario_fechamento,
-- 		ad.address_neighborhood AS bairro,
-- 		ad.address_road AS rua,
-- 		ad.address_number AS numero
-- 	FROM barber_shops bs
-- 	JOIN address ad ON bs.barber_shops_address_id = ad.id;

-- SELECT * FROM accommodations;
