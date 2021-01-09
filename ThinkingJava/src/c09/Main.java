package c09;

public class Main {
    public static void main(String[] args) {


        try {
            // break code
        }catch (Exception exception){
            try {
                throw new Exceptions(exception.getMessage());
            } catch (Exceptions exceptions) {
                exceptions.printStackTrace();
            }
            //   System.out.println(exception);
        }finally {
            System.out.println("I was here");
        }
    }
}
