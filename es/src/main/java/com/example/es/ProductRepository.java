package com.example.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
    List<Product> findByNameContaining(String name); // 按名称模糊查询
    List<Product> findByCategory(String category);   // 按类别精确查询
    
}
