package c10;


import java.io.*;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //EX_2 String input = scanner.nextLine();
        String input = "E:\\test for java.txt";

        BufferedReader reader = new BufferedReader(new FileReader(input));
        //EX_3
        BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\testWrite for java.txt"));

        ArrayDeque<String> rows = new ArrayDeque<>();
        String row = reader.readLine();
        int i = 0;
        while (row != null) {
            //EX_4
            //        row = row.substring(0, 1).toUpperCase() + row.substring(1);
//EX_5
            if (cnotain(row))
                //EX_3
                writer.write(++i + ". " + row + System.lineSeparator());

            row = reader.readLine();
        }

        while (!rows.isEmpty()) {
            System.out.println(rows.poll());
        }
        reader.close();
        writer.close();
    }

    private static boolean cnotain(String row) {
        StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine(), ", ");
        while (!tokenizer.hasMoreElements()) {
            if (row.contains(tokenizer.nextToken())) {
                return true;
            }
        }
        return false;


    }
}
