class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high=0;

        for(int num:nums){
            low = Math.max(low,num);
            high += num;
        }

        while(low <= high){
            int mid = low + (high-low)/2;

            int subarrays = countSubarrays(nums, mid);

            if(subarrays > k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
    private int countSubarrays(int[] nums, int maxSum){
        int count = 1;
        int currentSum = 0;
        for(int num:nums){
            if(currentSum + num > maxSum){
                count++;
                currentSum = num;
            }else{
                currentSum += num;
            }
        }
        return count;
    }
}