package StackOfStrings;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class StackOfStrings extends ArrayList<String> {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public void push(String element) {
        this.data.add(0, element);
    }

    public String peek() {
        return this.data.get(0);
    }

    public String pop() {
        return this.data.remove(0);
    }
}
