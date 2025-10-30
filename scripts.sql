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
