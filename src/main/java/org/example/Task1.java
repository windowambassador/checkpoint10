package org.example;

import java.util.*;

public class Task1 {
    public static void solve(String[] input) {
        int n = Integer.parseInt(input[0].trim());
        long[][] iv = new long[n][2];
        for (int i = 0; i < n; i++) {
            String[] p = input[1 + i].trim().split("\\s+");
            iv[i][0] = Long.parseLong(p[0]);
            iv[i][1] = Long.parseLong(p[1]);
        }

        Arrays.sort(iv, (a, b) -> {
            if (a[1] != b[1]) return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });

        int count = 0;
        long lastEnd = Long.MIN_VALUE;
        for (long[] e : iv) {
            if (e[0] >= lastEnd) {
                count++;
                lastEnd = e[1];
            }
        }
        System.out.println(count);
    }
}