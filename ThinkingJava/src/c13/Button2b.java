package c13;
// Using anonymous inner classes
// <applet code=Button2b width=200 height=50>
// </applet>
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Button2b extends JApplet {
    JButton
            b1 = new JButton("Button 1"),
            b2 = new JButton("Button 2");
    ActionListener al = new ActionListener() {
        public void actionPerformed(ActionEvent e){
            String name =
                    ((JButton)e.getSource()).getText();
            getAppletContext().showStatus(name);
        }
    };
    public void init() {
        b1.addActionListener(al);
        b2.addActionListener(al);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(b1);
        cp.add(b2);
    }
}