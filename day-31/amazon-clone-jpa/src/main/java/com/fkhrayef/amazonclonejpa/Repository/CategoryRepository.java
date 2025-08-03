package com.fkhrayef.amazonclonejpa.Repository;

import com.fkhrayef.amazonclonejpa.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
