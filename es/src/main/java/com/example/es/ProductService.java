package com.example.es;

import co.elastic.clients.elasticsearch._types.aggregations.Aggregation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    // 创建或更新文档
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // 根据 ID 查询文档
    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    // 删除文档
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    // 查询所有文档
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 分页查询
    public Page<Product> getProductsByPage(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    // 按名称模糊搜索
    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContaining(name);
    }

    // 按类别精确查询
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    /**
     * 聚合操作
     */
    public void aggregationOption(){
        NativeQuery query = NativeQuery.builder()
                .withQuery(q -> q.matchAll(m -> m))
                .withAggregation("agg1", Aggregation.of(a -> a.terms(t -> t.field("category"))))
                .build();
        SearchHits<Product> searchHits = elasticsearchOperations.search(query, Product.class);
    }
}
