import React from 'react';
import { Container, Row, Col, Form, Button } from 'react-bootstrap';
import { Formik, Field, Form as FormikForm } from 'formik';
import { Icon } from 'semantic-ui-react';

const Homepage = () => {
  const handleSearch = () => {};

  return (
    <>
    <Container className="mt-5">
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
                  <Form.Label className="h5">
                    Alış Yeri
                  </Form.Label>
                  <Field
                    name="pickupLocation"
                    placeholder="Alış Yeri Giriniz"
                    as={Form.Control}
                  />
                </Form.Group>
                <Row>
                  <Col>
                    <Form.Group controlId="pickupDate">
                      <Form.Label className="h6">Alış Tarihi</Form.Label>
                      <Field type="date" name="pickupDate" as={Form.Control} />
                    </Form.Group>
                  </Col>
                  <Col>
                    <Form.Group controlId="returnDate">
                      <Form.Label className="h6">Dönüş Tarihi</Form.Label>
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
    </Container>
    </>
  );
};

export default Homepage;
