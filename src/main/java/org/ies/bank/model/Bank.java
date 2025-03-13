package org.ies.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Bank {
    protected String name;
    protected Map<String, Account> accountsByIban;
    protected List<Customer> customers;
}
