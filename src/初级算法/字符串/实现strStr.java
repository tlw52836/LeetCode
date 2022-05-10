package 初级算法.字符串;

public class 实现strStr {
    public static void main(String[] args) {
        System.out.println(strStr("tttytr", "tyz"));
    }
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
