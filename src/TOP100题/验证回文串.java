package TOP100题;

import java.util.Locale;

public class 验证回文串 {
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        String ss = "";

        for(int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                ss += s.charAt(i);
            }
        }

        String str = ss.toLowerCase();

        System.out.println(str);

        for (int i = 0, j = str.length()-1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
