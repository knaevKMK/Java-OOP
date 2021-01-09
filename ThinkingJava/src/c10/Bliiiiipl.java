package c10;

import java.io.*;

public class Bliiiiipl {

    static class Blip1 implements Externalizable {
        public Blip1() {
            System.out.println("Blip1 Constructor");
        }

        public void writeExternal(ObjectOutput out)
                throws IOException {
            System.out.println("Blip1.writeExternal");
        }

        public void readExternal(ObjectInput in)
                throws IOException, ClassNotFoundException {
            System.out.println("Blip1.readExternal");
        }
    }

    public static class BlipCheck implements Externalizable {
        BlipCheck() {
            System.out.println("Blip2 Constructor");
        }

        public void writeExternal(ObjectOutput out)
                throws IOException {
            System.out.println("Blip2.writeExternal");
        }

        public void readExternal(ObjectInput in)
                throws IOException, ClassNotFoundException {
            System.out.println("Blip2.readExternal");
        }
    }


    public static void main(String[] args) {
        System.out.println("Constructing objects:");
        Blip1 b1 = new Blip1();
        BlipCheck b2 = new BlipCheck();
        try {
            ObjectOutputStream o =
                    new ObjectOutputStream(
                            new FileOutputStream("Blips.out"));
            System.out.println("Saving objects:");
            o.writeObject(b1);
            o.writeObject(b2);
            o.close();
// Now get them back:
            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream("Blips.out"));
            System.out.println("Recovering b1:");
            b1 = (Blip1) in.readObject();
// OOPS! Throws an exception:
            System.out.println("Recovering b2:");
            b2 = (BlipCheck) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}