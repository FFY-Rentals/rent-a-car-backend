// Homepage.js

import React from 'react';
import { Row, Col, Form, Button } from 'react-bootstrap';
import { Formik, Field, Form as FormikForm } from 'formik';
import SliderComp from '../../components/Home/SliderComp';
import './Homepage.css';

const Homepage = () => {
  const handleSearch = () => {};

  const locationOptions = [
    "Adres 1",
    "Adres 2",
    "Adres 3",
    // Diğer adres seçenekleri
  ];

  return (
    <>
      <div className="mt-5">
        <Row className="justify-content-md-center">
          <Col md={6}>
            <Formik
              initialValues={{
                pickupLocation: '',
                pickupDate: '',
                returnDate: '',
              }}
              onSubmit={handleSearch}
            >
              {() => (
                <FormikForm>
                  <Form.Group controlId="pickupLocation">
                    <Form.Label className="form-label-bold">Alış Yeri</Form.Label>
                    <Field
                      name="pickupLocation"
                      as="select"
                      className="form-control"
                    >
                      <option value="" disabled>
                        Lütfen bir adres seçiniz
                      </option>
                      {locationOptions.map((location, index) => (
                        <option key={index} value={location}>
                          {location}
                        </option>
                      ))}
                    </Field>
                  </Form.Group>
                  <Row>
                    <Col>
                      <Form.Group controlId="pickupDate">
                        <Form.Label className="form-label-bold">Alış Tarihi</Form.Label>
                        <Field type="date" name="pickupDate" as={Form.Control} />
                      </Form.Group>
                    </Col>
                    <Col>
                      <Form.Group controlId="returnDate">
                        <Form.Label className="form-label-bold">Dönüş Tarihi</Form.Label>
                        <Field type="date" name="returnDate" as={Form.Control} />
                      </Form.Group>
                    </Col>
                  </Row>
                  <br />
                  <Button variant="primary" type="submit">
                    Araçları Göster
                  </Button>
                </FormikForm>
              )}
            </Formik>
          </Col>
        </Row>
      </div>
      <br /><br /><br />
      <SliderComp />
    </>
  );
};

export default Homepage;
