import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class PostfixToInfix {
    private static Scanner sc;
    private boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
            return true;
        return false;
    }
    private boolean isInt(char c){
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }
    public String convert(String postfix) {
        StringDoubleEndedQueueImpl empty = new StringDoubleEndedQueueImpl();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            String s = Character.toString(c);
            if (isOperator(c)) {
                String a = empty.getFirst();
                empty.removeFirst();
                String b = empty.getFirst();
                empty.removeFirst();
                empty.addFirst("("+a+s+b+")");
            } else if (isInt(c)){
                empty.addLast(s);
            }else {
                System.out.println("error!");
                empty.head=null;
                break;
            }
        }
        return String.valueOf(empty.head);
    }
    public static void main(String[] args) {
        PostfixToInfix obj = new PostfixToInfix();
        sc = new Scanner(System.in);
        System.out.print("Postfix: ");
        String postfix = sc.next(); // abc++
        System.out.println("Infix: " + obj.convert(postfix));
    }
}
