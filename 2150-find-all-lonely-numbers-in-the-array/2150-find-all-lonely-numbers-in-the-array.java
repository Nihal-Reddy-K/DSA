class Solution {
    public List<Integer> findLonely(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }

        for(int i=0; i<nums.length; i++){
            if(map.get(nums[i]) == 1 && !map.containsKey(nums[i] - 1) && !map.containsKey(nums[i] + 1)){
                result.add(nums[i]);
            }
        }

        return result;
    }
}