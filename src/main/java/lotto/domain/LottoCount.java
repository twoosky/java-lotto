package lotto.domain;

public class LottoCount {
    private static final int LOTTO_PRICE = 1000;
    private final int lottoCount;

    public LottoCount(Money money) {
        this.lottoCount = countLottoByMoney(money);
    }

    private int countLottoByMoney(Money money) {
        int amount = money.getMoney();
        return (amount / LOTTO_PRICE);
    }

    public int getCount() {
        return this.lottoCount;
    }
}
