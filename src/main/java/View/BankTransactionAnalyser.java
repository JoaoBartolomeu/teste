package main.java.View;

import main.java.Controller.BankStatementProcessor;
import main.java.Interfaces.BankStatementParser;
import main.java.Model.BankTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyser {

    private static final String RESOURCES ="C:\\Users\\SENAI\\IdeaProjects\\AnaliseDeExtratosBancarios\\src\\main\\resources\\";

    public void analyser(String fileName, BankStatementParser bankStatementParser) throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);

        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);

        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectInformation(bankStatementProcessor);
    }

    private void collectInformation(BankStatementProcessor bankStatementProcessor){

        System.out.println("The total for Transaction is: " + bankStatementProcessor.calculateAmount());
        System.out.println("The total for Transactions in January is: " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for Transactions in February is: " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total for Transaction per category: " + bankStatementProcessor.calculateTotalForCategory("Salary"));
        System.out.println("The total for Transaction Greater Than Equal is: "
                + bankStatementProcessor.findTransactionsGreaterThanEqual(1000));
    }
}