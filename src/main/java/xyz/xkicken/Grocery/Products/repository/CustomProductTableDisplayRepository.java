package xyz.xkicken.Grocery.Products.repository;

import xyz.xkicken.Grocery.Products.model.ProductsTableDisplay;

import java.util.List;

public interface CustomProductTableDisplayRepository{

    List<ProductsTableDisplay> searchProductsByColumn(String column, String query);



}
