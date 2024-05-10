package test.java;

import main.java.Model.BankTransaction;
import main.java.Parsers.BankStatementCSVParser;
import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;
import java.time.Month;

public class BankTransactionCSVParseTest {
    final private BankStatementCSVParser statementCSVParser = new BankStatementCSVParser();

    @Test
    public void testParse(){
        String line = "30-01-2017,-100,Deliveroo";
        final BankTransaction result = statementCSVParser.parseFrom(line);
        final BankTransaction bankTransactionExpectd = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -100, "Deliveroo");
        Assert.assertEquals(result.getDate(), bankTransactionExpectd.getDate());
        Assert.assertEquals(result.getAmount(), bankTransactionExpectd.getAmount(), 0.0d);
        Assert.assertEquals(result.getDescription(), bankTransactionExpectd.getDescription());
    }
}