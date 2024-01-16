import axios, { AxiosResponse } from "axios";
import { CarModel } from "../../models/carModels/GetAllCarModel";

const API_URL = 'http://localhost:8080/api/cars/getAll';

class CarService {
  getAll(): Promise<AxiosResponse<CarModel[]>> {
    return axios.get<CarModel[]>(API_URL);
  }
}

export default new CarService();