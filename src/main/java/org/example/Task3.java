package org.example;

import java.util.*;

public class Task3 {
    public static void solve(String[] input) {
        String[] first = input[0].trim().split("\\s+");
        int n = Integer.parseInt(first[0]);
        int k = Integer.parseInt(first[1]);

        String[] parts = input[1].trim().split("\\s+");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(parts[i]);

        System.out.println(quickSelect(a, 0, n - 1, k - 1));
    }

    static int quickSelect(int[] a, int lo, int hi, int k) {
        while (true) {
            if (lo == hi) return a[lo];
            int pivot = a[lo + (hi - lo) / 2];
            int i = lo, j = hi;
            while (i <= j) {
                while (a[i] < pivot) i++;
                while (a[j] > pivot) j--;
                if (i <= j) {
                    int t = a[i]; a[i] = a[j]; a[j] = t;
                    i++; j--;
                }
            }
            if (k <= j) hi = j;
            else if (k >= i) lo = i;
            else return a[k];
        }
    }
}