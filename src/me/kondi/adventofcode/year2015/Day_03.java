package me.kondi.adventofcode.year2015;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day_03 {

   record Pair(int x, int y){}

    public static int result(){
        HashMap<Pair, Integer> fieldHashMap = new HashMap<>();
        try {

            File file = new File("E:\\PROGRAMOWANIE\\Java\\AdventOfCode\\Day_01_2015\\resources\\Day_03_Data_P1.txt");
            Scanner reader = new Scanner(file);
            int x = 0, y = 0;

            while (reader.hasNextLine()) {

                String data = reader.nextLine();
                for (char c : data.toCharArray()) {
                    if(c == '^')
                        y++;
                    if(c == 'v')
                        y--;
                    if(c == '>')
                        x++;
                    if(c == '<')
                        x--;
                    Pair pair = new Pair(x, y);
                    System.out.println(pair);
                    if(fieldHashMap.containsKey(pair))
                        fieldHashMap.put(pair, fieldHashMap.get(pair)+1);
                    else fieldHashMap.put(pair, 1);
                }


            }
        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
        List<Integer> resultList = fieldHashMap.values().stream().filter(i -> i>=1).toList();
        //2565
        System.out.println(resultList.size());
        return 1;
    }

    public static int result2(){
        HashMap<Pair, Integer> fieldHashMap = new HashMap<>();
        try {

            File file = new File("E:\\PROGRAMOWANIE\\Java\\AdventOfCode\\Day_01_2015\\resources\\Day_03_Data_P1.txt");
            Scanner reader = new Scanner(file);
            int x = 0, y = 0;
            int a = 0, b = 0;
            while (reader.hasNextLine()) {

                String data = reader.nextLine();

                for (int i = 0; i < data.toCharArray().length; i++) {
                    Pair pair;
                    char c = data.toCharArray()[i];
                    if(i%2==0){
                        if(c == '^')
                            y++;
                        if(c == 'v')
                            y--;
                        if(c == '>')
                            x++;
                        if(c == '<')
                            x--;
                        pair = new Pair(x, y);
                    }else{
                        if(c == '^')
                            b++;
                        if(c == 'v')
                            b--;
                        if(c == '>')
                            a++;
                        if(c == '<')
                            a--;
                        pair = new Pair(a, b);
                    }


                    System.out.println(pair);
                    if(fieldHashMap.containsKey(pair))
                        fieldHashMap.put(pair, fieldHashMap.get(pair)+1);
                    else fieldHashMap.put(pair, 1);
                }


            }
        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
        List<Integer> resultList = fieldHashMap.values().stream().filter(i -> i>=1).toList();
        //2639
        System.out.println(resultList.size());
        return 1;
    }

}
