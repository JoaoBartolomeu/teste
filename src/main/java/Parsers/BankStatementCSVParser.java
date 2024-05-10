package main.java.Parsers;

import main.java.Interfaces.BankStatementParser;
import main.java.Model.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser implements BankStatementParser {
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public BankTransaction parseFrom(final String line){
        final String[] columns = line.split(",");
        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);

        return new BankTransaction(date, amount, columns[2]);
    }

    public List<BankTransaction> parseLinesFromCSV(final List<String> lines){

        List<BankTransaction> bankTransactions = new ArrayList<>();
        for (String line : lines){
            bankTransactions.add(parseFrom(line));
        }
        return bankTransactions;
    }
    //teste
}