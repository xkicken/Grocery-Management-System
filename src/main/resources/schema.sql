-- Table for Categories
CREATE TABLE IF NOT EXISTS Categories (
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL
    );

-- Table for Products
CREATE TABLE IF NOT EXISTS Products (
    product_id SERIAL PRIMARY KEY ,
    product_name VARCHAR(100) NOT NULL,
    category_id INT,
    price DECIMAL(10, 2) NOT NULL,
    stock_quantity INT NOT NULL,
    min_stock_quantity INT DEFAULT NULL,
    cost_price DECIMAL(10, 2),
    reorder_level INT DEFAULT NULL,
    unit_of_measure VARCHAR(20),
    shelf_location VARCHAR(50),
    plu_code VARCHAR(20),
    barcode VARCHAR(50),
    expiration_date DATE,
    is_active BOOLEAN DEFAULT TRUE,
    date_added DATE DEFAULT CURRENT_DATE,
    version INT DEFAULT 0,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
    );

-- Table for Inventory
CREATE TABLE IF NOT EXISTS Inventory (
     inventory_id SERIAL PRIMARY KEY ,
     product_id INT,
     quantity_in INT DEFAULT 0,
     quantity_out INT DEFAULT 0,
     transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     FOREIGN KEY (product_id) REFERENCES Products(product_id)
    );

-- Table for Sales Orders
CREATE TABLE IF NOT EXISTS SalesOrders (
    order_id SERIAL PRIMARY KEY ,
    customer_id INT DEFAULT NULL,  -- Optional foreign key to link to a Customers table
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10, 2) NOT NULL
    );

-- Table for Sales Order Items
CREATE TABLE IF NOT EXISTS SalesOrderItems (
    order_item_id SERIAL PRIMARY KEY ,
    order_id INT,
    product_id INT,
    quantity_sold INT NOT NULL,
    sale_amount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES SalesOrders(order_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
    );

CREATE TABLE IF NOT EXISTS Customers (
    customer_id SERIAL PRIMARY KEY ,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone_number VARCHAR(20),
    address VARCHAR(255),
    city VARCHAR(100),
    postal_code VARCHAR(20),
    date_added TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );
