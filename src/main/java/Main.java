package main.java;

import main.java.Interfaces.BankStatementParser;
import main.java.Parsers.BankStatementCSVParser;
import main.java.View.BankTransactionAnalyser;

import java.io.IOException;

public class Main {

    public static void main( String[] args) throws IOException {

        final  String fileName = "bank-data-simple.csv";
        BankTransactionAnalyser bankTransactionAnalyser = new BankTransactionAnalyser();
        BankStatementParser bankStatementParser = new BankStatementCSVParser();
        bankTransactionAnalyser.analyser(fileName,bankStatementParser );

   }
}