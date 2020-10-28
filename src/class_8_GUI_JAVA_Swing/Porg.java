package class_8_GUI_JAVA_Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Porg {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Frame");
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setSize(200,200);
        panel.setBackground(Color.CYAN);

        JLabel label = new JLabel("My Label");
        panel.add(label);
        label.setVisible(true);

        JButton button = new JButton("My Button");
        panel.add(button);
        button.setVisible(true);

        button.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(frame,"mouse clicked","warning",JOptionPane.WARNING_MESSAGE);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                label.setText("mouse pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                label.setText("mouse released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("mouse entered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("mouse exited");
            }
        });

    }
}
