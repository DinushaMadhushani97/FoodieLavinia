import React from 'react';

function FoodResponseTable({ foodResponse }) {
  return (
    <div>
      
      <table className="table-foodUpload" style={{ marginTop: '600px'}}>
        
        <thead>
          <tr>
            <th>Name</th>
            <th>Price</th>
            <th>File Type</th>
            <th>File Size</th>
            <th>Download URL</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{foodResponse.name}</td>
            <td>{foodResponse.price}</td>
            <td>{foodResponse.fileType}</td>
            <td>{foodResponse.fileSize}</td>
            <td>{foodResponse.downloadUrl}</td>
          </tr>
        </tbody>
      </table>
      
    </div>
    
  );
}

export default FoodResponseTable;
