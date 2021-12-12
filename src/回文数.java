public class 回文数 {
    public static void main(String[] args) {

    }

    public static boolean isPalindrome(int x) {

        char[] s = (x + "").toCharArray();
        int i = 0;
        int j = s.length-1;
        while (i < j) {
            if (s[i] != s[j])
                return false;
            i++;
            j--;
        }

        return true;
    }
}
