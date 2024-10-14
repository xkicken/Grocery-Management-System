let pageSize = 20;
let pageNumber = 0;
let currentPage = 0;
let sortBy = 'productId';
let direction = 'asc';
let baseURL = 'http://localhost:8080/api/products/table/paginated';

// Function to fetch categories from the API
async function fetchCategories(apiEndpoint) {
    try {
        const response = await fetch(apiEndpoint);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const categories = await response.json();
        populateFormCategory(categories);
    } catch (error) {
        console.error('Error fetching categories:', error);
        document.getElementById('myDropdownFilterCategories').innerHTML = 'Error fetching categories.';
    }
}

async function fetchCategoriesForm(apiEndpoint) {
    try {
        const response = await fetch(apiEndpoint);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const categories = await response.json();
        populateFormCategory(categories);
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

        const th = document.createElement('th');
        th.textContent = "edit";
        tableHeadRow.appendChild(th);
        
        
        
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
            
            const td = document.createElement('td');
            
            const a = document.createElement('a');
            a.href = '#'
            a.classList.add('productEditButton');
            a.onclick = function () {
                productEditForm(product.productId, product.productName, product.categoryId, product.categoryName, product.price, product.costPrice, product.unitofMeasure, product.shelfLocation, product.pluCode, product.barcode);
            }
            
            const img = document.createElement('img');
            img.src = '../static/images/icons/edit-button-svgrepo-com.svg'
            a.appendChild(img);
            td.appendChild(a);
            row.appendChild(td);
            
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

function populateFormCategory(categories) {
    const selectElement = document.getElementById('category');
    selectElement.innerHTML = '';
    
    categories.forEach(category => {
        const optionElement = document.createElement('option');
        optionElement.textContent = category.category_name;
        optionElement.value = category.category_id;
        selectElement.appendChild(optionElement);
    })
}

function toggleDropdown(id) {
    const dropdown = document.getElementById(id);
    dropdown.classList.toggle('show');
}

window.onclick = function(event) {
    // Check if the click was outside the dropdown button and its content
    if (!event.target.matches('.dropbtn') && !event.target.closest('.dropbtn-content')) {
        const dropdowns = document.getElementsByClassName("dropdown-content");
        for (let i = 0; i < dropdowns.length; i++) {
            const openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show'); // Close the dropdown
            }
        }
    }
};

// Optional: Add event listener directly to the dropbtn-content
document.querySelector('.dropbtn-content').addEventListener('click', function(event) {
    event.stopPropagation(); // Prevent the click from propagating to window
    toggleDropdown('myDropdown'); // Toggle the dropdown explicitly
});

function ChangeapEndPointPage(pageNumber){
    console.log(pageNumber);
    currentPage = pageNumber;
    ChangeapiEndPoint(baseURL, pageNumber);
}

function ChangeapiEndPointCategory(id) {
    if(baseURL != 'http://localhost:8080/api/products/table/paginated/category/'){
        baseURL = 'http://localhost:8080/api/products/table/paginated/category/' + id;
    }
    ChangeapiEndPoint(baseURL)
}

// change api for table
function ChangeapiEndPoint(URL, page = 0, size = pageSize, sort = sortBy, directionOrder = direction) {
    const endpoint = `${URL}?page=${page}&size=${size}&sortBy=${sort}&direction=${directionOrder}`;
    loadProducts(endpoint);
}

function changePageSize(newSize) {
    console.log(baseURL)
    console.log('Changing page size to:', newSize);
    pageSize = newSize;
    ChangeapiEndPoint(baseURL, 0, pageSize);
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
            ChangeapEndPointPage(i);
        };
        a.textContent = i + 1;
        li.appendChild(a);

        pageNumberContainer.appendChild(li);
    }
}

function openEdit(){
    document.getElementById("editForm").style.display = "block";
}

function closeEdit(){
    document.getElementById("editForm").style.display = "none";
}

document.addEventListener('DOMContentLoaded', function() {
    const toggleLink = document.getElementById('toggleLink');
    const toggleText = document.getElementById('toggleText'); // Select the text span
    let asc = true;

    toggleLink.addEventListener('click', function(event) {
        event.preventDefault();

        // Select the arrow image using its class
        const arrowImage = toggleLink.querySelector('.arrow-icon');

        if (asc) {
            sortByPriceASC(); // Call function for ascending sort
            arrowImage.src = "../static/images/icons/arrowhead-down-svgrepo-com.svg"; // Update the image source
            toggleText.textContent = "Product Name Descending"; // Update link text
        } else {
            sortByPriceDESC(); // Call function for descending sort
            arrowImage.src = "../static/images/icons/arrowhead-up-svgrepo-com.svg"; // Update the image source
            toggleText.textContent = "Product Name Ascending"; // Update link text
        }

        asc = !asc; // Toggle the state
    });
});



function sortByPriceASC(){
    ChangeapiEndPoint(baseURL, pageNumber, pageSize, 'productName', 'asc');
}

function sortByPriceDESC(){
    ChangeapiEndPoint(baseURL, pageNumber, pageSize, 'productName', 'desc');
}

document.getElementById('editForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const productName = document.getElementById('productName').value;
    const category = document.getElementById('category').value;
    const price = document.getElementById('price').value;
    const costPrice = document.getElementById('costPrice').value;
    const unitofMeasure = document.getElementById('unitofMeasure').value;
    const shelfLocation = document.getElementById('shelfLocation').value;
    const pluCode = document.getElementById('pluCode').value;
    const barcode = document.getElementById('barcode').value;
    

    const data = {
        productName : productName,
        category: category,
        price : price,
        costPrice : costPrice,
        unitofMeasure : unitofMeasure,
        shelfLocation : shelfLocation,
        pluCode : pluCode,
        barcode : barcode,
    };

    fetch(`https://example.com/api/products/${productId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json())
        .then(data => {
            alert('Product updated successfully!');
        })
        .catch(error => {
            console.error('Error:', error);
            alert('An error occurred while updating the product.');
        });
});

function productEditForm(productId, productName, categoryId, categoryName, price, costPrice, unitofMeasure, shelfLocation, pluCode, barcode) {
    
    const formContainer = document.getElementById('formContainer');
    
    formContainer.classList.toggle('hidden');
    
    if(!formContainer.classList.contains('hidden')) {
        
        formContainer.innerHTML = '';
        
        const form = document.createElement('form');
        
        const productNameLabel = document.createElement('label');
        productNameLabel.setAttribute('for', 'productName');
        productNameLabel.textContent = 'Product Name'
        form.appendChild(productNameLabel);
        
        const productNameInput = document.createElement('input');
        productNameInput.type = 'text';
        productNameInput.placeholder = productName;
        productNameInput.id = 'productName';
        productNameInput.required = true;
        form.appendChild(productNameInput);
        
        const categoryIdLabel = document.createElement('label');
        categoryIdLabel.setAttribute('for', 'category');
        categoryIdLabel.textContent = 'Category Name'
        form.appendChild(categoryIdLabel);
        
        const categoryIdSelect = document.createElement('select');
        categoryIdSelect.type = 'select';
        categoryIdSelect.id = 'category'
        formContainer.appendChild(categoryIdSelect);
        
        fetchCategoriesForm('http://localhost:8080/api/category')
    }
    
}


// Load the data when the page loads
window.onload = () => {
    const initialEndpoint = `${baseURL}?page=0&size=${pageSize}&sortBy=${sortBy}&direction=${direction}`;
    loadProducts(initialEndpoint);
    const categoryEndpoint = 'http://localhost:8080/api/category';
    fetchCategories(categoryEndpoint)
};