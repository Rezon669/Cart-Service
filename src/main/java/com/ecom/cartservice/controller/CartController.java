//package com.ecom.cartservice.controller;
//
//
//
//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ecom.cartservice.exception.CustomException;
//import com.ecom.cartservice.model.Product;
//import com.ecom.cartservice.service.CartService;
//
//@RestController
//@RequestMapping("/easybuy/cart")
//public class CartController {
//    private static final Logger logger = LogManager.getLogger(CartController.class);
//
//  
//     CartService cartService;
//
//    @PostMapping("/public/addtocart")
//    public ResponseEntity<String> addCart(@RequestParam("productId") Long productId,
//                                          @RequestParam("userId") Long userId) {
//        try {
//            cartService.addToCart(productId, userId);
//            logger.info("Product added to cart");
//            return ResponseEntity.accepted().body("Product details added to cart");
//        } catch (CustomException e) {
//            logger.error(e);
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//
//    @GetMapping("/public/getcartproducts")
//    public ResponseEntity<List<Product>> getCartProducts(@RequestParam("userid") Long userid) {
//        try {
//            List<Product> list = cartService.getCartProducts(userid);
//            logger.info("Product fetched from cart");
//            return ResponseEntity.ok(list);
//        } catch (CustomException e) {
//            logger.error(e);
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
//}
package com.ecom.cartservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.cartservice.exception.CustomException;
import com.ecom.cartservice.model.Product;
import com.ecom.cartservice.service.CartService;

@RestController
@RequestMapping("/ecom/cart")
public class CartController {
	// private static final Logger logger =
	// LogManager.getLogger(CartController.class);

	@Autowired
	private CartService cartService;

	@PostMapping("/public/addtocart")
	public ResponseEntity<String> addCart(@RequestParam("productId") Long productId,
			@RequestParam("userId") Long userId) {
		try {
			cartService.addToCart(productId, userId);
			// logger.info("Product added to cart");
			return ResponseEntity.accepted().body("Product details added to cart");
		} catch (CustomException e) {
			// logger.error(e);
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/public/getcartproducts/{userid}")
	public ResponseEntity<List<Product>> getCartProducts(@PathVariable("userid") Long userid) {
		try {
			List<Product> list = cartService.getCartProducts(userid);
			// logger.info("Product fetched from cart");
			return ResponseEntity.ok(list);
		} catch (CustomException e) {
			// logger.error(e);
			return ResponseEntity.badRequest().body(null);
		}
	}
}
