public class 反转字符串 {
    public static void main(String[] args) {
        char[] s = {'a', 'b', 'c', 'd'};
        reverseString(s);
        System.out.println(s);
    }

    public static void reverseString(char[] s) {
        for (int i = 0, j = s.length-1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
