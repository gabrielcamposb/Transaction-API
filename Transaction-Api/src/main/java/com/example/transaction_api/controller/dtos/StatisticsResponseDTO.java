package com.example.transaction_api.controller.dtos;

public record StatisticsResponseDTO(Long count, Double sum, Double avg, Double min, Double max) {
    
}