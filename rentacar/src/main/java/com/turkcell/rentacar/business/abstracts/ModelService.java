package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;

import java.util.List;


public interface ModelService {
    Model add(Model Model);
    void update(int id, Model model);
    void delete(int id);
    List<Model> getAll();
    Model getById(int id);

}
