package com.awsft.knifeandmustache.dto.error;

public record ErrorResponse (
    String timestramp, 
    int status, 
    String error, 
    String message, 
    String path) {}
