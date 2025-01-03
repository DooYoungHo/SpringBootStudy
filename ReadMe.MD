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

## Day 03. Spring AOP

- AOP 를 이용하려, 각 메소드의 호출과 종료 시 로그를 남긴다.
    - 각 메소드가 시작과 종료 시에 클래스와 메소드 이름을 찍어서 호출 순서를 보기 쉽게 표현한다.
    - aop 로그는 다른 파일에 찍을 수 있도록 한다. (기본 로그와 분리를 의미 - 해당 aop 파일 로그에는 aop 관련 로그만 찍히도록 한다)
    - 로그 예시 (반드시 아래와 같을 필요는 없고, 메소드 실행과 끝을 인지할 수 있도록 로그를 남긴다)
```
 --> OrderProcessorBean.processOrder()
 --> OrderReceiverBean.receiveOrder()
 <-- OrderReceiverBean.receiveOrder()
 --> PaymentProcessorBean.processPayment()
 <-- PaymentProcessorBean.processPayment()
 <-- OrderProcessorBean.processOrder()
```
- aop 로그는 일주일간 보관하도록 설정한다.

## Day04. Spring MVC

- 학생 정보를 등록, 조회, 수정할 수 있는 Controller를 구현

- GET /student/{studentId}?hideScore=yes
    - 이 경우에는 점수와 평가 항목을 출력하지 않는다

- GET /student/{studentId}와는 다른 별도의 Controller Method로 작성한다

- 쿠키를 이용한 로그인 기능
SESSION 이라는 이름을 가진 쿠키가 있으면 로그인 된것으로 간주</br>
로그인하지 않고 다른 기능 사용 불가</br>
GET /login 경로로 접근하면 SESSION 쿠키를 확인하고
있으면 학생 정보 조회 화면(studentView) 을 보여준다.
없으면 로그인 폼(loginForm)을 보여준다.</br>
POST /login 경로로 접근하면 입력받은 id, password와 일치하는 학생이 있는지 확인하고
있으면 SESSION 쿠키를 만들고 학생 정보 조회 화면(studentView) 을 보여준다.
없으면 로그인 폼(loginForm)으로 redirect 한다.

## Day05. Spring MVC

- 등록, 수정 시 아래 조건으로 입력 폼을 검증해야 한다.
    - 이름: 공백 제거 후 문자열의 길이가 0보다 커야 함
    - 이메일: 이메일 형식이 맞아야 함
    - 점수: 0점 이상 100점 이하
    - 평가: 공백 제거 후 문자열의 길이가 0보다 크고 200보다 같거나 작아야 함

- 에러 처리는 다음의 조건을 만족해야 한다.
다음 URL 접근 시 없는 리소스에 대한 접근일 경우 Controller 기반 예외 처리 방법을 이용해서 Http Status Code 404로 응답한다
```
GET /student/{studentId}
```
그 외의 예외는 @ControllerAdvice를 이용해서 예외 처리를 해야 한다.

- 다국어 지원
    - 모든 메세지는 영어, 한국어 2개 언어 지원

- 언어 변경 가능

## Day06. Spring MVC

- interceptor 를 이용한 로그인/로그아웃 기능 추가
    - 작업했던 로그인 체크하는 기능을 interceptor를 이용해서 구현
    - 로그인하지 않고 다른 기능 사용 불가
    - 로그인 체크하는 LoginCheckInterceptor 작성

- Controller 들에 대해
    - Test Coverage 100%가 되도록 Test Case 작성
    - Unit Test로 작성할 것
