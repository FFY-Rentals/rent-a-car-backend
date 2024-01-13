import axios from "axios";


const API_URL = 'http://localhost:8080/api/cars/getAll'
class CarService {
	
	getAll()
	{
		return axios.get(API_URL)
	}

}

export default new CarService();