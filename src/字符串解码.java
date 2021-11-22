import java.util.Stack;

public class 字符串解码 {
    public static void main(String[] args) {
        String s = "10[a]";
        System.out.println(decodeString(s));
    }

    /**
     * 利用栈实现：遇到非"["进栈，否则将栈中"["前的字符串与"]"后的数字出栈，组成新的字符串进栈
     * @param s
     * @return
     */

    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        char[] ss = s.toCharArray();
        String res = "";

        for (int i = 0; i < ss.length; i++) {
            if (ss[i] != ']')
                stack.push(ss[i]+"");
            else {
                String ch;
                String str = "";   //[]中的字符串
                String cStr  = "";  //[]前的数字
                String pStr = "";  //需要push进栈的字符串

                while (!(ch = stack.pop()).equals("["))
                    str = ch + str;


                while (!stack.empty() && (stack.peek().charAt(0)) >= '0' && stack.peek().charAt(0) <= '9')
                    cStr = stack.pop() + cStr;


                int count = Integer.valueOf(cStr);

                for (int j = 0; j < count; j++) {
                    pStr += str;
                }

                stack.push(pStr);
            }
        }

        while (!stack.empty()) {
            res = stack.pop() + res;
        }

        return res;
    }
}
