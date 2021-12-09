import java.util.ArrayList;
import java.util.List;

public class 三角形最小路径和 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>(){{
            add(new ArrayList<Integer>(){{add(2);}});
            add(new ArrayList<Integer>(){{add(3);add(4);}});
            add(new ArrayList<Integer>(){{add(6);add(5);add(7);}});
            add(new ArrayList<Integer>(){{add(4);add(1);add(8);add(3);}});
        }};
        System.out.println(minimumTotal(triangle));
    }

    /**
     * trangle[i][j] = min(trangle[i-1][j], trangle[i-1][j]) + trangle[i][j]
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                int num = triangle.get(i).get(j);
                if (i == 0 && j == 0)
                    continue;
                else if (j == 0)
                    triangle.get(i).set(j, triangle.get(i-1).get(0)+num);
                else if (j == i)
                    triangle.get(i).set(j, triangle.get(i-1).get(i-1)+num);
                else
                    triangle.get(i).set(j, Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j))+num);
            }
        }

        int min = triangle.get(m-1).get(0);
        for (int i = 0; i < m; i++) {
           if (triangle.get(m-1).get(i) < min)
               min = triangle.get(m-1).get(i);
        }
        return min;
    }
}
