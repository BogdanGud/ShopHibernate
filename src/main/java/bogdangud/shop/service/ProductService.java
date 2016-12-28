package bogdangud.shop.service;

import bogdangud.shop.dao.ProductDao;
import bogdangud.shop.model.Product;

import java.util.List;

public class ProductService {
    private ProductDao productDao = new ProductDao();

    public void create(Product newProduct) {
        productDao.add(newProduct);
    }

    public Product get(int id) {
        return productDao.get(id);
    }

    public void delete(int id) {
        productDao.delete(id);
    }

    public void update(Product newProduct) {
        productDao.update(newProduct);
    }

    public List<Product> getAll() {
        return productDao.getAll();
    }
}
