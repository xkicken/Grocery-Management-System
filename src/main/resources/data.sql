-- Insert into Categories
INSERT INTO Categories (category_name) VALUES
    ('Beverages'),
    ('Snacks'),
    ('Dairy'),
    ('Household Supplies'),
    ('Frozen Foods'),
    ('Bakery'),
    ('Fruits'),
    ('Vegetables'),
    ('Meat'),
    ('Seafood'),
    ('Personal Care'),
    ('Health & Wellness'),
    ('Cleaning Supplies'),
    ('Electronics'),
    ('Pet Supplies'),
    ('Baby Products');

-- Insert into Products
INSERT INTO Products (
    product_name,
    category_id,
    price,
    min_stock_quantity,
    cost_price,
    reorder_level,
    unit_of_measure,
    shelf_location,
    plu_code,
    barcode,
    is_active
) VALUES
      -- Beverages
      ('Cola 1L', 1, 1.50, 50, 1.00, 100, 'Bottle', 'A1', NULL, '4006381333931', TRUE),
      ('Orange Juice 1L', 1, 2.50, 30, 2.00, 70, 'Bottle', 'A2', NULL, '4897036690542', TRUE),
      ('Green Tea 500ml', 1, 2.00, 25, 1.50, 65, 'Bottle', 'A3', NULL, '4902432214393', TRUE),
      ('Black Coffee 1L', 1, 3.00, 20, 2.00, 45, 'Bottle', 'A4', NULL, '4006381333931', TRUE),
      ('Mineral Water 500ml', 1, 1.00, 60, 0.60, 120, 'Bottle', 'A5', NULL, '0123456789012', TRUE),
      ('Lemonade 1L', 1, 2.80, 40, 1.80, 80, 'Bottle', 'A6', NULL, '3006381333931', TRUE),
      ('Coconut Water 500ml', 1, 3.50, 30, 2.50, 50, 'Bottle', 'A7', NULL, '5023487895431', TRUE),

      -- Snacks
      ('Potato Chips 200g', 2, 2.00, 20, 1.20, 50, 'Packet', 'B1', NULL, '5000112617961', TRUE),
      ('Pretzels 150g', 2, 1.80, 25, 1.10, 60, 'Packet', 'B2', NULL, '0012993445906', TRUE),
      ('Trail Mix 250g', 2, 3.50, 15, 2.50, 40, 'Packet', 'B3', NULL, '0744705503426', TRUE),
      ('Granola Bars 6 Pack', 2, 4.00, 10, 3.00, 35, 'Box', 'B4', NULL, '0123456789123', TRUE),
      ('Popcorn 100g', 2, 1.50, 30, 0.90, 75, 'Packet', 'B5', NULL, '0123456789234', TRUE),
      ('Rice Cakes 100g', 2, 2.50, 18, 1.50, 20, 'Packet', 'B6', NULL, '0123456789345', TRUE),
      ('Beef Jerky 100g', 2, 4.00, 12, 2.50, 10, 'Packet', 'B7', NULL, '0123456789456', TRUE),

      -- Dairy
      ('Milk 1L', 3, 1.30, 40, 0.90, 90, 'Carton', 'C1', NULL, '8714100772047', TRUE),
      ('Butter 250g', 3, 3.50, 15, 2.00, 30, 'Block', 'C2', NULL, '0505503125087', TRUE),
      ('Cheddar Cheese 200g', 3, 4.00, 12, 2.50, 25, 'Block', 'C3', NULL, '0123456789345', TRUE),
      ('Yogurt 500g', 3, 2.50, 20, 1.50, 45, 'Cup', 'C4', NULL, '0123456789456', TRUE),
      ('Cream 300ml', 3, 2.00, 25, 1.20, 50, 'Bottle', 'C5', NULL, '0123456789567', TRUE),
      ('Sour Cream 300g', 3, 2.50, 15, 1.80, 40, 'Cup', 'C6', NULL, '0123456789678', TRUE),
      ('Greek Yogurt 500g', 3, 3.50, 20, 2.00, 50, 'Cup', 'C7', NULL, '0123456789789', TRUE),

      -- Household Supplies
      ('Laundry Detergent 1L', 4, 5.00, 20, 3.00, 40, 'Bottle', 'H1', NULL, '5010123700481', TRUE),
      ('Dish Soap 500ml', 4, 2.50, 25, 1.50, 50, 'Bottle', 'H2', NULL, '8001090596211', TRUE),
      ('Paper Towels 6 Rolls', 4, 3.00, 15, 1.80, 30, 'Pack', 'H3', NULL, '0123456789678', TRUE),
      ('Trash Bags 20 Pack', 4, 4.50, 18, 2.50, 35, 'Box', 'H4', NULL, '0123456789789', TRUE),
      ('Glass Storage Containers 12 Pack', 4, 6.00, 12, 3.50, 25, 'Set', 'H5', NULL, '0123456789890', TRUE),
      ('Sponges 6 Pack', 4, 3.00, 40, 2.00, 50, 'Pack', 'H6', NULL, '0123456789901', TRUE),
      ('Disinfectant Spray 500ml', 4, 4.50, 25, 3.00, 30, 'Bottle', 'H7', NULL, '0123456789912', TRUE),

      -- Frozen Foods
      ('Frozen Pizza 500g', 5, 6.00, 15, 4.00, 35, 'Pack', 'I1', NULL, '0500015704884', TRUE),
      ('Frozen Vegetables 1kg', 5, 3.00, 20, 2.00, 45, 'Pack', 'I2', NULL, '0005000070116', TRUE),
      ('Ice Cream 1L', 5, 5.50, 12, 3.50, 30, 'Carton', 'I3', NULL, '0123456790001', TRUE),
      ('Frozen Berries 500g', 5, 4.00, 16, 2.50, 32, 'Pack', 'I4', NULL, '0123456790112', TRUE),
      ('Frozen Lasagna 400g', 5, 7.00, 11, 4.50, 28, 'Pack', 'I5', NULL, '0123456790223', TRUE),
      ('Frozen Fries 1kg', 5, 3.50, 20, 2.20, 45, 'Pack', 'I6', NULL, '0123456790334', TRUE),
      ('Frozen Chicken Nuggets 500g', 5, 5.00, 15, 3.00, 35, 'Pack', 'I7', NULL, '0123456790445', TRUE),

      -- Bakery
      ('Whole Wheat Bread 500g', 6, 2.00, 15, 1.20, 30, 'Loaf', 'J1', NULL, '5012991010090', TRUE),
      ('Croissant 100g', 6, 1.50, 20, 0.80, 40, 'Piece', 'J2', NULL, '0049000018807', TRUE),
      ('Bagel 150g', 6, 1.80, 18, 1.00, 35, 'Piece', 'J3', NULL, '0123456790334', TRUE),
      ('Sourdough Bread 600g', 6, 2.50, 16, 1.50, 33, 'Loaf', 'J4', NULL, '0123456790445', TRUE),
      ('Baguette 250g', 6, 1.70, 19, 0.90, 38, 'Piece', 'J5', NULL, '0123456790556', TRUE),
      ('Danish Pastry 80g', 6, 1.20, 25, 0.70, 50, 'Piece', 'J6', NULL, '0123456790667', TRUE),
      ('Chocolate Chip Cookies 300g', 6, 3.00, 10, 2.00, 25, 'Pack', 'J7', NULL, '0123456790778', TRUE),

      -- Pet Supplies
      ('Dog Food 1.5kg', 15, 15.00, 25, 10.00, 15, 'Bag', 'P1', NULL, '0023456789012', TRUE),
      ('Cat Food 1kg', 15, 12.00, 20, 8.00, 10, 'Bag', 'P2', NULL, '0034567890123', TRUE),
      ('Dog Treats 500g', 15, 8.00, 30, 5.00, 20, 'Bag', 'P3', NULL, '0045678901234', TRUE),
      ('Cat Litter 5kg', 15, 20.00, 15, 15.00, 12, 'Bag', 'P4', NULL, '0056789012345', TRUE),
      ('Dog Toys', 15, 10.00, 25, 6.00, 18, 'Unit', 'P5', NULL, '0067890123456', TRUE),
      ('Cat Toys', 15, 9.00, 30, 5.00, 15, 'Unit', 'P6', NULL, '0078901234567', TRUE),

      -- Baby Products
      ('Diapers Size 4', 16, 25.00, 15, 20.00, 10, 'Pack', 'B1', NULL, '0800017000000', TRUE),
      ('Baby Wipes 80 Pack', 16, 3.50, 30, 2.00, 15, 'Pack', 'B2', NULL, '0800017000001', TRUE),
      ('Baby Formula 900g', 16, 40.00, 12, 35.00, 8, 'Tin', 'B3', NULL, '0800017000002', TRUE),
      ('Pacifiers', 16, 5.00, 25, 3.00, 20, 'Unit', 'B4', NULL, '0800017000003', TRUE),
      ('Baby Shampoo 300ml', 16, 4.50, 20, 3.50, 15, 'Bottle', 'B5', NULL, '0800017000004', TRUE),
      ('Baby Lotion 400ml', 16, 5.50, 18, 4.00, 12, 'Bottle', 'B6', NULL, '0800017000005', TRUE),
-- Beverages
('Iced Tea 1L', 1, 2.50, 40, 1.50, 70, 'Bottle', 'A8', NULL, '0123456789023', TRUE),
      ('Fruit Punch 1L', 1, 2.80, 30, 1.80, 60, 'Bottle', 'A9', NULL, '0123456789134', TRUE),
      ('Energy Drink 500ml', 1, 3.50, 25, 2.20, 50, 'Can', 'A10', NULL, '0123456789245', TRUE),

      -- Snacks
      ('Chocolate Bar 100g', 2, 1.50, 20, 0.80, 50, 'Bar', 'B8', NULL, '0123456789356', TRUE),
      ('Fruit Snacks 150g', 2, 2.00, 15, 1.00, 40, 'Pack', 'B9', NULL, '0123456789467', TRUE),
      ('Granola 500g', 2, 4.00, 12, 2.50, 30, 'Pack', 'B10', NULL, '0123456789578', TRUE),
      ('Cookies 300g', 2, 3.50, 15, 2.00, 20, 'Pack', 'B11', NULL, '0123456789689', TRUE),
      ('Trail Mix 400g', 2, 5.00, 10, 3.00, 15, 'Pack', 'B12', NULL, '0123456789790', TRUE),

      -- Dairy
      ('Almond Milk 1L', 3, 3.00, 30, 2.20, 50, 'Carton', 'C8', NULL, '0123456789801', TRUE),
      ('Mozzarella Cheese 200g', 3, 5.00, 20, 3.50, 40, 'Block', 'C9', NULL, '0123456789912', TRUE),
      ('Ice Cream Sandwiches', 3, 6.00, 15, 4.50, 25, 'Box', 'C10', NULL, '0123456790023', TRUE),

      -- Household Supplies
      ('All-Purpose Cleaner 500ml', 4, 3.00, 20, 2.00, 30, 'Bottle', 'H8', NULL, '0123456790134', TRUE),
      ('Toilet Paper 12 Rolls', 4, 6.00, 15, 4.00, 25, 'Pack', 'H9', NULL, '0123456790245', TRUE),
      ('Scented Candles 3 Pack', 4, 8.00, 10, 5.00, 20, 'Pack', 'H10', NULL, '0123456790356', TRUE),

      -- Frozen Foods
      ('Frozen Meatballs 500g', 5, 8.00, 20, 5.00, 15, 'Pack', 'I8', NULL, '0123456790467', TRUE),
      ('Frozen Burritos 400g', 5, 5.00, 15, 3.50, 10, 'Pack', 'I9', NULL, '0123456790578', TRUE),
      ('Frozen Vegetables Mix 1kg', 5, 4.00, 12, 2.50, 8, 'Pack', 'I10', NULL, '0123456790689', TRUE),

      -- Bakery
      ('White Bread 500g', 6, 1.20, 25, 0.80, 35, 'Loaf', 'J8', NULL, '0123456790790', TRUE),
      ('Brownie Mix 500g', 6, 3.00, 20, 2.00, 30, 'Box', 'J9', NULL, '0123456790901', TRUE),
      ('Whole Wheat Baguette', 6, 1.80, 15, 1.00, 28, 'Piece', 'J10', NULL, '0123456791012', TRUE),

      -- Fruits
      ('Apples 1kg', 7, 3.00, 40, 2.00, 70, 'Bag', 'K1', NULL, '0123456791123', TRUE),
      ('Bananas 1kg', 7, 2.50, 35, 1.80, 60, 'Bag', 'K2', NULL, '0123456791234', TRUE),
      ('Grapes 500g', 7, 5.00, 20, 3.50, 50, 'Bag', 'K3', NULL, '0123456791345', TRUE),
      ('Pineapples 1kg', 7, 4.00, 25, 2.50, 40, 'Bag', 'K4', NULL, '0123456791456', TRUE),

      -- Vegetables
      ('Carrots 1kg', 8, 2.00, 40, 1.20, 80, 'Bag', 'L1', NULL, '0123456791567', TRUE),
      ('Potatoes 1kg', 8, 1.50, 50, 0.80, 90, 'Bag', 'L2', NULL, '0123456791678', TRUE),
      ('Broccoli 500g', 8, 2.50, 30, 1.50, 70, 'Bag', 'L3', NULL, '0123456791789', TRUE),
      ('Onions 1kg', 8, 1.80, 35, 1.20, 60, 'Bag', 'L4', NULL, '0123456791890', TRUE),

      -- Meat
      ('Chicken Breast 1kg', 9, 10.00, 20, 8.00, 15, 'Pack', 'M1', NULL, '0123456791901', TRUE),
      ('Ground Beef 500g', 9, 8.00, 25, 6.00, 12, 'Pack', 'M2', NULL, '0123456792012', TRUE),
      ('Pork Chops 1kg', 9, 12.00, 15, 9.00, 10, 'Pack', 'M3', NULL, '0123456792123', TRUE),
      ('Bacon 200g', 9, 5.00, 20, 3.50, 20, 'Pack', 'M4', NULL, '0123456792234', TRUE),

      -- Seafood
      ('Salmon Fillet 200g', 10, 8.00, 20, 6.00, 15, 'Pack', 'N1', NULL, '0123456792345', TRUE),
      ('Shrimp 500g', 10, 15.00, 10, 10.00, 5, 'Pack', 'N2', NULL, '0123456792456', TRUE),
      ('Tuna 300g', 10, 4.00, 25, 3.00, 20, 'Pack', 'N3', NULL, '0123456792567', TRUE),

      -- Personal Care
      ('Toothpaste 100ml', 11, 3.00, 40, 2.00, 50, 'Tube', 'O1', NULL, '0123456792678', TRUE),
      ('Shampoo 300ml', 11, 5.00, 30, 3.50, 40, 'Bottle', 'O2', NULL, '0123456792789', TRUE),
      ('Conditioner 300ml', 11, 5.00, 30, 3.50, 40, 'Bottle', 'O3', NULL, '0123456792890', TRUE),

      -- Health & Wellness
      ('Vitamins 100 Tabs', 12, 20.00, 15, 15.00, 10, 'Bottle', 'P1', NULL, '0123456792901', TRUE),
      ('Protein Powder 1kg', 12, 50.00, 10, 40.00, 8, 'Pack', 'P2', NULL, '0123456793012', TRUE),
      ('Fish Oil 90 Caps', 12, 25.00, 20, 18.00, 15, 'Bottle', 'P3', NULL, '0123456793123', TRUE),

      -- Cleaning Supplies
      ('Dish Soap 500ml', 13, 2.50, 30, 1.50, 40, 'Bottle', 'Q1', NULL, '0123456793234', TRUE),
      ('Laundry Detergent 1L', 13, 6.00, 20, 4.00, 25, 'Bottle', 'Q2', NULL, '0123456793345', TRUE),
      ('Glass Cleaner 500ml', 13, 3.00, 25, 2.00, 15, 'Bottle', 'Q3', NULL, '0123456793456', TRUE),

      -- Electronics
      ('Wireless Earbuds', 14, 50.00, 15, 35.00, 10, 'Pair', 'R1', NULL, '0123456793567', TRUE),
      ('Smartphone', 14, 800.00, 10, 700.00, 5, 'Unit', 'R2', NULL, '0123456793678', TRUE),
      ('Bluetooth Speaker', 14, 100.00, 15, 70.00, 10, 'Unit', 'R3', NULL, '0123456793789', TRUE),

      -- Pet Supplies (Additional)
      ('Dog Food 3kg', 15, 30.00, 25, 25.00, 15, 'Bag', 'P7', NULL, '0123456793890', TRUE),
      ('Cat Food 3kg', 15, 28.00, 20, 22.00, 10, 'Bag', 'P8', NULL, '0123456793901', TRUE),
      ('Dog Shampoo 250ml', 15, 15.00, 25, 10.00, 15, 'Bottle', 'P9', NULL, '0123456794012', TRUE),
      ('Cat Litter 10kg', 15, 25.00, 15, 20.00, 12, 'Bag', 'P10', NULL, '0123456794123', TRUE),

      -- Baby Products (Additional)
      ('Baby Powder 200g', 16, 6.00, 20, 4.00, 15, 'Container', 'B7', NULL, '0800017000006', TRUE),
      ('Baby Lotion 200ml', 16, 5.50, 18, 4.00, 12, 'Bottle', 'B8', NULL, '0800017000007', TRUE),
      ('Baby Diapers Size 5', 16, 30.00, 15, 25.00, 10, 'Pack', 'B9', NULL, '0800017000008', TRUE),
      ('Baby Feeding Bottle 250ml', 16, 8.00, 20, 5.00, 15, 'Unit', 'B10', NULL, '0800017000009', TRUE),

      ('Herbal Tea 20 Bags', 1, 4.00, 40, 2.50, 70, 'Box', 'A11', NULL, '0123456789145', TRUE),
      ('Soda 330ml', 1, 1.20, 50, 0.70, 90, 'Can', 'A12', NULL, '0123456789256', TRUE),
      ('Lemonade 1L', 1, 2.50, 30, 1.50, 60, 'Bottle', 'A13', NULL, '0123456789367', TRUE),

      -- Snacks
      ('Potato Chips 150g', 2, 3.00, 25, 1.50, 60, 'Pack', 'B13', NULL, '0123456789478', TRUE),
      ('Popcorn 100g', 2, 2.50, 30, 1.00, 50, 'Pack', 'B14', NULL, '0123456789589', TRUE),
      ('Beef Jerky 50g', 2, 5.00, 20, 3.50, 40, 'Pack', 'B15', NULL, '0123456789690', TRUE),
      ('Rice Cakes 100g', 2, 2.80, 15, 1.50, 30, 'Pack', 'B16', NULL, '0123456789701', TRUE),

      -- Dairy
      ('Yogurt 200g', 3, 1.80, 50, 1.00, 40, 'Cup', 'C11', NULL, '0123456789812', TRUE),
      ('Cream Cheese 250g', 3, 3.00, 20, 2.00, 30, 'Pack', 'C12', NULL, '0123456789923', TRUE),
      ('Cottage Cheese 500g', 3, 4.50, 15, 3.00, 25, 'Container', 'C13', NULL, '0123456790034', TRUE),

      -- Household Supplies
      ('Trash Bags 50 Pack', 4, 10.00, 25, 7.00, 20, 'Pack', 'H11', NULL, '0123456790145', TRUE),
      ('Paper Towels 6 Rolls', 4, 5.00, 20, 3.00, 15, 'Pack', 'H12', NULL, '0123456790256', TRUE),
      ('Disinfecting Wipes 35 Pack', 4, 8.00, 15, 5.00, 10, 'Pack', 'H13', NULL, '0123456790367', TRUE),

      -- Frozen Foods
      ('Frozen Pizza 400g', 5, 8.00, 20, 5.00, 15, 'Pack', 'I11', NULL, '0123456790478', TRUE),
      ('Frozen French Fries 1kg', 5, 4.00, 25, 2.50, 10, 'Pack', 'I12', NULL, '0123456790589', TRUE),
      ('Frozen Chicken Nuggets 500g', 5, 7.00, 20, 4.50, 12, 'Pack', 'I13', NULL, '0123456790690', TRUE),

      -- Bakery
      ('Croissants 4 Pack', 6, 3.50, 20, 2.50, 25, 'Pack', 'J11', NULL, '0123456790701', TRUE),
      ('Bagels 6 Pack', 6, 4.00, 15, 2.50, 20, 'Pack', 'J12', NULL, '0123456790812', TRUE),
      ('Muffins 6 Pack', 6, 5.00, 15, 3.50, 18, 'Pack', 'J13', NULL, '0123456790923', TRUE),

      -- Fruits
      ('Mangoes 1kg', 7, 4.50, 35, 3.50, 50, 'Bag', 'K5', NULL, '0123456791034', TRUE),
      ('Strawberries 250g', 7, 3.00, 20, 2.00, 40, 'Pack', 'K6', NULL, '0123456791145', TRUE),
      ('Oranges 1kg', 7, 3.50, 40, 2.50, 70, 'Bag', 'K7', NULL, '0123456791256', TRUE),
      ('Peaches 500g', 7, 3.00, 25, 2.00, 30, 'Bag', 'K8', NULL, '0123456791367', TRUE),

      -- Vegetables
      ('Spinach 250g', 8, 2.50, 30, 1.50, 60, 'Bag', 'L5', NULL, '0123456791478', TRUE),
      ('Cabbage 1kg', 8, 1.80, 40, 1.00, 50, 'Piece', 'L6', NULL, '0123456791589', TRUE),
      ('Bell Peppers 500g', 8, 3.00, 25, 2.00, 40, 'Pack', 'L7', NULL, '0123456791690', TRUE),
      ('Zucchini 1kg', 8, 2.80, 20, 1.80, 30, 'Bag', 'L8', NULL, '0123456791701', TRUE),

      -- Meat
      ('Turkey Breast 1kg', 9, 11.00, 15, 9.00, 10, 'Pack', 'M5', NULL, '0123456791812', TRUE),
      ('Sausages 500g', 9, 7.00, 20, 5.00, 15, 'Pack', 'M6', NULL, '0123456791923', TRUE),
      ('Chicken Thighs 1kg', 9, 9.00, 20, 7.00, 10, 'Pack', 'M7', NULL, '0123456792034', TRUE),

      -- Seafood
      ('Crab Meat 200g', 10, 12.00, 15, 9.00, 10, 'Pack', 'N4', NULL, '0123456792145', TRUE),
      ('Fish Fillets 400g', 10, 10.00, 20, 7.00, 12, 'Pack', 'N5', NULL, '0123456792256', TRUE),
      ('Shrimp Scampi 500g', 10, 15.00, 10, 12.00, 8, 'Pack', 'N6', NULL, '0123456792367', TRUE),

      -- Personal Care
      ('Deodorant 150ml', 11, 4.00, 30, 2.50, 25, 'Stick', 'O4', NULL, '0123456792478', TRUE),
      ('Body Wash 400ml', 11, 5.50, 20, 3.50, 20, 'Bottle', 'O5', NULL, '0123456792589', TRUE),
      ('Face Cream 50ml', 11, 15.00, 15, 10.00, 10, 'Jar', 'O6', NULL, '0123456792690', TRUE),

      -- Health & Wellness
      ('Calcium Tablets 100 Tabs', 12, 18.00, 15, 12.00, 10, 'Bottle', 'P4', NULL, '0123456792701', TRUE),
      ('Energy Bars 6 Pack', 12, 12.00, 15, 8.00, 10, 'Pack', 'P5', NULL, '0123456792812', TRUE),
      ('Omega-3 Capsules 60 Caps', 12, 20.00, 10, 15.00, 8, 'Bottle', 'P6', NULL, '0123456792923', TRUE),

      -- Cleaning Supplies
      ('Toilet Cleaner 750ml', 13, 3.50, 25, 2.50, 15, 'Bottle', 'Q4', NULL, '0123456793034', TRUE),
      ('Oven Cleaner 500ml', 13, 5.00, 20, 4.00, 10, 'Bottle', 'Q5', NULL, '0123456793145', TRUE),
      ('All-Purpose Cleaner 1L', 13, 6.50, 15, 4.50, 10, 'Bottle', 'Q6', NULL, '0123456793256', TRUE),

      -- Electronics
      ('Smartwatch', 14, 150.00, 10, 120.00, 5, 'Unit', 'R4', NULL, '0123456793367', TRUE),
      ('Laptop', 14, 1200.00, 5, 1000.00, 3, 'Unit', 'R5', NULL, '0123456793478', TRUE),
      ('Tablet', 14, 300.00, 15, 250.00, 10, 'Unit', 'R6', NULL, '0123456793589', TRUE),

      -- Pet Supplies
      ('Cat Treats 200g', 15, 5.00, 25, 4.00, 15, 'Pack', 'P11', NULL, '0123456793690', TRUE),
      ('Dog Toys', 15, 10.00, 15, 6.00, 10, 'Unit', 'P12', NULL, '0123456793701', TRUE),
      ('Flea Treatment for Cats', 15, 20.00, 10, 15.00, 8, 'Pack', 'P13', NULL, '0123456793812', TRUE),

      -- Baby Products
      ('Baby Wipes 80 Pack', 16, 5.00, 20, 3.50, 15, 'Pack', 'B11', NULL, '0800017000010', TRUE),
      ('Baby Oil 200ml', 16, 6.00, 15, 4.50, 12, 'Bottle', 'B12', NULL, '0800017000020', TRUE),
      ('Baby Pacifier', 16, 3.00, 30, 1.50, 20, 'Unit', 'B13', NULL, '0800017000030', TRUE),

-- Beverages
    ('Sparkling Water 1L', 1, 2.00, 50, 1.00, 80, 'Bottle', 'A14', NULL, '0123456789146', TRUE),
    ('Iced Coffee 250ml', 1, 3.00, 40, 1.50, 70, 'Can', 'A15', NULL, '0123456789257', TRUE),
    ('Energy Drink 500ml', 1, 4.50, 35, 3.00, 60, 'Can', 'A16', NULL, '0123456789368', TRUE),

    -- Snacks
    ('Chocolate Bar 50g', 2, 1.50, 30, 0.80, 50, 'Bar', 'B17', NULL, '0123456789479', TRUE),
    ('Trail Mix 200g', 2, 5.00, 25, 3.00, 40, 'Pack', 'B18', NULL, '0123456789580', TRUE),
    ('Rice Crackers 100g', 2, 2.00, 30, 1.00, 45, 'Pack', 'B19', NULL, '0123456789691', TRUE),
    ('Granola Bars 6 Pack', 2, 4.00, 20, 2.50, 30, 'Pack', 'B20', NULL, '0123456789702', TRUE),

    -- Dairy
    ('Ice Cream 500ml', 3, 6.00, 20, 4.00, 15, 'Container', 'C14', NULL, '0123456790045', TRUE),
    ('Sour Cream 250g', 3, 2.50, 30, 1.50, 25, 'Container', 'C15', NULL, '0123456790156', TRUE),
    ('Butter 250g', 3, 3.20, 25, 2.00, 20, 'Block', 'C16', NULL, '0123456790267', TRUE),

    -- Household Supplies
    ('Laundry Detergent 2L', 4, 15.00, 20, 10.00, 10, 'Bottle', 'H14', NULL, '0123456790378', TRUE),
    ('Dish Soap 500ml', 4, 2.50, 30, 1.50, 25, 'Bottle', 'H15', NULL, '0123456790489', TRUE),
    ('Fabric Softener 1L', 4, 8.00, 15, 5.00, 10, 'Bottle', 'H16', NULL, '0123456790590', TRUE),

    -- Frozen Foods
    ('Frozen Vegetables 500g', 5, 3.50, 25, 2.00, 15, 'Pack', 'I14', NULL, '0123456790601', TRUE),
    ('Frozen Waffles 300g', 5, 4.00, 20, 2.50, 12, 'Pack', 'I15', NULL, '0123456790712', TRUE),
    ('Frozen Burgers 500g', 5, 6.50, 20, 4.50, 10, 'Pack', 'I16', NULL, '0123456790823', TRUE),

    -- Bakery
    ('Baguette', 6, 2.50, 30, 1.50, 20, 'Loaf', 'J14', NULL, '0123456790934', TRUE),
    ('Brown Bread', 6, 3.00, 25, 2.00, 20, 'Loaf', 'J15', NULL, '0123456791045', TRUE),
    ('Cupcakes 6 Pack', 6, 6.00, 20, 4.00, 15, 'Pack', 'J16', NULL, '0123456791156', TRUE),

    -- Fruits
    ('Grapes 500g', 7, 4.00, 30, 2.50, 50, 'Bag', 'K9', NULL, '0123456791267', TRUE),
    ('Bananas 1kg', 7, 2.50, 40, 1.80, 70, 'Bunch', 'K10', NULL, '0123456791378', TRUE),
    ('Pineapple 1kg', 7, 3.00, 25, 2.00, 40, 'Piece', 'K11', NULL, '0123456791489', TRUE),

    -- Vegetables
    ('Carrots 1kg', 8, 2.50, 30, 1.50, 60, 'Bag', 'L9', NULL, '0123456791590', TRUE),
    ('Potatoes 1kg', 8, 1.50, 40, 0.80, 70, 'Bag', 'L10', NULL, '0123456791701', TRUE),
    ('Broccoli 500g', 8, 2.80, 25, 1.80, 50, 'Bag', 'L11', NULL, '0123456791812', TRUE),

    -- Meat
    ('Pork Chops 1kg', 9, 12.00, 15, 8.00, 10, 'Pack', 'M8', NULL, '0123456791923', TRUE),
    ('Beef Steaks 500g', 9, 14.00, 15, 10.00, 10, 'Pack', 'M9', NULL, '0123456792034', TRUE),
    ('Ground Beef 500g', 9, 8.00, 20, 5.00, 15, 'Pack', 'M10', NULL, '0123456792145', TRUE),

    -- Seafood
    ('Salmon Fillets 300g', 10, 20.00, 10, 15.00, 5, 'Pack', 'N7', NULL, '0123456792256', TRUE),
    ('Tuna Steak 250g', 10, 15.00, 10, 12.00, 5, 'Pack', 'N8', NULL, '0123456792367', TRUE),
    ('Calamari Rings 400g', 10, 18.00, 10, 14.00, 5, 'Pack', 'N9', NULL, '0123456792478', TRUE),

    -- Personal Care
    ('Shampoo 400ml', 11, 6.00, 30, 4.00, 25, 'Bottle', 'O7', NULL, '0123456792589', TRUE),
    ('Conditioner 400ml', 11, 6.00, 30, 4.00, 25, 'Bottle', 'O8', NULL, '0123456792690', TRUE),
    ('Toothpaste 150ml', 11, 3.00, 40, 1.50, 20, 'Tube', 'O9', NULL, '0123456792701', TRUE),

    -- Health & Wellness
    ('Vitamin C Tablets 100 Tabs', 12, 15.00, 15, 10.00, 10, 'Bottle', 'P7', NULL, '0123456792812', TRUE),
    ('Protein Powder 500g', 12, 25.00, 10, 20.00, 5, 'Pack', 'P8', NULL, '0123456792923', TRUE),
    ('Multivitamins 60 Caps', 12, 18.00, 15, 12.00, 10, 'Bottle', 'P9', NULL, '0123456793034', TRUE),

    -- Cleaning Supplies
    ('Glass Cleaner 500ml', 13, 4.00, 25, 3.00, 15, 'Bottle', 'Q7', NULL, '0123456793145', TRUE),
    ('Bleach 1L', 13, 3.50, 30, 2.00, 20, 'Bottle', 'Q8', NULL, '0123456793256', TRUE),
    ('Mop Refill', 13, 7.00, 20, 5.00, 15, 'Unit', 'Q9', NULL, '0123456793367', TRUE),

    -- Electronics
    ('Wireless Headphones', 14, 80.00, 15, 60.00, 10, 'Unit', 'R7', NULL, '0123456793478', TRUE),
    ('Portable Charger', 14, 30.00, 20, 20.00, 15, 'Unit', 'R8', NULL, '0123456793589', TRUE),
    ('Smart TV 55 inch', 14, 800.00, 10, 600.00, 5, 'Unit', 'R9', NULL, '0123456793690', TRUE),

    -- Pet Supplies
    ('Dog Food 2kg', 15, 15.00, 15, 10.00, 10, 'Bag', 'P14', NULL, '0123456793701', TRUE),
    ('Cat Litter 5kg', 15, 12.00, 15, 8.00, 8, 'Bag', 'P15', NULL, '0123456793812', TRUE),
    ('Pet Carrier', 15, 25.00, 10, 15.00, 5, 'Unit', 'P16', NULL, '0123456793923', TRUE),

    -- Baby Products
    ('Baby Formula 900g', 16, 25.00, 10, 20.00, 5, 'Tin', 'B14', NULL, '0800017000040', TRUE),
    ('Diapers Size 4 30 Pack', 16, 20.00, 15, 15.00, 8, 'Pack', 'B15', NULL, '0800017000050', TRUE),
    ('Baby Bath Soap 250ml', 16, 4.00, 25, 2.50, 15, 'Bottle', 'B16', NULL, '0800017000060', TRUE);