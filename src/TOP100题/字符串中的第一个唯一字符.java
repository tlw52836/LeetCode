package TOP100题;

import java.util.HashMap;
import java.util.Map;

public class 字符串中的第一个唯一字符 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
    public static int firstUniqChar(String s) {
        Map<Character, Integer> maps = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            maps.put(s.charAt(i), maps.getOrDefault(s.charAt(i), 0)+1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (maps.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }


//    public static int firstUniqChar(String s) {
//        int[] count = new int[26];
//        List<Character> list = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            count[s.charAt(i)-'a']++;
//        }
//
//        for (int i = 0; i < count.length; i++) {
//            if (count[i] == 1) {
//                list.add((char) (i+'a'));
//            }
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//            if (list.contains(s.charAt(i))) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
