// Function to dynamically load data from API and populate table
async function loadProducts() {
    try {
        const response = await fetch('http://localhost:8080/api/products/table');
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const products = await response.json();

        if (products.length === 0) {
            document.getElementById('tableBody').innerHTML = '<tr><td colspan="100%">No products available.</td></tr>';
            return;
        }

        // Get table head and body elements
        const tableHeadRow = document.getElementById('tableHeadRow');
        const tableBody = document.getElementById('tableBody');

        // Clear existing headers and rows
        tableHeadRow.innerHTML = '';
        tableBody.innerHTML = '';

        // Get the keys from the first product object to create column headers
        const headers = Object.keys(products[0]);

        // Create table headers
        headers.forEach(header => {
            const th = document.createElement('th');
            th.textContent = header.charAt(0).toUpperCase() + header.slice(1); // Capitalize header names
            tableHeadRow.appendChild(th);
        });

        // Create table rows dynamically
        products.forEach(product => {
            const row = document.createElement('tr');

            // Loop through each key in the product object to create cells
            headers.forEach(header => {
                const cell = document.createElement('td');
                cell.textContent = product[header] !== null ? product[header] : 'N/A';  // Handle null values
                row.appendChild(cell);
            });

            tableBody.appendChild(row);
        });

    } catch (error) {
        console.error('Error fetching the products:', error);
        const tableBody = document.getElementById('tableBody');
        tableBody.innerHTML = '<tr><td colspan="100%">Error loading products.</td></tr>';
    }
}

// Load the data when the page loads
window.onload = loadProducts;

function toggleDropdown(id) {
    const dropdown = document.getElementById(id);
    dropdown.classList.toggle('show');
}

window.onclick = function(event) {
    if (!event.target.matches('.dropbtn')) {
        var dropdowns = document.getElementsByClassName("dropdown-content");
        for (var i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}
