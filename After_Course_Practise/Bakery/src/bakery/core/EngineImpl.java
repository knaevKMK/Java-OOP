package bakery.core;

import bakery.common.enums.Commands;
import bakery.core.interfaces.Controller;
import bakery.core.interfaces.Engine;
import bakery.io.ConsoleReader;
import bakery.io.ConsoleWriter;
import bakery.io.interfaces.InputReader;
import bakery.io.interfaces.OutputWriter;

import java.io.IOException;
import java.util.Arrays;

import static bakery.common.enums.Commands.END;

public class EngineImpl implements Engine {
    private InputReader reader;
    private OutputWriter writer;
    private Controller controller;

    public EngineImpl() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.controller = new ControllerImpl();
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processOfInput();
                if (result.equals(END.name())) {
                    break;
                }
            } catch (IOException | IllegalArgumentException | NullPointerException exception) {
                result = exception.getMessage();
            }
            this.writer.writeLine(result);
        }
    }

    private String processOfInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");
        Commands commands = Commands.valueOf(tokens[0]);
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        String result = null;
        switch (commands) {
            case AddFood:
                result = controller.addFood(data[1], data[2], Double.parseDouble(data[3]));
                break;
            case AddDrink:
                result = controller.addDrink( data[0], data[1], Integer.parseInt(data[2]), data[3]);
                break;
            case AddTable:
                result = controller.addTable( data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]));
                break;
            case ReserveTable:
                result = controller.reserveTable(Integer.parseInt(data[0]));
                break;
            case OrderFood:
                result = controller.orderFood(Integer.parseInt(data[0]),data[1]);
                break;
            case OrderDrink:
                result = controller.orderDrink(Integer.parseInt(data[0]),data[1],data[2]);
                break;
            case LeaveTable:
                result = controller.leaveTable(Integer.parseInt(data[0]));
                break;
            case GetFreeTablesInfo:
                result = controller.getFreeTablesInfo();
                break;
            case GetTotalIncome:
                result = controller.getTotalIncome();
                break;
            case END:
                result = END.name();
                break;
        }
        return result.trim();
    }
}
