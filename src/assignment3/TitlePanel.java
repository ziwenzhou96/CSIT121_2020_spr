package assignment3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TitlePanel extends JPanel {
    private JLabel titleLabel;
    private JList<String> list;

    public TitlePanel(String title) {
        this.titleLabel=new JLabel(title);
        this.list=new JList<>();
        this.setLayout(new BorderLayout());
        this.add(titleLabel,BorderLayout.NORTH);
        this.add(new JScrollPane(this.list),BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void setListData(String[] listData) {
        list.setListData(listData);
        list.notify();
    }

    public void clear(){
        list.removeAll();
    }
}
