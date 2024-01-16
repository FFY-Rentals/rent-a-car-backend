package com.tobeto.pair8.controllers;

import com.tobeto.pair8.services.abstracts.RentalService;
import com.tobeto.pair8.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair8.services.dtos.rental.requests.DeleteRentalRequest;
import com.tobeto.pair8.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.pair8.services.dtos.rental.responses.GetByIdRentalResponse;
import com.tobeto.pair8.services.dtos.rental.responses.GetListRentalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
@AllArgsConstructor
public class RentalsController {
    private final RentalService rentalService;

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddRentalRequest addRentalRequest){
        rentalService.add(addRentalRequest);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateRentalRequest updateRentalRequest){
        rentalService.update(updateRentalRequest);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody @Valid DeleteRentalRequest deleteRentalRequest){ rentalService.delete(deleteRentalRequest);}

    @GetMapping("getRentals")
    public List<GetListRentalResponse> getList(){
        return rentalService.getList();
    }

    @GetMapping("/getAll")
    public List<GetListRentalResponse> getAll() {return rentalService.getAll();}

    @GetMapping("/getById")
    public GetByIdRentalResponse getById(@RequestParam @Valid int id){
        return rentalService.getById(id);
    }
}
