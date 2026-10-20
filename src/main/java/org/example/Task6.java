package org.example;

import java.util.*;

public class Task6 {
    static class Point {
        long r2, x, y; int id;
        Point(long r2, long x, long y, int id) {
            this.r2 = r2; this.x = x; this.y = y; this.id = id;
        }
    }

    static int cmp(Point a, Point b) {
        if (a.r2 != b.r2) return Long.compare(a.r2, b.r2);
        if (a.x != b.x) return Long.compare(a.x, b.x);
        if (a.y != b.y) return Long.compare(a.y, b.y);
        return Integer.compare(a.id, b.id);
    }

    public static void solve(String[] input) {
        String[] first = input[0].trim().split("\\s+");
        int n = Integer.parseInt(first[0]);
        int k = Integer.parseInt(first[1]);

        // max-heap размера k: корень — «худший» из хранимых
        PriorityQueue<Point> heap = new PriorityQueue<>((a, b) -> cmp(b, a));

        for (int i = 1; i <= n; i++) {
            String[] p = input[i].trim().split("\\s+");
            long x = Long.parseLong(p[0]);
            long y = Long.parseLong(p[1]);
            long r2 = x * x + y * y;
            Point pt = new Point(r2, x, y, i);
            if (heap.size() < k) {
                heap.add(pt);
            } else if (cmp(pt, heap.peek()) < 0) {
                heap.poll();
                heap.add(pt);
            }
        }

        List<Point> res = new ArrayList<>(heap);
        res.sort(Task6::cmp);

        StringBuilder sb = new StringBuilder();
        for (Point pt : res) {
            sb.append(pt.x).append(' ').append(pt.y).append(' ').append(pt.id).append('\n');
        }
        System.out.print(sb);
    }
}