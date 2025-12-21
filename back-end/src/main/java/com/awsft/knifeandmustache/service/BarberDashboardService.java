// package com.awsft.knifeandmustache.service;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.awsft.knifeandmustache.dto.BarberDTO;
// import com.awsft.knifeandmustache.dto.BarberDashboardDTO;
// import com.awsft.knifeandmustache.dto.ServiceAppointmentDTO;
// import com.awsft.knifeandmustache.repository.BarberRepository;
// import com.awsft.knifeandmustache.repository.ServiceAppointmentRepository;

// @Service
// public class BarberDashboardService {

//     private final BarberRepository barberRepository;
//     private final ServiceAppointmentRepository serviceAppointmentRepository;

//     public BarberDashboardService(BarberRepository barberRepository, ServiceAppointmentRepository serviceAppointmentRepository) {
//         this.barberRepository = barberRepository;
//         this.serviceAppointmentRepository = serviceAppointmentRepository;
//     }

//     public BarberDashboardDTO getBarberDash(Long id) {
//         List<BarberDTO> barbers = barberRepository.findBarbersByBarbershopId(id);
//         List<ServiceAppointmentDTO> serviceAppointments = serviceAppointmentRepository.findServiceAppointmentByBarbershopId(id);
         
//         Long sizeBarbers = (long) barbers.size();
//         Long sizeServiceAppointments = (long) serviceAppointments.size();
        
//         Double total = serviceAppointments.stream().mapToDouble(obj -> obj.getValue()).sum();

//         return new BarberDashboardDTO(barbers, sizeBarbers, serviceAppointments, sizeServiceAppointments, total);
//     }

// }
