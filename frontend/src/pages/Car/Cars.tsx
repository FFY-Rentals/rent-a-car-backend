import React, { useEffect, useState } from 'react';
import CarService from '../../service/carService/CarService';
import { CarModel } from '../../models/carModels/GetAllCarModel';
import { motion } from 'framer-motion';
import { Link } from 'react-router-dom';

const Cars = () => {
  const [cars, setCars] = useState<CarModel[]>([]);

  useEffect(() => {
    fetchCars();
  }, []);

  const fetchCars = async () => {
    CarService.getAll().then((res) => {
      setCars(res.data);
    });
  };

  return (
      <motion.div initial={{ opacity: 0 }} animate={{ opacity: 1 }} exit={{ opacity: 0 }} className="pt-2">
        <div className="container">
          <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-4">
            {cars.map((car) => (
              <div key={car.id} className="mb-3 col">
                <motion.div whileHover={{ scale: 1.05 }}>
                  <div className="card">
                    <img
                      src={car?.imagePath}
                      alt={`Car Image - ${car.imagePath}`}
                      className="card-img-top"
                      style={{ objectFit: 'cover', height: '200px' }}
                      loading='lazy'
                    />
                    <div className="card-body">
                      <h5 className="card-title">
                        {car.modelYear} {car.model.brand.name} {car.model.name}
                      </h5>
                      <div className="d-flex justify-content-end">
                        <Link to="/" className="btn btn-lg btn-outline-success" style={{ marginRight: '20px' }}>
                          Şimdi Kirala <br /> {car.dailyPrice}₺
                        </Link>
                        <button className="btn btn-lg btn-outline-danger mr-5">DETAY</button>
                      </div>
                    </div>
                  </div>
                </motion.div>
              </div>
            ))}
          </div>
        </div>
      </motion.div>
    );
  };
  
  export default Cars;
