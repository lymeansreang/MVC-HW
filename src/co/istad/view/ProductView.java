package co.istad.view;

import co.istad.dao.ProductDao;
import co.istad.model.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ProductView {

    private static ProductDao productService;

    public static void printProductList(List<Product> products) {
        System.out.println("Product List");
        products.forEach(product -> {
            System.out.println("ID : " + product.getId());
            System.out.println("NAME : " + product.getName());
            System.out.println("QTY : " + product.getQty());
            System.out.println("PRICE : " + product.getPrice());
            System.out.println("IMPORTED DATE : " + product.getImportDate());
        });
    }
}
