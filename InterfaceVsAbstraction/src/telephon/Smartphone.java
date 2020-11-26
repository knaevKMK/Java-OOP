package telephon;

import java.util.List;
import java.util.stream.Collectors;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder s = new StringBuilder();
        urls.forEach(e -> s.append(Validator.checkUrls(e)).append(System.lineSeparator()));
        return s.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder s = new StringBuilder();
        numbers.forEach(e -> s.append(Validator.checkNumbers(e)).append(System.lineSeparator()));
        return s.toString().trim();
    }
}
