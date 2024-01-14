import React, { useContext } from 'react';
import { AuthContext } from '../../contexts/AuthContext';
import SignedIn from './SignedIn';
import SignedOut from './SignedOut';
import { Navbar, Nav } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import styled from 'styled-components';

const StyledNav = styled(Nav)`
  a {
    font-size: 18px;
    color: rgba(0, 0, 0, 0.7); /* Griye yakın siyah renk */
    font-weight: normal; /* Normal kalınlıkta yazı stilini belirt */
    transition: color 0.3s ease, font-weight 0.3s ease; /* Renk ve kalınlık değişimi için geçiş efekti ekleme */
  }

  a:hover {
    color: #000; /* Üzerine gelince renk değiştir */
    font-weight: bold; /* Kalın yazı stilini belirt */
  }
`;

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
    <Navbar style={{ backgroundColor: '#d3d3d3' }} variant="dark" expand="lg">
      <Navbar.Brand as={Link} to="/">
        <img
          src="https://www.garenta.com.tr/Content/assets/images/garenta-logo.png"
          alt="logo"
          className="logo"
        />
      </Navbar.Brand>
      <Navbar.Toggle aria-controls="responsive-navbar-nav" />
      <Navbar.Collapse id="responsive-navbar-nav">
        <StyledNav className="ms-auto justify-content-center">
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
        </StyledNav>
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
