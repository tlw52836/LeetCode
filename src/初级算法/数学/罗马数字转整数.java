package 初级算法.数学;

import java.util.HashMap;
import java.util.Map;

public class 罗马数字转整数 {
    public static void main(String[] args) {

    }

    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<Character, Integer>(){{
           put('I', 1);
           put('V', 5);
           put('X', 10);
           put('L', 50);
           put('C', 100);
           put('D', 500);
           put('M', 1000);
        }};

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) > map.get(s.charAt(i+1)) || i == s.length()-1) {
                res += map.get(s.charAt(i));
            } else {
                res -= map.get(s.charAt(i));
            }

        }

        return res;
    }


}
