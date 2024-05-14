package Interfaces;

import Model.BankTransaction;

//Com o uso dessa interface, evito a duplicação e alteração do código para introduzir um novo parâmetro.
@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
