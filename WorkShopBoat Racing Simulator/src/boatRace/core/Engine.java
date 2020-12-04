package boatRace.core;

import boatRace.core.Controller.Controller;
import boatRace.core.Controller.ControllerImpl;
import boatRace.io.InputManager;
import boatRace.io.OutputManager;

public class Engine {
    private InputManager reader;
    private OutputManager printer;
    private Controller controller;


    public Engine() {
        this.reader = new InputManager();
        this.printer = new OutputManager();
        this.controller = new ControllerImpl();
    }

    public void run() {
        while (true) {
            String result;
            try {
                result = processInput();
                if (result.equals("End")) {
                    break;
                }
            } catch (Exception exception) {
                result = exception.getMessage();
            }
            printer.writeLine(result);
        }
    }

    private String processInput() {
        String read = reader.readLine();
        if (read.equals("End")) {
            return read;
        }
        String[] tokens = read.split("\\\\");
        return controller.execute(tokens);
    }
}
