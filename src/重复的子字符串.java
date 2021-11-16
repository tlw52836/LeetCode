import java.util.ArrayList;
import java.util.List;

public class 重复的子字符串 {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length() / 2; j++) {
                list.add(s.substring(i, j));
            }
        }

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            if (s.length() % list.get(i).length() != 0)
                continue;
            int k = s.length() / list.get(i).length();
            String ss = "";
            for (int j = 0; j < k; j++) {
                ss += list.get(i);
            }

            if (ss.equals(s))
                return true;
        }

        return false;
    }
}
