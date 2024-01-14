package com.tobeto.pair8.services.dtos.car.responses;

import com.tobeto.pair8.services.dtos.color.resposes.GetAllListColorResponse;
import com.tobeto.pair8.services.dtos.color.resposes.GetColorNameResponse;
import com.tobeto.pair8.services.dtos.model.responses.GetAllListModelRespose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllListCarResponse {
    private int id;
    private short modelYear;
    private String plate;
    private short minFindeksRate;
    private Long kilometer;
    private Float dailyPrice;
    private String imagePath;

    private GetAllListModelRespose model;
    private GetColorNameResponse color;
}
