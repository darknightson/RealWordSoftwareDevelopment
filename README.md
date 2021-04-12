객체지향 개념에 대한 학습 일지

* 입출금 내역 분석기 중 csv 파싱하여 값을 추출하는 소스 개발
1. 2021.04.05
page 25

2. 2021.04.06
page 32

3. 2021.04.07 page 37
  - SOLID : 객체 지향 프로그래밍 및 설계 5원칙, DRY&KISS는 개발 원칙이라고 보면 된다.
  - SRP ( 단일 책임의 원칙 )
    . DRY : 같은 코드를 반복하지 마라
    . KISS : 단순하게 하라
  - 응집도 : 클래스나 메소드의 책임이 서로 얼마나 강하게 연결되어 있는지를 측정한다.
  3.1 실무에서 응집도는 다음과 같은 여섯 가지 방법으로 그룹화 한다.
    - 기능 :기능을 너무 세부적으로 따져서 한개의 메서드를 가지는 클래스를 여러개 만든다면 클래스가 많아지고 장황해진다.
    - 정보 : 예를들어 BankTransaction 객체를 만들고, 읽고, 쓰고, 갱신, 삭제하는 CRUD이 필요해 기능만 제공하는 클래스를 만들어야 한다. BankTransactionDAO Class ( 정보로 응집 )
    - 유틸리티 : 때로는 관련성 없는 메서드를 한 클래스에 포함시켜야 한다. 특히 메서드가 어디에 속해야 할지 결정하기 어려울 때는 만능 스위스 군용 칼과 같은 유틸리티 클래스에 추가하기도 한다.
    - 논리 : 
    - 순차 : 
    - 시간 :
 

4. 2021.04.08 page 48
  - 코드를 구현할 때는 결합도를 낮춰야 한다. (low coupling), 이는 코드의 다양한 컴포넌타가 내부와 세부 구현에 의존하지 않아야 함을 의미한다.
  - 반대로 높은 high coupling는 무조건 피해야 한다. 
  - 결합도를 낮추기 위해서는 클래스간 참조에서 interface를 사용하자.
  4.1
    - 갓 클래스와 코드 중복은 코드를 추론하고 유지보수하기 어렵게 만드는 요인이다.
    - 단일 책임 원칙(SRP)은 관리하고 유지보수하기 쉬운 코드를 구현하는 데 도움을 준다.
    - 응집도는 클래스나 메서드의 책임이 얼마나 강하게 연관되어 있는지를 가리킨다. ( 클래스의 코드가 서로 얼마나 관련되어 있는가 )
    - 결합도는 클래스가 다른 코드 부분에 얼마나 의존하고 있는지를 가르킨다. ( 다른 클래스에 얼마나 의존 하는가 )
    - 높은 응집도와 낮은 결합도는 유지보수가 가능한 코드가 가져야 할 특징이다.
    - 자동화된 스트 스위트는 소프트웨어가 올바로 동작하며, 코드를 수정해도 잘 동작할 것임을 확신할 수 있고, 프로그램을 이해할 수 있도록 도움을 준다.
  
5. 2021.04.08 page 48
  - Assertion.fail(message) 메서드 실행 결과를 실패로 만든다.
  - Assertion.assertEquals(expected, actual) 두값이 같은지 테스트
  - Assertion.assertEquals(expected, actual, delta) 두 float or double이 delta 범위내에서 같은지 테스트
  - Assertion.assertNotNull(object) 객체가 null이 아닌지 테스트

6. 2021.04.09 page 60
    - 개방/폐쇄 원칙 (OCP)
      - 코드 베이스의 유연성을 추가하고 유지보수성을 개선하는데 도움을 주는 원칙
      - 반복로직과 비즈니스 로직이 결합되어 분리하기가 어려워질때 ocp를 적용한다.
      - 코드를 반복하는 경우

7. 2021.04.12 page 85
  - 노티피케이션 패턴은 너무 많은 미확인 예외를 사용하는 상황에서 적합한 해결책을 제공한다. 이 패턴에서는 도메일 클래스로 오류를 수집한다.
  
    
    
