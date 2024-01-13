import React, { useContext, useEffect } from 'react';
import { AuthContext } from '../../contexts/AuthContext';
import SignedIn from './SignedIn';
import SignedOut from './SignedOut';
import './Navbar.css'; // Gerekirse stil dosyanızı buraya ekleyin
import { Navbar, Container, Nav, NavDropdown } from 'react-bootstrap';
import { Link } from 'react-router-dom';

type Props = {};

const CustomNavbar = (props: Props) => {
  const authContext: any = useContext(AuthContext);


  const signOut = () => {
    authContext.setIsAuthenticated(false);
    localStorage.removeItem('isAuthenticated');
  };

  const signIn = () => {
    authContext.setIsAuthenticated(true);
    localStorage.setItem('isAuthenticated', 'true');
  };

  return (
    <Navbar style={{ backgroundColor: '#d3d3d3' }} variant="dark" expand="lg">
      <Navbar.Brand as={Link} to="/">
        <img
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRndcsEsp7_zgOBCRq38Pzfsdd9rOO6VjBASg&usqp=CAU"
          alt="logo"
          className="logo"
          style={{ width: '150px', height: 'auto', maxWidth: '100%', maxHeight: '60px' }}
        />
      </Navbar.Brand>
      <Navbar.Toggle aria-controls="responsive-navbar-nav" />
      <Navbar.Collapse id="responsive-navbar-nav">
        <Nav className="ms-auto justify-content-center">
          <Nav.Link as={Link} to="/about" style={{ color: 'black', fontSize: '18px' }}>
            Hakkımızda
          </Nav.Link>
          <Nav.Link as={Link} to="/cars" style={{ color: 'black', fontSize: '18px' }}>
            Araçlar
          </Nav.Link>
          <Nav.Link as={Link} to="/services" style={{ color: 'black', fontSize: '18px' }}>
            Hizmetler
          </Nav.Link>
          <Nav.Link as={Link} to="/contact" style={{ color: 'black', fontSize: '18px' }}>
            İletişim
          </Nav.Link>
        </Nav>
        <Nav className="ms-auto">
          <Nav.Link>
            {authContext.isAuthenticated ? <SignedIn signOut={signOut} /> : <SignedOut signIn={signIn} />}
          </Nav.Link>
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  );
};

export default CustomNavbar;
