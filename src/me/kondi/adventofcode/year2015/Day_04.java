package me.kondi.adventofcode.year2015;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public  class Day_04 {

    public static String result()   {
        String input =  "yzbqklnj";
        for (int i = 0; i<Integer.MAX_VALUE; i++){
            String out = input + i;
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                byte[] digest = md5.digest(out.getBytes(StandardCharsets.UTF_8));
                String hash = encodeMD5(digest);

                char[] cs = hash.toCharArray();
                if(cs[0] == '0' && cs[1] == '0' && cs[2] == '0' && cs[3] == '0' && cs[4] == '0'){
                    System.out.println(out);
                    System.out.println(hash);
                    return hash;
                }

            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }


        }
        //282749
        return  "";
    }
    private static String encodeMD5(byte[] bytes) {
        return String.format("%032x", new BigInteger(1, bytes));
    }

    public static String result2()   {
        String input =  "yzbqklnj";
        for (int i = 0; i<Integer.MAX_VALUE; i++){
            String out = input + i;
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                byte[] digest = md5.digest(out.getBytes(StandardCharsets.UTF_8));
                String hash = encodeMD5(digest);

                char[] cs = hash.toCharArray();
                if(cs[0] == '0' && cs[1] == '0' && cs[2] == '0' && cs[3] == '0' && cs[4] == '0' && cs[5] == '0'){
                    System.out.println(out);
                    System.out.println(hash);
                    return hash;
                }

            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }


        }
        //9962624
        return  "";
    }
}
