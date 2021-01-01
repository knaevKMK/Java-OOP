package IO;

import java.io.*;

public class DataSerilization implements Serializable {

    private int i;

    DataSerilization(int x) {
        this.i = x;
    }

    public String toString() {
        return Integer.toString(i);
    }
}

class Worm implements Serializable {
    // Generate a random int value:
    private static int r() {
        return (int) (Math.random() * 10);
    }

    private DataSerilization[] d = {
            new DataSerilization(r()), new DataSerilization(r()), new DataSerilization(r())
    };
    private Worm next;
    private char c;

    // Value of i == number of segments
    Worm(int i, char x) {
        System.out.println(" Worm constructor: " + i);
        c = x;
        if (--i > 0)
            next = new Worm(i, (char) (x + 1));
    }

    Worm() {
        System.out.println("Default constructor");
    }

    public String toString() {
        String s = ":" + c + "(";
        for (DataSerilization dataSerilization : d) {
            s += dataSerilization.toString();
        }
        s += ")";
        return s;
    }

    public static void main(String[] args) {
        Worm w = new Worm(6, 'a');
        System.out.println("w = " + w);
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.out"));
            out.writeObject("Worm storage");
            out.writeObject(w);
            out.close(); // Also flushes output
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.out"));
            String s = (String) in.readObject();
            Worm w2 = (Worm) in.readObject();
            System.out.println(s + ", w2 = " + w2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bout);
            out.writeObject("Worm storage");
            out.writeObject(w);
            out.flush();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
            String s = (String) in.readObject();
            Worm w3 = (Worm) in.readObject();
            System.out.println(s + ", w3 = " + w3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
