package ShoppingSpree;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        try {
            addPersons(people);
            addList(products);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return;
        }
        String read;
        while (!"END".equals(read = scanner.nextLine())) {
            buyProduct(people, products, read);
        }

        people.forEach((k, v) -> System.out.println(v));
    }

    private static void buyProduct(Map<String, Person> people, Map<String, Product> products, String read) {
        String[] token = read.split("\\s+");
        try {
            people.get(token[0]).buyProduct(products.get(token[1]));
            System.out.println(people.get(token[0]).getName() + " bought " + products.get(token[1]));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }


    private static void addPersons(Map<String, Person> list) {
        String[] token = scanner.nextLine().split(";");
        for (String s : token) {
            String[] subToken = s.split("=");
            list.put(s, new Person(subToken[0], Double.parseDouble(subToken[1])));
        }
    }

    private static void addList(Map<String, Product> list) {
        String[] token = scanner.nextLine().split(";");
        for (String s : token) {
            String[] subToken = s.split("=");
            list.put(s, new Product(subToken[0], Double.parseDouble(subToken[1])));
        }
    }
}
