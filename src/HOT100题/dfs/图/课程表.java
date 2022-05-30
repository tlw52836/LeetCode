package HOT100题.dfs.图;

import java.util.ArrayList;
import java.util.List;

public class 课程表 {
    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        System.out.println(canFinish(2, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //构建图：利用邻接表的方式
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        int[] visit = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (graph[i].size() > 0 && visit[i] == 0 && !dfs(i, graph, visit)) {
                return false;
            }
        }
        return true;
    }


    public static boolean dfs(int elem, List<Integer>[] graph, int[] visit) {
        if (visit[elem] == 1) {
            return false;
        }

        if (visit[elem] == -1) {
            return true;
        }

        visit[elem] = 1;

        for (int i = 0; i < graph[elem].size(); i++) {
            if (!dfs(graph[elem].get(i), graph, visit)) {
                return false;
            }
        }
        // visit[elem] = 0
        visit[elem] = -1;

        return true;
    }
}
