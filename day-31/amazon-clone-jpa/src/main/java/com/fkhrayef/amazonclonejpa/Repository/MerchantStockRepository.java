package com.fkhrayef.amazonclonejpa.Repository;

import com.fkhrayef.amazonclonejpa.Model.MerchantStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantStockRepository extends JpaRepository<MerchantStock, Integer> {
}
