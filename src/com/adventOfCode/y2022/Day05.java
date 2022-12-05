package com.adventOfCode.y2022;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Day05 {
    public static final String TEST_INPUT = """
                [D]    
            [N] [C]    
            [Z] [M] [P]
             1   2   3 
                        
            move 1 from 2 to 1
            move 3 from 1 to 3
            move 2 from 2 to 1
            move 1 from 1 to 2""";

    public static final String INPUT = """
                    [H]         [S]         [D]
                [S] [C]         [C]     [Q] [L]
                [C] [R] [Z]     [R]     [H] [Z]
                [G] [N] [H] [S] [B]     [R] [F]
            [D] [T] [Q] [F] [Q] [Z]     [Z] [N]
            [Z] [W] [F] [N] [F] [W] [J] [V] [G]
            [T] [R] [B] [C] [L] [P] [F] [L] [H]
            [H] [Q] [P] [L] [G] [V] [Z] [D] [B]
             1   2   3   4   5   6   7   8   9
                        
            move 2 from 7 to 2
            move 1 from 4 to 8
            move 2 from 1 to 9
            move 4 from 6 to 5
            move 1 from 7 to 6
            move 2 from 1 to 4
            move 7 from 8 to 9
            move 7 from 4 to 5
            move 4 from 2 to 4
            move 1 from 5 to 9
            move 14 from 5 to 4
            move 1 from 3 to 8
            move 5 from 4 to 8
            move 1 from 2 to 5
            move 2 from 4 to 1
            move 6 from 8 to 1
            move 1 from 8 to 6
            move 1 from 2 to 5
            move 5 from 3 to 7
            move 2 from 6 to 3
            move 2 from 4 to 7
            move 3 from 3 to 9
            move 7 from 4 to 1
            move 1 from 6 to 9
            move 2 from 6 to 1
            move 3 from 5 to 2
            move 1 from 1 to 8
            move 21 from 9 to 1
            move 1 from 4 to 2
            move 7 from 7 to 2
            move 1 from 4 to 2
            move 23 from 1 to 5
            move 5 from 5 to 1
            move 1 from 3 to 6
            move 1 from 6 to 3
            move 12 from 1 to 6
            move 1 from 3 to 6
            move 2 from 1 to 8
            move 1 from 9 to 3
            move 2 from 8 to 1
            move 2 from 1 to 8
            move 1 from 1 to 3
            move 2 from 3 to 1
            move 2 from 8 to 1
            move 3 from 6 to 1
            move 1 from 8 to 7
            move 4 from 6 to 2
            move 3 from 6 to 9
            move 2 from 5 to 7
            move 2 from 7 to 8
            move 1 from 7 to 9
            move 9 from 1 to 5
            move 12 from 5 to 9
            move 1 from 8 to 6
            move 1 from 6 to 9
            move 1 from 6 to 9
            move 7 from 9 to 4
            move 10 from 2 to 1
            move 12 from 5 to 4
            move 7 from 4 to 9
            move 7 from 4 to 7
            move 1 from 5 to 4
            move 7 from 7 to 8
            move 1 from 6 to 3
            move 1 from 3 to 1
            move 3 from 2 to 4
            move 1 from 6 to 8
            move 7 from 1 to 2
            move 1 from 6 to 7
            move 12 from 9 to 4
            move 3 from 8 to 5
            move 1 from 7 to 3
            move 6 from 9 to 1
            move 10 from 1 to 9
            move 7 from 9 to 5
            move 3 from 9 to 5
            move 1 from 3 to 4
            move 2 from 2 to 1
            move 1 from 5 to 1
            move 9 from 4 to 3
            move 1 from 1 to 3
            move 8 from 4 to 7
            move 7 from 5 to 3
            move 2 from 7 to 2
            move 8 from 3 to 9
            move 1 from 1 to 8
            move 10 from 2 to 3
            move 4 from 8 to 7
            move 12 from 3 to 4
            move 9 from 7 to 2
            move 2 from 1 to 3
            move 1 from 9 to 6
            move 2 from 4 to 9
            move 1 from 7 to 6
            move 5 from 5 to 9
            move 8 from 3 to 1
            move 2 from 6 to 3
            move 14 from 4 to 3
            move 15 from 3 to 9
            move 1 from 3 to 1
            move 3 from 9 to 8
            move 1 from 8 to 1
            move 1 from 3 to 2
            move 5 from 2 to 8
            move 1 from 4 to 2
            move 2 from 1 to 3
            move 2 from 3 to 9
            move 3 from 2 to 4
            move 6 from 1 to 8
            move 2 from 2 to 6
            move 1 from 6 to 4
            move 2 from 4 to 7
            move 5 from 8 to 5
            move 1 from 6 to 9
            move 7 from 9 to 6
            move 1 from 5 to 3
            move 2 from 7 to 8
            move 2 from 2 to 4
            move 3 from 5 to 6
            move 1 from 3 to 8
            move 1 from 5 to 6
            move 2 from 4 to 1
            move 3 from 1 to 6
            move 21 from 9 to 5
            move 1 from 4 to 3
            move 1 from 4 to 9
            move 2 from 9 to 2
            move 1 from 3 to 9
            move 4 from 2 to 3
            move 3 from 8 to 1
            move 14 from 5 to 9
            move 7 from 5 to 4
            move 3 from 8 to 4
            move 4 from 3 to 2
            move 3 from 8 to 5
            move 1 from 2 to 3
            move 1 from 5 to 1
            move 2 from 5 to 4
            move 3 from 2 to 9
            move 11 from 4 to 1
            move 17 from 9 to 2
            move 17 from 2 to 9
            move 10 from 9 to 2
            move 2 from 8 to 2
            move 3 from 8 to 3
            move 8 from 9 to 7
            move 4 from 7 to 3
            move 2 from 3 to 2
            move 3 from 2 to 3
            move 9 from 3 to 5
            move 1 from 1 to 9
            move 8 from 5 to 1
            move 2 from 7 to 9
            move 24 from 1 to 3
            move 24 from 3 to 6
            move 1 from 5 to 3
            move 10 from 2 to 1
            move 1 from 4 to 5
            move 3 from 9 to 1
            move 1 from 3 to 5
            move 17 from 6 to 5
            move 1 from 7 to 4
            move 13 from 5 to 4
            move 3 from 5 to 8
            move 1 from 7 to 9
            move 3 from 6 to 9
            move 8 from 6 to 4
            move 1 from 9 to 6
            move 11 from 1 to 8
            move 1 from 5 to 6
            move 12 from 4 to 9
            move 2 from 5 to 1
            move 1 from 1 to 7
            move 5 from 9 to 2
            move 1 from 7 to 9
            move 3 from 1 to 5
            move 3 from 5 to 9
            move 7 from 9 to 3
            move 4 from 9 to 6
            move 3 from 6 to 8
            move 5 from 4 to 3
            move 2 from 2 to 6
            move 3 from 9 to 3
            move 3 from 6 to 4
            move 4 from 2 to 6
            move 11 from 3 to 5
            move 11 from 6 to 9
            move 2 from 3 to 5
            move 1 from 5 to 8
            move 3 from 6 to 2
            move 7 from 9 to 2
            move 8 from 5 to 7
            move 6 from 4 to 5
            move 2 from 4 to 3
            move 1 from 8 to 6
            move 4 from 8 to 3
            move 13 from 8 to 3
            move 1 from 9 to 5
            move 6 from 7 to 2
            move 1 from 7 to 6
            move 1 from 6 to 5
            move 2 from 6 to 7
            move 13 from 3 to 5
            move 6 from 2 to 7
            move 1 from 6 to 1
            move 1 from 2 to 8
            move 2 from 7 to 8
            move 14 from 5 to 8
            move 1 from 1 to 4
            move 9 from 2 to 1
            move 14 from 8 to 7
            move 3 from 3 to 9
            move 11 from 5 to 3
            move 1 from 4 to 5
            move 4 from 9 to 8
            move 4 from 8 to 7
            move 5 from 3 to 9
            move 11 from 7 to 8
            move 9 from 1 to 3
            move 4 from 3 to 2
            move 6 from 8 to 4
            move 2 from 8 to 2
            move 13 from 3 to 6
            move 1 from 4 to 1
            move 5 from 4 to 2
            move 10 from 2 to 6
            move 4 from 9 to 1
            move 8 from 7 to 8
            move 10 from 8 to 5
            move 2 from 3 to 2
            move 2 from 8 to 6
            move 1 from 7 to 1
            move 2 from 7 to 6
            move 2 from 2 to 9
            move 2 from 8 to 6
            move 6 from 1 to 7
            move 5 from 9 to 1
            move 4 from 7 to 8
            move 1 from 7 to 2
            move 2 from 1 to 7
            move 1 from 3 to 8
            move 1 from 1 to 6
            move 2 from 2 to 6
            move 1 from 7 to 8
            move 1 from 1 to 9
            move 8 from 5 to 7
            move 2 from 7 to 9
            move 9 from 6 to 3
            move 13 from 6 to 8
            move 3 from 9 to 1
            move 5 from 6 to 1
            move 3 from 8 to 1
            move 3 from 3 to 4
            move 1 from 4 to 3
            move 1 from 4 to 8
            move 4 from 6 to 3
            move 11 from 8 to 2
            move 1 from 6 to 9
            move 8 from 3 to 9
            move 3 from 5 to 8
            move 4 from 1 to 2
            move 6 from 8 to 5
            move 6 from 5 to 1
            move 5 from 1 to 3
            move 3 from 3 to 4
            move 3 from 8 to 4
            move 2 from 4 to 5
            move 10 from 7 to 8
            move 5 from 9 to 2
            move 1 from 7 to 5
            move 3 from 5 to 2
            move 4 from 9 to 3
            move 4 from 1 to 5
            move 1 from 3 to 2
            move 3 from 5 to 2
            move 6 from 2 to 5
            move 10 from 8 to 3
            move 4 from 4 to 5
            move 4 from 2 to 8
            move 12 from 3 to 8
            move 1 from 1 to 3
            move 9 from 8 to 6
            move 1 from 4 to 1
            move 6 from 8 to 7
            move 3 from 1 to 7
            move 9 from 5 to 7
            move 11 from 7 to 2
            move 2 from 7 to 3
            move 9 from 2 to 7
            move 1 from 8 to 7
            move 1 from 5 to 2
            move 2 from 6 to 2
            move 2 from 1 to 2
            move 6 from 3 to 5
            move 2 from 3 to 6
            move 4 from 7 to 3
            move 3 from 3 to 1
            move 2 from 1 to 5
            move 7 from 7 to 6
            move 1 from 1 to 5
            move 3 from 2 to 4
            move 1 from 3 to 2
            move 18 from 2 to 1
            move 4 from 2 to 7
            move 6 from 5 to 9
            move 1 from 4 to 8
            move 2 from 6 to 1
            move 19 from 1 to 2
            move 4 from 9 to 5
            move 5 from 7 to 2
            move 1 from 8 to 7
            move 1 from 1 to 2
            move 6 from 5 to 7
            move 1 from 3 to 8
            move 6 from 7 to 6
            move 1 from 4 to 1
            move 4 from 7 to 9
            move 1 from 1 to 3
            move 1 from 2 to 5
            move 1 from 4 to 8
            move 1 from 3 to 4
            move 3 from 5 to 4
            move 2 from 8 to 9
            move 9 from 2 to 4
            move 19 from 6 to 4
            move 1 from 4 to 7
            move 5 from 9 to 5
            move 10 from 2 to 9
            move 2 from 5 to 4
            move 14 from 4 to 7
            move 2 from 2 to 1
            move 3 from 9 to 1
            move 1 from 1 to 3
            move 13 from 7 to 6
            move 1 from 5 to 9
            move 1 from 6 to 9
            move 1 from 7 to 2
            move 5 from 9 to 7
            move 1 from 5 to 2
            move 3 from 7 to 3
            move 3 from 4 to 9
            move 1 from 5 to 2
            move 4 from 4 to 2
            move 2 from 7 to 3
            move 4 from 1 to 6
            move 1 from 7 to 9
            move 11 from 9 to 5
            move 8 from 2 to 9
            move 6 from 9 to 6
            move 8 from 4 to 5
            move 14 from 5 to 6
            move 1 from 5 to 4
            move 3 from 5 to 1
            move 1 from 5 to 2
            move 2 from 6 to 4
            move 2 from 4 to 2
            move 1 from 9 to 2
            move 1 from 2 to 3
            move 1 from 9 to 3
            move 3 from 2 to 7
            move 7 from 6 to 7
            move 5 from 4 to 3
            move 23 from 6 to 1
            move 5 from 7 to 2
            move 22 from 1 to 6
            move 6 from 6 to 3
            move 6 from 2 to 4
            move 6 from 4 to 1
            move 3 from 7 to 8
            move 3 from 1 to 8
            move 4 from 3 to 2
            move 1 from 1 to 3
            move 3 from 3 to 1
            move 1 from 7 to 5
            move 1 from 6 to 5
            move 1 from 7 to 4
            move 4 from 6 to 9
            move 5 from 3 to 6
            move 2 from 2 to 1
            move 3 from 9 to 4
            move 11 from 1 to 9
            move 2 from 4 to 7
            move 4 from 6 to 1
            move 1 from 5 to 4
            move 5 from 8 to 9
            move 1 from 7 to 1
            move 3 from 2 to 7
            move 4 from 1 to 2
            move 3 from 4 to 2
            move 1 from 8 to 5
            move 1 from 5 to 4
            move 1 from 5 to 4
            move 5 from 6 to 1
            move 3 from 7 to 6
            move 5 from 2 to 8
            move 15 from 9 to 2
            move 1 from 3 to 9
            move 10 from 6 to 8
            move 1 from 4 to 9
            move 1 from 8 to 3
            move 1 from 4 to 6
            move 4 from 6 to 3
            move 2 from 9 to 7
            move 1 from 7 to 6
            move 1 from 1 to 6
            move 3 from 3 to 8
            move 2 from 7 to 8
            move 3 from 8 to 4
            move 12 from 2 to 9
            move 14 from 9 to 5
            move 12 from 8 to 2
            move 1 from 6 to 7
            move 8 from 3 to 1
            move 2 from 4 to 6
            move 1 from 3 to 6
            move 5 from 6 to 1
            move 17 from 1 to 2
            move 29 from 2 to 1
            move 1 from 8 to 5
            move 1 from 4 to 3
            move 1 from 8 to 5
            move 1 from 8 to 7
            move 5 from 2 to 1
            move 1 from 3 to 5
            move 1 from 6 to 4
            move 6 from 5 to 8
            move 1 from 4 to 9
            move 1 from 7 to 2
            move 1 from 2 to 6
            move 7 from 8 to 7
            move 1 from 6 to 9
            move 2 from 9 to 2
            move 2 from 2 to 8
            move 15 from 1 to 2
            move 2 from 8 to 3
            move 9 from 1 to 2
            move 24 from 2 to 7
            move 11 from 1 to 2
            move 1 from 3 to 1
            move 22 from 7 to 6
            move 6 from 5 to 2
            move 2 from 6 to 5
            move 1 from 1 to 9
            move 1 from 9 to 6
            move 6 from 5 to 1
            move 12 from 6 to 2
            move 3 from 1 to 5
            move 1 from 3 to 2
            move 25 from 2 to 6
            move 4 from 7 to 5
            move 8 from 5 to 4
            move 4 from 4 to 8
            move 1 from 1 to 8
            move 5 from 8 to 4
            move 4 from 4 to 1
            move 2 from 1 to 9
            move 20 from 6 to 8
            move 4 from 2 to 6
            move 19 from 8 to 7
            move 2 from 9 to 3
            move 1 from 8 to 2
            move 11 from 6 to 7
            move 3 from 1 to 2
            move 5 from 4 to 3
            move 1 from 1 to 3
            move 1 from 3 to 5
            move 2 from 2 to 8
            move 33 from 7 to 3
            move 1 from 5 to 3
            move 1 from 8 to 7
            move 1 from 7 to 4
            move 5 from 6 to 8
            move 2 from 7 to 6
            move 2 from 2 to 3
            move 1 from 2 to 5
            move 1 from 7 to 9
            move 1 from 5 to 7
            move 1 from 8 to 2
            move 1 from 4 to 3
            move 43 from 3 to 7
            move 1 from 3 to 8
            move 1 from 6 to 8
            move 8 from 7 to 5
            move 3 from 5 to 3
            move 1 from 6 to 4
            move 2 from 6 to 7
            move 4 from 8 to 7
            move 3 from 3 to 2
            move 1 from 9 to 6
            move 3 from 8 to 3
            move 1 from 6 to 7
            move 1 from 4 to 6
            move 1 from 3 to 7
            move 1 from 3 to 2
            move 5 from 2 to 5
            move 1 from 6 to 1
            move 1 from 3 to 2
            move 42 from 7 to 5
            move 44 from 5 to 4
            move 2 from 5 to 8
            move 1 from 7 to 3
            move 16 from 4 to 6
            move 3 from 5 to 9
            """;

    public static void main(String[] args) {

        List<List<Character>> crateStacks = initStacks(INPUT);
        moveCrates9000(crateStacks, INPUT);
        crateStacks = initStacks(INPUT);
        moveCrates9001(crateStacks, INPUT);
        crateStacks.forEach(stack -> System.out.print(stack.get(stack.size() - 1)));
    }

    private static void moveCrates9000(List<List<Character>> crateStacks, String testInput) {
        String movements = testInput.substring(testInput.indexOf("move"));
        movements.lines().map(Day05::cleanLine).forEach(coordinates -> {

            List<Character> fromStack = crateStacks.get(Integer.parseInt(coordinates[1]) - 1);
            List<Character> toStack = crateStacks.get(Integer.parseInt(coordinates[2]) - 1);
            int numberOfCreates = Integer.parseInt(coordinates[0]);
            IntStream.range(0, numberOfCreates)
                    .forEach(c -> toStack.add(fromStack.remove(fromStack.size() - 1)));
        });
    }

    private static void moveCrates9001(List<List<Character>> crateStacks, String testInput) {
        String movements = testInput.substring(testInput.indexOf("move"));
        movements.lines().map(Day05::cleanLine).forEach(coordinates -> {

            List<Character> fromStack = crateStacks.get(Integer.parseInt(coordinates[1]) - 1);
            List<Character> toStack = crateStacks.get(Integer.parseInt(coordinates[2]) - 1);
            int numberOfCreates = Integer.parseInt(coordinates[0]);
            int removePosition = fromStack.size() - numberOfCreates;
            IntStream.range(0, numberOfCreates)
                    .forEach(c -> toStack.add(fromStack.remove(removePosition)));
        });
    }

    private static String[] cleanLine(String line) {
        return line
                .replace("move ", "")
                .replace("from ", "")
                .replace("to ", "").split(" ");
    }

    private static List<List<Character>> initStacks(String testInput) {
        List<List<Character>> stacks = new ArrayList<>();
        //Split input
        String startSituation = testInput.substring(0, testInput.indexOf("1") - 2);
        System.out.println(startSituation);
        List<String> lines = startSituation.lines().toList();

        long numberOfStacks = lines.get(lines.size() - 1).chars().filter(c -> c == '[').count();
        IntStream.range(0, (int) numberOfStacks).forEach(i -> stacks.add(new ArrayList<>()));

        for (int i = lines.size() - 1; i >= 0; i--) {
            char[] characters = lines.get(i).toCharArray();
            int column = 0;
            for (int j = 1; j < characters.length; j += 4) {
                if (characters[j] == ' ') {
                    column++;
                    continue;
                }
                stacks.get(column).add(characters[j]);
                column++;
            }
        }
        return stacks;
    }
}
