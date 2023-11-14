package co.istad.database;

import co.istad.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private List<Product> products;
    public ProductDatabase(){
        products = new ArrayList<>();
        products.add(new Product(1L,"Coca",100,2500.0, LocalDate.now()));
        products.add(new Product(2L,"Sting",20,3000.0, LocalDate.now()));
        products.add(new Product(3L,"FanTa",10,2000.0, LocalDate.now()));
        products.add(new Product(4L,"Pepsi",150,2500.0, LocalDate.now()));
        products.add(new Product(5L,"Ize",200,2500.0, LocalDate.now()));
    }

    public List<Product> getProducts() {
        return products;
    }
}
