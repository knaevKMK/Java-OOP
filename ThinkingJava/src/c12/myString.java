package c12;

public class myString {
    private String string;

    public myString(String string){
        this.string=string;
    }

    public void concatenate (String add){
        this.string += add;
    }
    public  myString clone(){
        return this;
    }
    @Override
    public String toString(){
        return string;
    }

    public static void main(String[] args) {
        myString x= new myString("knev");
        x.concatenate("K");
        System.out.println(x.clone());
        myString y= new myString("knev");
        System.out.println(y.clone());

    }
}
