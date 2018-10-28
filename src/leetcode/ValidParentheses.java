package leetcode;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

     //   boolean isBalanced = true;

        if (s == null) {
            return false;
        }

        if (s.length() % 2 != 0)
            return false;

        Stack<Character> openBraces = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '['){
                openBraces.push(c);
            }else if(openBraces.empty() || !isClosingParentheses(openBraces.pop(), c)){
                return false;
            }
        }
        return openBraces.isEmpty();
    }

    public boolean isClosingParentheses(char opening, char closing){
        switch (opening){
            case '(':
                return closing == ')';

            case '{':
                return closing == '}';

            case '[':
                return closing == ']';

            default:
                return false;
        }
    }

    public static void main(String[] args) {
        ValidParentheses val = new ValidParentheses();
        boolean result = val.isValid("{[(])}");
        System.out.println(result);
    }
}