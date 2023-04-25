package me.kondi.adventofcode.year2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day_05 {

    public static int result(){
        File file = new File("E:\\PROGRAMOWANIE\\Java\\AdventOfCode\\Day_01_2015\\resources\\Day_05_Data_P1.txt");
        String[] forbiddenStrings = {"ab", "cd", "pq", "xy"};
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        try {
            Scanner reader = new Scanner(file);
            int size = 0;
            while(reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
                char[] chars = data.toCharArray();
                boolean haveVowel = false;
                boolean inRow = false;
                boolean notForbidden = true;

                int vowelCounter = 0;
                //Check vowels
                for (char vowel : vowels) {
                    for (int i = 0; i < chars.length; i++) {
                        if(chars[i] == vowel)
                            vowelCounter++;
                    }
                }
                if(vowelCounter>2)
                    haveVowel = true;
                
                //Check letters in row
                for (int i = 97; i < 123; i++) {
                    char c = (char) i;
                    for (int j = 0; j < chars.length-1; j++) {
                        if(chars[j] == c && chars[j+1] == c){
                            inRow = true;
                        }
                    }
                }
                

                //Check forbidden
                for (String forbiddenString : forbiddenStrings) {
                    for (int i = 0; i < chars.length-1; i++) {
                        if(chars[i] == forbiddenString.toCharArray()[0] && chars[i+1] == forbiddenString.toCharArray()[1]){
                            notForbidden = false;
                        }
                    }
                }


                if(haveVowel && notForbidden && inRow)
                    size++;


            }
            System.out.println(size);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //258
        return 1;
    }

    public static int result2(){
        File file = new File("E:\\PROGRAMOWANIE\\Java\\AdventOfCode\\Day_01_2015\\resources\\Day_05_Data_P1.txt");

        try {
            Scanner reader = new Scanner(file);
            int size = 0;
            while(reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
                char[] chars = data.toCharArray();

                boolean inMiddle = false;
                boolean inRow = false;

                for (int i = 0; i < chars.length-1; i++) {
                    char c1 = chars[i];
                    char c2 = chars[i+1];
                    for (int j = i+2;  j< chars.length-1; j++)
                        if (chars[j] == c1 && chars[j + 1] == c2)
                            inRow = true;
                }

                for (int i = 0; i < chars.length-2; i++) {
                    char c1 = chars[i];
                    char c3 = chars[i + 2];
                    if(c1 == c3)
                        inMiddle = true;
                }

                if(inMiddle && inRow)
                    size++;


            }
            System.out.println(size);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //53
        return 1;
    }

}
