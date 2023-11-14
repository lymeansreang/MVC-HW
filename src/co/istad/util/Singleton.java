package co.istad.util;

import co.istad.controller.MenuController;
import co.istad.controller.ProductController;
import co.istad.service.ProductService;
import co.istad.service.ProductServiceImpl;

import java.util.Scanner;

public class Singleton {

    // 1. Create static reference type
    private static Scanner s;
    private static ProductController productController;
    private static ProductServiceImpl productServiceImpl;
    private static MenuController menuController;

    // 2. Create get instance of scanner
    public static Scanner s(){
        if(s == null){
            s = new Scanner(System.in);
        }
        return s;
    }
    public static ProductController productController(){
        if(productController == null){
            productController = new ProductController();
        }
        return productController;
    }
    public static ProductServiceImpl productServiceImpl(){
        if(productServiceImpl == null){
            productServiceImpl = new ProductServiceImpl();
        }
        return productServiceImpl;
    }
    public static MenuController menuController(){
        if(menuController == null){
            menuController = new MenuController();
        }
        return menuController;
    }

}
