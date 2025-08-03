package com.fkhrayef.amazonclonejpa.Service;

import com.fkhrayef.amazonclonejpa.Model.*;
import com.fkhrayef.amazonclonejpa.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final MerchantStockService merchantStockService;
    private final ProductService productService;
    private final MerchantService merchantService;
    private final CategoryService categoryService;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public Boolean updateUser(Integer id, User user) {
        User oldUser = userRepository.getById(id);
        if (oldUser == null) {
            return false;
        }
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setBalance(user.getBalance());
        oldUser.setCountry(user.getCountry());
        userRepository.save(oldUser);
        return true;
    }

    public Boolean deleteUser(Integer id) {
        User user = userRepository.getById(id);
        if (user == null) {
            return false;
        }
        userRepository.delete(user);
        return true;
    }

    public Integer buyProduct(Integer userId, Integer productId, Integer merchantId, String coupon) {

        // Check if user exists
        boolean userExists = false;
        User user = null; // to use later (saves us a for loop of O(n))
        for (User u : userRepository.findAll()) {
            if (u.getId().equals(userId)) {
                userExists = true;
                user = u;
                break;
            }
        }
        if (!userExists) return 2; // User not found

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
        Product product = null; // to use later (saves us a for loop of O(n))
        for (Product p : productService.getProducts()) {
            if (p.getId().equals(productId)) {
                productExists = true;
                product = p;
                break;
            }
        }
        if (!productExists) return 4; // Product not found

        // Check if product in stock
        boolean productInStock = false;
        MerchantStock merchantStock = null; // to use later (saves us a for loop of O(n))
        for (MerchantStock m : merchantStockService.getMerchantStocks()) {
            if (m.getProductId().equals(productId) && m.getMerchantId().equals(merchantId)) {
                if (m.getStock() >= 1) {
                    productInStock = true;
                    merchantStock = m;
                    break;
                }
            }
        }
        if (!productInStock) return 5; // product is out of stock

        // check if user has a coupon
        boolean couponStatus = false; // no coupon provided
        if (coupon != null) {
            if (!coupon.matches("^[a-zA-Z]{4}-\\d{1,2}$") || !coupon.equals(merchantStock.getCoupon())) {
                return 7; // Invalid coupon
            } else {
                couponStatus = true;
            }
        }

        if (couponStatus) {
            // get coupon discount amount
            int discount = Integer.parseInt(coupon.substring(5));

            // Check if user has sufficient funds
            double discountedPrice = product.getPrice() * (1 - discount / 100.0);
            if (user.getBalance() < discountedPrice) {
                return 6; // insufficient funds
            }
            user.setBalance(user.getBalance() - discountedPrice); // reduce balance with discount
        } else {
            // Check if user has sufficient funds
            if (user.getBalance() < product.getPrice()) {
                return 6; // insufficient funds
            }
            user.setBalance(user.getBalance() - product.getPrice()); // reduce balance without discount
        }
        // success
        merchantStock.setStock(merchantStock.getStock() - 1); // reduce stock
        // statistics
        // Track purchase as view
        product.setViewCount(product.getViewCount() + 1);
        // Add loyalty points:
        int pointsEarned = (int) Math.floor(product.getPrice()); // 1 point per dollar spent
        user.setLoyaltyPoints(user.getLoyaltyPoints() + pointsEarned);
        // Country bought from:
        if (user.getCountry().equals("Saudi Arabia")) {
            product.setSaudiBuyCount(product.getSaudiBuyCount() + 1); // saudi bought the product
        } else {
            product.setKuwaitBuyCount(product.getKuwaitBuyCount() + 1); // kuwaiti bought the product
        }
        // Merchant Rating
        for (Merchant m : merchantService.getMerchants()) {
            if (m.getId().equals(merchantStock.getMerchantId())) {
                m.setRating(m.getRating() + 1); // add 1 score for buys
                merchantService.updateMerchant(m.getId(), m);
                break;
            }
        }
        // Add carbon footprint tracking:
        user.setTotalCarbonFootprint(user.getTotalCarbonFootprint() + product.getCarbonFootprint());

        // SAVE CHANGES
        userRepository.save(user);
        merchantStockService.updateMerchantStock(merchantStock.getId(), merchantStock);
        productService.updateProduct(product.getId(), product);
        return 1; // Bought the product successfully
    }

    // Extra: Refund a product
    public Integer refundProduct(Integer userId, Integer productId, Integer merchantId) {

        // Check if user exists
        boolean userExists = false;
        User user = null; // to use later (saves us a for loop of O(n))
        for (User u : userRepository.findAll()) {
            if (u.getId().equals(userId)) {
                userExists = true;
                user = u;
                break;
            }
        }
        if (!userExists) return 2; // User not found

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
        Product product = null; // to use later (saves us a for loop of O(n))
        for (Product p : productService.getProducts()) {
            if (p.getId().equals(productId)) {
                productExists = true;
                product = p;
                break;
            }
        }
        if (!productExists) return 4; // Product not found

        // Get Merchant Stock
        MerchantStock merchantStock = null;
        for (MerchantStock m : merchantStockService.getMerchantStocks()) {
            if (m.getProductId().equals(productId) && m.getMerchantId().equals(merchantId)) {
                merchantStock = m;
                break;
            }
        }
        if (merchantStock == null) return 5; // MerchantStock not found

        // success
        merchantStock.setStock(merchantStock.getStock() + 1); // add stock
        user.setBalance(user.getBalance() + product.getPrice()); // refund balance
        // statistics
        if (user.getCountry().equals("Saudi Arabia")) {
            // saudi refunded the product
            if (product.getSaudiBuyCount() > 0) {
                product.setSaudiBuyCount(product.getSaudiBuyCount() - 1);
            }
        } else {
            // kuwaiti refunded the product
            if (product.getKuwaitBuyCount() > 0) {
                product.setKuwaitBuyCount(product.getKuwaitBuyCount() - 1);
            }
        }
        for (Merchant m : merchantService.getMerchants()) {
            if (m.getId().equals(merchantStock.getMerchantId())) {
                m.setRating(m.getRating() - 2); // subtract 2 scores for returns
                merchantService.updateMerchant(m.getId(), m);
                break;
            }
        }
        // Reduce carbon footprint on return:
        if (user.getTotalCarbonFootprint() >= product.getCarbonFootprint()) {
            user.setTotalCarbonFootprint(user.getTotalCarbonFootprint() - product.getCarbonFootprint());
        } else {
            user.setTotalCarbonFootprint(0.0); // Prevent negative values
        }

        // SAVE CHANGES:
        userRepository.save(user);
        merchantStockService.updateMerchantStock(merchantStock.getId(), merchantStock);
        productService.updateProduct(product.getId(), product);
        return 1; // Refunded the product successfully
    }

    // Extra: suggested items based on user country
    public List<Product> getSuggestedProducts(Integer userId) {
        List<Product> products = productService.getProducts();

        // get user
        User user = null;
        boolean userExists = false;
        for (User u : userRepository.findAll()) {
            if (u.getId().equals(userId)) {
                userExists = true;
                user = u;
                break;
            }
        }

        if (!userExists) return null; // user doesn't exist

        // Sort by priority: Buys (most important) → Views → Eco-friendliness (least important)
        if (user.getCountry().equals("Saudi Arabia")) {
            products.sort((p1, p2) -> {
                // Priority scoring: Buys × 10 + Views × 2 + Eco bonus
                int score1 = (p1.getSaudiBuyCount() * 10) + (p1.getViewCount() * 2) + (int)(10 - p1.getCarbonFootprint());
                int score2 = (p2.getSaudiBuyCount() * 10) + (p2.getViewCount() * 2) + (int)(10 - p2.getCarbonFootprint());
                return Integer.compare(score2, score1); // Higher score first
            });
        } else {
            products.sort((p1, p2) -> {
                // Priority scoring: Buys × 10 + Views × 2 + Eco bonus
                int score1 = (p1.getKuwaitBuyCount() * 10) + (p1.getViewCount() * 2) + (int)(10 - p1.getCarbonFootprint());
                int score2 = (p2.getKuwaitBuyCount() * 10) + (p2.getViewCount() * 2) + (int)(10 - p2.getCarbonFootprint());
                return Integer.compare(score2, score1); // Higher score first
            });
        }

        int count = Math.min(15, products.size()); // setting maximum suggested product size to 15.
        return products.subList(0, count);
    }

    // Extra: Discounts
    public Integer addDiscount(Integer userId, Integer merchantStockId, String coupon) {
        // check if user exists and his permissions
        int userState = 3; // user not found
        for (User u : userRepository.findAll()) {
            if (u.getId().equals(userId)) {
                if (u.getRole().equals("Admin")) {
                    userState = 1; // user found and has permissions
                    break;
                } else {
                    userState = 2; // user doesn't have permissions
                }
            }
        }
        if (userState == 3) {
            return 3; // user not found
        } else if (userState == 2) {
            return 2; // user doesn't have permissions
        } else {
            for (MerchantStock m : merchantStockService.getMerchantStocks()) {
                if (m.getId().equals(merchantStockId)) {
                    m.setCoupon(coupon);
                    merchantStockService.updateMerchantStock(m.getId(), m);
                    return 1; // user found and has permissions
                }
            }
            return 4; // MerchantStock not found
        }
    }

    // Extra: allows users to buy gift cards
    public String buyGiftCard(Integer userId, Double amount) {
        if (amount != 10 && amount != 20 && amount != 50 && amount != 80 && amount != 100) {
            return "2"; // invalid gift card amount
        }

        boolean userExists = false;
        User user = null;
        for (User u : userRepository.findAll()) {
            if (u.getId().equals(userId)) {
                userExists = true;
                user = u;
                break;
            }
        }

        if (!userExists) return "3"; // user not found

        if (user.getBalance() < amount) {
            return "4"; // insufficient amount
        }

        // Deduct the gift card amount from user's balance
        user.setBalance(user.getBalance() - amount);
        userRepository.save(user);

        // check if category is created
        boolean categoryExist = false;

        for (Category c : categoryService.getCategories()) {
            if (c.getId().equals(999)) {
                categoryExist = true;
                break;
            }
        }

        // if it's not created, create it
        if (!categoryExist) {
            // add the category
            categoryService.addCategory(new Category(999, "Gift Cards"));
        }

        // success
        Integer giftCardCode = Integer.parseInt("1" + userId + System.currentTimeMillis() / 1000000);
        // Create new Product (gift card)
        Product giftCard = new Product(
                giftCardCode,                    // id
                "Gift Card $" + amount,          // name
                amount,                          // price
                999,                              // categoryId
                0,                               // saudiBuyCount
                0,                               // kuwaitBuyCount
                0,                               // viewCount
                0.0                              // carbonFootprint
        );

        // Add to products
        productService.addProduct(giftCard);

        // Return gift card code
        return "" + giftCardCode;
    }

    // Extra: redeem gift card
    public Integer redeemGiftCard(Integer userId, String giftCardCode) {
        // Validate user exists
        boolean userExists = false;
        User user = null;
        for (User u : userRepository.findAll()) {
            if (u.getId().equals(userId)) {
                userExists = true;
                user = u;
                break;
            }
        }
        if (!userExists) return 2; // user not found

        // Find gift card
        boolean giftCardExists = false;
        Product giftCard = null;
        for (Product p: productService.getProducts()) {
            if (p.getId().equals(Integer.parseInt(giftCardCode)) && p.getCategoryId().equals(999)) {
                giftCardExists = true;
                giftCard = p;
                break;
            }
        }
        if (!giftCardExists) return 3; // invalid gift card

        // success
        user.setBalance(user.getBalance() + giftCard.getPrice());
        userRepository.save(user);
        productService.deleteProduct(Integer.parseInt(giftCardCode));
        return 1; // gift card redeemed successfully
    }

    public Integer spendPoints(Integer userId, Integer points) {
        // Validate points amount (minimum 100 points = $1)
        if (points < 100 || points % 100 != 0) {
            return 2; // Invalid points amount (must be multiple of 100)
        }

        // Find user
        boolean userExists = false;
        User user = null;
        for (User u : userRepository.findAll()) {
            if (u.getId().equals(userId)) {
                userExists = true;
                user = u;
                break;
            }
        }
        if (!userExists) return 3; // User not found

        // Check if user has enough points
        if (user.getLoyaltyPoints() < points) {
            return 4; // Insufficient points
        }

        // Convert points to balance (100 points = $1)
        double balanceToAdd = points / 100.0;
        user.setLoyaltyPoints(user.getLoyaltyPoints() - points);
        user.setBalance(user.getBalance() + balanceToAdd);
        userRepository.save(user);

        return 1; // Success
    }

    // Extra: get user's carbon footprint
    public Double getUserCarbonFootprint(Integer userId) {
        for (User u : userRepository.findAll()) {
            if (u.getId().equals(userId)) {
                return u.getTotalCarbonFootprint();
            }
        }
        return null; // User not found
    }

    // Extra: get carbon footprint leaderboard (lowest first = most eco-friendly)
    public List<User> getCarbonFootprintLeaderboard() {
        List<User> leaderboard = userRepository.findAll();
        leaderboard.sort(Comparator.comparingDouble(User::getTotalCarbonFootprint));

        int count = Math.min(3, leaderboard.size()); // Top 3 eco-friendly users
        return leaderboard.subList(0, count);
    }
}
