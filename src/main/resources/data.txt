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
('Electronics');


-- Insert into Products
INSERT INTO Products (
    product_name,
    category_id,
    price,
    stock_quantity,
    min_stock_quantity,
    cost_price,
    reorder_level,
    unit_of_measure,
    shelf_location,
    plu_code,
    barcode,
    expiration_date,
    is_active
) VALUES
      -- Beverages
      ('Cola 1L', 1, 1.50, 200, 50, 1.00, 100, 'Bottle', 'A1', NULL, '4006381333931', '2025-12-31', TRUE),
      ('Orange Juice 1L', 1, 2.50, 150, 30, 2.00, 70, 'Bottle', 'A2', NULL, '4897036690542', '2024-11-30', TRUE),
      ('Green Tea 500ml', 1, 2.00, 130, 25, 1.50, 65, 'Bottle', 'A3', NULL, '4902432214393', '2025-05-20', TRUE),
      ('Black Coffee 1L', 1, 3.00, 90, 20, 2.00, 45, 'Bottle', 'A4', NULL, '4006381333931', '2025-12-31', TRUE),
      ('Mineral Water 500ml', 1, 1.00, 300, 60, 0.60, 120, 'Bottle', 'A5', NULL, '0123456789012', '2026-01-15', TRUE),

      -- Snacks
      ('Potato Chips 200g', 2, 2.00, 100, 20, 1.20, 50, 'Packet', 'B1', NULL, '5000112617961', '2024-09-15', TRUE),
      ('Pretzels 150g', 2, 1.80, 120, 25, 1.10, 60, 'Packet', 'B2', NULL, '0012993445906', '2025-01-20', TRUE),
      ('Trail Mix 250g', 2, 3.50, 80, 15, 2.50, 40, 'Packet', 'B3', NULL, '0744705503426', '2025-03-10', TRUE),
      ('Granola Bars 6 Pack', 2, 4.00, 70, 10, 3.00, 35, 'Box', 'B4', NULL, '0123456789123', '2025-04-05', TRUE),
      ('Popcorn 100g', 2, 1.50, 150, 30, 0.90, 75, 'Packet', 'B5', NULL, '0123456789234', '2025-02-28', TRUE),

      -- Dairy
      ('Milk 1L', 3, 1.30, 180, 40, 0.90, 90, 'Carton', 'C1', NULL, '8714100772047', '2024-08-10', TRUE),
      ('Butter 250g', 3, 3.50, 75, 15, 2.00, 30, 'Block', 'C2', NULL, '0505503125087', '2024-12-15', TRUE),
      ('Cheddar Cheese 200g', 3, 4.00, 60, 12, 2.50, 25, 'Block', 'C3', NULL, '0123456789345', '2025-06-20', TRUE),
      ('Yogurt 500g', 3, 2.50, 90, 20, 1.50, 45, 'Cup', 'C4', NULL, '0123456789456', '2024-09-10', TRUE),
      ('Cream 300ml', 3, 2.00, 100, 25, 1.20, 50, 'Bottle', 'C5', NULL, '0123456789567', '2025-01-25', TRUE),

      -- Household Supplies
      ('Laundry Detergent 1L', 4, 5.00, 80, 20, 3.00, 40, 'Bottle', 'H1', NULL, '5010123700481', '2026-03-01', TRUE),
      ('Dish Soap 500ml', 4, 2.50, 100, 25, 1.50, 50, 'Bottle', 'H2', NULL, '8001090596211', '2025-06-20', TRUE),
      ('Paper Towels 6 Rolls', 4, 3.00, 60, 15, 1.80, 30, 'Pack', 'H3', NULL, '0123456789678', '2025-07-15', TRUE),
      ('Trash Bags 20 Pack', 4, 4.50, 70, 18, 2.50, 35, 'Box', 'H4', NULL, '0123456789789', '2025-08-10', TRUE),
      ('Glass Storage Containers 12 Pack', 4, 6.00, 50, 12, 3.50, 25, 'Set', 'H5', NULL, '0123456789890', '2025-09-05', TRUE),

      -- Frozen Foods
      ('Frozen Pizza 500g', 5, 6.00, 70, 15, 4.00, 35, 'Pack', 'I1', NULL, '0500015704884', '2025-02-28', TRUE),
      ('Frozen Vegetables 1kg', 5, 3.00, 90, 20, 2.00, 45, 'Pack', 'I2', NULL, '0005000070116', '2025-04-15', TRUE),
      ('Ice Cream 1L', 5, 5.50, 60, 12, 3.50, 30, 'Carton', 'I3', NULL, '0123456790001', '2025-03-20', TRUE),
      ('Frozen Berries 500g', 5, 4.00, 80, 16, 2.50, 32, 'Pack', 'I4', NULL, '0123456790112', '2025-05-25', TRUE),
      ('Frozen Lasagna 400g', 5, 7.00, 55, 11, 4.50, 28, 'Pack', 'I5', NULL, '0123456790223', '2025-06-30', TRUE),

      -- Bakery
      ('Whole Wheat Bread 500g', 6, 2.00, 60, 15, 1.20, 30, 'Loaf', 'J1', NULL, '5012991010090', '2024-11-25', TRUE),
      ('Croissant 100g', 6, 1.50, 80, 20, 0.80, 40, 'Piece', 'J2', NULL, '0049000018807', '2024-10-03', TRUE),
      ('Bagel 150g', 6, 1.80, 70, 18, 1.00, 35, 'Piece', 'J3', NULL, '0123456790334', '2024-10-10', TRUE),
      ('Sourdough Bread 600g', 6, 2.50, 65, 16, 1.50, 33, 'Loaf', 'J4', NULL, '0123456790445', '2024-11-05', TRUE),
      ('Baguette 250g', 6, 1.70, 75, 19, 0.90, 38, 'Piece', 'J5', NULL, '0123456790556', '2024-10-15', TRUE),

      -- Fruits
      ('Bananas per kg', 7, 2.20, 100, 20, 1.50, 50, 'kg', 'D1', '4011', NULL, '2024-10-05', TRUE),
      ('Apples per kg', 7, 3.00, 120, 30, 2.00, 60, 'kg', 'D2', '4012', NULL, '2024-10-07', TRUE),
      ('Oranges per kg', 7, 2.80, 110, 25, 1.80, 55, 'kg', 'D3', '4013', NULL, '2024-10-09', TRUE),
      ('Grapes per kg', 7, 4.50, 90, 18, 3.00, 45, 'kg', 'D4', '4014', NULL, '2024-10-12', TRUE),
      ('Strawberries per kg', 7, 5.00, 80, 20, 3.50, 40, 'kg', 'D5', '4015', NULL, '2024-10-15', TRUE),

      -- Vegetables
      ('Carrots per kg', 8, 1.80, 90, 20, 1.00, 45, 'kg', 'E1', '4562', NULL, '2024-10-10', TRUE),
      ('Potatoes per kg', 8, 1.50, 110, 25, 0.80, 55, 'kg', 'E2', '4072', NULL, '2024-10-09', TRUE),
      ('Tomatoes per kg', 8, 2.20, 100, 22, 1.60, 50, 'kg', 'E3', '4062', NULL, '2024-10-11', TRUE),
      ('Lettuce per head', 8, 1.20, 85, 17, 0.70, 42, 'Head', 'E4', '4052', NULL, '2024-10-08', TRUE),
      ('Broccoli per kg', 8, 2.50, 95, 19, 1.90, 48, 'kg', 'E5', '4042', NULL, '2024-10-13', TRUE),

      -- Meat
      ('Chicken Breast per kg', 9, 8.00, 60, 15, 6.00, 30, 'kg', 'F1', '5478', NULL, '2024-10-12', TRUE),
      ('Beef Mince per kg', 9, 10.00, 70, 18, 7.50, 35, 'kg', 'F2', '5532', NULL, '2024-10-13', TRUE),
      ('Pork Chops per kg', 9, 9.50, 65, 16, 7.00, 33, 'kg', 'F3', '5542', NULL, '2024-10-14', TRUE),
      ('Lamb Ribs per kg', 9, 12.00, 50, 12, 9.00, 25, 'kg', 'F4', '5552', NULL, '2024-10-16', TRUE),
      ('Turkey Legs per kg', 9, 7.50, 55, 14, 5.50, 28, 'kg', 'F5', '5562', NULL, '2024-10-17', TRUE),

      -- Seafood
      ('Salmon Fillet per kg', 10, 15.00, 50, 12, 12.00, 25, 'kg', 'G1', '4050', NULL, '2024-10-14', TRUE),
      ('Shrimp per kg', 10, 20.00, 40, 10, 16.00, 20, 'kg', 'G2', '4018', NULL, '2024-10-15', TRUE),
      ('Tilapia Fillet per kg', 10, 12.50, 45, 11, 9.50, 23, 'kg', 'G3', '4060', NULL, '2024-10-16', TRUE),
      ('Cod Fillet per kg', 10, 14.00, 35, 9, 11.00, 18, 'kg', 'G4', '4070', NULL, '2024-10-17', TRUE),
      ('Mussels per kg', 10, 13.00, 30, 8, 10.00, 15, 'kg', 'G5', '4080', NULL, '2024-10-18', TRUE),

      -- Personal Care
      ('Shampoo 500ml', 11, 4.50, 90, 20, 2.80, 45, 'Bottle', 'K1', NULL, '5000204596501', '2025-12-20', TRUE),
      ('Toothpaste 100ml', 11, 2.00, 100, 30, 1.20, 50, 'Tube', 'K2', NULL, '8901030704721', '2026-01-10', TRUE),
      ('Body Lotion 250ml', 11, 5.00, 70, 18, 3.50, 35, 'Bottle', 'K3', NULL, '0123456790666', '2025-02-25', TRUE),
      ('Deodorant 150ml', 11, 3.50, 80, 20, 2.50, 40, 'Stick', 'K4', NULL, '0123456790777', '2025-03-30', TRUE),
      ('Facial Cleanser 200ml', 11, 4.00, 75, 19, 3.00, 38, 'Bottle', 'K5', NULL, '0123456790888', '2025-04-15', TRUE),

      -- Health & Wellness
      ('Vitamin C 100 Tablets', 12, 12.00, 40, 10, 8.00, 20, 'Bottle', 'L1', NULL, '9311770596638', '2026-06-30', TRUE),
      ('Pain Relief 24 Tablets', 12, 5.00, 50, 15, 3.50, 25, 'Box', 'L2', NULL, '9310703224004', '2025-07-10', TRUE),
      ('Multivitamins 60 Tablets', 12, 15.00, 35, 9, 10.00, 17, 'Bottle', 'L3', NULL, '0123456790999', '2026-08-20', TRUE),
      ('Herbal Supplements 90 Capsules', 12, 20.00, 25, 7, 14.00, 13, 'Bottle', 'L4', NULL, '0123456791000', '2026-09-25', TRUE),
      ('Omega-3 Fish Oil 120 Softgels', 12, 18.00, 30, 8, 12.50, 15, 'Bottle', 'L5', NULL, '0123456791111', '2026-10-30', TRUE),

      -- Cleaning Supplies
      ('All-Purpose Cleaner 1L', 13, 4.00, 75, 20, 2.50, 40, 'Bottle', 'M1', NULL, '0043900562507', '2025-09-15', TRUE),
      ('Glass Cleaner 500ml', 13, 3.00, 90, 25, 1.80, 45, 'Bottle', 'M2', NULL, '5010386236009', '2025-11-20', TRUE),
      ('Floor Cleaner 2L', 13, 5.50, 65, 16, 3.50, 33, 'Bottle', 'M3', NULL, '0123456791222', '2025-10-05', TRUE),
      ('Bathroom Cleaner 1L', 13, 4.50, 80, 20, 2.70, 40, 'Bottle', 'M4', NULL, '0123456791333', '2025-11-10', TRUE),
      ('Kitchen Cleaner 1.5L', 13, 5.00, 70, 18, 3.00, 35, 'Bottle', 'M5', NULL, '0123456791444', '2025-12-15', TRUE),

      -- Electronics
      ('Batteries AA 4 Pack', 14, 5.00, 120, 30, 3.00, 60, 'Pack', 'N1', NULL, '0041498000053', '2028-01-01', TRUE),
      ('USB Cable 1m', 14, 3.00, 150, 40, 1.50, 75, 'Piece', 'N2', NULL, '0758300415203', '2028-06-01', TRUE),
      ('HDMI Cable 2m', 14, 7.00, 100, 25, 4.00, 50, 'Piece', 'N3', NULL, '0123456791555', '2027-02-20', TRUE),
      ('Wireless Mouse', 14, 15.00, 80, 20, 10.00, 40, 'Piece', 'N4', NULL, '0123456791666', '2027-03-15', TRUE),
      ('Portable Charger 10000mAh', 14, 25.00, 60, 15, 15.00, 30, 'Piece', 'N5', NULL, '0123456791777', '2027-04-10', TRUE),

      -- Additional Beverages
      ('Herbal Tea 20 Bags', 1, 3.00, 110, 22, 1.80, 55, 'Box', 'A6', NULL, '0123456791888', '2025-07-25', TRUE),
      ('Energy Drink 500ml', 1, 2.50, 140, 28, 1.80, 70, 'Can', 'A7', NULL, '0123456791999', '2025-08-30', TRUE),

      -- Additional Snacks
      ('Mixed Nuts 300g', 2, 5.00, 85, 17, 3.50, 42, 'Pack', 'B6', NULL, '0123456792000', '2025-09-20', TRUE),
      ('Rice Crackers 150g', 2, 2.20, 95, 19, 1.60, 48, 'Pack', 'B7', NULL, '0123456792111', '2025-10-25', TRUE),

      -- Additional Dairy
      ('Greek Yogurt 200g', 3, 3.00, 100, 25, 1.80, 50, 'Cup', 'C6', NULL, '0123456792222', '2024-09-20', TRUE),
      ('Mozzarella Cheese 250g', 3, 4.50, 70, 18, 2.70, 35, 'Block', 'C7', NULL, '0123456792333', '2024-10-05', TRUE),

      -- Additional Household Supplies
      ('Hand Soap 250ml', 4, 3.50, 90, 20, 2.10, 45, 'Bottle', 'H6', NULL, '0123456792444', '2025-05-15', TRUE),
      ('Air Freshener 300ml', 4, 4.00, 80, 18, 2.50, 40, 'Bottle', 'H7', NULL, '0123456792555', '2025-06-20', TRUE),

      -- Additional Frozen Foods
      ('Frozen Chicken Nuggets 500g', 5, 5.50, 65, 16, 3.00, 33, 'Pack', 'I6', NULL, '0123456792666', '2025-07-25', TRUE),
      ('Frozen French Fries 1kg', 5, 4.50, 85, 21, 2.70, 42, 'Pack', 'I7', NULL, '0123456792777', '2025-08-30', TRUE),

      -- Additional Bakery
      ('Chocolate Muffins 4 Pack', 6, 3.50, 90, 22, 2.50, 45, 'Pack', 'J6', NULL, '0123456792888', '2024-10-20', TRUE),
      ('Blueberry Scones 6 Pack', 6, 4.00, 80, 20, 2.80, 40, 'Pack', 'J7', NULL, '0123456792999', '2024-11-25', TRUE),

      -- Additional Fruits
      ('Pineapples per unit', 7, 3.50, 60, 12, 2.50, 30, 'Unit', 'D6', '4021', NULL, '2024-10-18', TRUE),
      ('Mangoes per kg', 7, 4.00, 70, 14, 2.80, 35, 'kg', 'D7', '4022', NULL, '2024-10-19', TRUE),

      -- Additional Vegetables
      ('Spinach per bunch', 8, 2.00, 85, 17, 1.30, 42, 'Bunch', 'E6', '4092', NULL, '2024-10-12', TRUE),
      ('Cucumbers per unit', 8, 1.50, 95, 19, 0.90, 48, 'Unit', 'E7', '4093', NULL, '2024-10-13', TRUE),

      -- Additional Meat
      ('Pork Shoulder per kg', 9, 11.00, 55, 14, 8.50, 28, 'kg', 'F6', '5572', NULL, '2024-10-18', TRUE),
      ('Duck Breast per kg', 9, 13.50, 40, 10, 10.00, 20, 'kg', 'F7', '5582', NULL, '2024-10-19', TRUE),

      -- Additional Seafood
      ('Tuna Steaks per kg', 10, 16.00, 35, 9, 12.50, 18, 'kg', 'G6', '4094', NULL, '2024-10-20', TRUE),
      ('Crab Legs per kg', 10, 22.00, 25, 7, 17.00, 14, 'kg', 'G7', '4095', NULL, '2024-10-21', TRUE),

      -- Additional Personal Care
      ('Conditioner 500ml', 11, 4.50, 85, 20, 2.80, 42, 'Bottle', 'K6', NULL, '0123456793000', '2025-05-25', TRUE),
      ('Hair Gel 200ml', 11, 3.00, 75, 18, 1.80, 38, 'Bottle', 'K7', NULL, '0123456793111', '2025-06-30', TRUE),

      -- Additional Health & Wellness
      ('Calcium Tablets 60 Tablets', 12, 10.00, 45, 11, 6.50, 23, 'Bottle', 'L6', NULL, '0123456793222', '2026-07-15', TRUE),
      ('Probiotic Capsules 30 Capsules', 12, 14.00, 30, 7, 9.00, 14, 'Bottle', 'L7', NULL, '0123456793333', '2026-08-20', TRUE),

      -- Additional Cleaning Supplies
      ('Oven Cleaner 750ml', 13, 6.00, 65, 16, 3.80, 33, 'Bottle', 'M6', NULL, '0123456793444', '2025-10-10', TRUE),
      ('Bathroom Spray 500ml', 13, 3.50, 85, 21, 2.50, 42, 'Bottle', 'M7', NULL, '0123456793555', '2025-11-15', TRUE),

      -- Additional Electronics
      ('Bluetooth Speaker', 14, 30.00, 50, 12, 18.00, 25, 'Piece', 'N6', NULL, '0123456793666', '2027-05-20', TRUE),
      ('Wireless Keyboard', 14, 20.00, 60, 15, 12.00, 30, 'Piece', 'N7', NULL, '0123456793777', '2027-06-25', TRUE),

      -- Continue adding products to reach 100 entries
      -- Beverages
      ('Herbal Infusion 250ml', 1, 2.20, 100, 20, 1.60, 50, 'Bottle', 'A8', NULL, '0123456793888', '2025-09-10', TRUE),
      ('Sports Drink 750ml', 1, 3.00, 130, 26, 2.00, 65, 'Bottle', 'A9', NULL, '0123456793999', '2025-10-15', TRUE),

      -- Snacks
      ('Salted Almonds 200g', 2, 4.50, 75, 18, 2.80, 38, 'Pack', 'B8', NULL, '0123456794000', '2025-11-20', TRUE),
      ('Energy Bars 12 Pack', 2, 6.00, 65, 16, 3.50, 33, 'Box', 'B9', NULL, '0123456794111', '2025-12-25', TRUE),

      -- Dairy
      ('Swiss Cheese 200g', 3, 5.00, 55, 14, 3.50, 28, 'Block', 'C8', NULL, '0123456794222', '2025-01-30', TRUE),
      ('Skim Milk 1L', 3, 1.20, 190, 38, 0.80, 95, 'Carton', 'C9', NULL, '0123456794333', '2024-08-15', TRUE),

      -- Household Supplies
      ('Fabric Softener 2L', 4, 6.00, 70, 17, 3.60, 35, 'Bottle', 'H8', NULL, '0123456794444', '2025-07-20', TRUE),
      ('Bleach 1L', 4, 3.80, 85, 20, 2.30, 42, 'Bottle', 'H9', NULL, '0123456794555', '2025-08-25', TRUE),

      -- Frozen Foods
      ('Frozen Vegetables Mix 1kg', 5, 3.50, 95, 24, 2.30, 48, 'Pack', 'I8', NULL, '0123456794666', '2025-09-30', TRUE),
      ('Frozen Meatballs 500g', 5, 5.00, 80, 20, 3.00, 40, 'Pack', 'I9', NULL, '0123456794777', '2025-10-05', TRUE),

      -- Bakery
      ('Cinnamon Rolls 6 Pack', 6, 4.50, 70, 18, 3.00, 35, 'Pack', 'J8', NULL, '0123456794888', '2024-11-30', TRUE),
      ('Banana Bread 1 Loaf', 6, 3.00, 65, 16, 2.20, 32, 'Loaf', 'J9', NULL, '0123456794999', '2024-12-05', TRUE),

      -- Fruits
      ('Pears per kg', 7, 3.20, 85, 17, 2.10, 42, 'kg', 'D8', '4023', NULL, '2024-10-20', TRUE),
      ('Kiwis per kg', 7, 4.00, 75, 15, 2.80, 38, 'kg', 'D9', '4024', NULL, '2024-10-21', TRUE),

      -- Vegetables
      ('Bell Peppers per kg', 8, 3.00, 80, 20, 1.90, 40, 'kg', 'E8', '4096', NULL, '2024-10-14', TRUE),
      ('Zucchini per kg', 8, 2.50, 90, 22, 1.60, 45, 'kg', 'E9', '4097', NULL, '2024-10-16', TRUE),

      -- Meat
      ('Ground Turkey per kg', 9, 9.00, 60, 15, 6.80, 30, 'kg', 'F8', '5592', NULL, '2024-10-19', TRUE),
      ('Bacon Slices 500g', 9, 7.50, 55, 14, 5.50, 28, 'Pack', 'F9', '5593', NULL, '2024-10-20', TRUE),

      -- Seafood
      ('Lobster Tails per kg', 10, 25.00, 20, 5, 20.00, 10, 'kg', 'G8', '4098', NULL, '2024-10-22', TRUE),
      ('Scallops per kg', 10, 18.00, 25, 6, 13.50, 12, 'kg', 'G9', '4099', NULL, '2024-10-23', TRUE),

      -- Personal Care
      ('Hand Cream 100ml', 11, 3.50, 80, 20, 2.30, 40, 'Tube', 'K10', NULL, '0123456795000', '2025-07-05', TRUE),
      ('Lip Balm 10 Pack', 11, 4.00, 90, 22, 2.50, 45, 'Pack', 'K11', NULL, '0123456795111', '2025-08-10', TRUE),

      -- Health & Wellness
      ('Iron Supplements 60 Tablets', 12, 11.00, 35, 9, 7.50, 17, 'Bottle', 'L8', NULL, '0123456795222', '2026-09-15', TRUE),
      ('Magnesium Capsules 90 Capsules', 12, 16.00, 25, 7, 10.50, 14, 'Bottle', 'L9', NULL, '0123456795333', '2026-10-20', TRUE),

      -- Cleaning Supplies
      ('Carpet Cleaner 1L', 13, 7.00, 60, 15, 4.50, 30, 'Bottle', 'M10', NULL, '0123456795444', '2025-12-10', TRUE),
      ('Kitchen Degreaser 750ml', 13, 5.00, 70, 18, 3.20, 35, 'Bottle', 'M11', NULL, '0123456795555', '2025-12-15', TRUE),

      -- Electronics
      ('Smartphone Charger', 14, 12.00, 80, 20, 7.00, 40, 'Piece', 'N8', NULL, '0123456795666', '2027-07-25', TRUE),
      ('Wireless Earbuds', 14, 45.00, 50, 12, 27.00, 25, 'Piece', 'N9', NULL, '0123456795777', '2027-08-30', TRUE),

      -- Additional Products to reach 100 entries
      -- Beverages
      ('Coconut Water 1L', 1, 3.00, 100, 25, 1.80, 50, 'Bottle', 'A10', NULL, '0123456795888', '2025-11-05', TRUE),
      ('Lemonade 1L', 1, 2.50, 120, 30, 2.00, 60, 'Bottle', 'A11', NULL, '0123456795999', '2025-12-10', TRUE),

      -- Snacks
      ('Granola 500g', 2, 5.00, 80, 20, 3.00, 40, 'Pack', 'B10', NULL, '0123456796000', '2025-01-15', TRUE),
      ('Chocolate Chips 300g', 2, 4.00, 70, 18, 2.50, 35, 'Bag', 'B11', NULL, '0123456796111', '2025-02-20', TRUE),

      -- Dairy
      ('Evaporated Milk 400ml', 3, 2.50, 85, 21, 1.80, 42, 'Can', 'C10', NULL, '0123456796222', '2024-09-25', TRUE),
      ('Cottage Cheese 250g', 3, 3.00, 90, 22, 2.10, 45, 'Cup', 'C11', NULL, '0123456796333', '2024-10-30', TRUE),

      -- Household Supplies
      ('Air Purifier 1 Unit', 4, 50.00, 30, 8, 30.00, 15, 'Unit', 'H10', NULL, '0123456796444', '2025-09-25', TRUE),
      ('Electric Kettle 1.5L', 4, 25.00, 40, 10, 15.00, 20, 'Piece', 'H11', NULL, '0123456796555', '2025-10-30', TRUE),

      -- Frozen Foods
      ('Frozen Spinach 500g', 5, 3.50, 100, 25, 2.20, 50, 'Pack', 'I10', NULL, '0123456796666', '2025-11-05', TRUE),
      ('Frozen Chicken Wings 1kg', 5, 8.00, 60, 15, 4.80, 30, 'Pack', 'I11', NULL, '0123456796777', '2025-12-10', TRUE),

      -- Bakery
      ('Rye Bread 600g', 6, 2.80, 70, 18, 1.80, 35, 'Loaf', 'J10', NULL, '0123456796888', '2024-11-10', TRUE),
      ('Chocolate Croissant 100g', 6, 2.00, 85, 21, 1.10, 42, 'Piece', 'J11', NULL, '0123456796999', '2024-12-15', TRUE),

      -- Fruits
      ('Pomegranates per unit', 7, 4.50, 50, 12, 3.00, 25, 'Unit', 'D10', '4025', NULL, '2024-10-22', TRUE),
      ('Peaches per kg', 7, 3.80, 65, 16, 2.80, 33, 'kg', 'D11', '4026', NULL, '2024-10-23', TRUE),

      -- Vegetables
      ('Cauliflower per kg', 8, 2.80, 80, 20, 1.70, 40, 'kg', 'E10', '4098', NULL, '2024-10-14', TRUE),
      ('Eggplants per kg', 8, 3.20, 75, 19, 2.10, 38, 'kg', 'E11', '4099', NULL, '2024-10-16', TRUE),

      -- Meat
      ('Bison Steak per kg', 9, 20.00, 25, 6, 15.00, 12, 'kg', 'F12', '5602', NULL, '2024-10-21', TRUE),
      ('Venison Roast per kg', 9, 18.00, 30, 7, 13.50, 14, 'kg', 'F13', '5612', NULL, '2024-10-22', TRUE),

      -- Seafood
      ('Halibut Fillet per kg', 10, 19.00, 28, 7, 14.00, 14, 'kg', 'G12', '4100', NULL, '2024-10-24', TRUE),
      ('Clams per kg', 10, 17.00, 22, 5, 12.00, 11, 'kg', 'G13', '4101', NULL, '2024-10-25', TRUE),

      -- Personal Care
      ('Nail Polish 12 Pack', 11, 10.00, 60, 15, 6.00, 30, 'Pack', 'K12', NULL, '0123456797000', '2025-09-05', TRUE),
      ('Hair Spray 300ml', 11, 6.00, 70, 18, 3.50, 35, 'Bottle', 'K13', NULL, '0123456797111', '2025-10-10', TRUE),

      -- Health & Wellness
      ('Vitamin D 60 Tablets', 12, 13.00, 30, 8, 8.50, 16, 'Bottle', 'L12', NULL, '0123456797222', '2026-11-15', TRUE),
      ('Probiotic Gummies 30 Gummies', 12, 10.00, 40, 10, 6.50, 20, 'Pack', 'L13', NULL, '0123456797333', '2026-12-20', TRUE),

      -- Cleaning Supplies
      ('Tile Cleaner 1L', 13, 5.50, 65, 16, 3.10, 33, 'Bottle', 'M12', NULL, '0123456797444', '2025-12-20', TRUE),
      ('Window Cleaner 750ml', 13, 4.00, 80, 20, 2.30, 40, 'Bottle', 'M13', NULL, '0123456797555', '2026-01-25', TRUE),

      -- Electronics
      ('Laptop Charger', 14, 25.00, 70, 17, 15.00, 35, 'Piece', 'N10', NULL, '0123456797666', '2027-09-10', TRUE),
      ('Smartwatch', 14, 60.00, 40, 10, 36.00, 20, 'Piece', 'N11', NULL, '0123456797777', '2027-10-15', TRUE),

      -- Final Products to reach 100
      -- Beverages
      ('Iced Tea 1L', 1, 2.80, 110, 22, 1.90, 55, 'Bottle', 'A12', NULL, '0123456797888', '2025-11-10', TRUE),
      ('Sparkling Water 750ml', 1, 2.20, 140, 28, 1.60, 70, 'Bottle', 'A13', NULL, '0123456797999', '2025-12-15', TRUE),

      -- Snacks
      ('Beef Jerky 100g', 2, 5.50, 75, 19, 3.80, 38, 'Pack', 'B12', NULL, '0123456798000', '2025-03-20', TRUE),
      ('Salted Peanuts 250g', 2, 3.50, 85, 21, 2.50, 42, 'Pack', 'B13', NULL, '0123456798111', '2025-04-25', TRUE),

      -- Dairy
      ('Half and Half 500ml', 3, 2.80, 95, 24, 1.90, 48, 'Carton', 'C12', NULL, '0123456798222', '2024-10-05', TRUE),
      ('Feta Cheese 200g', 3, 4.50, 65, 16, 3.00, 33, 'Block', 'C13', NULL, '0123456798333', '2024-10-10', TRUE),

      -- Household Supplies
      ('Air Freshener Spray 200ml', 4, 4.50, 90, 22, 2.70, 45, 'Bottle', 'H14', NULL, '0123456798444', '2025-11-25', TRUE),
      ('Stain Remover 500ml', 4, 3.00, 80, 20, 1.80, 40, 'Bottle', 'H15', NULL, '0123456798555', '2025-12-30', TRUE),

      -- Frozen Foods
      ('Frozen Meat Pies 4 Pack', 5, 7.50, 55, 14, 4.50, 28, 'Pack', 'I12', NULL, '0123456798666', '2025-01-05', TRUE),
      ('Frozen Spinach 1kg', 5, 6.50, 85, 21, 4.00, 42, 'Pack', 'I13', NULL, '0123456798777', '2025-02-10', TRUE),

      -- Bakery
      ('Raisin Bread 600g', 6, 3.00, 75, 18, 2.20, 38, 'Loaf', 'J12', NULL, '0123456798888', '2024-11-15', TRUE),
      ('Chocolate Danish 4 Pack', 6, 5.00, 65, 16, 3.50, 33, 'Pack', 'J13', NULL, '0123456798999', '2024-12-20', TRUE),

      -- Fruits
      ('Blueberries per kg', 7, 5.50, 70, 14, 3.80, 35, 'kg', 'D12', '4027', NULL, '2024-10-24', TRUE),
      ('Cherries per kg', 7, 6.00, 60, 12, 4.00, 30, 'kg', 'D13', '4028', NULL, '2024-10-25', TRUE),

      -- Vegetables
      ('Spinach per kg', 8, 2.80, 85, 21, 1.90, 42, 'kg', 'E12', '4102', NULL, '2024-10-17', TRUE),
      ('Kale per bunch', 8, 3.50, 70, 17, 2.50, 35, 'Bunch', 'E13', '4103', NULL, '2024-10-18', TRUE),

      -- Meat
      ('Prime Rib per kg', 9, 25.00, 20, 5, 18.00, 10, 'kg', 'F14', '5622', NULL, '2024-10-23', TRUE),
      ('Sausage Links 500g', 9, 6.50, 60, 15, 4.20, 30, 'Pack', 'F15', '5623', NULL, '2024-10-24', TRUE),

      -- Seafood
      ('Mahi-Mahi Fillet per kg', 10, 17.50, 30, 7, 13.00, 14, 'kg', 'G14', '4104', NULL, '2024-10-26', TRUE),
      ('Squid per kg', 10, 14.50, 25, 6, 11.50, 12, 'kg', 'G15', '4105', NULL, '2024-10-27', TRUE),

      -- Personal Care
      ('Hand Sanitizer 500ml', 11, 5.00, 85, 21, 3.00, 42, 'Bottle', 'K14', NULL, '0123456799000', '2025-09-15', TRUE),
      ('Body Wash 400ml', 11, 4.00, 75, 19, 2.50, 38, 'Bottle', 'K15', NULL, '0123456799111', '2025-10-20', TRUE),

      -- Health & Wellness
      ('Zinc Supplements 60 Tablets', 12, 14.00, 30, 8, 9.50, 16, 'Bottle', 'L14', NULL, '0123456799222', '2026-12-25', TRUE),
      ('Fiber Gummies 30 Gummies', 12, 12.00, 40, 10, 7.50, 20, 'Pack', 'L15', NULL, '0123456799333', '2027-01-30', TRUE),

      -- Cleaning Supplies
      ('Laundry Stain Remover 500ml', 13, 5.00, 70, 18, 3.00, 35, 'Bottle', 'M14', NULL, '0123456799444', '2025-12-20', TRUE),
      ('Multi-Surface Wipes 40 Pack', 13, 4.50, 80, 20, 2.70, 40, 'Pack', 'M15', NULL, '0123456799555', '2026-01-25', TRUE),

      -- Electronics
      ('Gaming Mouse', 14, 35.00, 45, 11, 21.00, 22, 'Piece', 'N14', NULL, '0123456799666', '2027-11-30', TRUE),
      ('4K Monitor 27"', 14, 300.00, 20, 5, 180.00, 10, 'Piece', 'N15', NULL, '0123456799777', '2027-12-05', TRUE);


-- Insert Customers
INSERT INTO Customers (first_name, last_name, email, phone_number, address, city, postal_code)
VALUES
    ('John', 'Doe', 'john.doe@example.com', '123-456-7890', '123 Main St', 'Auckland', '1010'),
    ('Jane', 'Smith', 'jane.smith@example.com', '987-654-3210', '456 Elm St', 'Wellington', '6011'),
    ('Alice', 'Johnson', 'alice.johnson@example.com', '555-123-4567', '789 Pine St', 'Christchurch', '8011');

-- Insert Sales Orders
INSERT INTO SalesOrders (customer_id, total_amount)
VALUES
    (1, 15.75),
    (2, 10.00),
    (3, 8.50);

-- Insert Sales Order Items
INSERT INTO SalesOrderItems (order_id, product_id, quantity_sold, sale_amount)
VALUES
    (1, 1, 3, 9.00),  -- 3 Apples
    (1, 4, 2, 2.00),  -- 2 Milk
    (2, 2, 4, 10.00), -- 4 Bananas
    (3, 3, 5, 7.50);  -- 5 Carrots
