package com.fkhrayef.amazonclonejpa.Service;

import com.fkhrayef.amazonclonejpa.Model.Merchant;
import com.fkhrayef.amazonclonejpa.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepository merchantRepository;

    public List<Merchant> getMerchants() {
        return merchantRepository.findAll();
    }

    public void addMerchant(Merchant merchant) {
        merchantRepository.save(merchant);
    }

    public Boolean updateMerchant(Integer id, Merchant merchant) {
        Merchant oldMerchant = merchantRepository.getById(id);
        if (oldMerchant == null) {
            return false;
        }
        oldMerchant.setName(merchant.getName());
        merchantRepository.save(oldMerchant);
        return true;
    }

    public Boolean deleteMerchant(Integer id) {
        Merchant merchant = merchantRepository.getById(id);
        if (merchant == null) {
            return false;
        }
        merchantRepository.delete(merchant);
        return true;
    }

    public List<Merchant> getTopMerchants() {
        List<Merchant> topMerchants = merchantRepository.findAll();
        topMerchants.sort(Comparator.comparingDouble(Merchant::getRating).reversed());

        int count = Math.min(5, topMerchants.size()); // setting maximum suggested product size to 5.

        return topMerchants.subList(0, count);
    }
}
