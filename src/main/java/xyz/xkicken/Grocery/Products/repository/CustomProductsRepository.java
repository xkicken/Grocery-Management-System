package xyz.xkicken.Grocery.Products.repository;

import xyz.xkicken.Grocery.Products.model.Products;

public interface CustomProductsRepository {
    void updateProducts(Products products, int id);
    void deleteProducts(int id);
}
