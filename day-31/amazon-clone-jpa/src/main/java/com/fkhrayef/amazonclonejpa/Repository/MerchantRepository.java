package com.fkhrayef.amazonclonejpa.Repository;

import com.fkhrayef.amazonclonejpa.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
}
