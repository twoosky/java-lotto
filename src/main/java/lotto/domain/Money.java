package lotto.domain;

import static lotto.utils.ErrorMessages.*;

public class Money {
    private static final int MIN_RANGE = 1000;
    private static final int MONEY_UNIT = 1000;
    private final int money;

    public Money(String inputMoney) {
        validateInteger(inputMoney);
        int money = Integer.parseInt(inputMoney);
        validateRange(money);
        validateDivideUnit(money);
        this.money = money;
    }

    private void validateInteger(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MONEY_NOT_INTEGER);
        }
    }

    private void validateRange(int money) {
        if (money < MIN_RANGE) {
            throw new IllegalArgumentException(MONEY_OUT_OF_RANGE);
        }
    }

    private void validateDivideUnit(int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(MONEY_NOT_DIVIDE_UNIT);
        }
    }

    public int getMoney() {
        return this.money;
    }
}