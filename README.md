# java-lottoController
로또 미션 진행을 위한 저장소

## 요구사항

### 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
```
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 30%입니다.
```

### 프로그래밍 요구사항
- indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.
- depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- else를 사용하지 마라.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
    - method가 한 가지 일만 하도록 최대한 작게 만들어라.
- 배열 대신 ArrayList를 사용한다.
- enum을 적용해 프로그래밍을 구현한다.

### 힌트
- 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
- Collections.sort() 메소드를 활용해 정렬 가능하다.
- ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

## 테스트 목록

### 입력 관련 테스트

- null 빈 문자열 → isNullOrEmptyString()
- 구입 금액에 대한 테스트
    - 1000원 미만, 10만원 초과인 경우 → isValueRange()
    - 숫자가 아닌 값 → isNotAnumber()
    - 1000원 단위인지 → isUnitK()
- 당첨 번호에 대한 테스트
    - 6개 아닌 갯수만큼 입력 → hasSix()
    - 숫자와 , 가 아닌 값 → isNumberFormat()
- 보너스 볼에 대한 테스트
    - 숫자가 아닌 값 → isNumber()
    - 당첨 번호와 동일한 값이 있는지 → isContainsWinNumber()

### 로직 관련 테스트

- 숫자가 정렬되는지 → isSorted()
- 당첨 번호 안에 있는 값인지 → isInWinNumber()
- 5개 일치 후, 보너스 볼이 일치했을 때 따로 결과가 나오는지 → hasBonusNumber()
- 수익률이 맞게 출력되는지 → isYieldCorrect()
    - (번 돈) * 100 / (투자한 돈)  (단위: %) (타입 : Integer)
    
## 코드 리뷰
### 첫번째 피드백
- [x] 사용하지 않는 변수는 삭제.
- [x] Initializer의 이름 변경.
- [x] String constant를 LottoResult enum에서 처리.
- [x] 맞은 갯수에 대한 네이밍.
- [x] 일급 콜렉션을 사용하라. Map은 더욱 유용하다.
- [x] HashMap을 Map으로 변경하라.
- [x] LottoNumbers에서의 상수의 접근 제어자를 변경하라.
- [x] Initializer의 횟수에 대한 로직을 Payment로 옮겨라.
- [x] 객체 사용을 하라.
- [x] 게임 결과를 관리하는 일급 콜렉션을 만들어라.
- [x] AutoNumber에 대한 콜렉션을 담는 클래스를 만들어라.
- [x] 인스턴스 변수에 직접 접근하지 마라.
- [x] LottoResult에 Lotto 클래스에 있는 로직을 여럿 이동하라.
- [x] 당첨 번호를 인스턴스 변수로 만들어라.
- [x] 메소드는 한 가지 기능만을 해야 한다.
- [x] 연산자는 최대한 적게 사용하라.
- [x] PAYMENT_UNIT를 변수 대신 클래스로 관리.
- [x] 도메인 클래스에서 입력에 대한 예외 메세지를 InputView로 이동.
- [x] hasSix 메소드 명을 isSizeSix와 같이 변경.
- [x] 문자열 split은 InputView에서 처리.

### 두번째 피드백
- [x] 도메인과 응용 계층을 분리하여 예외처리하라.
- [x] 클래스명을 변경하라.
- [x] LottoResult 생성을 클래스 내로 옮겨라.
- [x] AutoNumber 생성자의 숫자 가져오는 메소드를 변경하라.
- [x] BonusBall 클래스 내 변수 static을 제거하라.
- [x] is~ 이름을 가진 메서드는 boolean을 반환해야 한다. 명칭을 변경.
- [x] LottoRank enum 내 rank 변수는 불필요하므로 제거하라.
- [x] LottoRank enum 내 correct 변수명을 변경하라.
- [x] LottoRank enum 내 메서드명을 변경하라.
- [x] Payment 클래스 내 getPaymentCount 메서드명을 변경하라.
- [x] Prize 클래스 내 sumPrize 메서드 구조를 for문으로 변경하라.
- [x] YieldMoney 클래스 내 countYieldMoney 메서드 인자명을 간략화하지마라.
- [x] AutoNumber 클래스 내 멤버변수를 LottoNumbers로 변경하라.

### 세번째 피드백
- [x] LottoController 클래스 내 lottoTicket 생성자 변경.
- [x] LottoResult 클래스 내 초기화에 사용하는 Map을 LottoRank로 이동.

## 2단계 - 수동 구매

### 기능 요구사항
- 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
- 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

### 프로그래밍 요구사항
- 예외가 발생하는 부분에 대해 자바 Exception을 적용해 예외처리한다.
- 사용자가 입력한 값에 대한 예외 처리를 철저히 한다.
```
구입금액을 입력해 주세요.
14000

수동으로 구매할 로또 수를 입력해 주세요.
3

수동으로 구매할 번호를 입력해 주세요.
8, 21, 23, 41, 42, 43
3, 5, 11, 16, 32, 38
7, 11, 16, 35, 36, 44

수동으로 3장, 자동으로 11개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 30%입니다.
```

## 코드 리뷰
### 첫번째 피드백
- [x] LottoController 클래스 내 ticketNumber를 지역 변수로 둬라.
- [x] WinNumber 클래스의 LottoTicket 상속을 조합으로 변경하라.
- [x] Payment 클래스의 countAutoTickets() 메서드 명을 변경하라.
- [x] LottoTicket 클래스에서 자동, 수동 생성 클래스를 나누어 생성하라.

### 두번째 피드백 
- [x] LottoController 클래스 내 각 티켓 생성자의 반복문 중복을 제거하라.
- [x] TicketNumber 클래스 내 totalTicket 변수 제거.
- [x] LottoTicket 클래스 내 lottoTicket의 Integer 값을 포장하라.
- [x] ManualTicket과 AutoTicket을 상속이 아닌 interface를 활용하라.
- [x] 테스트 코드 검토하라.

### 세번째 피드백
- [x] 피드백 요청 전에 테스트 코드를 실행하라.
- [x] 로또 번호 범위를 관리하는 주체를 확인하라.
- [x] 로또 번호 자릿수를 관리하는 주체를 확인하라.
- [x] 불필요한 지역 변수 생성을 제거하라.
- [x] BonusBall의 checkContainsWinNumber 메소드에서 winNumber의 null 체크를 하라.
- [ ] 인터페이스명을 변경하라.
- [x] LottoResult에서 LottoRank.values()를 활용하라.
- [x] LottoTicket의 checkLottoLength 메소드에서 inputs의 null 체크를 하라.
- [x] LottoTickets의 combineTickets 메소드에서 중복 코드를 제거하라.
- [x] LottoTickets에서 LottoGenerator를 생성하여 combineTickets 메서드를 수정하지 않도록 개선하라.
- [x] ManualTicket에서 InputView를 제거하라.
- [x] ManualTicket에서 createManualTicket 메서드를 제거하라.
- [x] LottoNumber에서 매번 새로운 LottoNumber를 생성하지 말고 미리 생성하여 사용하라.

### 네번째 피드백 
- [ ] LottoController 클래스의 makeLottoTickets 메서드 리팩토링하라.
- [ ] static 변수를 인스턴스 변수 위로 작성해야 한다.
- [ ] LottoNumber 클래스의 lottoNumber 메서드를 valueOf 혹은 of로 변경하라.
- [ ] LottoTicket 클래스의 makeAutoTicket 메서드의 파라미터를 덮어씌우지 마라.
- [ ] TicketInformationTest에서 자동, 수동 구매햇을 때 getAutoTicketCount 메서드의 테스트를 하라.
- [  LottoTicket 클래스의 makeAutoTicket 메서드를 자동 로또 티켓 클래스로 옮겨라.