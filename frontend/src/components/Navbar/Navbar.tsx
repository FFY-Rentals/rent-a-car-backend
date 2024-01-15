import React, { useContext } from 'react';
import { AuthContext } from '../../contexts/AuthContext';
import SignedIn from './SignedIn';
import SignedOut from './SignedOut';
import { Navbar, Nav } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import './Navbar.css';

const CustomNavbar = () => {
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
    <Navbar expand="lg" className='Navbar'>
      <Navbar.Brand as={Link} to="/">
        <img
          src="https://i.ibb.co/m9VCTp4/lillogo-FFY.png"
          alt="logo"
          className="logo"
        />
      </Navbar.Brand>
      <Navbar.Toggle aria-controls="responsive-navbar-nav" />
      <Navbar.Collapse id="responsive-navbar-nav">
        <Nav className="Nav">
          <Nav.Link as={Link} to="/about">
            Hakkımızda
          </Nav.Link>
          <Nav.Link as={Link} to="/cars">
            Araçlar
          </Nav.Link>
          <Nav.Link as={Link} to="/services">
            Hizmetler
          </Nav.Link>
          <Nav.Link as={Link} to="/contact">
            İletişim
          </Nav.Link>
        </Nav>
        <Nav className="Navbar-right">
          <Nav.Link>
            {authContext.isAuthenticated ? <SignedIn signOut={signOut} /> : <SignedOut signIn={signIn} />}
          </Nav.Link>
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  );
};

export default CustomNavbar;
