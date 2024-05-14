
import Controller.HtmlExporter;
import Interfaces.BankStatementParser;
import Parsers.BankStatementCSVParser;
import View.BankTransactionAnalyser;
import java.io.IOException;

public class Main {

    public static void main( String[] args) throws IOException {

        final  String fileName = "bank-data-simple.csv";
        HtmlExporter exporter = new HtmlExporter();
        BankTransactionAnalyser bankTransactionAnalyser = new BankTransactionAnalyser();
        BankStatementParser bankStatementParser = new BankStatementCSVParser();
        bankTransactionAnalyser.analyser(fileName,bankStatementParser, exporter );

   }
}