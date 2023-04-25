package me.kondi.adventofcode.year2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day_07 {

    public static int result() {

        File file = new File("E:\\PROGRAMOWANIE\\Java\\AdventOfCode\\Day_01_2015\\resources\\Day_07_Data_P1.txt");
        HashMap<String, Integer> wires = new HashMap<>();

        for (int i = 97; i < 123; i++) {
            char c1 = (char) i;
            wires.put(String.valueOf(c1), 0);
            for (int j = 97; j < 123; j++) {
                char c2 = (char) j;
                String s = String.valueOf(c1) + String.valueOf(c2);
                wires.put(s, 0);
            }
        }

        try {
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] cmd = data.split(" ");
                System.out.println(data);

                if (cmd.length == 3) {
                    if (!wires.containsKey(cmd[0]))
                        wires.put(cmd[2], Integer.valueOf(cmd[0]));
                    else wires.put(cmd[2], wires.get(cmd[0]));
                }

                if (cmd.length > 4) {
                    if (cmd[0].equals("NOT")) {
                        if (!wires.containsKey(cmd[1]))
                            wires.put(cmd[3], ~Integer.valueOf(cmd[1]));
                        else wires.put(cmd[3], ~wires.get(cmd[1]));
                    } else {
                        int v1;
                        int v2;
                        if (!wires.containsKey(cmd[0]))
                            v1 = Integer.valueOf(cmd[0]);
                        else v1 = wires.get(cmd[0]);

                        if (!wires.containsKey(cmd[2]))
                            v2 = Integer.valueOf(cmd[2]);
                        else v2 = wires.get(cmd[2]);

                        if (cmd[1].equals("OR")) {
                            int bit = v1 | v2;
                            wires.put(cmd[4], bit);
                        }
                        if (cmd[1].equals("AND")) {
                            int bit = v1 & v2;
                            wires.put(cmd[4], bit);
                        }
                        if (cmd[1].equals("LSHIFT")) {
                            int bit = v1 << v2;
                            wires.put(cmd[4], bit);
                        }
                        if (cmd[1].equals("RSHIFT")) {
                            int bit = v1 >> v2;
                            wires.put(cmd[4], bit);

                        }
                    }
                }


            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        wires.forEach((s, value) -> System.out.println(s + ": " + value));

        System.out.println(String.format("%16s", Integer.toBinaryString(~0)).replace(" ", "0"));

        return 1;
    }
}
