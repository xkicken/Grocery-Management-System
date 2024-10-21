-- Table for Categories
CREATE TABLE IF NOT EXISTS Categories (
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL
    );

CREATE TABLE TransactionTypes (
  transaction_type_id SERIAL PRIMARY KEY,
  transaction_type_name VARCHAR(255) NOT NULL,
  description TEXT
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

    -- Table for Inventory
CREATE TABLE IF NOT EXISTS InventoryTransactions (
     inventory_transaction_id SERIAL PRIMARY KEY ,
     product_id INT,
     quantity_difference INT DEFAULT 0,
     transaction_type_id INT,
     transaction_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     FOREIGN KEY (product_id) REFERENCES Products(product_id),
     FOREIGN KEY (transaction_type_id) REFERENCES TransactionTypes(transaction_type_id)
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

CREATE VIEW inventory_table_display AS
SELECT
    it.inventory_transaction_id,
    it.product_id,
    p.product_name,
    it.quantity_difference,
    it.transaction_type_id,
    tt.transaction_type_name,
    it.transaction_time
    FROM
    InventoryTransactions it
        INNER JOIN
    Products p ON it.product_id = p.product_id
        INNER JOIN
    TransactionTypes tt ON it.transaction_type_id = tt.transaction_type_id;


