package 笔试题;

import java.util.Arrays;
import java.util.Scanner;

public class WorkerSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Work[] works = new Work[n];
        for (int i = 0; i < n; i++) {
            Work w = new Work();
            works[i] = w;
            w.s = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            works[i].e = in.nextInt();
        }
        Arrays.sort(works);
        int t = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (works[i].s > t) {
                res++;
                t = works[i].e;
            }
        }
        System.out.println(res);
    }

    static class Work implements Comparable{
        private int s;
        private int e;

        @Override
        public int compareTo(Object o) {
            Work w = (Work) o;
            if (this.e > w.e)
                return 1;
            else if (this.e < w.e)
                return -1;
            else {
                if (this.s < w.s)
                    return -1;
                else if (this.s > w.s)
                    return 1;
                else
                    return 0;
            }
        }

        @Override
        public String toString() {
            return "Work{" +
                    "s=" + s +
                    ", e=" + e +
                    '}';
        }

        /**
         * 不影响实现（加了规范一些）
         * @return
         */
        @Override
        public int hashCode() {
            return this.e;
        }
    }
}
