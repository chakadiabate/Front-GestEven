package com.kalanso.event.Service;

import com.kalanso.event.Model.TypeEvent;
import com.kalanso.event.Repository.TypeEventRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class typeEvent_Service {
    private TypeEventRepo typeEventRepo;

    public List<TypeEvent> ListeType(){
        return typeEventRepo.findAll();
    }

    public TypeEvent CreateType(TypeEvent type){
        return typeEventRepo.save(type);
    }
}
