class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> result = new ArrayList<>();

        solve(n, result);

        int[] answer = new int[n];

        for(int i=0; i<n; i++){
            answer[i] = result.get(i);
        }

        return answer;
    }

    public void solve(int n, List<Integer> result){
        if(n==1){
            result.add(1);
            return;
        }

        List<Integer> temp = new ArrayList<>();

        solve((n+1)/2, temp);

        for(int num : temp){
            result.add(2*num - 1);
        }

        temp.clear();

        solve(n/2, temp);

        for(int num : temp){
            result.add(2*num);
        }
    }
}