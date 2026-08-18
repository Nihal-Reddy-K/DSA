class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        int num = 0;
        String current = "";

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = num*10 + (ch - '0');
            }

            else if(ch == '['){
                numStack.push(num);
                stringStack.push(current);

                num = 0;
                current = "";
            }

            else if(ch == ']'){
                int repeat = numStack.pop();
                String previous = stringStack.pop();

                String temp = "";

                for(int j=0; j<repeat; j++){
                    temp += current;
                }

                current = previous + temp;
            }else{
                current += ch;
            }
        }
        return current;
    }
}