import axios from "axios";


const API_URL = 'http://localhost:8080/api/brands/getAll'
class ProductService {
	
	getAll()
	{
		return axios.get(API_URL)
	}

}

export default new ProductService();