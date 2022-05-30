package HOT100题.贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 根据身高重建队列 {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] res = reconstructQueue(people);
        for (int[] re : res) {
            System.out.print(Arrays.toString(re) + " ");
        }

    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return -(o1[0]- o2[0]);
                else
                    return o1[1] - o2[1];
            }
        });

        List<int[]> ans = new ArrayList<>();
        for (int[] p:people) {
            ans.add(p[1],p);
        }
        return ans.toArray(new int[people.length][2]);
    }
}
