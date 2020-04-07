import java.util.*;
import java.util.stream.Collectors;

public class ForFunSSS {

    public ForFunSSS() {};

    public int maxProfit(int[] prices) {
        int profit = 0;
        boolean buy = true;
        //7 1 5 3 6 4
        if(prices.length == 0 || prices.length == 1) return profit;

        int bought = -1;
        for(int i = 0; i < prices.length; i++) {
            if(buy) {
                if(i == prices.length - 1) break;
                if (prices[i] < prices[i + 1]) {
                    bought = prices[i];
                    buy = false;
                }
            }
            else {
                if(i == prices.length - 1) {
                    profit = profit + prices[i] - bought;
                    break;
                }
                if (prices[i] > prices[i + 1]) {
                    profit = profit + prices[i] - bought;
                    buy = true;
                }
            }
        }

        return profit;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);

            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }

        return map.values().stream().collect(Collectors.toList());
    }
}
