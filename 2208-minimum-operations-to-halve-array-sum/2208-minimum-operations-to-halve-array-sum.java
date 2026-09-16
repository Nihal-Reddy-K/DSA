class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        double total = 0;
        for(int num: nums){
            total += num;
            maxHeap.add((double) num);
        }

        int count = 0;
        double temp = total;
        while(temp > (total/2)){
            double largest = maxHeap.poll();
            double half = largest / 2;
            temp -= largest;
            temp += half;
            maxHeap.add(half);
            count++;
        }
        return count;
    }
}