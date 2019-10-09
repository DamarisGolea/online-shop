package org.fasttrackit.onlineshop.web;

import org.fasttrackit.onlineshop.service.CartService;
import org.fasttrackit.onlineshop.transfer.cart.AddProductToCartRequest;
import org.fasttrackit.onlineshop.transfer.cart.CartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;
    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @PutMapping
    public ResponseEntity addProductToCart (@RequestBody @Valid AddProductToCartRequest request){
        cartService.addProductToCart(request);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CartResponse> getCart (@PathVariable("id") long customerId){
        CartResponse cart = cartService.getCart(customerId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
}
