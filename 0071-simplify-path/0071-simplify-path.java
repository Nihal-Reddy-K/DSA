class Solution {
    public String simplifyPath(String path) {
        String [] parts = path.split("/");

        Stack<String> stack = new Stack<>();

        for(String part : parts){
            if(part.equals(".") || part.equals("")){
                continue;
            }
            else if(part.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder();

        for(String direc : stack){
            result.append("/");
            result.append(direc);
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}