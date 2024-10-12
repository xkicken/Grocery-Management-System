let pageSize = 20;
let pageNumber = 0;
let currentPage = 0;
let sortBy = 'productId';
let direction = 'asc';
let baseURL = 'http://localhost:8080/api/products/table';

// Function to fetch categories from the API
async function fetchCategories(apiEndpoint) {
    try {
        const response = await fetch(apiEndpoint);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const categories = await response.json();
        populateLinks(categories); // Populate category links
    } catch (error) {
        console.error('Error fetching categories:', error);
        document.getElementById('myDropdownFilterCategories').innerHTML = 'Error fetching categories.';
    }
}

// Function to dynamically load products from API and populate table
async function loadProducts(apiEndpoint) {
    try {
        const response = await fetch(apiEndpoint);
        console.log(apiEndpoint)
        console.log('Fetch response status:', response.status);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        console.log('Fetched data:', data);
        genratePageNumbers(data.totalPages)

        // Access the 'content' array from the paginated response
        const products = data.content;

        if (!Array.isArray(products) || products.length === 0) {
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

        // Create table headers (excluding 'categoryId' if necessary)
        headers.forEach(header => {
            if (header !== "categoryId") { // Adjust based on your requirements
                const th = document.createElement('th');
                th.textContent = header.charAt(0).toUpperCase() + header.slice(1); // Capitalize header names
                tableHeadRow.appendChild(th);
            }
        });

        // Create table rows dynamically
        products.forEach(product => {
            const row = document.createElement('tr');

            // Loop through each key in the product object to create cells
            headers.forEach(header => {
                if (header !== "categoryId") { // Adjust based on your requirements
                    const cell = document.createElement('td');
                    cell.textContent = product[header] !== null ? product[header] : 'N/A';  // Handle null values
                    row.appendChild(cell);
                }
            });

            tableBody.appendChild(row);
        });

    } catch (error) {
        console.error('Error fetching the products:', error);
        const tableBody = document.getElementById('tableBody');
        tableBody.innerHTML = '<tr><td colspan="100%">Error loading products.</td></tr>';
    }
}

// Function to populate <a> tags with fetched category data
function populateLinks(categories) {
    const linksContainer = document.getElementById('myDropdownFilterCategories');
    linksContainer.innerHTML = ''; // Clear previous links

    // Create an <a> tag for each category
    categories.forEach(category => {
        const id = category.category_id;
        const link = document.createElement('a');
        link.href = `#`; // Set the href attribute
        link.onclick = function () {
            ChangeapiEndPointCategory(id);
        };
        link.textContent = category.category_name; // Ensure 'category_name' exists in your data

        linksContainer.appendChild(link); // Append the link to the container
    });
}

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

function ChangeapiEndPointCategory(id) {
    if(baseURL != 'http://localhost:8080/api/products/table/paginated/category/'){
        baseURL = 'http://localhost:8080/api/products/table/paginated/category/';
    }
    ChangeapiEndPoint(baseURL  + id)
}

// change api for table
function ChangeapiEndPoint(URL, page = 0, size = pageSize, sort = sortBy, directionOrder = direction) {
    const endpoint = `${URL}?page=${page}&size=${size}&sortBy=${sort}&direction=${directionOrder}`;
    loadProducts(endpoint);
}

function changePageSize(newSize) {
    console.log('Changing page size to:', newSize);
    pageSize = newSize;
    // Optionally, reload products with the new page size
    const newEndpoint = `${baseURL}/paginated?page=${pageNumber}&size=${pageSize}&sortBy=${sortBy}&direction=${direction}`;
    loadProducts(newEndpoint);
    fetchTotalPageCount('http://localhost:8080/api/products/table/pages/', pageSize);
}

// Function to generate page numbers for pagination
function genratePageNumbers(pageCount) {
    const pageNumberContainer = document.getElementById('pagination-container');
    pageNumberContainer.innerHTML = '';
    for (let i = 0; i < pageCount; i++) {
        const li = document.createElement('li');
        const a = document.createElement('a');
        li.id = 'pageNumber';
        a.href = '#';
        a.onclick = function () {
            ChangeapiEndPoint(`${baseURL}/paginated/category/`, i);
        };
        a.textContent = i + 1;
        li.appendChild(a);

        pageNumberContainer.appendChild(li);
    }
}

function changePage(){

}

// Load the data when the page loads
window.onload = () => {
    const initialEndpoint = `${baseURL}/paginated?page=0&size=${pageSize}&sortBy=${sortBy}&direction=${direction}`;
    loadProducts(initialEndpoint);
    const categoryEndpoint = 'http://localhost:8080/api/category';
    fetchCategories(categoryEndpoint); // Populate category filter
};
