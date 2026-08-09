class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == key){
                if(map.containsKey(nums[i+1])){
                    map.put(nums[i+1], map.get(nums[i+1]) + 1);
                }else{
                    map.put(nums[i+1], 1);
                }
            }
        }

        int max = 0;
        int result = 0;

        for(int num : map.keySet()){
            if(map.get(num) > max){
                max = map.get(num);
                result = num;
            }
        }
        return result;
    }
}