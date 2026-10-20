package org.example;

import java.util.*;

public class Task4 {
    static Map<Long, Long> parent = new HashMap<>();

    static long find(long x) {
        if (!parent.containsKey(x)) { parent.put(x, x); return x; }
        long p = parent.get(x);
        if (p == x) return x;
        long root = find(p);
        parent.put(x, root);
        return root;
    }

    public static void solve(String[] input) {
        int n = Integer.parseInt(input[0].trim());
        long[][] orders = new long[n][2]; // {d, p}
        for (int i = 0; i < n; i++) {
            String[] q = input[1 + i].trim().split("\\s+");
            orders[i][0] = Long.parseLong(q[0]);
            orders[i][1] = Long.parseLong(q[1]);
        }

        Arrays.sort(orders, (a, b) -> Long.compare(b[1], a[1])); // по убыванию прибыли

        parent.clear();
        long total = 0;
        for (long[] o : orders) {
            long slot = find(o[0]);
            if (slot > 0) {
                total += o[1];
                parent.put(slot, slot - 1); // занимаем слот
            }
        }
        System.out.println(total);
    }
}