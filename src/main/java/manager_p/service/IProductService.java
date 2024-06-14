package manager_p.service;

import manager_p.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    void create(Product product);
    void delete(int id);
    void edit(int id , Product product);
    List<Product> findProductByName(String name);
}
