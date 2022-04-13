package TOP100题;

import java.util.*;

public class 电话号码的字母组合 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

//    public static List<String> letterCombinations(String digits) {
//        //初始化关系
//        HashMap<String,List> map = new HashMap<>();
//        List l = new ArrayList();
//        l.add("!");
//        l.add("@");
//        l.add("#");
//        map.put("1",l);
//        int m = 0;
//        for(int i = 0;i < 8;i++){
//            List<String> list = new ArrayList<>();
//            for(int j = 0;j < 3;j++){
//                list.add((char)(97+(m++)) + "");
//            }
//            if (i == 5 || i == 7) {
//                list.add((char)(97+(m++)) + "");
//            }
//            map.put(Integer.toString(i+2),list);
//        }
//        System.out.println(map);
//
//        Queue<String> queue = new LinkedList<>();  //用队列记录组合
//
//        for(int i = 0;i < digits.length();i++){
//            int j;
//            if (i == 0) {
//                for(j = 0;j < map.get(digits.charAt(i)+"").size();j++){
//                    queue.add(map.get(digits.charAt(i)+"").get(j)+"");
//                }
//            }else {
//                int len = queue.size();  //记录本次需要取出的字符串个数
//                for(int n = 0;n < len;n++){
//                    String str = queue.poll();
//                    for(j = 0;j < map.get(digits.charAt(i)+"").size();j++){
//                        queue.add(str + map.get(digits.charAt(i)+"").get(j));
////                        System.out.println("queue:" + queue);
//                    }
//                }
//            }
//
//        }
//        return (List<String>) queue;
//    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() <= 0)
            return null;

        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        List<String> res = new ArrayList<>();
        dfs (map, digits, res, "");
        return res;
    }

    public static void dfs (Map<Character, String> map, String digits, List<String> res, String str) {

        if (str.length() == digits.length()) {
            res.add(str);
            str = "";
            return;
        }

        String s = map.get(digits.charAt(str.length()));
        for (int i = 0; i < s.length(); i++) {
            dfs (map, digits, res, str+s.charAt(i));
        }
    }
}
