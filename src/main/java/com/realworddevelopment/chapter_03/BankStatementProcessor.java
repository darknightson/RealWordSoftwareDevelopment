package com.realworddevelopment.chapter_03;

import java.time.Month;
import java.util.ArrayList;
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

    /**
     * 특정 금액 이상의 거래내역 조회
     * @param amount
     * @return
     */
    public List<BankTransaction> findTransactionGreaterThanEqual(final int amount) {
        final List<BankTransaction> result = new ArrayList<>();
        for ( final BankTransaction bankTransaction : bankTransactions ) {
            if ( bankTransaction.getAmount() > amount ) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    /**
     * 특정 월 거래내역 조회
     * @param month
     * @return
     */
    public List<BankTransaction> findTransactionInMonth(Month month) {
        final List<BankTransaction> result = new ArrayList<>();
        for ( final BankTransaction bankTransaction : bankTransactions ) {
            if ( bankTransaction.getDate().getMonth() == month ) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    /**
     * 월&일정 금액 이상 조회
     * @param month
     * @param amount
     * @return
     */
    public List<BankTransaction> findTransactionsInMonthAndGreater(final Month month, final int amount) {
        final List<BankTransaction> result = new ArrayList<>();
        for ( final BankTransaction bankTransaction : bankTransactions ) {
            if ( bankTransaction.getAmount() > amount && bankTransaction.getDate().getMonth() == month ) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
        final List<BankTransaction> transactions = findTransactions(new BankTransactionIsInFebruaryAndExpensive());
        System.out.println("transactions = " + transactions);
        return transactions;
    }

    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();
        for ( final BankTransaction bankTransaction : bankTransactions ) {
            if (bankTransactionFilter.test(bankTransaction) ) {
                result.add(bankTransaction);
            }
        }
        return result;
    }
}
