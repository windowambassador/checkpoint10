package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Задача 1 ===");
        Task1.solve(new String[]{
                "4",
                "1 3",
                "2 5",
                "3 4",
                "4 6"
        });
        System.out.println();

        System.out.println("=== Задача 2 ===");
        Task2.solve(new String[]{
                "8",
                "PUSH 5",
                "PUSH 2",
                "MIN",
                "MAX",
                "POP",
                "MIN",
                "PUSH 7",
                "MAX"
        });
        System.out.println();

        System.out.println("=== Задача 3 ===");
        Task3.solve(new String[]{
                "5 3",
                "4 1 7 3 9"
        });
        System.out.println();

        System.out.println("=== Задача 4 ===");
        Task4.solve(new String[]{
                "3",
                "1 10",
                "2 20",
                "1 15"
        });
        System.out.println();

        System.out.println("=== Задача 5 ===");
        Task5.solve(new String[]{
                "2 8",
                "PUT 1 100",
                "PUT 2 200",
                "GET 1",
                "PUT 3 300",
                "GET 2",
                "GET 3",
                "PUT 1 150",
                "GET 1"
        });
        System.out.println();

        System.out.println("=== Задача 6 ===");
        Task6.solve(new String[]{
                "5 3",
                "1 1",
                "0 2",
                "1 0",
                "-1 0",
                "0 -1"
        });
    }
}