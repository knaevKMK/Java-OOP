package c06;

public class C extends A {
    B b;

    public C(String name, int age) {
    super(name);
    this.b= new B(age);
    }
}
