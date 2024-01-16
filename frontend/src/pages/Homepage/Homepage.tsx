// Homepage.tsx

import React, { useState } from 'react';
import { Container, Row, Col, Form, Button } from 'react-bootstrap';
import { Formik, Form as FormikForm } from 'formik';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCar } from '@fortawesome/free-solid-svg-icons';
import SliderComp from '../../components/Home/SliderComp';
import FormikSelect from '../../components/FormikSelect/FormikSelect';
import FormikInput from '../../components/FormikInput/FormikInput';
import './Homepage.css';

interface HomepageProps {}

const Homepage: React.FC<HomepageProps> = () => {
  const [isCarAnimated, setCarAnimated] = useState(false);

  const handleSearch = () => {
    // Your search logic here
    // For demo purposes, let's toggle the animation state
    setCarAnimated(!isCarAnimated);
  };

  const locationOptions: string[] = [
    "Adres 1",
    "Adres 2",
    "Adres 3",
    // Diğer adres seçenekleri
  ];

  return (
    <Container fluid className="mt-5">
      <Row className="justify-content-md-center">
        <Col md={6}>
          <div className="formik-section">
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
                    <FormikSelect
                      label="Alış Yeri"
                      name="pickupLocation"
                      options={locationOptions.map(location => ({ value: location, label: location }))}
                    />
                  </Form.Group>
                  <FormikInput label="Alış Tarihi" name="pickupDate" type="date" />
                  <FormikInput label="Dönüş Tarihi" name="returnDate" type="date" />
                  <br />
                  <Button
                    variant="primary"
                    type="submit"
                    className={isCarAnimated ? 'car-animated' : ''}
                  >
                    <FontAwesomeIcon icon={faCar} className="mr-2" />
                    <span>Araçları Göster</span>
                  </Button>
                </FormikForm>
              )}
            </Formik>
          </div>
        </Col>
      </Row>
      <br /><br /><br /><br /><br />
      <SliderComp />
    </Container>
  );
};

export default Homepage;
