package com.example.es;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    // 创建或更新产品
    @PostMapping
    public Product createOrUpdateProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // 根据 ID 获取产品
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    // 删除产品
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }

    // 获取所有产品
    @GetMapping
    public Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // 分页获取产品
    @GetMapping("/page")
    public Page<Product> getProductsByPage(@RequestParam int page, @RequestParam int size) {
        return productService.getProductsByPage(page, size);
    }

    // 搜索产品
    @GetMapping("/search")
    public List<Product> searchProductsByName(@RequestParam String name) {
        return productService.searchProductsByName(name);
    }

    // 按类别查询产品
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }
}
