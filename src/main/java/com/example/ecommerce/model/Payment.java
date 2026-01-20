package com.example.ecommerce.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Payment {

    @Id
    private String id;

    private String orderId;
    private double amount;
    private String status; // PENDING / SUCCESS
}
