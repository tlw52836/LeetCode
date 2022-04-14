package 初级算法.字符串;

import java.util.HashMap;
import java.util.Map;

public class 有效的字母异位词 {
    public static void main(String[] args) {
        String s =  "rat";
        String t =  "tar";
        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (map.getOrDefault(t.charAt(i),0) - 1 < 0) {
                return false;
            }
            map.put(t.charAt(i), map.get(t.charAt(i))-1);
        }

        return true;
    }

}
