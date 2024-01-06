package com.tobeto.pair8.rules.car;

import com.tobeto.pair8.repositories.CarRepository;
import com.tobeto.pair8.services.dtos.car.requests.AddCarRequest;
import com.tobeto.pair8.services.dtos.car.requests.UpdateCarRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class CarBusinessRulesMenager implements CarBusinessRulesService {

private final CarRepository carRepository;
    @Override
    public void exceptionSamePalte(AddCarRequest addCarRequest) {
        if (carRepository.existsByPlate(addCarRequest.getPlate())){
            throw new RuntimeException("Aynı plakata araç mevcuttur.");

        }
    }


}
