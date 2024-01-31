import React, { useEffect, useState } from 'react';
import './FoodUploadForm.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { generatePDF } from './pdfGenerator';

function FoodList() {
  const [foods, setFoods] = useState([]);
  const [page, setPage] = useState(0);
  const [size, setSize] = useState(10);
  const [hasMoreData, setHasMoreData] = useState(true);

  const downloadFile = async (foodId) => {
    try {
      const response = await fetch(`http://localhost:8080/api/foods/${foodId}/download`);
      const blob = await response.blob();
      const url = window.URL.createObjectURL(blob);
      const a = document.createElement('a');
      a.href = url;
      a.download = 'foodFile.jpg'; // set the desired file name here
      a.click();
      window.URL.revokeObjectURL(url);
    } catch (error) {
      console.error('Error downloading file:', error);
    }
  };

  const handleGeneratePDF = () => {
    // Call the imported generatePDF function with the foods data
    generatePDF(foods);
  };

  useEffect(() => {
    const apiUrl = `http://localhost:8080/api/foods/list?page=${page}&size=${size}`;

    fetch(apiUrl)
      .then((response) => response.json())
      .then((data) => {
        if (data.length === 0) {
          setHasMoreData(false); // No more data to load
        } else {
          setFoods(data);
          setHasMoreData(true);
        }
      })
      .catch((error) => console.error('Error fetching data:', error));
  }, [page, size]);

  return (
    <div className='d'>
      <div>
        <h1 style={{ margin: '80px', padding: '0px', color: 'white' }}>
          <center>Food List</center>
        </h1>

        <div className="pagination" style={{ display: 'flex', justifyContent: 'center' }}>
          <label htmlFor="pageSize" style={{ color: 'white' }}>Items per page: </label>
          <select
            id="pageSize"
            value={size}
            onChange={(e) => setSize(Number(e.target.value))}
          >
            <option value="5">5</option>
            <option value="10">10</option>
            <option value="15">15</option>
          </select>
        </div>

        <table className="table-FoodList">
          <thead>
            <tr>
              <th>Name</th>
              <th>Price</th>
              <th>File Type</th>
              <th>File Size</th>
              <th>Download</th>
            </tr>
          </thead>
          <tbody>
            {foods.map((food, index) => (
              <tr key={index}>
                <td>{food.name}</td>
                <td>{food.price}</td>
                <td>{food.fileType}</td>
                <td>{food.fileSize}</td>
                <td>
                  <button className="btn btn-warning" onClick={() => downloadFile(food.foodId)}>
                    Download
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>

        <div className="pagination" style={{ display: 'flex', justifyContent: 'space-between' }}>
          <button
            className="btn btn-dark"
            onClick={() => setPage(page - 1)}
            disabled={page === 0}
          >
            Previous
          </button>

          <button className="btn btn-secondary" onClick={handleGeneratePDF}>
            Generate PDF
          </button>

          <button
            className="btn btn-dark"
            onClick={() => setPage(page + 1)}
            // Disable the Next button when there's no more data
            disabled={!hasMoreData} 
          >
            Next
          </button>
        </div>
      </div>
    </div>
  );
}

export default FoodList;
