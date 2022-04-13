package TOP100题;

import java.util.HashMap;
import java.util.Map;

public class 单词规律 {
    public static void main(String[] args) {
        String s = "dog cat cat dog";
        String pattern = "abba";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");

        if (pattern.length() != ss.length) {
            return false;
        }

        Map<Character,String> cMap = new HashMap<>();  //存储正向对应对应关系
        Map<String,Character> sMap = new HashMap<>();  //存储反向对应对应关系

        for (int i = 0; i < pattern.length(); i++) {
            if (cMap.containsKey(pattern.charAt(i)) && !cMap.get(pattern.charAt(i)).equals(ss[i])) {
                return false;
            } else if (sMap.containsKey(ss[i]) && sMap.get(ss[i]) != pattern.charAt(i)){
                return false;
            } else {
                cMap.put(pattern.charAt(i), ss[i]);
                sMap.put(ss[i], pattern.charAt(i));
            }
        }

        return true;
    }
}
