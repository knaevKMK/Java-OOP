package c06.Cartoon;

public class Main {
    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }
    // Cartoon create via his father class Drawing and
    //   goes via super() to its constructor,
    //   but Drawing is child class of Art and goes via super () to Art constructor.
    // That first print msg from Art constructor, next Drawing and last is current - Cartoon
}
