package com.realworddevelopment.chapter_03;

import com.realworddevelopment.chapter_03.BankTransaction;

/**
 * BankTransactionFilter 는 BankTransaction 의 선택 조건을 결정한다.
 */

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
