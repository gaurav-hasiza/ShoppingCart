package com.online.shopping.cart.controller;

import com.online.shopping.cart.dtos.request.ProductCreateRequest;
import com.online.shopping.cart.dtos.request.ProductUpdateRequest;
import com.online.shopping.cart.dtos.response.ProductCreateResponse;
import com.online.shopping.cart.dtos.response.ProductListResponseDTO;
import com.online.shopping.cart.dtos.response.ProductUpdateResponseDTO;
import com.online.shopping.cart.entity.User;
import com.online.shopping.cart.enums.UserRole;
import com.online.shopping.cart.services.ProductService;
import com.online.shopping.cart.services.SessionManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v0/products")
public class ProductController {

    private final SessionManagementService sessionManagementService;

    private final ProductService productService;

    @Autowired
    public ProductController(SessionManagementService sessionManagementService, ProductService productService) {
        this.sessionManagementService = sessionManagementService;
        this.productService = productService;
    }

    /**
     * create the product
     *
     * @param cookieHeader
     * @param productCreateRequest
     * @return
     */
    @PostMapping
    public ResponseEntity create(@RequestHeader("Cookie") String cookieHeader,
                              @RequestBody ProductCreateRequest productCreateRequest) {
        try {
            User user = sessionManagementService.getUserBySessionId(cookieHeader);
            if (!user.getUserRole().equals(UserRole.ADMIN)){
                throw new Exception("Invalid Role");
            }
            // add validation on the user
            ProductCreateResponse response = productService.add(productCreateRequest);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * update the products.
     *
     * @param cookieHeader
     * @param productUpdateRequest
     * @return
     */
    @PutMapping
    public ResponseEntity update(@RequestHeader("Cookie") String cookieHeader,
                                 @RequestBody ProductUpdateRequest productUpdateRequest) {
        try {
            User user = sessionManagementService.getUserBySessionId(cookieHeader);
            if (!user.getUserRole().equals(UserRole.ADMIN)){
                throw new Exception("Invalid Role");
            }
            ProductUpdateResponseDTO response = productService.update(productUpdateRequest);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Get available product. Any Role is Authorise to perform this action
     *
     * @param cookieHeader
     * @return
     */
    @GetMapping
    public ResponseEntity listProduct(@RequestHeader("Cookie") String cookieHeader) {
        try {
            User user = sessionManagementService.getUserBySessionId(cookieHeader);
            if (!user.getUserRole().equals(UserRole.ADMIN)){
                throw new Exception("Invalid Role");
            }
            ProductListResponseDTO response = productService.listProduct();
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}