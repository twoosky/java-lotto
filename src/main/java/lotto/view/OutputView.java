package lotto.view;

import lotto.domain.LottoRateOfReturn;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.enums.LottoResult;

import java.util.Arrays;

import static lotto.utils.ViewMessages.*;

public class OutputView {
    private OutputView() {
    }

    public static void printLottoNumbers(Lottos lottos) {
        lottos.getLottos().forEach(lotto ->
                System.out.println(lotto.getNumbers())
        );
    }

    public static void printLottoDone() {
        System.out.println(OUTPUT_LOTTO_DONE);
        System.out.println(OUTPUT_LINE);
    }

    public static void printLottoResult(LottoResults results) {
        Arrays.stream(LottoResult.values())
            .filter(result -> result.getMatchCount() != 0)
            .forEach(result -> {
                int count = getLottoMatchCount(results, result);
                printResult(result, count);
            });
    }

    private static int getLottoMatchCount(LottoResults results, LottoResult result) {
        return (int) results.getResults().stream()
                .filter(result::equals)
                .count();
    }

    private static void printResult(LottoResult result, int count) {
        int lottoMatchCount = result.getMatchCount();
        int lottoAmount = result.getAmount();

        if (result.isMatchBonusNumber()) {
            System.out.printf(OUTPUT_BONUS_MATCH_RESULT, lottoMatchCount, lottoAmount, count);
        }
        if (!result.isMatchBonusNumber()) {
            System.out.printf(OUTPUT_MATCH_RESULT, result.getMatchCount(), result.getAmount(), count);
        }
    }

    public static void printRateOfReturn(LottoRateOfReturn rateOfReturn) {
        System.out.printf(OUTPUT_RATE_OF_RETURN, rateOfReturn.getRateOfReturn());
    }
}
