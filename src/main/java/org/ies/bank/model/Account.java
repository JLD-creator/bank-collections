package org.ies.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
public class Account {
    protected String iban;
    protected String nif;
    protected Double balance;
    Map<String, Account> accountsByIban;

}
