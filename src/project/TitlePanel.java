package project;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {
    private JLabel title;
    private JPanel panel;
    private JScrollPane scrollPane;

    public TitlePanel(JLabel title, JPanel panel) {
        this.title = title;
        this.panel = panel;

        this.setLayout(new BorderLayout());

        this.add(title,BorderLayout.NORTH);
        this.add(panel,BorderLayout.CENTER);
    }

    public TitlePanel(JLabel title, JScrollPane scrollPane) {
        this.title = title;
        this.scrollPane = scrollPane;

        this.setLayout(new BorderLayout());

        this.add(title,BorderLayout.NORTH);
        this.add(scrollPane,BorderLayout.CENTER);
    }
}
