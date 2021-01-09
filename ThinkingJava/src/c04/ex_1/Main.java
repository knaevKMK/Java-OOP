package c04.ex_1;

public class Main {
    public static void main(String[] args) {
        DemoClass demoClass = new DemoClass();
        DemoClass demo1Class = new DemoClass("arg");
        //ex_3 Create array with oblects from this class- empty
        DemoClass[] array = new DemoClass[3];
        //ex_4 create objects and add it to array
        array[0] = new DemoClass();
        array[1] = new DemoClass("Demo");
        array[2] = new DemoClass("Memo");
    }
}
