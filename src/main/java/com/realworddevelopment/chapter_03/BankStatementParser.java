package com.realworddevelopment.chapter_03;

import com.realworddevelopment.chapter_03.BankTransaction;

import java.util.List;

public interface BankStatementParser {

    BankTransaction parseFrom(String line) throws CSVSyntaxException;
    List<BankTransaction> parseLinesFrom(List<String> lines) throws CSVSyntaxException;
}
