package org.ies.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class Bank {
    protected String name;
    protected Map<String, Account> accountsByIban;
    protected List<Customer> customers;

    public void depositMoney(String iban, double amount) {
        if (accountsByIban.containsKey(iban)) {
            Account account = accountsByIban.get(iban);
            account.setBalance((account.balance + amount));
        } else {
            System.out.println("No existe la cuenta");
        }
    }

    public List<Account> findCustomerAccounts(String nif) {
        if (customers.equals(nif)) {
            List<Account> customerAccounts = new LinkedList<>();
            for (Account account : accountsByIban.values()) {
                if (account.getNif().equals(nif)) {
                    customerAccounts.add(account);
                }
            }
            return customerAccounts;
        } else {
            return null;
        }
    }

    public Customer findCustomer(String nif) {
        for (var customer : customers) {
            if (customer.getNif().equals(nif)) {
                return customer;
            }
        }
        return null;
    }

    public void retiredMoney(String iban, double amount) {
        if (accountsByIban.containsKey(iban)) {
            Account account = accountsByIban.get(iban);
            account.retired(amount);
        } else {
            System.out.println("No existe la cuenta");
        }
    }

    public void transfer(String ibanOrigin, String ibanDestination, double amount) {
        if (accountsByIban.containsKey(ibanOrigin)) {
            var accountOrigin = accountsByIban.get(ibanOrigin);
            if (accountsByIban.containsKey(ibanDestination)) {
                var accountDestination = accountsByIban.get(ibanDestination);
                if (accountOrigin.retired(amount)) {
                    accountDestination.deposit(amount);
                } else {
                    System.out.println("No hay suficiente dinero");
                }
            } else {
                System.out.println("No existe la cuenta de origen");
            }
        } else {
            System.out.println("No existe la cuenta origen");
        }
    }
    public Set<String> showCustomer(int zipCode){
    Set<String> nifs = new HashSet<>();
   for (Customer customer: customers){
       if (customer.getZipCode() == zipCode){
           nifs.add(customer.getNif());
       }
   }
   return nifs;
    }
    public List<Account> foundAccounts (int zipCode){
        var nifs = showCustomer(zipCode);
        List<Account>  accountList = new LinkedList<>();
        for (Account account: accountsByIban.values()){
            if (nifs.contains(account.getNif())){
                accountList.add(account);
            }
        }
        return accountList;
    }
}



