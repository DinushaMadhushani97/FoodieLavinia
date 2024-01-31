import jsPDF from 'jspdf';
import 'jspdf-autotable';
import 'bootstrap/dist/css/bootstrap.min.css';
import backgroundImage from '../images/backgroun-image4.jpg';

export const generatePDF = async () => {
  const doc = new jsPDF();

  const bgImage = new Image();
  bgImage.src = backgroundImage;

  // Wait for the background image to load
  await new Promise((resolve) => {
    bgImage.onload = resolve;
  });

  // Title Page
  doc.addImage(bgImage, 'JPEG', 0, 0, doc.internal.pageSize.width, doc.internal.pageSize.height);

  // Title
  doc.setFontSize(30);
  doc.setTextColor(0, 0, 255);
  doc.text("Foodie Lavinia", 105, 150, 'center', {
    bold: true,
    italic: true,
  });

  // title page Description
//   doc.setFontSize(12); // Adjust the font size for the description
//   doc.setTextColor(0, 0, 0); // Set text color to black
//   const description = "Welcome to Foodie Lavinia!";
//   doc.text(description, 15, 200); 

  
  doc.addPage(); 
  doc.addImage(bgImage, 'JPEG', 0, 0, doc.internal.pageSize.width, doc.internal.pageSize.height);

  // Function to create a page with table content
  async function createPageWithTable(page) {
    const apiUrl = `http://localhost:8080/api/foods/list?page=${page}&size=10`;

    try {
      const response = await fetch(apiUrl);
      const data = await response.json();

      if (data.length > 0) {
        const columns = ["Name", "Price", "File Type", "File Size"];
        const rows = data.map((food) => [food.name, food.price, food.fileType, food.fileSize]);

        const tableOptions = {
          startY: 40, // Set margin-top to 40px
        };

        if (page > 1) {
          doc.addPage(); // Add a new page for each page of data except the first
          doc.addImage(bgImage, 'JPEG', 0, 0, doc.internal.pageSize.width, doc.internal.pageSize.height);
        }

        // doc.setFontSize(30);
        // doc.setTextColor(0, 0, 255);
        // doc.text("Foodie Lavinia", 105, 30, 'center', {
        //   bold: true,
        //   italic: true,
        // });

        doc.autoTable(columns, rows, tableOptions);

        // Check if there is more data to fetch
        return data.length === 10;
      }
    } catch (error) {
      console.error('Error fetching data:', error);
    }

    // If there's no more data, return false
    return false;
  }

  // Generate pages with table data
  let page = 1;
  while (true) {
    const hasMoreData = await createPageWithTable(page);
    page++;
  
    if (!hasMoreData) {
      break; // Exit the loop when there's no more data
    }
  }

  // Save the PDF
  doc.save('foodList.pdf');
};
