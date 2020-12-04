package boatRace.io;

import boatRace.io.interfaces.OutputWrite;

public class OutputManager implements OutputWrite {
    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

}
