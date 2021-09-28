import java.util.*;

public class 电话号码的字母组合 {
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }

    public static List<String> letterCombinations(String digits) {
        //初始化关系
        HashMap<String,List> map = new HashMap<>();
        List l = new ArrayList();
        l.add("!");
        l.add("@");
        l.add("#");
        map.put("1",l);
        int m = 0;
        for(int i = 0;i < 8;i++){
            List<String> list = new ArrayList<>();
            for(int j = 0;j < 3;j++){
                list.add((char)(97+(m++)) + "");
            }
            if (i == 5 || i == 7) {
                list.add((char)(97+(m++)) + "");
            }
            map.put(Integer.toString(i+2),list);
        }
        System.out.println(map);

        Queue<String> queue = new LinkedList<>();  //用队列记录组合

        for(int i = 0;i < digits.length();i++){
            int j;
            if (i == 0) {
                for(j = 0;j < map.get(digits.charAt(i)+"").size();j++){
                    queue.add(map.get(digits.charAt(i)+"").get(j)+"");
                }
            }else {
                int len = queue.size();  //记录本次需要取出的字符串个数
                for(int n = 0;n < len;n++){
                    String str = queue.poll();
                    for(j = 0;j < map.get(digits.charAt(i)+"").size();j++){
                        queue.add(str + map.get(digits.charAt(i)+"").get(j));
//                        System.out.println("queue:" + queue);
                    }
                }
            }

        }
        return (List<String>) queue;
    }
}
