package TOP100题;

import java.util.Arrays;

public class 最短补全词 {
    public static void main(String[] args) {
        String licensePlate = "GrC8950";
        String[] words = {"measure","other","every","base","according","level","meeting","none","marriage","rest"};
        System.out.println(shortestCompletingWord(licensePlate, words));
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        char[] ch = licensePlate.toLowerCase().toCharArray();
        int[] n = new int[26];
        for (int i = 0; i < ch.length; i++) {
            if (Character.isLetter(ch[i]))
                n[ch[i]-'a']++;
        }

        //根据字符串长度进行排序
        for (int i = 0; i < words.length-1; i++) {
            for (int j = 0; j < words.length-1-i; j++) {
                if (words[j].length() > words[j+1].length()){
                    String temp = words[j];
                    words[j] = words[j+1];
                    words[j+1] = temp;
                }
            }
        }

        System.out.println("排序结果：");
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < words.length; i++) {
            int[] m = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                m[words[i].charAt(j)-'a']++;
            }

            int k;
            for (k = 0; k < 26; k++) {
                if (m[k] < n[k])
                    break;
            }

            if (k == 26)
                return words[i];
        }
        return null;
    }
}
