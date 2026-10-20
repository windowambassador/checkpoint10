package org.example;

import java.util.*;

public class Task2 {
    public static void solve(String[] input) {
        int q = Integer.parseInt(input[0].trim());

        Deque<Long> stack = new ArrayDeque<>();
        Deque<Long> minStack = new ArrayDeque<>();
        Deque<Long> maxStack = new ArrayDeque<>();

        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= q; i++) {
            String line = input[i].trim();
            if (line.startsWith("PUSH")) {
                long x = Long.parseLong(line.substring(5).trim());
                stack.push(x);
                minStack.push(minStack.isEmpty() ? x : Math.min(x, minStack.peek()));
                maxStack.push(maxStack.isEmpty() ? x : Math.max(x, maxStack.peek()));
            } else if (line.equals("POP")) {
                stack.pop();
                minStack.pop();
                maxStack.pop();
            } else if (line.equals("MIN")) {
                out.append(minStack.peek()).append('\n');
            } else { // MAX
                out.append(maxStack.peek()).append('\n');
            }
        }
        System.out.print(out);
    }
}