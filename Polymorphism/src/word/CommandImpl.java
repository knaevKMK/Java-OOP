package word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandImpl implements CommandInterface {
    private Map<String, TextTransform> commandTransforms;
    private StringBuilder text;

    public CommandImpl(StringBuilder text) {
        this.commandTransforms = new HashMap<>();
        this.text = text;
    }

    @Override
    public void init() {
        this.commandTransforms.clear();
        for (Command p : this.initCommands()) {
            this.commandTransforms.putIfAbsent(p.getText(), p.getTextTransform());
        }
    }

    @Override
    public void handleInput(String input) {
        String[] tokens = input.split("\\s+");

        String commandName = tokens[0];
        int startInd = Integer.parseInt(tokens[1]);
        int endInd = Integer.parseInt(tokens[2]);
        if (0 <= startInd && endInd < this.text.length() && startInd < endInd) {
            this.commandTransforms.get(commandName).invokeOn(this.text, startInd, endInd);
        }
    }

    protected List<Command> initCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new Command("uppercase", new ToUpperTransform()));
        commands.add(new Command("cut", new Cut()));
        commands.add(new Command("paste", new Paste()));

        return commands;
    }

    static class ToUpperTransform implements TextTransform {

        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            for (int i = startIndex; i < endIndex; i++) {
                text.setCharAt(i, Character.toUpperCase(text.charAt(i)));
            }
        }
    }

    static class Cut implements TextTransform {
        private static StringBuilder lastCut = new StringBuilder();


        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {

            lastCut.append(text, startIndex, endIndex - 1);
            text.delete(startIndex, endIndex);
        }

        public static StringBuilder getLastCut() {

            return lastCut;
        }
    }

    static class Paste implements TextTransform {

        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            String lastCut = Cut.getLastCut().toString();
            if (lastCut.length() > 0) {
                text.delete(startIndex + 1, endIndex);
                text.insert(startIndex, lastCut);
            }
        }
    }
}
