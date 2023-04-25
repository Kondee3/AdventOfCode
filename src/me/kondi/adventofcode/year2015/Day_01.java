package me.kondi.adventofcode.year2015;

public class Day_01 {
    public static int result(String seq){
        int s = 0;
        char[] seqChar = seq.toCharArray();
        for (char c : seqChar) {
            System.out.println(c);
            if(c == '(')
                s++;
            else s--;
        }
        return s;
        //result 138
    }

}
