package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.entities.concretes.Fuel;

import java.util.List;

public interface FuelService {
    Fuel add(Fuel fuel);
    void update(int id, Fuel fuel);
    void delete(int id);
    List<Fuel> getAll();
    Fuel getById(int id);
}
