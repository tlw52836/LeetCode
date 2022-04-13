package TOP100题;

import java.util.ArrayList;
import java.util.List;

public class 课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> res = new ArrayList<>();
        //初始化每门课程的先行课列表
        for (int i = 0; i < numCourses; i++) {
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }

        //为每门课程添加先行课
        for (int i = 0; i < prerequisites.length; i++) {
            res.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                res.get(i).get(j);
            }
        }


        return true;
    }
}
