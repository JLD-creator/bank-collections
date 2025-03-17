package org.ies.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;



@AllArgsConstructor
@Data
public class Account {
    protected String iban;
    protected String nif;
    protected Double balance;

    public boolean retired(Double amount){
        if(amount > balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    public void deposit(double amount) {
        balance += amount;
    }

}
