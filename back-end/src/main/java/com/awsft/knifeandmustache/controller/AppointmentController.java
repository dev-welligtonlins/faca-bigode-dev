package com.awsft.knifeandmustache.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awsft.knifeandmustache.dto.AppointmentDTO;
import com.awsft.knifeandmustache.dto.BarberDTO;
import com.awsft.knifeandmustache.model.Appointment;
import com.awsft.knifeandmustache.model.ServiceAppointment;
import com.awsft.knifeandmustache.new_dto.NewAppointmentDTO;
import com.awsft.knifeandmustache.service.AppointmentService;
import com.awsft.knifeandmustache.update_dto.UpdateAppointmentDTO;

@RestController
@RequestMapping("/appointments")
public class AppointmentController implements  ICrud<Appointment>{
       
    private final AppointmentService service;

    public AppointmentController(AppointmentService service){
        this.service = service;
    }

    // @PostMapping("/")
    public ResponseEntity<Appointment> insert(@RequestBody Appointment obj){
        Appointment record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Appointment>> findAll(){
        List<Appointment> allRecors = service.findAll();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getById(@PathVariable("id") Long id){
        Appointment record = service.getById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Appointment> update(@RequestBody Appointment obj){
        Appointment record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/b/{id}")
    public ResponseEntity<List<ServiceAppointment>> findBarbersByAppointments(@PathVariable("id") Long id){
        List<ServiceAppointment> allRecors = service.findBarbersByAppointments(id);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/day/{id}")
    public ResponseEntity<List<Appointment>> findByDayOfWeek(@PathVariable("id") Long id){
        List<Appointment> allRecors = service.findByDayOfWeek(id);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }    

    @GetMapping("/{id}/{dayOfWeek}")
    public ResponseEntity<List<ServiceAppointment>> findServiceAppointmentsByBarberIdAndDayOfWeek(@PathVariable("id") Long id, @PathVariable("dayOfWeek") Long dayOfWeek){
        List<ServiceAppointment> allRecors = service.findServiceAppointmentsByBarberIdAndDayOfWeek(id, dayOfWeek);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }

    @GetMapping("/dto/barbershop/{id}")
    public ResponseEntity<List<AppointmentDTO>> findByBarbershopId(@PathVariable("id") Long id){
        List<AppointmentDTO> allRecors = service.findByBarbershopId(id);
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }
 
    @GetMapping("/dto/{id}")
    public ResponseEntity<AppointmentDTO> findIdDTO(@PathVariable("id") Long id) {
        AppointmentDTO record = service.findIdDTO(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PostMapping("/dto/new-appointment/")
    public ResponseEntity<AppointmentDTO> newDto(@RequestBody NewAppointmentDTO dto){
        AppointmentDTO record = service.newDto(dto);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }

    @PutMapping("/dto/update-appointment/{id}")
    public ResponseEntity<AppointmentDTO> updateDto(@PathVariable("id") Long id, @RequestBody UpdateAppointmentDTO dto){
        AppointmentDTO record = service.updateDto(id, dto);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
}
