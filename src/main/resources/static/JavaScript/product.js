let pageSize = 20;
let pageNumber = 0;
let currentPage = 0;
let sortBy = 'productId';
let direction = 'asc';
let baseURL = 'http://localhost:8080/api/products/table/paginated';
let url = '';
let searchBaseURL ='http://localhost:8080/api/products/table/paginated/search?page=0&size=' + pageSize +'&query=';

// Function to fetch categories from the API
async function fetchCategories(apiEndpoint) {
    try {
        const response = await fetch(apiEndpoint);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const categories = await response.json();
        populateLinks(categories);
    } catch (error) {
        console.error('Error fetching categories:', error);
        document.getElementById('myDropdownFilterCategories').innerHTML = 'Error fetching categories.';
    }
}

async function fetchCategoriesForm(apiEndpoint, categoryId) {
    try {
        const response = await fetch(apiEndpoint);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const categories = await response.json();
        populateFormCategory(categories, categoryId);
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
        generatePageNumbers(data.totalPages)

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
        th.textContent = "";

        const createButton = document.createElement('a');
        createButton.href = '#';
        createButton.classList.add('productButton')
        createButton.style.backgroundColor = '#28a745'
        createButton.onclick = function () {
            productCreateForm()
        }

        const createImg = document.createElement('img');
        createImg.src = '../static/images/icons/create-svgrepo-com.svg'

        createButton.appendChild(createImg);
        th.appendChild(createButton);
        tableHeadRow.appendChild(th);
        
        
        
        // Create table headers (excluding 'categoryId')
        headers.forEach(header => {
            if (header !== "categoryId") {
                const th = document.createElement('th');
                header = header.replace(/([A-Z])/g, ' $1').trim();
                th.textContent = header.charAt(0).toUpperCase() + header.slice(1);
                tableHeadRow.appendChild(th);
            }
        });

        // Create table rows dynamically
        products.forEach(product => {
            const row = document.createElement('tr');
            
            const td = document.createElement('td');
            
            const buttonDiv = document.createElement('ul');
            buttonDiv.classList.add('productEdit');
            
            const updateButton = document.createElement('a');
            updateButton.href = '#'
            updateButton.classList.add('productButton');
            updateButton.style.backgroundColor = "#007bff";
            updateButton.onclick = function () {
                productEditForm(product.productId, product.productName, product.categoryId, product.categoryName, product.price, product.costPrice, product.unitOfMeasure, product.minStockQuantity, product.reorderLevel, product.shelfLocation, product.pluCode, product.barcode);
            }
            
            const imgUpdate = document.createElement('img');
            imgUpdate.src = '../static/images/icons/edit-button-svgrepo-com.svg'
            updateButton.appendChild(imgUpdate);
            buttonDiv.appendChild(updateButton);
            
            const deleteButton = document.createElement('a');
            deleteButton.href = '#'
            deleteButton.classList.add('productButton');
            deleteButton.classList.add('productDelete');
            deleteButton.style.backgroundColor = '#dc3545';
            deleteButton.onclick = function () {
                confirmDelete(product.productId, product.productName)
            }
            
            const imgDelete = document.createElement('img');
            imgDelete.src = '../static/images/icons/delete-button-svgrepo-com.svg'
            deleteButton.appendChild(imgDelete);
            buttonDiv.appendChild(deleteButton);
            td.appendChild(buttonDiv);
            row.appendChild(td);

            headers.forEach(header => {
                if (header !== "categoryId") {
                    const cell = document.createElement('td');
                    cell.textContent = product[header] !== null ? product[header] : 'N/A';
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

function populateLinks(categories) {
    const linksContainer = document.getElementById('myDropdownFilterCategories');
    linksContainer.innerHTML = '';
    categories.forEach(category => {
        const id = category.category_id;
        const link = document.createElement('a');
        link.href = `#`;
        link.onclick = function () {
            ChangeapiEndPointCategory(id);
        };
        link.textContent = category.category_name;

        linksContainer.appendChild(link);
    });
}

function populateFormCategory(categories, categoryId) {
    const selectElement = document.getElementById('category');
    selectElement.innerHTML = '';
    
    categories.forEach(category => {
        const optionElement = document.createElement('option');
        optionElement.textContent = category.category_name;
        optionElement.value = category.category_id;
        if(category.category_id === categoryId) {
            optionElement.selected = true;
        }
        selectElement.appendChild(optionElement);
    })
}

function toggleDropdown(id) {
    const dropdown = document.getElementById(id);
    dropdown.classList.toggle('show');
}

window.onclick = function(event) {
    if (!event.target.matches('.dropbtn') && !event.target.closest('.dropbtn-content')) {
        const dropdowns = document.getElementsByClassName("dropdown-content");
        for (let i = 0; i < dropdowns.length; i++) {
            const openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
};

document.querySelector('.dropbtn-content').addEventListener('click', function(event) {
    event.stopPropagation();
    toggleDropdown('myDropdown');
});

function generatePageNumbers(pageCount) {
    const paginationContainer = document.getElementById('pagination-container');
    const paginationList = document.createElement('ul');
    paginationList.className = 'pagination';
    paginationContainer.innerHTML = '';

    for (let i = 0; i < pageCount; i++) {
        const li = document.createElement('li');
        const a = document.createElement('a');
        a.href = '#';
        a.textContent = i + 1;

        a.addEventListener('click', function(event) {
            event.preventDefault();
            ChangeapEndPointPage(i);
            currentPage = i
            highlightActivePage(i);
        });

        li.appendChild(a);
        paginationList.appendChild(li);


        if (i === currentPage) {
            a.classList.add('active');
        }
    }

    paginationContainer.appendChild(paginationList);
}

function highlightActivePage(activeIndex) {
    const pageLinks = document.querySelectorAll('.pagination a');
    console.log(pageLinks);
    pageLinks.forEach((link, index) => {
        if (index === activeIndex) {
            console.log('active page add', activeIndex);
            console.log(link);
            link.classList.add('active');
        } else {
            console.log('active page remove', activeIndex);
            link.classList.remove('active');
        }
    });
    console.log(pageLinks);
}

document.addEventListener('DOMContentLoaded', function() {
    const toggleLinkName = document.getElementById('toggleLinkName');
    const toggleTextName = document.getElementById('toggleTextName');
    let nameasc = true;

    toggleLinkName.addEventListener('click', function(event) {
        event.preventDefault();

        const arrowImage = toggleLinkName.querySelector('.arrow-icon');

        if (nameasc) {
            sortByASC('productName');
            arrowImage.src = "../static/images/icons/arrowhead-down-svgrepo-com.svg";
            toggleTextName.textContent = "Product Name Descending";
        } else {
            sortByDESC('productName');
            arrowImage.src = "../static/images/icons/arrowhead-up-svgrepo-com.svg";
            toggleTextName.textContent = "Product Name Ascending";
        }

        nameasc = !nameasc;
    });
});

document.addEventListener('DOMContentLoaded', function() {
    const toggleLinkPrice = document.getElementById('toggleLinkPrice');
    const toggleTextPrice = document.getElementById('toggleTextPrice');
    let priceasc = true;

    toggleLinkPrice.addEventListener('click', function(event) {
        event.preventDefault();

        const arrowImage = toggleLinkPrice.querySelector('.arrow-icon');

        if (priceasc) {
            sortByASC('price');
            arrowImage.src = "../static/images/icons/arrowhead-down-svgrepo-com.svg";
            toggleTextPrice.textContent = "Product Price Descending";
        } else {
            sortByDESC('price');
            arrowImage.src = "../static/images/icons/arrowhead-up-svgrepo-com.svg";
            toggleTextPrice.textContent = "Product Price Ascending";
        }

        priceasc = !priceasc;
    });
});

function sortByASC(sortBy){
    currentPage = 0
    ChangeapiEndPoint(baseURL, pageNumber, pageSize, sortBy, 'asc');
}

function sortByDESC(sortBy){
    currentPage = 0
    ChangeapiEndPoint(baseURL, pageNumber, pageSize, sortBy, 'desc');
}

function productEditForm(productId, productName, categoryId, categoryName, price, costPrice, unitOfMeasure, minStockQuantity, reorderLevel,shelfLocation, pluCode, barcode) {
    const formContainer = document.getElementById('formContainer');
    const popup = document.getElementById('myForm');

    // Toggle the visibility of the popup
    if (popup.style.display === "flex") {
        popup.style.display = "none";
        formContainer.innerHTML = '';
        return;
    } else {
        popup.style.display = "flex";
    }

    formContainer.innerHTML = '';

    const fields = [
        { id: 'productName', label: 'Product Name', type: 'text', placeholder: productName },
        { id: 'category', label: 'Category Name', type: 'select', placeholder: categoryName },
        { id: 'price', label: 'Price', type: 'text', placeholder: price },
        { id: 'costPrice', label: 'Cost', type: 'text', placeholder: costPrice },
        { id: 'unitOfMeasure', label: 'Unit of Measure', type: 'text', placeholder: unitOfMeasure },
        { id: 'minStockQuantity', label: 'Min Stick Quantity' , type: 'text', placeholder: minStockQuantity },
        { id: 'reorderLevel', label: 'Reorder level', type: 'text', placeholder: reorderLevel },
        { id: 'shelfLocation', label: 'Shelf Location', type: 'text', placeholder: shelfLocation },
        { id: 'pluCode', label: 'Plu Code', type: 'text', placeholder: pluCode },
        { id: 'barcode', label: 'Barcode', type: 'text', placeholder: barcode },
    ];

    fields.forEach(field => {
        const label = document.createElement('label');
        label.setAttribute('for', field.id);
        label.textContent = field.label;
        formContainer.appendChild(label);

        if (field.type === 'select') {
            const select = document.createElement('select');
            select.id = field.id;
            formContainer.appendChild(select);

            fetchCategoriesForm('http://localhost:8080/api/category', categoryId);
        } else {
            const input = document.createElement('input');
            input.type = field.type;
            input.placeholder = field.placeholder;
            input.id = field.id;
            formContainer.appendChild(input);
        }
    });

    // Create close button
    const closeButton = document.createElement('button');
    closeButton.type = 'button';
    closeButton.textContent = 'Close';
    closeButton.onclick = function () {
        popup.style.display = 'none';
        formContainer.innerHTML = '';
    };
    formContainer.appendChild(closeButton);

    // Create submit button
    const submitButton = document.createElement('button');
    submitButton.type = 'submit';
    submitButton.textContent = 'Save';
    formContainer.appendChild(submitButton);

    // Handle form submission
    formContainer.onsubmit = function (event) {
        event.preventDefault();
        if(document.getElementById('productName').value === '') {
            document.getElementById('productName').value = productName;
        }
        if(document.getElementById('category').value === '') {
            document.getElementById('category').value = categoryName;
        }
        if(document.getElementById('price').value === '') {
            document.getElementById('price').value = price;
        }
        if(document.getElementById('costPrice').value === '') {
            document.getElementById('costPrice').value = costPrice;
        }
        if(document.getElementById('unitOfMeasure').value === '') {
            document.getElementById('unitOfMeasure').value = unitOfMeasure;
        }
        if(document.getElementById('shelfLocation').value === '') {
            document.getElementById('shelfLocation').value = shelfLocation;
        }
        if(document.getElementById('barcode').value === '') {
            document.getElementById('barcode').value = barcode;
        }
        if(document.getElementById('minStockQuantity').value === '') {
            document.getElementById('minStockQuantity').value = minStockQuantity;
        }
        if(document.getElementById('reorderLevel').value === '') {
            document.getElementById('reorderLevel').value = reorderLevel;
        }

        const formData = {
            productId,
            productName: document.getElementById('productName').value.trim(),
            categoryId: document.getElementById('category').value.trim(),
            price: document.getElementById('price').value.trim(),
            costPrice: document.getElementById('costPrice').value.trim(),
            unitOfMeasure: document.getElementById('unitOfMeasure').value.trim(),
            shelfLocation: document.getElementById('shelfLocation').value.trim(),
            pluCode: document.getElementById('pluCode').value.trim(),
            barcode: document.getElementById('barcode').value.trim(),
            minStockQuantity: document.getElementById('minStockQuantity').value.trim(),
            reorderLevel: document.getElementById('reorderLevel').value.trim(),
        };
        console.log('Form Data:', formData);


    fetch(`http://localhost:8080/api/products/${productId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
        .then(response => {
            if (response.status === 204) {
                alert('Product updated successfully');
                loadProducts(url);
            } else {
                return response.json().then(data => {
                    throw new Error(data.message || 'Failed to update product');
                });
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert('An error occurred while updating the product');
        });
        
        popup.style.display = 'none';
        formContainer.innerHTML = '';
    };
}

function confirmDelete(productId, productName) {
    const deleteContainer = document.getElementById('deleteContainer');
    const deletePopup = document.getElementById('deleteConfirm');

    deletePopup.style.display = "flex";

    deleteContainer.innerHTML = '';

    // Create confirmation message
    const message = document.createElement('p');
    message.textContent = `Are you sure you want to delete "${productName}"?`;
    deleteContainer.appendChild(message);

    // Create cancel button
    const cancelButton = document.createElement('button');
    cancelButton.textContent = 'Cancel';
    cancelButton.onclick = function () {
        deletePopup.style.display = 'none';
    };
    deleteContainer.appendChild(cancelButton);

    // Create confirm button
    const confirmButton = document.createElement('button');
    confirmButton.textContent = 'Confirm';
    confirmButton.onclick = function () {
        deleteProduct(productId);
        deletePopup.style.display = 'none';
    };
    deleteContainer.appendChild(confirmButton);
}

function deleteProduct(productId) {
    fetch(`http://localhost:8080/api/products/${productId}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (response.status === 204) {
                alert('Product deleted successfully');
                loadProducts(url);  // Reload the product list
            } else {
                return response.json().then(data => {
                    throw new Error(data.message || 'Failed to delete product');
                });
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert('An error occurred while deleting the product');
        });
}

function productCreateForm() {
    const formContainer = document.getElementById('formContainer');
    const popup = document.getElementById('myForm');

    popup.style.display = "flex";

    formContainer.innerHTML = '';

    const fields = [
        { id: 'productName', label: 'Product Name', type: 'text', placeholder: 'Enter product name' },
        { id: 'category', label: 'Category Name', type: 'select', placeholder: 'Select category' },
        { id: 'price', label: 'Price', type: 'text', placeholder: 'Enter price' },
        { id: 'costPrice', label: 'Cost', type: 'text', placeholder: 'Enter cost price' },
        { id: 'unitOfMeasure', label: 'Unit of Measure', type: 'text', placeholder: 'Enter unit of measure' },
        { id: 'minStockQuantity', label: 'Min Stick Quantity' , type: 'text', placeholder: 'Enter quantity' },
        { id: 'reorderLevel', label: 'Reorder level', type: 'text', placeholder: 'Enter reorder level' },
        { id: 'shelfLocation', label: 'Shelf Location', type: 'text', placeholder: 'Enter shelf location' },
        { id: 'pluCode', label: 'Plu Code', type: 'text', placeholder: 'Enter PLU code' },
        { id: 'barcode', label: 'Barcode', type: 'text', placeholder: 'Enter barcode' },
    ];

    fields.forEach(field => {
        const label = document.createElement('label');
        label.setAttribute('for', field.id);
        label.textContent = field.label;
        formContainer.appendChild(label);

        if (field.type === 'select') {
            const select = document.createElement('select');
            select.id = field.id;
            formContainer.appendChild(select);

            fetchCategoriesForm('http://localhost:8080/api/category');
        } else {
            const input = document.createElement('input');
            input.type = field.type;
            input.placeholder = field.placeholder;
            input.id = field.id;
            formContainer.appendChild(input);
        }
    });

    // Create close button
    const closeButton = document.createElement('button');
    closeButton.type = 'button';
    closeButton.textContent = 'Close';
    closeButton.onclick = function () {
        popup.style.display = 'none';
        formContainer.innerHTML = '';
    };
    formContainer.appendChild(closeButton);

    // Create submit button for new product creation
    const submitButton = document.createElement('button');
    submitButton.type = 'submit';
    submitButton.textContent = 'Save';
    formContainer.appendChild(submitButton);


    formContainer.onsubmit = function (event) {

        event.preventDefault();

        const formData = {
            productName: document.getElementById('productName').value.trim(),
            categoryId: document.getElementById('category').value.trim(),
            price: document.getElementById('price').value.trim(),
            costPrice: document.getElementById('costPrice').value.trim(),
            unitOfMeasure: document.getElementById('unitOfMeasure').value.trim(),
            shelfLocation: document.getElementById('shelfLocation').value.trim(),
            pluCode: document.getElementById('pluCode').value.trim() === '' ? null : document.getElementById('pluCode').value.trim(),
            barcode: document.getElementById('barcode').value.trim() === '' ? null : document.getElementById('barcode').value.trim(),
            minStockQuantity: document.getElementById('minStockQuantity').value.trim(),
            reorderLevel: document.getElementById('reorderLevel').value.trim(),
        };
        console.log("create new", formData);


        fetch('http://localhost:8080/api/products', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
            .then(response => {
                if(response.status === 204){
                    alert('Product created successfully');
                    loadProducts(url);
                } else{
                    return response.json().then(data => {
                        throw new Error(data.message || 'Failed to create product');
                    })
                }
            })
            .catch((error) => {
                console.error('Error:', error);
                alert('An error occurred while creating the product');
            });

        popup.style.display = 'none';
        formContainer.innerHTML = '';
    };
}

function ChangeapEndPointPage(pageNumber){
    ChangeapiEndPoint(baseURL, pageNumber);
}

function ChangeapiEndPointCategory(id) {
    currentPage = 0
    if(baseURL != 'http://localhost:8080/api/products/table/paginated/category/'){
        baseURL = 'http://localhost:8080/api/products/table/paginated/category/' + id;
    }
    ChangeapiEndPoint(baseURL)
}

//Change api for table
function ChangeapiEndPoint(URL, page = 0, size = pageSize, sort = sortBy, directionOrder = direction) {
    const endpoint = `${URL}?page=${page}&size=${size}&sortBy=${sort}&direction=${directionOrder}`;
    url = endpoint
    loadProducts(endpoint);
}

function changePageSize(newSize) {
    currentPage = 0;
    console.log('Changing page size to:', newSize);
    pageSize = newSize;
    ChangeapiEndPoint(baseURL, 0, pageSize);
}

function performSearch() {
    const searchInput = document.getElementById('searchInput');
    const query = searchInput.value;
    currentPage = 0;
    loadProducts(searchBaseURL + query);

}

// Load the data when the page loads
window.onload = () => {
    const initialEndpoint = `${baseURL}?page=0&size=${pageSize}&sortBy=${sortBy}&direction=${direction}`;
    url = initialEndpoint
    loadProducts(initialEndpoint);
    const categoryEndpoint = 'http://localhost:8080/api/category';
    fetchCategories(categoryEndpoint)
};