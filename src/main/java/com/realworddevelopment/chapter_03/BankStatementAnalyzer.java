package com.realworddevelopment.chapter_03;

import com.realworddevelopment.chapter_03.BankStatementParser;
import com.realworddevelopment.chapter_03.BankStatementProcessor;
import com.realworddevelopment.chapter_03.BankTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

    private static final String RESOURCES = "src/main/resources/";

    public void analyze( final String fileName, final BankStatementCSVParser bankStatementParser ) throws IOException {
        Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transaction is a " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transaction in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transaction in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
        // functionInterface
        System.out.println("findTransactionGreaterThanEqual " + bankStatementProcessor.findTransactionGreaterThanEqual(1000));
        System.out.println("findTransactionInMonth " + bankStatementProcessor.findTransactionInMonth(Month.FEBRUARY));
        System.out.println("The function interface test " + bankStatementProcessor.findTransactionsGreaterThanEqualInMonth(Month.FEBRUARY,6_000));


        //System.out.println("The summarizeTransaction " + bankStatementProcessor.summarizeTransaction());

    }
}
