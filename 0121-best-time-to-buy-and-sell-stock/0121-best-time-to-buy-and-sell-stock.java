class Solution {
    public int maxProfit(int[] prices) {
        int cheapest = Integer.MAX_VALUE;
        int profit = 0;

        for(int price : prices){
            cheapest = Math.min(cheapest, price);
            profit = Math.max((price - cheapest), profit);
        }
        return profit;
    }
}