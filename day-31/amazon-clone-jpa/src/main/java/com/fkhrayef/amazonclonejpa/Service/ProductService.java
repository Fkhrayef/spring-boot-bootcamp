package com.fkhrayef.amazonclonejpa.Service;

import com.fkhrayef.amazonclonejpa.Model.Category;
import com.fkhrayef.amazonclonejpa.Model.Product;
import com.fkhrayef.amazonclonejpa.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer productId) {
        return productRepository.getById(productId);
    }

    public Boolean addProduct(Product product) {
        for (Category category : categoryService.getCategories()) {
            if (category.getId().equals(product.getCategoryId())) {
                productRepository.save(product);
                return true;
            }
        }
        return false;
    }

    public Integer updateProduct(Integer id, Product product) {
        Product oldProduct = productRepository.getById(id);
        if (oldProduct == null) {
            return 3; // product not found
        }
        for (Category category : categoryService.getCategories()) {
            if (category.getId().equals(product.getCategoryId())) {
                oldProduct.setName(product.getName());
                oldProduct.setPrice(product.getPrice());
                oldProduct.setCategoryId(product.getCategoryId());
                oldProduct.setCarbonFootprint(product.getCarbonFootprint());
                productRepository.save(oldProduct);
                return 1; // updated successfully
            }
        }
        return 2; // Product found but category is not found
    }

    public Boolean deleteProduct(Integer id) {
        Product product = productRepository.getById(id);
        if (product == null) {
            return false;
        }
        productRepository.delete(product);
        return true;
    }
}
