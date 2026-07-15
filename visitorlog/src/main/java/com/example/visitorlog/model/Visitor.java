package com.example.visitorlog.model;

import lombok.Data;

@Data
public class Visitor {
    private Long id;
    private String name;
    private String company;
    private String purpose;
}
