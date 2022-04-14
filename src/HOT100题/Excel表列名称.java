package HOT100题;

public class Excel表列名称 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
    }

    /**
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * @param columnNumber
     * @return
     */

    public static String convertToTitle(int columnNumber) {
        int a;
        String res = "";
        while (columnNumber != 0) {
            a = columnNumber % 27;
            a = '0' + a + 16;
            res = (char)a + res;
            columnNumber = columnNumber / 26;
        }
        return res;
    }
}
