package com.kalanso.event.Service;

import com.kalanso.event.Model.Prestateur;
import com.kalanso.event.Repository.PrestateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestateurService {

    @Autowired
    private PrestateurRepository prestateurRepository;

    public List<Prestateur> findAll() {
        return prestateurRepository.findAll();
    }

    public Optional<Prestateur> findById(Long id) {
        return prestateurRepository.findById(id);
    }

    public Prestateur save(Prestateur prestateur) {
        return prestateurRepository.save(prestateur);
    }

    public void deleteById(Long id) {
        prestateurRepository.deleteById(id);
    }
}

