import java.util.ArrayList;
import java.util.List;

public class 替换所有的问号 {
    public static void main(String[] args) {

    }
    public static String modifyString(String s) {
        char a = ' ';
        char b = ' ';
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                a = ' ';
                b = ' ';
                if (i - 1 >= 0) {
                    a = res.charAt(i-1);
                }
                if (i + 1 < s.length()) {
                    b = s.charAt(i+1);
                }
                char ch = 0;
                for (int j = 0; j < 26; j++) {
                     ch = (char) ('a' + j);
                    if (ch != a && ch != b)
                        break;
                }
                res += (ch+"");
            } else {
                res += s.charAt(i);
            }
        }
        return res;
    }
}
