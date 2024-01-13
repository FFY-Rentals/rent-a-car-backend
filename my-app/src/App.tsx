import React, { ReactElement } from 'react';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import "bootstrap/dist/css/bootstrap.css";
import Navbar from './components/Navbar/Navbar';
import Homepage from './pages/Homepage/Homepage';
import Cars from './pages/Car/Cars';
import 'react-slideshow-image/dist/styles.css'

function App() : ReactElement{
  return (
    <>
    <Navbar />
    <Routes>
      <Route path="/" element={<Homepage />} />
      <Route path="/cars" element={<Cars />} />
    </Routes>
    </>
  );
}

export default App;
