package com.ecom.cartservice.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.cartservice.model.Product;

@FeignClient(name = "product-service")//, url = "${product.service.url}")
public interface ProductServiceFeignClient {

    @GetMapping("/ecom/product/public/{id}")
    Product findById(@PathVariable("id") Long productId);

    @GetMapping("/ecom/product/public/productlist")
    List<Product> findAllByIds(@RequestParam("ids") List<Long> productIds);
}
