package com.realworddevelopment.chapter_03;

import com.realworddevelopment.chapter_03.BankStatementCSVParser;

import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        bankStatementAnalyzer.analyze("bank-data-simple.csv", new BankStatementCSVParser());
    }
}
