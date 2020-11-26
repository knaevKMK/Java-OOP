package Demo;

import java.lang.annotation.Annotation;

public class Tracker implements Authour {
    private String name;

    private Tracker(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return this.name;
    }

    public static void printMethodsByAuthor(Class<?> clazz) {

//        System.out.println(reflectionObject);
        System.out.println(clazz.getMethods()[0]);
        System.out.println();
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
