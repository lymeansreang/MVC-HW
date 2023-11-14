package co.istad;

import co.istad.controller.MenuController;
import co.istad.controller.ProductController;
import co.istad.model.Product;
import co.istad.service.ProductService;
import co.istad.service.ProductServiceImpl;
import co.istad.util.Singleton;
import co.istad.view.MenuView;
import co.istad.view.ProductView;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
    private final Scanner s;
    private final MenuController menuController;
    private final ProductController productController;
    public MainApplication(){
        s = Singleton.s();
        menuController=Singleton.menuController();
        productController = Singleton.productController();

    }
    private void run(){

        try {
            while (true) {
                menuController.index();
                System.out.print("Enter options : ");

                int options = Integer.parseInt(s.nextLine());
                switch (options) {
                    case 1 -> productController.index();
                    case 2 -> productController.create();
                    case 3 -> productController.delete();
                    case 4 -> productController.update();
                    default -> throw new IllegalArgumentException();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        new MainApplication().run();

    }
}
