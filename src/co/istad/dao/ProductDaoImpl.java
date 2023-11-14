package co.istad.dao;

import co.istad.database.ProductDatabase;
import co.istad.model.Product;
import co.istad.exception.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao{

    private final ProductDatabase productDb;
    public ProductDaoImpl(){
        productDb = new ProductDatabase();
    }
    @Override
    public Product insert(Product product) {
        productDb.getProducts().add(product);
        return product;
    }

    @Override
    public List<Product> select() {
        return productDb.getProducts();
    }

    @Override
    public Optional<Product> selectById(Long id) {
        return
                productDb.getProducts()
                        .stream()
                        .filter(product -> product.getId().equals(id))
                        .findFirst();

    }

    @Override
    public Product updateById(Product product) {
        return productDb.getProducts().stream()
                .filter(pro -> pro.getId().equals(product.getId()))
                .map(newpro -> product)
                .findFirst()
                .orElseThrow(()-> new ProductNotFoundException(String
                        .format("Product Id = %s does not exist in DB!",product.getId())));

    }

    @Override
    public Product deleteById(Long id) {
        Product foundproduct = productDb.getProducts().stream()
                .filter(pro -> pro.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ProductNotFoundException(String
                        .format("Product Id = %s does not exist in DB!",id)));
        productDb.getProducts().remove((foundproduct));
        return foundproduct;
    }

    @Override
    public List<Product> selectByName(String name) {

        return productDb.getProducts().stream().filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

}
