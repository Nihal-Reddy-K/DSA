class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean monoinc = true;
        boolean monodec = true;

        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                monoinc = false;
            }
            if(nums[i] < nums[i+1]){
                monodec = false;
            }
        }
        return monoinc || monodec;
    }
}