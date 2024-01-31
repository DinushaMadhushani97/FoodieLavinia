import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';


// import backgroundImage from '../images/background-image.jpg';

import './FoodUploadForm.css';
import FoodResponseTable from './FoodResponseTable';



function FoodUploadForm() {
  const [file, setFile] = useState(null);
  const [name, setName] = useState('');
  const [price, setPrice] = useState('');
  const [venue, setVenue] = useState('');
  const [response, setResponse] = useState(null); // State to store the response data

  const handleFileChange = (e) => {
    const selectedFile = e.target.files[0];
    setFile(selectedFile);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const formData = new FormData();
    formData.append('file', file);
    formData.append('name', name);
    formData.append('price', price);
    formData.append('venue', venue);

    try {
      const response = await axios.post('http://localhost:8080/api/foods/upload', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      });

      console.log('Upload success:', response.data);

      // Set the response data in the state
      setResponse(response.data);
    } catch (error) {
      console.error('Upload error:', error);
      // Handle error, show an error message.
    }
  };

  return (
    // <div className="container" style={{ backgroundImage: `url(${backgroundImage})` }}>
    <div className="container">
      <div className="form-container">
        <h1 style={{ color: 'white' }}>
          <center>Add Food Details</center>
        </h1>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label style={{ color: 'white' }} htmlFor="name" className="form-label">
              Name
            </label>
            <input
              type="text"
              className="form-control"
              id="name"
              value={name}
              onChange={(e) => setName(e.target.value)}
              required
            />
          </div>
          <div className="mb-3">
            <label style={{ color: 'white' }} htmlFor="price" className="form-label">
              Price
            </label>
            <input
              type="number"
              className="form-control"
              id="price"
              value={price}
              onChange={(e) => setPrice(e.target.value)}
              required
            />
          </div>
          <div className="mb-3">
            <label style={{ color: 'white' }} htmlFor="venue" className="form-label">
              Venue
            </label>
            <input
              type="text"
              className="form-control"
              id="venue"
              value={venue}
              onChange={(e) => setVenue(e.target.value)}
              required
            />
          </div>
          <div className="mb-3">
            <label style={{ color: 'white' }} htmlFor="file" className="form-label">
              Upload Image
            </label>
            <input
              type="file"
              className="form-control"
              id="file"
              accept="image/*"
              onChange={handleFileChange}
              required
            />
          </div>
          <button type="submit" className="btn btn-primary">
            Submit
          </button>
        </form>
      </div>
      {/* Conditional rendering of FoodResponseTable */}
      {response && <FoodResponseTable foodResponse={response} />}
      {/* <div className="space-after-table"></div> */}
      
      
    </div>
  );
}

export default FoodUploadForm;
