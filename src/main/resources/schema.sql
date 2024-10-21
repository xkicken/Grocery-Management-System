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
    min_stock_quantity INT DEFAULT NULL,
    cost_price DECIMAL(10, 2),
    reorder_level INT DEFAULT NULL,
    unit_of_measure VARCHAR(20),
    shelf_location VARCHAR(50),
    plu_code VARCHAR(20),
    barcode VARCHAR(50),
    is_active BOOLEAN DEFAULT TRUE,
    date_added DATE DEFAULT CURRENT_DATE,
    version INT DEFAULT 0,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
    );

CREATE VIEW products_table_display AS
SELECT
    p.product_id,
    p.product_name,
    p.category_id,
    c.category_name,
    p.price,
    p.cost_price,
    p.unit_of_measure,
    p.min_stock_quantity,
    p.reorder_level,
    p.shelf_location,
    p.plu_code,
    p.barcode,
    p.is_active
FROM
    Products p
        INNER JOIN
    Categories c ON p.category_id = c.category_id;


