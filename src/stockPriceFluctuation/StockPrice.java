package stockPriceFluctuation;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
/*
Runtime: 199 ms, faster than 49.98% of Java online submissions for Stock Price Fluctuation .
Memory Usage: 149.9 MB, less than 63.17% of Java online submissions for Stock Price Fluctuation .
 */
public class StockPrice {
  private int[] latest;
  private TreeSet<int[]> pricesSet;
  private Map<Integer, int[]> priceMap;
  public StockPrice() {
    pricesSet = new TreeSet<>((a,b)-> {
      if(a[1]!=b[1]) {
        return Integer.compare(a[1],b[1]);
      }else{
        return Integer.compare(a[0],b[0]);
      }
    });
    priceMap = new HashMap<>();
  }

  public void update(int timestamp, int price) {
    int[] node = {timestamp, price};
    if(latest !=null) {
      if(latest[0] <= timestamp) {
        latest = node;
      }
    }else{
      latest = node;
    }
    int[] origPrice = priceMap.get(timestamp);
    if (origPrice != null) {
      pricesSet.remove(origPrice);
    }
    priceMap.put(timestamp, node);
    pricesSet.add(node);
  }

  public int current() {
    return latest[1];
  }

  public int maximum() {
    return pricesSet.last()[1];
  }

  public int minimum() {
    return pricesSet.first()[1];
  }
  public static void main(String[] args) {
    StockPrice stockPrice = new StockPrice();
    stockPrice.update(1, 10);
    stockPrice.update(2,10);
  }
}


/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
