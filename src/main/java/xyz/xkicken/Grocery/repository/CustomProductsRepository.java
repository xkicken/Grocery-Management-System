package xyz.xkicken.Grocery.repository;

import xyz.xkicken.Grocery.model.Products;

public interface CustomProductsRepository {
    void updateProducts(Products products, int id);
}
