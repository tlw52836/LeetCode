package 图解算法数据结构.数据结构;

public class 替换空格 {
    public static void main(String[] args) {

    }

    public static String replaceSpace(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                res += "%20";
            else
                res += s.charAt(i);
        }
        return res;
    }
}
