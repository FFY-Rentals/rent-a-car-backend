import { Container, Row, Col, CardFooter } from "react-bootstrap";

const CustomFooter = () => {
  return (
    <CardFooter className="text-center" style={{ backgroundColor: 'red' }}>
      <Container>
        <Row>
          <Col>
            <span>© 2021 - </span>
            <a href="https://yourwebsite.com"
              target="_blank"
              rel="noopener noreferrer"
            >
              Your Website
            </a>
          </Col>
        </Row>
      </Container>
    </CardFooter>
  );
}

export default CustomFooter;