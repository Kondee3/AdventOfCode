package me.kondi.adventofcode.year2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day_06 {
    public static int result() {
        int[][] grid = new int[1000][1000];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = 0;
            }
        }
        File file = new File("E:\\PROGRAMOWANIE\\Java\\AdventOfCode\\Day_01_2015\\resources\\Day_06_Data_P1.txt");

        try {
            Scanner reader = new Scanner(file);
            int sum = 0;
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] cmd = data.split(" ");

                if (cmd[0].equals("turn") && cmd[1].equals("on")) {
                    String[] cd1 = cmd[2].split(",");
                    String[] cd2 = cmd[4].split(",");
                    System.out.println(Integer.valueOf(cd1[0]) + "." + Integer.valueOf(cd1[1]) + " - " + Integer.valueOf(cd2[0]) + "." + Integer.valueOf(cd2[1]));
                    for (int j = Integer.valueOf(cd1[0]); j <= Integer.valueOf(cd2[0]); j++) {
                        for (int k = Integer.valueOf(cd1[1]); k <= Integer.valueOf(cd2[1]); k++) {
                            grid[j][k] = 1;
                        }
                    }
                }

                if (cmd[0].equals("turn") && cmd[1].equals("off")) {
                    String[] cd1 = cmd[2].split(",");
                    String[] cd2 = cmd[4].split(",");
                    System.out.println(Integer.valueOf(cd1[0]) + "." + Integer.valueOf(cd1[1]) + " - " + Integer.valueOf(cd2[0]) + "." + Integer.valueOf(cd2[1]));
                    for (int j = Integer.valueOf(cd1[0]); j <= Integer.valueOf(cd2[0]); j++) {
                        for (int k = Integer.valueOf(cd1[1]); k <= Integer.valueOf(cd2[1]); k++) {
                            grid[j][k] = 0;
                        }
                    }
                }
                if (cmd[0].equals("toggle")) {
                    String[] cd1 = cmd[1].split(",");
                    String[] cd2 = cmd[3].split(",");
                    System.out.println(Integer.valueOf(cd1[0]) + "." + Integer.valueOf(cd1[1]) + " - " + Integer.valueOf(cd2[0]) + "." + Integer.valueOf(cd2[1]));
                    for (int j = Integer.valueOf(cd1[0]); j <= Integer.valueOf(cd2[0]); j++) {
                        for (int k = Integer.valueOf(cd1[1]); k <= Integer.valueOf(cd2[1]); k++) {
                            if (grid[j][k] == 0)
                                grid[j][k] = 1;
                            else grid[j][k] = 0;
                        }
                    }
                }

            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1)
                        sum++;
                }
            }
            System.out.println(sum);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //400410
        return 1;
    }

    public static int result2() {
        int[][] grid = new int[1000][1000];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = 0;
            }
        }
        File file = new File("E:\\PROGRAMOWANIE\\Java\\AdventOfCode\\Day_01_2015\\resources\\Day_06_Data_P1.txt");

        try {
            Scanner reader = new Scanner(file);
            int sum = 0;
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] cmd = data.split(" ");

                if (cmd[0].equals("turn") && cmd[1].equals("on")) {
                    String[] cd1 = cmd[2].split(",");
                    String[] cd2 = cmd[4].split(",");
                    for (int j = Integer.valueOf(cd1[0]); j <= Integer.valueOf(cd2[0]); j++) {
                        for (int k = Integer.valueOf(cd1[1]); k <= Integer.valueOf(cd2[1]); k++) {
                            grid[j][k]++;
                        }
                    }
                }

                if (cmd[0].equals("turn") && cmd[1].equals("off")) {
                    String[] cd1 = cmd[2].split(",");
                    String[] cd2 = cmd[4].split(",");
                    for (int j = Integer.valueOf(cd1[0]); j <= Integer.valueOf(cd2[0]); j++) {
                        for (int k = Integer.valueOf(cd1[1]); k <= Integer.valueOf(cd2[1]); k++) {
                            if(grid[j][k] != 0)
                                grid[j][k]--;
                        }
                    }
                }
                if (cmd[0].equals("toggle")) {
                    String[] cd1 = cmd[1].split(",");
                    String[] cd2 = cmd[3].split(",");
                    for (int j = Integer.valueOf(cd1[0]); j <= Integer.valueOf(cd2[0]); j++) {
                        for (int k = Integer.valueOf(cd1[1]); k <= Integer.valueOf(cd2[1]); k++) {
                            grid[j][k] += 2;
                        }
                    }
                }

            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                        sum += grid[i][j];
                }
            }
            System.out.println(sum);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //15343601
        return 1;
    }
}
