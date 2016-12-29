import bogdangud.shop.model.Product;
import bogdangud.shop.service.ProductService;
import org.junit.Assert;
import org.junit.Test;


public class ProductServiceTest {

    ProductService productService = new ProductService();

    @Test
    public void testCreateGetProduct() {
        Product newProduct = new Product("testCreate", 1000d);
        Product fromDB = productService.create(newProduct);
        Assert.assertEquals("testCreate", productService.get(fromDB.getId()).getName());
        Assert.assertEquals(1000d, productService.get(fromDB.getId()).getPrice(), 0.1);
    }

    @Test
    public void testUpdate() {
        Product newProduct = new Product("someText", 1200d);
        Product fromDB = productService.create(newProduct);
        fromDB.setName("testUpdate");
        Assert.assertEquals("testUpdate", productService.get(fromDB.getId()).getName());
        Assert.assertEquals(1200, productService.get(fromDB.getId()).getPrice(), 0.1);

    }


}
