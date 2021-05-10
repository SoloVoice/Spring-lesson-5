package ru.geekbrains.boot.servises;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.boot.model.Product;
import ru.geekbrains.boot.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductRepository productsRepository;

    public List<Product> getAllProducts() {
        return productsRepository.getAllProducts();
    }

    public void addProductToBD(long id, String name, long cost) {
        productsRepository.addProductToDB(new Product(id, name, cost));
    }
    public void deleteProduct(long id) {
        productsRepository.deleteProductById(id);
    }

}
