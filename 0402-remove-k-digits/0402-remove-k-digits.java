class Solution {
    public String removeKdigits(String num, int k) {
        Stack <Character> stack= new Stack<>();
        for (char digit: num.toCharArray()){
            while(k>0 && !stack.isEmpty() && stack.peek()>digit){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while(k>0){
            stack.pop();
            k--;
        }
        StringBuilder result= new StringBuilder();
        for(char digit:stack){
            result.append(digit);
        }
        while(result.length()>0 && result.charAt(0)=='0'){
            result.deleteCharAt(0);
        }
        return result.length()== 0? "0": result.toString();
    }
}