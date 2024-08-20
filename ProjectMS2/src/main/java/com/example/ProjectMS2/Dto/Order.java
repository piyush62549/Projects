package com.example.ProjectMS2.Dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class Order implements Serializable {
    private static final long SerialVersionUIDAdder = 1L;

    private Person person;

    private int Id;

    private  String orderDate;

    private int purchaseAmount;

    public Order(){
    }


}
