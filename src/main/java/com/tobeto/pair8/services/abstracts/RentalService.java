package com.tobeto.pair8.services.abstracts;

import com.tobeto.pair8.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.pair8.services.dtos.rental.requests.DeleteRentalRequest;
import com.tobeto.pair8.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.pair8.services.dtos.rental.responses.GetByIdRentalResponse;
import com.tobeto.pair8.services.dtos.rental.responses.GetListRentalResponse;

import java.util.List;

public interface RentalService {
    void add(AddRentalRequest addRentalRequest);

    void update(UpdateRentalRequest updateRentalRequest);

    void delete(DeleteRentalRequest deleteRentalRequest);

    List<GetListRentalResponse> getList();

    List<GetListRentalResponse> getAll();

    GetByIdRentalResponse getById(int id);
}
