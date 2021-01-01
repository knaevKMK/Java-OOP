package c13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextArea1 extends JApplet {
    JButton
            b1 = new JButton("Text Area 1"),
            b2 = new JButton("Text Area 2"),
            b3 = new JButton("Replace Text"),
            b4 = new JButton("Insert Text");
    JTextArea
            t1 = new JTextArea("t1", 1, 30),
            t2 = new JTextArea("t2", 4, 30);
    ActionListener a1 = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            getAppletContext().showStatus(t1.getText());
        }
    };
    ActionListener a2 = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            t2.setText("Inserted by Button 2");
            t2.append(": " + t1.getText());
            getAppletContext().showStatus(t2.getText());
        }
    };
    ActionListener a3 = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String s = " Replacement ";
            t2.replaceRange(s, 3, 3 + s.length());
        }
    };
    ActionListener a4 = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            t2.insert(" Inserted ", 10);
        }
    };

    public void init() {
        b1.addActionListener(a1);
        b2.addActionListener(a2);
        b3.addActionListener(a3);
        b4.addActionListener(a4);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(b1);
        cp.add(t1);
        cp.add(b2);
        cp.add(t2);
        cp.add(b3);
        cp.add(b4);
    }
}
