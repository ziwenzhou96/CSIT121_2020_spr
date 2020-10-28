package assignment3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentEnrolmentFrame extends JFrame {
    private JPanel
            northPanel,
            centerPanel,
            southPanel;

    private JLabel
            courseLabel,
            tCreditLabel,
            eCreditLabel;

    private JTextField
            stNameTF,
            stNumTF,
            dobTF;

    private JList<String>
            coreSubList,
            majorList,
            majorCoreList,
            electiveSubList;

    private JButton
            bcscsBtn,
            mcscsBtn,
            enrolBtn,
            resetBtn;

    private JRadioButton
            fmaleRBth,
            maleRBtn;

    private ButtonGroup genderBG;

    public StudentEnrolmentFrame() throws HeadlessException {
        initGui();
        initEventHandler();
    }

    private void initGui(){
        //init components
        courseLabel=new JLabel("");
        tCreditLabel=new JLabel("");
        eCreditLabel=new JLabel("0");

        stNameTF=new JTextField();
        stNumTF=new JTextField();
        dobTF=new JTextField();

        coreSubList=new JList<String>();
        coreSubList.setVisibleRowCount(8);
        majorList=new JList<String>();
        majorList.setVisibleRowCount(8);
        majorList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        majorCoreList=new JList<String>();
        majorCoreList.setVisibleRowCount(8);
        electiveSubList=new JList<String>();
        electiveSubList.setVisibleRowCount(8);
        majorCoreList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        bcscsBtn=new JButton("Bachelor of Computer Science Course Structure");
        mcscsBtn=new JButton("Master of Computer Science Course Structure");
        enrolBtn=new JButton("Enrol");
        resetBtn=new JButton("Reset");

        fmaleRBth=new JRadioButton("Female");
        maleRBtn=new JRadioButton("Male");

        genderBG=new ButtonGroup();
        genderBG.add(fmaleRBth);
        genderBG.add(maleRBtn);

        //init northPanel
        northPanel=new JPanel();
        northPanel.setLayout(new GridLayout(2,5,5,5));

        northPanel.add(new JLabel("Student Name:"));
        northPanel.add(this.stNameTF);
        northPanel.add(new JLabel());
        northPanel.add(new JLabel("Student Number:"));
        northPanel.add(this.stNumTF);
        northPanel.add(new JLabel("Gender:"));
        northPanel.add(this.fmaleRBth);
        northPanel.add(this.maleRBtn);
        northPanel.add(new JLabel("DOB:"));
        northPanel.add(this.dobTF);

        //init centerPanel
        centerPanel=new JPanel();
        centerPanel.setLayout(new GridLayout(7,2,5,5));

        centerPanel.add(this.bcscsBtn);
        centerPanel.add(this.mcscsBtn);
        centerPanel.add(new JLabel("Course Name:"));
        centerPanel.add(this.courseLabel);
        centerPanel.add(new JLabel("Total Credit:"));
        centerPanel.add(this.tCreditLabel);

        JPanel cSubPanel = new JPanel(new BorderLayout());

        cSubPanel.add(new JLabel("Core Subjects:"),BorderLayout.NORTH);
        cSubPanel.add(new JScrollPane(this.coreSubList),BorderLayout.CENTER);
        centerPanel.add(cSubPanel);
        centerPanel.add(new Label());

        JPanel majorPanel = new JPanel(new BorderLayout());
        majorPanel.add(new JLabel("Majors:"),BorderLayout.NORTH);
        majorPanel.add(new JScrollPane(this.majorList),BorderLayout.CENTER);
        centerPanel.add(majorPanel);

//        TitlePanel tp = new TitlePanel("Majors:");
//        centerPanel.add(tp);

        JPanel majorCorePanel = new JPanel(new BorderLayout());
        majorCorePanel.add(new JLabel("Majors Cores:"),BorderLayout.NORTH);
        majorCorePanel.add(new JScrollPane(this.majorCoreList),BorderLayout.CENTER);
        centerPanel.add(majorCorePanel);

        JPanel eSubPanel = new JPanel(new BorderLayout());
        eSubPanel.add(new JLabel("Elective Subjects:"),BorderLayout.NORTH);
        eSubPanel.add(new JScrollPane(this.electiveSubList),BorderLayout.CENTER);
        centerPanel.add(eSubPanel);
        centerPanel.add(new Label());

        centerPanel.add(new JLabel("Enrolled Credit:"));
        centerPanel.add(this.eCreditLabel);

        //init southPanel
        southPanel=new JPanel();
        southPanel.setLayout(new GridLayout(1,2,5,5));
        southPanel.add(this.enrolBtn);
        southPanel.add(this.resetBtn);


        this.add(northPanel,BorderLayout.NORTH);
        northPanel.setVisible(true);
        this.add(centerPanel,BorderLayout.CENTER);
        centerPanel.setVisible(true);
        this.add(southPanel,BorderLayout.SOUTH);
        southPanel.setVisible(true);

        //init frame and layout
        this.setTitle("Student Enrolment System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,1000);
        this.setVisible(true);
        this.setLayout(new BorderLayout(5,10));
    }

    private void initEventHandler(){
        this.resetBtn.addActionListener(e -> {
            courseLabel.setText("");
            tCreditLabel.setText("");
            eCreditLabel.setText("0");

            stNameTF.setText("");
            stNumTF.setText("");
            dobTF.setText("");

            coreSubList.removeAll();
            majorList.removeAll();
            majorCoreList.removeAll();
            electiveSubList.removeAll();

            genderBG.clearSelection();

            JOptionPane.showMessageDialog(
                    this,"The system is reset.",
                    "System Reset",JOptionPane.INFORMATION_MESSAGE);
        });
    }
}
