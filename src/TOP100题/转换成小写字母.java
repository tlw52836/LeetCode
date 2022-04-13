package TOP100题;

public class 转换成小写字母 {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(toLowerCase(s));
    }
    public static String toLowerCase(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                res += (char)(s.charAt(i)+32);
            else
                res += s.charAt(i);
        }
        return res;
    }
}
