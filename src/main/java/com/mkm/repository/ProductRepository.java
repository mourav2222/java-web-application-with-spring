package com.mkm.repository;

import com.mkm.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@AllArgsConstructor
public class ProductRepository {

    @Getter
    List<Product> products;

    public ProductRepository() {
        this(new ArrayList<>());
    }



    public List<Product> findAll() {
        return this.products;
    }

    private static List<Product> datas() {
        return List.of(
                new Product(UUID.randomUUID(), "Product #1", "Description #1"),
                new Product(UUID.randomUUID(), "Product #2", "Description #2"),
                new Product(UUID.randomUUID(), "Product #3", "Description #3")
        );
    }

    public Optional<Product> findOneById(UUID id) {
        return this.products.stream()
                .filter(product -> Objects.equals(id, product.getId()))
                .findFirst();
    }


}
