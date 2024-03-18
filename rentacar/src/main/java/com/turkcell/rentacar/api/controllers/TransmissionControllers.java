package com.turkcell.rentacar.api.controllers;


import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.entities.concretes.Transmission;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/transmissions")
public class TransmissionControllers {
    private TransmissionService transmissionService;


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Transmission add(@RequestBody Transmission transmission){
        return this.transmissionService.add(transmission);
    }

    @PostMapping("/update/{id}")
    @Transactional
    public void update(@PathVariable int id, @RequestBody Transmission transmission){
        this.transmissionService.update(id, transmission);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable int id){
        this.transmissionService.delete(id);
    }

    @GetMapping("/getall")
    public List<Transmission> getAll(){
        return this.transmissionService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public Transmission getById(@PathVariable int id){
        return this.transmissionService.getById(id);
    }
}
