import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 反转字符串中的元音字母 {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }

    public static String reverseVowels(String s) {
        ArrayList<Character> list = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] ch = s.toCharArray();

        int i = 0, j = ch.length-1;
        while (i < j) {
            while (i < j && !list.contains(ch[i])) {
                i++;
            }

            while (i < j && !list.contains(ch[j])) {
                j--;
            }

            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;

            i++;
            j--;
        }

        return new String(ch);
    }
}
