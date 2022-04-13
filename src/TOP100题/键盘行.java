package TOP100题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 键盘行 {
    public static void main(String[] args) {

        System.out.println(Arrays.asList(findWords(new String[]{"Hello","Alaska","Dad","Peace"})));
    }


    public static String[] findWords(String[] words) {

        List<String> res = new ArrayList<>();
        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";

        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toLowerCase().toCharArray();
            String ss;

            if (s1.contains(word[0]+"")) {
                ss = s1;
            } else if(s2.contains(word[0] + "")) {
                ss = s2;
            } else {
                ss = s3;
            }

            int j;
            for (j = 0; j < word.length; j++) {
                if (!ss.contains(word[j]+""))
                    break;
            }

            if (j == word.length) {
                res.add(words[i]);
            }

        }

        return res.toArray(new String[0]);
    }
}
