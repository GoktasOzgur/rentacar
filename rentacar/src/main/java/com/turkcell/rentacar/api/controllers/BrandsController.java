package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.entities.concretes.Brand;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/brands")
public class BrandsController {
    private BrandService brandService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Brand add(@RequestBody Brand brand){
        return brandService.add(brand);
    }

    @PostMapping("/update/{id}")
    @Transactional
    public void update(@PathVariable int id, @RequestBody Brand brand){
        this.brandService.update(id,brand);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }

    @GetMapping("/getall")
    public List<Brand> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public Brand getById(@PathVariable int id){
        return this.brandService.getById(id);
    }

}

//localhost:8080/api/v1/brands