package c09;

public class Exceptions extends Exception{
    String msg;
    public Exceptions(String args){
        this.msg=args;
    }
    public String toStrins(){
        return msg;
    }
}
