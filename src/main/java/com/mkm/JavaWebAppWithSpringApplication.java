package com.mkm;

import com.mkm.model.Product;
import com.mkm.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class JavaWebAppWithSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaWebAppWithSpringApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            List<Product> products = IntStream.range(1, 4)
                    .mapToObj(i -> new Product(UUID.randomUUID(), "Product #" + i,
                            "Product #" + i + " description"))
                    .collect(Collectors.toList());
            productRepository.getProducts().addAll(products);
        };
    }
}
