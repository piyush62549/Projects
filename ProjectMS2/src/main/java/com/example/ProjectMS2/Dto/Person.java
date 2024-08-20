package com.example.ProjectMS2.Dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.util.List;


@Getter
@Setter
public class Person implements Serializable {


    private int personId;

    private String firstName;

    private  String lastName;

    private String city;

    private List<Order> Orders;

    public Person() {
    }
}
