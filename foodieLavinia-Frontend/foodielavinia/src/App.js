import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Home from './components/Home';
import About from './components/About';
import Contact from './components/Contact';
import Login from './components/Login';
import Service from './components/Service';
import FoodUploadForm from './components/FoodUploadForm';
import FoodList from './components/FoodList';
import FoodDownload from './components/FoodDownload';
import NavBar from './components/NavBar/NavBar';

const App = () => {
  return (
    <BrowserRouter>
    <NavBar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/login" element={<Login />} />
        <Route path="/service" element={<Service />} />

        {/* Nested routes */}
        <Route path="/service/foodUploadForm" element={<FoodUploadForm />} />
        <Route path="/service/foodList" element={<FoodList />} />
        <Route path="/service/foodDownload" element={<FoodDownload />} />
        

      </Routes>
    </BrowserRouter>
  );
};

export default App;
