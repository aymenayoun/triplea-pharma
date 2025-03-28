package com.ayouni.tripleA.Pharma.dto;
import lombok.Data;

@Data
public class OrderItemRequest {
    private Long productId;
    private int quantity;
}
