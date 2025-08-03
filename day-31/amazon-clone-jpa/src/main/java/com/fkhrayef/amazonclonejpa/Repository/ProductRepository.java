package com.fkhrayef.amazonclonejpa.Repository;

import com.fkhrayef.amazonclonejpa.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
