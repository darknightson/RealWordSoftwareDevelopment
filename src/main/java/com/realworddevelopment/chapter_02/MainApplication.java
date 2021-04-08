package com.realworddevelopment.chapter_02;

import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        bankStatementAnalyzer.analyze("bank-data-simple.csv", new BankStatementCSVParser());
    }
}
