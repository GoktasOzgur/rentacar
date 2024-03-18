package com.turkcell.rentacar.api.controllers;


import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.entities.concretes.Fuel;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fuels")
public class FuelsController {
    private FuelService fuelService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Fuel add(@RequestBody Fuel fuel){
        return this.fuelService.add(fuel);
    }

    @PostMapping("/update/{id}")
    @Transactional
    public void update(@PathVariable int id, @RequestBody Fuel fuel){
        this.fuelService.update(id,fuel);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable int id){
        this.fuelService.delete(id);
    }

    @GetMapping("/getall")
    public List<Fuel> getAll(){
        return this.fuelService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public Fuel getById(@PathVariable int id){
        return this.fuelService.getById(id);
    }

}
