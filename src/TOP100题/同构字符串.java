package TOP100题;

import java.util.HashMap;
import java.util.Map;

public class 同构字符串 {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";

        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {

        Map<Character,Character> sMap = new HashMap<>();
        Map<Character,Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i))) {
                if (sMap.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else if (tMap.containsKey(t.charAt(i))){
                if (tMap.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            }
            else {
                sMap.put(s.charAt(i),t.charAt(i));
                tMap.put(t.charAt(i), s.charAt(i));
            }

           // System.out.println(map);
        }

        return true;
    }
}
