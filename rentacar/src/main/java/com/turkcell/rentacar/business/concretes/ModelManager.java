package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    @Override
    public Model add(Model model) {
        Model createdModel = this.modelRepository.save(model);
        return createdModel;
    }

    @Override
    public void update(int id, Model model) {
        Optional<Model> existsModel =this.modelRepository.findById(id);
        if(existsModel.isPresent()){
            existsModel.get().setName(model.getName());
            existsModel.get().setUpdatedDate(model.getUpdatedDate());

            this.modelRepository.save(existsModel.get());
        }else{
            throw new FindException("İlgili id'ye karşılık gelen bir veri veritabanında bulunamadı");
        }
    }

    @Override
    public void delete(int id) {
        Optional<Model> existsModel = this.modelRepository.findById(id);
        if(existsModel.isPresent()){
            this.modelRepository.deleteById(id);
        }else{
            throw new FindException("İlgili id'ye karşılık gelen bir veri veritabanında bulunamadı");
        }

    }

    @Override
    public List<Model> getAll() {
        return this.modelRepository.findAll();
    }

    @Override
    public Model getById(int id) {
        Optional<Model> existsModel = this.modelRepository.findById(id);
        if(existsModel.isPresent()){
            return existsModel.get();
        }else{
            throw new FindException("İlgili id'ye karşılık gelen bir veri veritabanında bulunamadı");
        }
    }
}
