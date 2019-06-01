import java.util.Stack;

public class ValidExpressions {


    boolean isValidExpression(String expression) {
        boolean result=true;
        Stack<Integer> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for(int i=0;i<expression.length();i++){
            char c=expression.charAt(i);
            if(isDigit(c)){
                s1.push(c-'0');
            }
            else if(isOperator(c))
                s2.push(c);
            else{
                if(isBracketOpen(c)){
                    s2.push(c);
                }
                else{
                    boolean flag=true;
                    while(!s2.isEmpty()) {
                        char c1 = s2.pop();
                        if (c1 == getCorrespondingChar(c)) {
                            flag = false;
                            break;
                        } else {
                            if (s1.size() < 2)
                                return false;
                            else
                                s1.pop();
                        }
                    }
                    if(flag)
                        return false;
                   }

            }
        }

        while(!s2.isEmpty()){
            char c=s2.pop();
            if(!isOperator(c))
                return false;
            if(s1.size()<2)
                return false;
            else
                s1.pop();
        }
        if(s1.size()>1 || !s2.isEmpty())
            return false;
        return result;

    }

    public static char getCorrespondingChar(char c) {
        if (c == ')') {
            return '(';
        }
        else if (c == ']') {
            return '[';
        }
        return '{';
    }

    public boolean isBracketOpen(char c) {
        if (c == '(' || c == '[' || c == '{') {
            return true;
        }
        return false;
    }

    /*checks if the given character is a digit.*/
    public boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    public boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*') {
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        ValidExpressions vE=new ValidExpressions();
        System.out.println("result is "+ vE.isValidExpression("(1+2)*3"));
    }

}
