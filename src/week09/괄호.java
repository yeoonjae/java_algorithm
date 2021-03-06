package week09;

import java.util.Scanner;
import java.util.Stack;

public class 괄호 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.println(stackMethod(sc.next()));
        }

    }

    private static String stackMethod(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == '('){
                stack.push(c);
            }else if(stack.empty()){
                return "NO";
            }else{
                stack.pop();
            }
        }

        if(stack.empty()){
            return "YES";
        }else{
            return "NO";
        }
    }
}
