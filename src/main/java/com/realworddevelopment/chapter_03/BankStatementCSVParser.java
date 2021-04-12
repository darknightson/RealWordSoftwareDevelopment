package com.realworddevelopment.chapter_03;

import com.realworddevelopment.chapter_03.BankStatementParser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser implements BankStatementParser {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final int EXPECTED_ATTRIBUTES_LENGTH = 3;

    public BankTransaction parseFrom(final String line) throws CSVSyntaxException {
        final String[] columns = line.split(",");

//        if ( columns.length >= EXPECTED_ATTRIBUTES_LENGTH ) {
//            throw new CSVSyntaxException("ERROR-001","csv 자릿수 부족 입니다.");
//        }

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date, amount, description);
    }

    public List<BankTransaction> parseLinesFrom(final List<String> lines) throws CSVSyntaxException {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for ( final String line : lines ) {
            bankTransactions.add(parseFrom(line));
        }
        return bankTransactions;
    }



}
