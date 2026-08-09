class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.length() == 0){
            return result;
        }

        HashMap<Integer, String> keypad = new HashMap<>();

        keypad.put(2, "abc");
        keypad.put(3, "def");
        keypad.put(4, "ghi");
        keypad.put(5, "jkl");
        keypad.put(6, "mno");
        keypad.put(7, "pqrs");
        keypad.put(8, "tuv");
        keypad.put(9, "wxyz");

        solve(digits, 0, "", keypad, result);

        return result;
    }

    public static void solve(String digits, int index, String current, HashMap<Integer, String> keypad, List<String> result){

        if(index == digits.length()){
            result.add(current);
            return;
        }

        int num = digits.charAt(index) - '0';
        String letters = keypad.get(num);

        for(int i=0; i<letters.length(); i++){
            solve(digits, index+1, current + letters.charAt(i), keypad, result);
        }
    }
}