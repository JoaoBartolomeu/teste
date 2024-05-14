package main.java.Controller;

import main.java.Interfaces.BankTransactionSummarizer;
import main.java.Model.BankTransaction;
import main.java.Interfaces.BankTransactionFilter;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor{
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

//    public List<BankTransaction> bankTransactionsInMonth(final Month month){
//
//        List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
//        for (BankTransaction bankTransaction: bankTransactions) {
//            if (bankTransaction.getDate().getMonth() == month) {
//                bankTransactionsInMonth.add(bankTransaction);
//            }
//        }
//        return  bankTransactionsInMonth;
//    }
     public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    public double calculateTotalInMonth(final Month month) {
        return summarizeTransactions((acc, bankTransaction) ->
                bankTransaction.getDate().getMonth() == month ? acc + bankTransaction.getAmount() : acc);
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

    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount){
        return findTransactions(bankTransaction -> bankTransaction.getAmount()>=amount);
    }

    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionfilter) {
        final List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransactionfilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return result;
    }
}