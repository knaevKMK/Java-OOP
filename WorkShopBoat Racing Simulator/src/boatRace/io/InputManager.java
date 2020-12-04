package boatRace.io;

import boatRace.io.interfaces.InputRead;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputManager implements InputRead {
    private BufferedReader reader;

    public InputManager() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        String input = null;
        try {
            input = this.reader.readLine().trim();
        } catch (Exception e) {
        }
        return null;
    }
}
