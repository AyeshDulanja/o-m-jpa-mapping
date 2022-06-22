package com.ad.jpa.controller;

import com.ad.jpa.dto.OrderRequest;
import com.ad.jpa.dto.OrderResponse;
import com.ad.jpa.entity.Customer;
import com.ad.jpa.repository.CustomerRepository;
import com.ad.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder") // http://localhost:8080/placeOrder - POST
    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerRepository.save(request.getCustomer());
    }

    @GetMapping("/findAllOrders") // http://localhost:8080/findAllOrders - GET
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo") // http://localhost:8080/getInfo - GET
    public List<OrderResponse> getJoinInformation(){
        return customerRepository.getJoinInformation();
    }
}
