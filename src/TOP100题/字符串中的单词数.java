package TOP100题;

import java.util.Arrays;

public class 字符串中的单词数 {
    public static void main(String[] args) {
        System.out.println(countSegments( "hello    "));
    }

    /**
     * 抓住ss[i] == ' ' ss[i+1] != ' '这个特点
     * @param s
     * @return
     */
//    public static int countSegments(String s) {
//        int count = 0;
//        char[] ss = s.toCharArray();
//        for (int i = 0; i < ss.length; i++) {
//            if (ss[i] != ' ') {
//                if (i+1 >= ss.length || (i+1 < ss.length && ss[i+1] == ' ')) {
//                    count++;
//                }
//            }
//        }
//        if (count == 0)
//            return 0;
//        return count;
//    }


    public static int countSegments(String s) {
        s = s + ' ';
        int count = 0;
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] != ' '&& ss[i+1] == ' ') {
                count++;
            }
        }
        if (count == 0)
            return 0;
        return count;
    }
}
