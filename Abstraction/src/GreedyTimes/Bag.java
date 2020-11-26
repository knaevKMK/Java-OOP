package GreedyTimes;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bag {
    private long capacity;
    private Map<String, Long> items;
    private Map<String, Long> gold;
    private Map<String, Long> gems;
    private Map<String, Long> currency;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.items = new TreeMap<>();
        this.gold = new HashMap<>();
        this.gems = new HashMap<>();
        this.currency = new HashMap<>();
    }

    public void addInBag(String s) {
        Pattern pattern = Pattern.compile("(?<group>[A-Za-z]+)\\s+(?<value>\\d+)");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find() && hasEnoughSpace(1)) {
            long temp = Integer.parseInt(matcher.group("value"));
            if (hasEnoughSpace(temp)) {
                if (matcher.group("group").equals("Gold")) {
                    //       items.putIfAbsent("Gold", 0);
                    items.put("Gold", getValue("Gold") + temp);
                    gold.putIfAbsent("Gold", 0L);
                    gold.put("Gold", gold.get("Gold") + temp);
                } else if (matcher.group("group").toLowerCase().contains("gem") && matcher.group("group").length() > 3 && temp + getValue("Gem") <= getValue("Gold")) {
                    //  items.putIfAbsent("Gem", 0);
                    items.put("Gem", getValue("Gem") + temp);
                    gems.putIfAbsent(matcher.group("group"), 0L);
                    gems.put(matcher.group("group"), gems.get(matcher.group("group")) + temp);
                } else if (matcher.group("group").length() == 3 && temp + getValue("Cash") <= getValue("Gem")) {
                    //      items.putIfAbsent("Cash", 0);
                    items.put("Cash", getValue("Cash") + temp);
                    currency.putIfAbsent(matcher.group("group"), 0L);
                    currency.put(matcher.group("group"), currency.get(matcher.group("group")) + temp);
                }
            }
        }

    }

    private long getValue(String s) {
        if (items.containsKey(s)) {
            return items.get(s);
        }
        return 0;
    }

    private boolean hasEnoughSpace(long temp) {
        return this.capacity - temp >= 0;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        items.entrySet().stream().sorted((a, s) -> {
            int result = Long.compare(s.getValue(), a.getValue());
            if (result == 0) {
                result = s.getKey().compareTo(a.getKey());
            }
            return result;
        })
                .forEach(e -> print
                        .append(String.format("<%s> $%d%n", e.getKey(), e.getValue()))
                        .append(getListofItems(e.getKey())));

        return print.toString().trim();
    }

    private String getListofItems(String list) {
        StringBuilder print = new StringBuilder("");
        Map<String, Long> temp = getList(list);
        if (!temp.isEmpty()) {
            temp.entrySet().stream().sorted((f, s) -> {
                int result = s.getKey().compareTo(f.getKey());
                if (result == 0) {
                    result = Long.compare(f.getValue(), s.getValue());
                }
                return result;
            })
                    .forEach((e) -> print.append(String.format("##%s - %d%n", e.getKey(), e.getValue())));
        }
        return print.toString();
    }

    private Map<String, Long> getList(String list) {
        switch (list) {
            case "Gold":
                return gold;
            case "Gem":
                return gems;
            case "Cash":
                return currency;
        }
        return null;
    }
}
