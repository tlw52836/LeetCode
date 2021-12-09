import java.util.ArrayList;
import java.util.List;

public class 分割回文串 {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            res.add(new ArrayList<String>());
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String str = s.substring(i,j);
                if (isPalind(str))
                    res.get(j-i-1).add(str);
            }

        }
        return res;
    }

    public static boolean isPalind(String s) {
        char[] ss = s.toCharArray();
        int i = 0;
        int j = ss.length-1;
        while (i < j) {
            if (ss[i] != ss[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}
