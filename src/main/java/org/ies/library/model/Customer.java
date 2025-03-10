package org.ies.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Customer {
    protected String nif;
    protected String name;
    protected String surname;
    protected int zipCode;
    List<Customer> customers;
}
