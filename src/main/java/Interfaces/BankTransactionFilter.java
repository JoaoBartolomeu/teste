package main.java.Interfaces;

import main.java.Model.BankTransaction;

//Com o uso dessa interface, evito a duplicação e alteração do código para introduzir um novo parâmetro.
@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
