package HOT100题;

import java.util.HashMap;
import java.util.Map;

public class 股票价格波动 {
    public static void main(String[] args) {

    }

    static class StockPrice {

        private Map<Integer, Integer> maps;
        private int curTimestamp;
        private int maxPrice;
        private int minPrice;

        public StockPrice() {
            maps = new HashMap<>();
            curTimestamp = 0;
            maxPrice = Integer.MIN_VALUE;
            minPrice = Integer.MAX_VALUE;
        }

        public void update(int timestamp, int price) {
            if (timestamp > curTimestamp)
                curTimestamp = timestamp;

            if (maps.containsKey(timestamp) && (maps.get(timestamp) == minPrice || maps.get(timestamp) == maxPrice)) {
                maps.put(timestamp, price);
                minPrice = Integer.MAX_VALUE;
                maxPrice = Integer.MIN_VALUE;
                for (int v:maps.values()) {
                    if (v < minPrice)
                        minPrice = v;
                    if (v > maxPrice)
                        maxPrice = v;
                }
            } else {
                maps.put(timestamp, price);
                if (price < minPrice)
                    minPrice = price;
                if (price > maxPrice)
                    maxPrice = price;
            }
        }

        public int current() {
            return maps.get(curTimestamp);
        }

        public int maximum() {
            return maxPrice;
        }

        public int minimum() {
            return minPrice;
        }
    }

}
