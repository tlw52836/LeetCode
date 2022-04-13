package TOP100题;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            //打印空格
            for (int j = 0; j < numRows-i-1; j++) {
                System.out.print(" ");
            }
            List list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i == 0) {
                    list.add(1);
                    //打印元素
                    System.out.print(1 + " ");
                } else {
                    int l = 0, r = 0;
                    if(j-1 >= 0)
                        l = res.get(i-1).get(j-1);
                    if(j < res.get(i-1).size())
                        r = res.get(i-1).get(j);
                    list.add(l+r);
                    //打印元素
                    System.out.print(l+r + " ");
                }
            }
            //打印换行
            System.out.println();
            res.add(list);
        }
        return res;
    }
}
