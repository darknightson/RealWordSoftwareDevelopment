package com.realworddevelopment.chapter_02;

/**
 * 아래 3개의 메서드는 파싱이라는 논리로 그룹화 되어있다.
 * 논리적으로 그룹화 하여 하나의 클래스로 만드는건 좋지만.
 * 각각의 메서드는 서로 관련이 없다.
 * 또한, 이렇게 그룹화 하게되면 클래스가 3가지의 책임을 갖게 되므로 SRP ( 단일 책임의 원칙 )에 위배된되. 결과적으로 아래 방법은 권장하지 않는다.
 * 하나의 파싱 인터페이스를 만들어 각각의 클래스에서 구현하도록 하는 것이 맞다.
 */
public class BankTransactionParser {

    public BankTransaction parserFromCSV(final String line) {
        // TODO CSV PARSER
        throw new UnsupportedOperationException();
    }

    public BankTransaction parserFromJSON(final String line) {
        // TODO JSON PARSER
        throw new UnsupportedOperationException();
    }

    public BankTransaction parserFromXML(final String line) {
        // TODO JSON XML
        throw new UnsupportedOperationException();
    }
}
