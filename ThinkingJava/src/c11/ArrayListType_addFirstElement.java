package c11;

import jdk.internal.icu.impl.UBiDiProps;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class ArrayListType_addFirstElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Collection list = new ArrayList<>();

        Object str = "knev";
        Object integer= 11;
        Object chaR='k';

        Class<?> type = str.getClass().arrayType();
        System.out.println(type.getSimpleName());
        list.add(str);
        list= Collections.singleton(list.stream()
                .collect(Collectors.toList()));


        //EX_2
        //Създайте нов тип колекция която използва ArrayList. Хванете типа на първия
        //вкаран обект, а после позволете на потребителя да вкарва обекти от само
        //него тип от този момент нататък.
    }
}
