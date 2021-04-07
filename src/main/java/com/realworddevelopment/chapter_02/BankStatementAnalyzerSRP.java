package com.realworddevelopment.chapter_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementAnalyzerSRP {

    private static final String RESOURCE = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

        final Path path = Paths.get(RESOURCE + "bank-data-simple.csv");
        final List<String> lines = Files.readAllLines(path);
        List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

        System.out.println("The total for all transaction is " + calculateTotalAmount(bankTransactions));
        System.out.println("Transactions in January " + selectInMonth(bankTransactions, Month.JANUARY));
    }

    private static double calculateTotalAmount(List<BankTransaction> bankTransactions) {
        double total = 0l;

        for ( final BankTransaction bankTransaction : bankTransactions ) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    private static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for ( final BankTransaction bankTransaction : bankTransactions ) {
            if ( bankTransaction.getDate().getMonth() == month ) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }


}
