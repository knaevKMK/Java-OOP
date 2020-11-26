package StackOfStrings;

public class Main {
    public static void main(String[] args) {
        StackOfStrings data = new StackOfStrings();
        data.push("one");
        data.push("two");
        data.push("three");

        System.out.println(data.isEmpty());
        System.out.println(data.peek());

        System.out.println(data.pop());
        System.out.println(data.pop());
        System.out.println(data.pop());
    }
}
