import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 字母异位词分组 {
    public static void main(String[] args) {
        String[] strs = {"ddddddddddg","dgggggggggg"};
        List<List<String>> res = groupAnagrams(strs);
        System.out.println(res);


    }

    /**
     * 过数组创造list需要注意的一些问题
     * List<String> ss = Arrays.asList(strs);  //此时ss与strs共用内存，不可以执行add，remove操作
     * List<String> ss = new ArrayList<>(Arrays.asList(strs));  //此时ss与strs不共用内存，可以执行add，remove操作
     * @param strs
     * @return
     */

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        List<String> ss = new ArrayList<>(Arrays.asList(strs));

       while (ss.size() > 0) {
            List<String> list = new ArrayList<>();  //保存同一类字母异位词
            list.add(ss.get(0));

            for (int j = 1; j < ss.size(); j++) {
                if (isAnagrams(ss.get(0), ss.get(j))) {
                    list.add(ss.get(j));
                }
            }
            res.add(list);
            //删除元素
            for (int k = 0; k < list.size(); k++) {
                ss.remove(list.get(k));
            }
        }

        return res;
    }

    /**
     * 判断两个字符串是否是字母异位词
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isAnagrams (String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        StringBuilder ss1 = new StringBuilder(s1);

        for (int i = 0; i < s2.length(); i++) {
            int index = ss1.indexOf(s2.charAt(i)+"");
            if (index < 0)
                return false;
             else
                 ss1.deleteCharAt(index);
        }
        return true;
    }
}
