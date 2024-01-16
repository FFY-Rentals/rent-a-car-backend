import React, { ReactElement } from 'react';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import "bootstrap/dist/css/bootstrap.css";
import Navbar from './components/Navbar/Navbar';
import Homepage from './pages/Homepage/Homepage';
import Cars from './pages/Car/Cars';
import 'react-slideshow-image/dist/styles.css'
import CustomFooter from './components/Footer/Footer';
import About from './pages/About/About';

function App() : ReactElement{
  return (
    <>
    <Navbar />
      <Routes>
        <Route path="/" element={<Homepage />} />
        <Route path="/about" element={< About/>} />
        <Route path="/cars" element={<Cars />} />
      </Routes>
      <CustomFooter />
    </>
  );
}

export default App;