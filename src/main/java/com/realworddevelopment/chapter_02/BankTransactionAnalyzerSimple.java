package com.realworddevelopment.chapter_02;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCE = "src/main/resources/";
    public final static DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(final String[] args) throws Exception {
        final Path path = Paths.get(RESOURCE + "bank-data-simple.csv");
        final List<String> lines = Files.readAllLines(path);
        double total = 0l;

        for ( final String line : lines ) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transaction is " + total);

        for ( final String line : lines ) {
            final String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            if ( date.getMonth() == Month.JANUARY ) {
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }
        }
        System.out.println("The total for all transactions in January is  " + total);
    }
}
