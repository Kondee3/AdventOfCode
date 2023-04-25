package me.kondi.adventofcode.year2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day_02 {
    public static int result(){
        int sum = 0;
        try {

            File file = new File("E:\\PROGRAMOWANIE\\Java\\AdventOfCode\\Day_01_2015\\resources\\Day_02_Data_P1.txt");
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                System.out.println(data);
                int[] values = new int[3];
                String[] str = data.split("x");
                for (int i = 0; i < str.length; i++) {
                    values[i] = Integer.valueOf(str[i]);
                }
                values = Arrays.stream(values).sorted().toArray();

                int x = values[0];
                int y = values[1];
                int z = values[2];

                sum += x*y+2*x*y+2*y*z+2*x*z;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sum);
        //result 1588178
        return sum;
    }

    public static int result2(){
        int sum = 0;
        try {

            File file = new File("E:\\PROGRAMOWANIE\\Java\\AdventOfCode\\Day_01_2015\\resources\\Day_02_Data_P2.txt");
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                System.out.println(data);
                int[] values = new int[3];
                String[] str = data.split("x");
                for (int i = 0; i < str.length; i++) {
                    values[i] = Integer.valueOf(str[i]);
                }
                values = Arrays.stream(values).sorted().toArray();

                int x = values[0];
                int y = values[1];
                int z = values[2];

                sum += 2*x+2*y+x*y*z;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sum);
        //result 3783758
        return sum;
    }



}
