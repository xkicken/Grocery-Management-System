CREATE OR REPLACE VIEW product_table_display AS
Select product_name,
       category_name,
       price,
       cost_price,
       stock_quantity,
       unit_of_measure,
       min_stock_quantity,
       reorder_level,
       shelf_location,
       plu_code,
       barcode,
       expiration_date,
       is_active,
       date_added
FROM products
         INNER JOIN categories
                    on products.category_id = categories.category_id

DROP VIEW product_table_display