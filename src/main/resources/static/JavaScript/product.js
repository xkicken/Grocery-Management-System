// Function to dynamically load data from API and populate table
async function loadProducts(apiEndpoint) {
    try {
        const response = await fetch(apiEndpoint);
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
window.onload = loadProducts('http://localhost:8080/api/products/table');

// Function to fetch data from the API
async function fetchData(apiEndpoint) {
    try {
        const response = await fetch(apiEndpoint);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        populateLinks(data); // Call function to populate links
    } catch (error) {
        console.error('Error fetching data:', error);
        document.getElementById('myDropdownFilter').innerHTML = 'Error fetching data.';
    }
}

// Function to populate <a> tags with fetched data
function populateLinks(categories) {
    const linksContainer = document.getElementById('myDropdownFilter');
    linksContainer.innerHTML = ''; // Clear previous loading message

    // Create an <a> tag for each product
    categories.forEach(categories => {
        var id = categories.category_id;
        const link = document.createElement('a');
        link.href = `#`; // Set the href attribute
        link.onclick = function () {ChangeapiEndPoint('http://localhost:8080/api/products/category/' + id)}
        link.textContent = categories.category_name; // Assuming 'name' is a key in the product object

        // Optional: Add an event listener for clicking on the link
        // link.addEventListener('click', () => {
        //     alert(`You clicked on ${categories.name}`);
        // });

        linksContainer.appendChild(link); // Append the link to the container
    });
}

// Load the data when the page loads
window.onload = () => {
    const endpoint = 'http://localhost:8080/api/category'; // Change this to your API endpoint
    fetchData(endpoint); // Call the fetch function with the desired endpoint
};



function toggleDropdown(id) {
    const dropdown = document.getElementById(id);
    dropdown.classList.toggle('show');
}

window.onclick = function(event) {
    if (!event.target.matches('.dropbtn')) {
        const dropdowns = document.getElementsByClassName("dropdown-content");
        for (let i = 0; i < dropdowns.length; i++) {
            const openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}

function ChangeapiEndPoint(apiEndpoint){
    const endpoint = apiEndpoint;
    loadProducts(endpoint);
}
