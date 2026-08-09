class Solution {
    public int search(int[] nums, int target) {
        int bp = -1;
        int n=nums.length;

        for(int i=0; i<n-1; i++){
            if(nums[i] > nums[i+1]){
                bp=i;
                break;
            }
        }  

        if(bp == -1){
            return binarySearch(nums, 0, n-1, target);
        }

        int lp;
        int rp;

        if(target >= nums[0] && target <= nums[bp]){
            lp=0;
            rp=bp;
        }else{
            lp=bp+1;
            rp=n-1;
        }

        return binarySearch(nums, lp, rp,target);
    }

    public int binarySearch(int[] nums, int lp, int rp, int target){
        while(lp<=rp){
            int mid = lp + (rp-lp)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(target < nums[mid]){
                rp = mid-1;
            }else{
                lp = mid+1;
            }
        }
        return -1;
    }
}