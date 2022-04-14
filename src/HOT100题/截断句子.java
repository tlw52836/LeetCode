package HOT100题;

public class 截断句子 {
    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        int k = 4;
        System.out.println(truncateSentence(s, k));
    }

    public static String truncateSentence(String s, int k) {
        int i = 0;
        int t = 0;
        String res = "";
        while (i < s.length()) {
            if (s.charAt(i) == ' ' ) {
                t++;
            }
            if (t >= k)
                break;
            res += s.charAt(i);
            i++;
        }

        return res;
    }
}
