package c10;


import java.io.*;
import java.util.ArrayDeque;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("E:\\test for java.txt"));
        ArrayDeque<String> rows = new ArrayDeque<>();
        String row = reader.readLine();
        while (row != null) {
            rows.push(row);
            row = reader.readLine();
        }
        while (!rows.isEmpty()) {
            System.out.println(rows.poll());
        }
        reader.close();
    }
}
