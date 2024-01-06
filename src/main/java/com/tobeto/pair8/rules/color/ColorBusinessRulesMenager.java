package com.tobeto.pair8.rules.color;

import com.tobeto.pair8.repositories.ColorRepository;
import com.tobeto.pair8.services.dtos.color.requests.AddColorRequest;
import com.tobeto.pair8.services.dtos.color.requests.UpdateColorRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ColorBusinessRulesMenager implements ColorBusinessRulesService {
private final ColorRepository colorRepository;


    @Override
    public void exceptionSameName(AddColorRequest addBrandRequest) {
        if (colorRepository.existsByName(addBrandRequest.getName())){
            throw new RuntimeException("Aynı isimde renk mevcut.");
        }
    }

    @Override
    public void exceptionSameName(UpdateColorRequest updateColorRequest) {
       if (colorRepository.existsByName(updateColorRequest.getName())){
           throw new RuntimeException("Aynı isimde renk mevcut.");
       }
    }
}
