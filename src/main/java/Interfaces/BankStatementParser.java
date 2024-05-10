package main.java.Interfaces;

import main.java.Model.BankTransaction;

import java.util.List;

public interface BankStatementParser {
    BankTransaction parseFrom(final String line);
    List<BankTransaction> parseLinesFromCSV(final List<String> lines);
}
