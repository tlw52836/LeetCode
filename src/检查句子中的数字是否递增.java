import javax.xml.stream.events.Characters;

public class 检查句子中的数字是否递增 {
    public static void main(String[] args) {

    }
    public static boolean areNumbersAscending(String s) {
        String[] ss = s.split(" ");
        int a = Integer.MIN_VALUE;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].charAt(0) >= '1' && ss[i].charAt(0) <= '9') {
                int b = Integer.valueOf(ss[i]);
                if (b > a)
                    a = b;
                else
                    return false;
            }
        }
        return true;
    }

}
