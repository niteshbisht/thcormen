package app.algo.arrays;

public class BestTimeToBuySellStock {

  public static int maxProfit(int[] prices) {
    int maxProfit = 0;
    int minPrice = prices[0];
    for (int i = 1; i < prices.length; i++) {
      int currentPrice = prices[i];
      maxProfit = Math.max(maxProfit, currentPrice - minPrice);
      minPrice = Math.min(minPrice, currentPrice);
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int[] iput = {7, 1, 5, 3, 6, 4};
    int maxProfit = maxProfit(iput);
    System.out.println(maxProfit);
  }
}
