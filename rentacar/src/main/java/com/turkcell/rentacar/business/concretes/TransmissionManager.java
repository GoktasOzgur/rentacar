package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TransmissionManager implements TransmissionService {
    private TransmissionRepository transmissionRepository;
    @Override
    public Transmission add(Transmission transmission) {
        Transmission createdTransmission = this.transmissionRepository.save(transmission);
        return createdTransmission;
    }

    @Override
    public void update(int id, Transmission transmission) {
        Optional<Transmission> existsTransmission = this.transmissionRepository.findById(id);
        if (existsTransmission.isPresent()){
            existsTransmission.get().setTransmissionType(transmission.getTransmissionType());
            existsTransmission.get().setUpdatedDate(transmission.getUpdatedDate());

            this.transmissionRepository.save(existsTransmission.get());
        }else{
            throw new FindException("İlgili id'ye karşılık gelen bir veri veritabanında bulunamadı");
        }

    }

    @Override
    public void delete(int id) {
        Optional<Transmission> existsTransmission = this.transmissionRepository.findById(id);
        if (existsTransmission.isPresent()){
            this.transmissionRepository.deleteById(id);
        }else{
            throw new FindException("İlgili id'ye karşılık gelen bir veri veritabanında bulunamadı");
        }

    }

    @Override
    public List<Transmission> getAll() {
        return this.transmissionRepository.findAll();
    }

    @Override
    public Transmission getById(int id) {
        Optional<Transmission> existsTransmission = this.transmissionRepository.findById(id);
        if(existsTransmission.isPresent()){
            return existsTransmission.get();
        }else{
            throw new FindException("İlgili id'ye karşılık gelen bir veri veritabanında bulunamadı");
        }
    }
}
