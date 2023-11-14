package co.istad.controller;

import co.istad.model.Product;
import co.istad.service.ProductService;
import co.istad.service.ProductServiceImpl;
import co.istad.util.Singleton;
import co.istad.view.ProductView;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    private final ProductService productService;
    private final Scanner s;
    public ProductController(){
        s = Singleton.s();
        productService = new ProductServiceImpl();
    }
    public void index(){
        List<Product> products = productService.select();
        ProductView.printProductList(products);
    }
    public void create() {
        System.out.print("Enter product id : ");
        long proID = Integer.parseInt(s.nextLine());
        System.out.print("Enter product name : ");
        String proName = s.nextLine();
        System.out.print("Enter product qty : ");
        int proQty = Integer.parseInt(s.nextLine());
        System.out.print("Enter product price : ");
        double proPrice = Double.parseDouble(s.nextLine());
        Product addProduct = new Product(proID, proName, proQty, proPrice, LocalDate.now());
        Product product = productService.insert(addProduct);
    }
    public void delete() {
        System.out.print("Enter id you want to delete : ");
        long proID = Long.parseLong(s.nextLine());
        Product product = productService.deleteById(proID);
    }
    public void update(){

    }
}
