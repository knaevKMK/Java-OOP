package c13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button2 extends JApplet {
    JButton
            b1 = new JButton("Button 1"),
            b2 = new JButton("Button 2");

    class BL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton) e.getSource()).getText();
            getAppletContext().showStatus(name);
        }

    }

    BL al = new BL();

    public void init() {
        b1.addActionListener(al);
        b2.addActionListener(al);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(b1);
        cp.add(b2);
    }
}
