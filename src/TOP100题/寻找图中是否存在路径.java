package TOP100题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 寻找图中是否存在路径 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 3;
        int[][] edges = {{0,1},{1,2},{2,0}};
        int start = 0;
        int end = 2;
        System.out.println(s.validPath(n, edges, start, end));
    }

    static class Solution {
        private int n;
        private List<List<Integer>> newEdges;
        private int end;
        private boolean[] visit;  //标记访问过的结点
        private boolean res;
        
        
        public boolean validPath(int n, int[][] edges, int start, int end) {
            this.n = n;
            this.newEdges = new ArrayList<>();
            this.end = end;
            this.visit = new boolean[n];
            this.res = false;

            for (int i = 0; i < n; i++) {
                newEdges.add(new ArrayList<>());
            }

            //添加每个顶点所能到达的边
            for (int i = 0; i < edges.length; i++) {
                int a = edges[i][0];
                int b = edges[i][1];
                newEdges.get(a).add(b);
                newEdges.get(b).add(a);
            }

            System.out.println(newEdges);
            dfs(start);
            visit[start] = true;
            
            return res;
        }
        
        public void dfs(int elem) {
            if (elem == end)
                res = true;

            for (int i = 0; i < newEdges.get(elem).size() && res == false; i++) {
                if (visit[newEdges.get(elem).get(i)])
                    continue;

                visit[newEdges.get(elem).get(i)] = true;
                dfs(newEdges.get(elem).get(i));
                visit[newEdges.get(elem).get(i)] = false;
            }
        }
    }

}
