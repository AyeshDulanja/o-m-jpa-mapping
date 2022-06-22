package com.ad.jpa.repository;

import com.ad.jpa.dto.OrderResponse;
import com.ad.jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query("SELECT new com.ad.jpa.dto.OrderResponse(c.name, p.productName, p.price) FROM Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();

}
