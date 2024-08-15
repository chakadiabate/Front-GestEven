package com.kalanso.event.Controller;

import com.kalanso.event.Model.TypeEvent;
import com.kalanso.event.Service.typeEvent_Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/EvenType")
@AllArgsConstructor
public class TypeEventController {
    private typeEvent_Service typeEventService;

    @GetMapping("all")
    public List<TypeEvent> getTypeEvents() {
        return typeEventService.ListeType();
    }

    @PostMapping("/createtype")
    public TypeEvent createTypeEvent(@RequestBody TypeEvent typeEvent) {
        return typeEventService.CreateType(typeEvent);
    }

}
