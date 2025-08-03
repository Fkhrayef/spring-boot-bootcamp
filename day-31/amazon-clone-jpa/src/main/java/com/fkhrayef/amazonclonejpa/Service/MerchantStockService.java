package com.fkhrayef.amazonclonejpa.Service;

import com.fkhrayef.amazonclonejpa.Model.Merchant;
import com.fkhrayef.amazonclonejpa.Model.MerchantStock;
import com.fkhrayef.amazonclonejpa.Model.Product;
import com.fkhrayef.amazonclonejpa.Repository.MerchantStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantStockService {

    private final MerchantStockRepository merchantStockRepository;
    private final ProductService productService;
    private final MerchantService merchantService;

    public List<MerchantStock> getMerchantStocks() {
        return merchantStockRepository.findAll();
    }

    public Integer addMerchantStock(MerchantStock merchantStock) {
        // validate stock is not 10 or under
        if (merchantStock.getStock() <= 10) {
            return 4; // stock is 10 or under
        }

        for (Product product : productService.getProducts()) {
            if (product.getId().equals(merchantStock.getProductId())) {
                for (Merchant merchant : merchantService.getMerchants()) {
                    if (merchant.getId().equals(merchantStock.getMerchantId())) {
                        merchantStockRepository.save(merchantStock);
                        return 1; // added successfully
                    }
                }
                return 3; // merchant not found
            }
        }
        return 2; // product not found
    }

    public Integer updateMerchantStock(Integer id, MerchantStock merchantStock) {
        MerchantStock oldMerchantStock = merchantStockRepository.getById(id);
        if (oldMerchantStock == null) {
            return 3; // MerchantStock not found
        }

        for (Merchant merchant : merchantService.getMerchants()) {
            if (merchant.getId().equals(merchantStock.getMerchantId())) {
                for (Product product : productService.getProducts()) {
                    if (product.getId().equals(merchantStock.getProductId())) {
                        oldMerchantStock.setStock(merchantStock.getStock());
                        oldMerchantStock.setMerchantId(merchantStock.getMerchantId());
                        oldMerchantStock.setProductId(merchantStock.getProductId());
                        merchantStockRepository.save(oldMerchantStock);
                        return 1; // updated successfully
                    }
                }
                return 2; // MerchantStock and Merchant found but Product is not found
            }
        }
        return 4; // MerchantStock found but Merchant is not found
    }

    public Boolean deleteMerchantStock(Integer id) {
        MerchantStock merchantStock = merchantStockRepository.getById(id);
        if (merchantStock == null) {
            return false;
        }
        merchantStockRepository.delete(merchantStock);
        return true;
    }

    public Integer addStock(Integer merchantId, Integer productId, Integer additionalStock) {
        // Validate additional stock is positive
        if (additionalStock <= 0) {
            return 2; // Invalid stock amount
        }

        // Check if merchant exists
        boolean merchantExists = false;
        for (Merchant m : merchantService.getMerchants()) {
            if (m.getId().equals(merchantId)) {
                merchantExists = true;
                break;
            }
        }
        if (!merchantExists) return 3; // Merchant not found

        // Check if product exists
        boolean productExists = false;
        for (Product p : productService.getProducts()) {
            if (p.getId().equals(productId)) {
                productExists = true;
                break;
            }
        }
        if (!productExists) return 4; // Product not found

        // Find and update the merchant stock
        List<MerchantStock> merchantStocks = merchantStockRepository.findAll();
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getProductId().equals(productId) &&
                    merchantStocks.get(i).getMerchantId().equals(merchantId)) {

                Integer currentStock = merchantStocks.get(i).getStock();
                merchantStocks.get(i).setStock(currentStock + additionalStock);
                merchantStockRepository.save(merchantStocks.get(i));
                return 1; // Success
            }
        }
        return 5; // MerchantStock not found
    }
}
