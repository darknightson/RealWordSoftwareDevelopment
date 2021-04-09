package com.realworddevelopment.chapter_03;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    /**
     * 스트림 사용 방식 기본
     * bankTransactions
     *
     */
    public List<BankTransaction> streamDefault() {
        return bankTransactions.stream()
                .filter(bankTransaction -> bankTransaction.getDate().getMonth() == Month.FEBRUARY)
                .collect(Collectors.toList());
    }


    public double summarizeTransaction(final BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0l;
        for (final BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    /**
     * 월별 금액 계산
     *
     * @param month
     * @return
     */
    public double calculateTotalInMonth(final Month month) {
        return summarizeTransaction((acc, bankTransaction) ->
                bankTransaction.getDate().getMonth() == month ? acc + bankTransaction.getAmount() : acc);
    }

    /**
     * 전체 금액 계산
     *
     * @return
     */
    public double calculateTotalAmount() {
        double total = 0l;
        for (BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();

        }
        return total;
    }

    /**
     * category 금액 계산
     *
     * @param category
     * @return
     */
    public double calculateTotalForCategory(final String category) {
        double total = 0l;
        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    /**
     * 특정 금액 이상의 거래내역 조회
     *
     * @param amount
     * @return
     */
    public List<BankTransaction> findTransactionGreaterThanEqual(final int amount) {
        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
    }

    /**
     * 특정 월 거래내역 조회
     *
     * @param month
     * @return
     */
    public List<BankTransaction> findTransactionInMonth(Month month) {
        return findTransactions(bankTransaction -> bankTransaction.getDate().getMonth() == month);
    }

    /**
     * 월&일정 금액 이상 조회
     *
     * @param month
     * @param amount
     * @return
     */
    public List<BankTransaction> findTransactionsGreaterThanEqualInMonth(final Month month, final int amount) {
        // final List<BankTransaction> transactions = findTransactions(new BankTransactionIsInFebruaryAndExpensive());
        // 위 처럼 하면 새로운 조건이 생기면 각각의 클래스를 만들어야 하는 귀차니즘이 있다. 그러므로 아래와 같이 람다를 사용한다.
        final List<BankTransaction> transactions
                = findTransactions(bankTransaction -> bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= amount);
        System.out.println("transactions = " + transactions);
        return transactions;
    }

    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return result;
    }
}
