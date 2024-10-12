package xyz.xkicken.Grocery.jdbcRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import xyz.xkicken.Grocery.model.ProductsTableDisplay;

import java.util.List;

@Repository
public class jdbcProductTableDisplayRepository {

    private static final Logger log = LoggerFactory.getLogger(jdbcProductTableDisplayRepository.class);
    private final JdbcClient jdbcClient;

    public jdbcProductTableDisplayRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<ProductsTableDisplay> findAll() {
        return jdbcClient.sql("select * from products_table_display")
                .query(ProductsTableDisplay.class)
                .list();
    }

    public List<ProductsTableDisplay> getAllProducts(int page, int size, String sortBy, String ascending) {
//        String order = ascending ? "ASC" : "DESC";
        String sql = "SELECT * FROM products_table_display ORDER BY " + sortBy + " " + ascending + " LIMIT ? OFFSET ?";

        return jdbcClient.sql(sql)
                .param(size) // Limit
                .param(page * size) // Offset
                .query(ProductsTableDisplay.class)
                .list();
    }

    public List<ProductsTableDisplay> getProductsByCategoryId(Integer id, int page, int size, String sortBy, String  ascending) {
//        String order = ascending ? "ASC" : "DESC";
        String sql = "SELECT * FROM products_table_display WHERE category_id = ? ORDER BY " + sortBy + " " + ascending + " LIMIT ? OFFSET ?";

        return jdbcClient.sql(sql)
                .param(id) // Category ID
                .param(size) // Limit
                .param(page * size) // Offset
                .query(ProductsTableDisplay.class)
                .list();
    }



    public List<ProductsTableDisplay> findByCategoryId(Integer id) {
        return jdbcClient.sql("select * from products_table_display where category_id = ?")
                .param(id)
                .query(ProductsTableDisplay.class)
                .list();
    }


    // validate sort direction and vaild input for sort
    private String getOrderByClause(String sortBy, String sortDir) {
        if (!"asc".equalsIgnoreCase(sortDir) && !"desc".equalsIgnoreCase(sortDir)) {
            sortDir = "asc";
        }

        switch (sortBy) {
            case "id":
            case "name":
            case "category":
            case "price":
            case "stock":
                break;
            default:
                return " ORDER BY id " + sortDir;
        }
        return " ORDER BY " + sortBy + " " + sortDir.toUpperCase();
    }

}
