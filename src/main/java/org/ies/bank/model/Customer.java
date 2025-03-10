package org.ies.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Customer {
    protected String nif;
    protected String name;
    protected String surname;
    protected int zipCode;

}
