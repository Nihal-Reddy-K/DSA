class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        int min=nums[0];
        int max=nums[0];

        for(int num:nums){
            map.put(num, 1);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for(int i=min; i <= max; i++){
            if(!map.containsKey(i)){
                list.add(i);
            }
        }
        return list;
    }
}