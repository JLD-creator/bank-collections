package org.ies.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;



@AllArgsConstructor
@Data
public class Account {
    protected String iban;
    protected String nif;
    protected Double balance;


}
