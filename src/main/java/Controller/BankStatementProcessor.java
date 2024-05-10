package main.java.Controller;

import main.java.Model.BankTransaction;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    final private List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateAmount(){
        double total = 0d;
        for (final BankTransaction bankTransaction: bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public List<BankTransaction> bankTransactionsInMonth(final Month month){

        List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for (BankTransaction bankTransaction: bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return  bankTransactionsInMonth;
    }

    public double calculateTotalForCategory(String category){
        double total = 0d;
        for (BankTransaction bankTransaction: bankTransactions){
            if (bankTransaction.getDescription().equals(category)){
                total+= bankTransaction.getAmount();
            }
        }
        return total;
    }
}