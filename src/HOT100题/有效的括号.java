package HOT100题;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 有效的括号 {
    public static void main(String[] args) {
        System.out.println(isValid("[]{()}"));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || ch != map.get(stack.pop()))
                    return false;
            }
        }

        return stack.isEmpty();
    }

}
