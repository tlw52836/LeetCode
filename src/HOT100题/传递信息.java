package HOT100题;

import java.util.ArrayList;
import java.util.List;

public class 传递信息 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5;
        int[][] relation = {{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        int k = 3;
        System.out.println(s.numWays(n, relation, k));
    }

    static class Solution {
        private int ways;
        private int n;
        private int k;
        List<List<Integer>> edges;

        public int numWays(int n, int[][] relation, int k) {
            this.ways = 0;
            this.n = n;
            this.k = k;
            this.edges = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                edges.add(new ArrayList<>());
            }

            //添加每个顶点所能到达的边
            for (int i = 0; i < relation.length; i++) {
                int from = relation[i][0];
                int to = relation[i][1];
                edges.get(from).add(to);
            }

            dfs(0, 0);

            return ways;
        }

        /**
         * 图的深度有限遍历（可以重复到达一个点）
         * @param elem
         * @param step
         */
        public void dfs(int elem, int step) {
            if (step == k) {
                if (elem == n-1)
                    ways++;
                return;
            }

            for (int i = 0; i < edges.get(elem).size(); i++) {
                dfs(edges.get(elem).get(i), step+1);
            }
        }
    }
}

