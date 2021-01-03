package bakery.io;

import bakery.io.interfaces.OutputWriter;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class ConsoleWriter implements OutputWriter {
 private BufferedWriter writer;

    public ConsoleWriter() {
        this.writer= new BufferedWriter(new OutputStreamWriter(System.out));
    }

    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
