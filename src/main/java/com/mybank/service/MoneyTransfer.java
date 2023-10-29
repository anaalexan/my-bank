//package com.mybank.service;
//
//import com.mybank.model.Account;
//import com.mybank.model.Currency;
//
//public class MoneyTransfer {
//    public void transfer (Account accountFrom, Account accountTo, double amount){
//        /*CurrencyName fromCurrency = accountFrom.getCurrency().getCurrencyName();
//        CurrencyName toCurrency = accountTo.getCurrency().getCurrencyName();
//        if(fromCurrency.equals(toCurrency)){
//            checkIfEnoughMoney(accountFrom,amount);
//            sendMoney(accountFrom,amount);
//            receiveMoney(accountTo, amount);
//        }else{
//            checkIfEnoughMoney(accountFrom,amount);
//            sendMoney(accountFrom,amount);
//            double newAmount = exchangeMoney(accountFrom.getCurrency(), accountTo.getCurrency(), amount);
//            receiveMoney(accountTo, newAmount);
//        }*/
//
//    }
//    private double exchangeMoney(Currency currencyFrom, Currency currencyTo, double amount){
//        Double rate = currencyTo.getExchangeRates().get(currencyFrom.getCurrencyName());
//        return amount * rate;
//    }
//    private void checkIfEnoughMoney(Account accountFrom, double amount){
//        if (amount > accountFrom.getAmount()) {
//            throw new IllegalStateException("No enough money to sent from account:" + accountFrom);
//        }
//    }
//    private void receiveMoney(Account accountTo, double amount){
//        accountTo.setAmount(accountTo.getAmount() + amount);
//    }
//    private void sendMoney(Account accountFrom, double amount){
//        accountFrom.setAmount(accountFrom.getAmount() - amount);
//    }
//}
