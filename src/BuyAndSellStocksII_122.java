import java.util.ArrayList;
import java.util.List;

public class BuyAndSellStocksII_122 {
  public int maxProfit(int[] prices) {
    List<Integer> price_list = new ArrayList<>();
    for (int i : prices) {
        price_list.add(i);
    }
    return maxProfit_list(price_list);
  }

  private int maxProfit_list(List<Integer> prices) {
    int n = prices.size();
    if (n == 0 || n == 1) {
      return 0;
    }

    int maxProfit = 0;
    int currentProfit;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int buy = prices.get(i);
        int sell = prices.get(j);
        if (buy < sell) {
          currentProfit = sell - buy + maxProfit_list(prices.subList(j + 1, n));
        } else {
          break;
        }
        maxProfit = Math.max(maxProfit, currentProfit);
      }
    }
    return maxProfit;
  }
}
