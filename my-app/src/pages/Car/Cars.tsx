import React, { useEffect, useState } from 'react';
import { Col, Row, Button, Card } from 'react-bootstrap';
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
      <Row xs={1} sm={2} md={3} lg={4} xl={4}>
        {cars.map((car) => (
          <Col key={car.id} className="mb-3">
            <motion.div whileHover={{ scale: 1.05 }}>
              <Card>
                <Card.Body>
                  <Card.Title>
                 
                    <br />
                    <img
                      src={car?.imagePath}
                      alt={`Car Image - ${car.imagePath}`}
                      style={{ width: '100%', maxHeight: '200px', objectFit: 'cover' }}
                    />
                  </Card.Title>
                  <Card.Text style={{ fontSize: '25px', fontWeight: 'bold' }}>
                  {car.modelYear} {car.model.brand.name} {car.model.name}
                  </Card.Text>

                  <div className='d-flex justify-content-end'>
                      <Link to="/" className="btn btn-lg btn-outline-success" style={{ marginRight: '20px' }}>Şimdi Kirala <br />{car.dailyPrice}₺</Link>
                    <button type="button" className="btn btn-lg btn-outline-danger  mr-5">DETAY</button>
                  </div>
                </Card.Body>
              </Card>
            </motion.div>
          </Col>
        ))}
      </Row>
    </motion.div>
  );
};

export default Cars;
