package lotto.model;

import lotto.exception.NotMultipleOfThousandException;
import lotto.exception.OverRangeException;
import lotto.utils.LottoRules;

public class Payment {
    private static final String OVER_RANGE_EXCEPTION_MESSAGE = "범위를 벗어났습니다.";
    private static final String UNIT_EXCEPTION_MESSAGE = "천 단위로 입력하세요.";
    private int payment;

    public Payment(int payment) {
        checkOverRange(payment);
        checkMultipleOfThousand(payment);
        this.payment = payment;
    }

    private void checkOverRange(int payment) {
        if (payment < LottoRules.MINIMUM_PAYMENT.getNumber() || payment > LottoRules.MAXIMUM_PAYMENT.getNumber()) {
            throw new OverRangeException(OVER_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private void checkMultipleOfThousand(int payment) {
        if (payment % LottoRules.PAYMENT_UNIT.getNumber() != 0) {
            throw new NotMultipleOfThousandException(UNIT_EXCEPTION_MESSAGE);
        }
    }

    public int getPayment() {
        return payment;
    }

    public int countLottoTickets() {
        return payment / LottoRules.PAYMENT_UNIT.getNumber();
    }
}
