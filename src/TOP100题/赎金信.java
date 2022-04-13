package TOP100题;

import java.util.HashMap;
import java.util.Map;

public class 赎金信 {
    public static void main(String[] args) {
        String ransomNote = "dehifb";
        String magazine = "hhjdgjbhahaagihhhhhajjibjffhijehda";
        System.out.println(canConstruct(ransomNote, magazine));
    }

//    public static boolean canConstruct(String ransomNote, String magazine) {
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < magazine.length(); i++) {
//            if (!map.containsKey(magazine.charAt(i))) {
//                map.put(magazine.charAt(i), 1);
//            } else {
//                int val = map.get(magazine.charAt(i));
//                map.put(magazine.charAt(i), val+1);
//            }
//        }
//
////        for (Map.Entry<Character, Integer> m:map.entrySet()) {
////            System.out.println(m.getKey() + "  " + m.getValue());
////        }
//
//        for (int i = 0; i < ransomNote.length(); i++) {
//            if (!map.containsKey(ransomNote.charAt(i)) || map.get(ransomNote.charAt(i)) == 0) {
//                return false;
//            } else {
//                int val = map.get(ransomNote.charAt(i));
//                map.put(ransomNote.charAt(i), val-1);
//            }
//        }
//        return true;
//    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] nums = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            nums[magazine.charAt(i)-'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (nums[ransomNote.charAt(i)-'a'] <= 0) {
                return false;
            } else {
                nums[ransomNote.charAt(i)-'a']--;
            }
        }
        return true;
    }
}
