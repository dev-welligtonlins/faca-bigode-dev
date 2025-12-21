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

import com.awsft.knifeandmustache.dto.AddressDTO;
import com.awsft.knifeandmustache.model.Address;
import com.awsft.knifeandmustache.new_dto.NewAddressDTO;
import com.awsft.knifeandmustache.service.AddressService;
import com.awsft.knifeandmustache.update_dto.UpdateAddressDTO;


@RestController
@RequestMapping("/address")
public class AddressController implements  ICrud<Address>{
       
    private final AddressService service;

    public AddressController(AddressService service){
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<Address> insert(@RequestBody Address obj){
        Address record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<Address>> findAll(){
        List<Address> allRecors = service.findAll();
        return new ResponseEntity<>(allRecors, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable("id") Long id){
        Address record = service.getById(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<Address> update(@RequestBody Address obj){
        Address record = service.save(obj);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    @GetMapping("/dto/{id}")
    public ResponseEntity<AddressDTO> findIdDTO(@PathVariable("id") Long id) {
        AddressDTO record = service.findIdDTO(id);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    @PostMapping("/dto/new-address/")
    public ResponseEntity<AddressDTO> newDto(@RequestBody NewAddressDTO dto){
        AddressDTO record = service.newDto(dto);
        return new ResponseEntity<>(record, HttpStatus.CREATED);
    }
    @PutMapping("/dto/update-address/{id}")
    public ResponseEntity<AddressDTO> updateDto(@PathVariable("id") Long id, @RequestBody UpdateAddressDTO dto){
        AddressDTO record = service.updateDto(id, dto);
        return new ResponseEntity<>(record, HttpStatus.OK);
    }
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }    
}
