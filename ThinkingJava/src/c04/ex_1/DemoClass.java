package c04.ex_1;

public class DemoClass {
    private String arg;
    public DemoClass(){
        System.out.println("DemoClass created");
    }
    public DemoClass(String arg){
        super();
        this.arg=arg;
        System.out.println("Get arg");
    }
}
