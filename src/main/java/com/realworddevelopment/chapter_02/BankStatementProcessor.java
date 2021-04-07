package com.realworddevelopment.chapter_02;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    /**
     * 전체 금액 계산
     * @return
     */
    public double calculateTotalAmount() {
        double total = 0l;
        for ( BankTransaction bankTransaction : bankTransactions ) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    /**
     * 월별 금액 계산
     * @param month
     * @return
     */
    public double calculateTotalInMonth(final Month month) {
        double total = 0l;
        for ( BankTransaction bankTransaction : bankTransactions ) {
            if ( bankTransaction.getDate().getMonth() == month ) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    /**
     * category 금액 계산
     * @param category
     * @return
     */
    public double calculateTotalForCategory(final String category) {
        double total = 0l;
        for ( BankTransaction bankTransaction : bankTransactions ) {
            if ( bankTransaction.getDescription().equals(category) ) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

}
