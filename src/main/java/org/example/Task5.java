package org.example;

import java.util.*;

public class Task5 {
    static Map<Long, Integer> keyToId = new HashMap<>();
    static long[] idToKey;
    static long[] vals;
    static int[] freqs;
    static Map<Integer, LinkedHashSet<Integer>> freqToIds = new HashMap<>();
    static int minFreq;
    static long tick;
    static int[] freeIds;
    static int freeTop;
    static int capacity;

    public static void solve(String[] input) {
        String[] first = input[0].trim().split("\\s+");
        capacity = Integer.parseInt(first[0]);
        int q = Integer.parseInt(first[1]);

        int maxSize = Math.min(q, capacity) + 5;
        vals = new long[maxSize];
        freqs = new int[maxSize];
        idToKey = new long[maxSize];
        freeIds = new int[maxSize];
        for (int i = 0; i < maxSize; i++) freeIds[i] = i;
        freeTop = maxSize - 1;
        minFreq = 0;
        tick = 0;

        StringBuilder out = new StringBuilder();

        for (int i = 1; i <= q; i++) {
            String line = input[i].trim();
            String[] p = line.split("\\s+");
            if (p[0].equals("GET")) {
                long key = Long.parseLong(p[1]);
                tick++;
                Integer id = keyToId.get(key);
                if (id == null) {
                    out.append(-1).append('\n');
                } else {
                    out.append(vals[id]).append('\n');
                    touch(id);
                }
            } else {
                long key = Long.parseLong(p[1]);
                long value = Long.parseLong(p[2]);
                tick++;
                Integer id = keyToId.get(key);
                if (id != null) {
                    vals[id] = value;
                    touch(id);
                } else {
                    if (keyToId.size() >= capacity) evict();
                    int newId = freeIds[freeTop--];
                    vals[newId] = value;
                    freqs[newId] = 1;
                    idToKey[newId] = key;
                    keyToId.put(key, newId);
                    freqToIds.computeIfAbsent(1, z -> new LinkedHashSet<>()).add(newId);
                    minFreq = 1;
                }
            }
        }
        System.out.print(out);
    }

    static void touch(int id) {
        int f = freqs[id];
        LinkedHashSet<Integer> set = freqToIds.get(f);
        set.remove(id);
        if (set.isEmpty()) {
            freqToIds.remove(f);
            if (minFreq == f) minFreq = f + 1;
        }
        freqs[id] = f + 1;
        freqToIds.computeIfAbsent(f + 1, z -> new LinkedHashSet<>()).add(id);
    }

    static void evict() {
        LinkedHashSet<Integer> set = freqToIds.get(minFreq);
        int victim = set.iterator().next(); // самый старый в порядке вставки/перестановки
        set.remove(victim);
        if (set.isEmpty()) freqToIds.remove(minFreq);
        long key = idToKey[victim];
        keyToId.remove(key);
        freeIds[++freeTop] = victim;
    }
}