package manager_p.service;

import manager_p.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService{
    private List<Product> productList = new ArrayList<>();

    public ProductService() {
        productList.add(new Product(1, "Máy lạnh", 20000000, "Iphone X", "Apple"));
        productList.add(new Product(2, "Điều hòa", 10000000, "Iphone 8", "Apple"));
        productList.add(new Product(3, "Tủ lạnh", 8000000, "Iphone 7", "Apple"));
        productList.add(new Product(4, "Xe LG", 6000000, "Iphone 6", "Apple"));
        productList.add(new Product(5, "Xe mô tô", 4000000, "Iphone 5", "Apple"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
                break;
            }
        }
    }

    @Override
    public void edit(int id, Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.set(i, product);
                break;
            }
        }
    }

    @Override
    public List<Product> findProductByName(String name) {
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++){
            if (productList.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                list.add(productList.get(i));
            }
        }
        return list;
    }
}
