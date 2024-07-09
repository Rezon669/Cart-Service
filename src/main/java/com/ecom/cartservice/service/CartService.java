package com.ecom.cartservice.service;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.cartservice.exception.CustomException;
import com.ecom.cartservice.feignclient.ProductServiceFeignClient;
import com.ecom.cartservice.model.Cart;
import com.ecom.cartservice.model.Product;
import com.ecom.cartservice.repository.CartRepository;

@Service
public class CartService {
    private static final Logger logger = LogManager.getLogger(CartService.class);

    @Autowired
    private ProductServiceFeignClient productFeignClient;

    @Autowired
    private CartRepository cartRepository;

    public String addToCart(Long productId, Long userId) throws CustomException {
        try {
            Product product = productFeignClient.findById(productId);
            if (product == null) {
                throw new CustomException("Product not found");
            }

            Cart cart = new Cart();
            cart.setUserid(userId);
            cart.setProductid(productId);

            cartRepository.save(cart);
            return "Successfully added to cart";
        } catch (CustomException e) {
            logger.error("CustomException: ", e);
            throw e;
        } catch (Exception e) {
            logger.error("Exception: ", e);
            throw new CustomException("An error occurred while adding to cart");
        }
    }

    public List<Product> getCartProducts(Long userid) throws CustomException {
        List<Long> productIds = cartRepository.findProductIdsByUserId(userid);

        if (productIds.isEmpty()) {
            throw new CustomException("No products are there in the cart");
        }

        List<Product> products = productFeignClient.findAllByIds(productIds);

        if (products.isEmpty()) {
            throw new CustomException("No product details found for the provided IDs");
        }

        return products;
    }
}
