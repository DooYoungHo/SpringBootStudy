# Spring Boot Study 

## Day 01. 의존성 주입 (DI)
- 주문 처리 Bean (OrderProcessorBean)
    - 주문 처리 Bean 은 주문 받는 Bean 과 결제하는 Bean 을 의존성 주입 받아서 단계대로 실행한다.

- 주문 받는 Bean (OrderReceiverBean)
    - 주문을 받는다는 출력을 한다.

- 결제하는 Bean (PaymentProcessorBean)
    - 결제 처리를 한다 는 출력을 한다.

- 요리하는 Bean (ChefBean)
    - 요리 한다 는 출력을 한다.

- 배달하는 Bean (DeliveryServiceBean)
    - 배달 한다 는 출력을 한다.

![alt text](image.png)

## Day 02. Spring 환경 구성

- 출력할 문자열을 외부 변수로 뺄 수 있도록 한다. (properites, yml 둘 다 상관 없음)
    - 바인딩은 @ConfigurationProperties, @Value 바인딩 모두 이용한다.

- 프로필에 따라서 출력 값이 다르게 설정 한다.
    - profile 은 eng, kor 로 각각 영어, 한글로 출력해야 한다.

- profile 이 없는 경우 영어로 출력한다.

- @ConditionalOnXXX 을 이용하여, 주문 받는 Bean, 결제하는 Bean에 해당 하는 클래스가 모두 있을 때만 주문 처리 Bean 이 활성화되도록 한다.
