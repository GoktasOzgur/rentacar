package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.entities.concretes.Model;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/models")
public class ModelsController {
    private ModelService modelService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Model add(@RequestBody Model model){
        return this.modelService.add(model);
    }

    @PostMapping("/update/{id}")
    @Transactional
    public void update(@PathVariable int id, @RequestBody Model model){
        this.modelService.update(id, model);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable int id){
        this.modelService.delete(id);
    }

    @GetMapping("/getall")
    public List<Model> getAll(){
        return this.modelService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public Model getById(@PathVariable int id){
        return this.modelService.getById(id);
    }
}
