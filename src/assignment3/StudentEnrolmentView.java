package assignment3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class StudentEnrolmentView extends JFrame {
    private JPanel
            northPanel,
            centerPanel,
            southPanel;

    private JLabel
            courseLabel,
            totalCreditLabel,
            selsectedCreditLabel;

    private JTextField
            stNameTF,
            stNumTF,
            dobTF;

    private JList<String>
            coreSubList,
            majorList,
            majorCoreSubList,
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
    private StudentSystem stuSys;

    private String[] coreSubListData,
                        majorListData,
                        majorCoreSubListData,
                        electiveSubListData;

    private ArrayList<Subject> electiveSubject;

    private Course course;
    private int coreCredit;
    private int majorCredit;
    private int electiveCredit;
    private int degreeCode;
    private static final int BCODE=1,MCODE=2;

    public StudentEnrolmentView(StudentSystem stuSys) throws HeadlessException {
        this.stuSys = stuSys;
        this.coreCredit = 0;
        this.majorCredit = 0;
        this.degreeCode = -1;
        initGui();
        initEventHandler();
    }

    private void initGui(){
        //init components
        courseLabel=new JLabel("");
        totalCreditLabel =new JLabel("");
        selsectedCreditLabel =new JLabel("0");

        stNameTF=new JTextField();
        stNumTF=new JTextField();
        dobTF=new JTextField();

        coreSubList=new JList<String>();
        coreSubList.setVisibleRowCount(8);
        coreSubList.setSelectionModel(new NoSelectionModel());
        majorList=new JList<String>();
        majorList.setVisibleRowCount(8);
        majorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        majorCoreSubList =new JList<String>();
        majorCoreSubList.setVisibleRowCount(8);
        majorCoreSubList.setSelectionModel(new NoSelectionModel());
        electiveSubList=new JList<String>();
        electiveSubList.setVisibleRowCount(8);
        majorCoreSubList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

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
        centerPanel.add(this.totalCreditLabel);

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
        majorCorePanel.add(new JScrollPane(this.majorCoreSubList),BorderLayout.CENTER);
        centerPanel.add(majorCorePanel);

        JPanel eSubPanel = new JPanel(new BorderLayout());
        eSubPanel.add(new JLabel("Elective Subjects:"),BorderLayout.NORTH);
        eSubPanel.add(new JScrollPane(this.electiveSubList),BorderLayout.CENTER);
        centerPanel.add(eSubPanel);
        centerPanel.add(new Label());

        centerPanel.add(new JLabel("Enrolled Credit:"));
        centerPanel.add(this.selsectedCreditLabel);

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
        this.bcscsBtn.addActionListener(e -> bcscsBtnOnClick(BCODE));
        this.mcscsBtn.addActionListener(e -> bcscsBtnOnClick(MCODE));
        this.majorList.addListSelectionListener(e -> majorListOnSelected());
        this.electiveSubList.addListSelectionListener(e -> electiveSubListOnChanged());
        this.resetBtn.addActionListener(e -> resetBtnOnClick());
        this.enrolBtn.addActionListener(e -> enrolBtnOnClick());
    }

    private void enrolBtnOnClick(){
        try{
            String stName=stNameTF.getText().trim();
            String stNum=stNumTF.getText().trim();
            String dob=dobTF.getText().trim();
            String gender="";

            if(stName.isEmpty()) throw new InputMismatchException("Student name is not inputted");
            if(stNum.isEmpty()) throw new InputMismatchException("Student number is not inputted");
            if(dob.isEmpty()) throw new InputMismatchException("Student DOB is not inputted");

            if(this.maleRBtn.isSelected()) gender="male";
            else if(this.fmaleRBth.isSelected()) gender="female";
            else throw new InputMismatchException("Gender is not selected");

            if(degreeCode<0) throw new InputMismatchException("Degree is not selected");

            int stNumber=Integer.parseInt(stNum);

            if(this.majorList.isSelectionEmpty()) throw new InputMismatchException("Major is not selected");
            int m = this.majorList.getSelectedIndex();

            ArrayList<String> eSubject = new ArrayList<>();

            for(int index:this.electiveSubList.getSelectedIndices()){
                eSubject.add(this.electiveSubject.get(index).getCode());
            }

            if(degreeCode==1){
                this.stuSys.enrollBStudent(stName,stNumber,gender,dob,m,eSubject);
            }else if(degreeCode==2){
                this.stuSys.enrollMStudent(stName,stNumber,gender,dob,m,eSubject);
            }else{
                throw new InputMismatchException("Degree is not selected");
            }

            JOptionPane.showMessageDialog(
                    StudentEnrolmentView.this,"The student's enrolment record is saved.",
                    "Save Enrolment record",JOptionPane.INFORMATION_MESSAGE);

        }catch (Exception e){
            JOptionPane.showMessageDialog(
                    StudentEnrolmentView.this,e,
                    "Validation Checking",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void electiveSubListOnChanged(){
        this.electiveCredit=0;
        for(int index:this.electiveSubList.getSelectedIndices()){
            electiveCredit+=this.electiveSubject.get(index).getCredit();
        }
        this.selsectedCreditLabel.setText(String.valueOf(this.coreCredit +this.majorCredit+this.electiveCredit));
    }

    private void majorListOnSelected(){
        int index=this.majorList.getSelectedIndex();
        if(index<0){
            return;
        }
        this.electiveSubList.clearSelection();
        this.majorCoreSubListData=new String[course.getMajors().get(index).getMCores().size()];
        this.majorCredit=0;
        for(int i=0;i<course.getMajors().get(index).getMCores().size();i++){
            this.majorCoreSubListData[i]=course.getMajors().get(index).getMCores().get(i).toString();
            this.majorCredit+=course.getMajors().get(index).getMCores().get(i).getCredit();
        }
        this.majorCoreSubList.setListData(this.majorCoreSubListData);
        this.selsectedCreditLabel.setText(String.valueOf(this.coreCredit +this.majorCredit));

        this.electiveSubject=new ArrayList<>();
        for(int i=0;i<course.getElectives().size();i++) {
            boolean contain=false;
            for (int j = 0; j < course.getMajors().get(index).getMCores().size(); j++) {
                if (course.getElectives().get(i).getCode().equals(course.getMajors().get(index).getMCores().get(j).getCode())) {
                    contain=true;
                    break;
                }
            }
            if(!contain){
                this.electiveSubject.add(course.getElectives().get(i));
            }
        }

        this.electiveSubListData=new String[course.getElectives().size()];
        for(int i = 0; i< this.electiveSubject.size(); i++){
            this.electiveSubListData[i]= this.electiveSubject.get(i).toString();
        }
        this.electiveSubList.setListData(this.electiveSubListData);
    }

    private void bcscsBtnOnClick(int code){
        if(code==BCODE){
            course =stuSys.getBCourse();
            this.degreeCode=BCODE;
        }else if(code==MCODE){
            course =stuSys.getMCourse();
            this.degreeCode=MCODE;
        }

        this.majorCoreSubList.clearSelection();
        this.majorCoreSubList.setListData(new String[0]);

        this.courseLabel.setText(course.getCName());
        this.totalCreditLabel.setText(String.valueOf(course.getCCredit()));

        this.coreSubListData=new String[course.getCores().size()];
        for(int i = 0; i< course.getCores().size(); i++){
            this.coreSubListData[i]= course.getCores().get(i).toString();
        }
        this.coreSubList.setListData(this.coreSubListData);

        this.majorListData=new String[course.getMajors().size()];
        for(int i=0;i<majorListData.length;i++){
            this.majorListData[i]= course.getMajors().get(i).getMName();
        }
        this.majorList.setListData(this.majorListData);


        this.electiveSubject=(ArrayList<Subject>)course.getElectives().clone();
        this.electiveSubListData=new String[course.getElectives().size()];
        for(int i = 0; i< course.getElectives().size(); i++){
            this.electiveSubListData[i]= course.getElectives().get(i).toString();
        }
        this.electiveSubList.setListData(this.electiveSubListData);

        this.coreCredit = 0;
        this.majorCredit = 0;
        for(int i = 0; i< course.getCores().size(); i++){
            coreCredit += course.getCores().get(i).getCredit();
        }
        this.selsectedCreditLabel.setText(String.valueOf(coreCredit));
    }

    private void resetBtnOnClick(){
        courseLabel.setText("");
        totalCreditLabel.setText("");
        selsectedCreditLabel.setText("0");

        stNameTF.setText("");
        stNumTF.setText("");
        dobTF.setText("");

        coreSubList.clearSelection();
        coreSubList.setListData(new String[0]);
        majorList.clearSelection();
        majorList.setListData(new String[0]);
        majorCoreSubList.clearSelection();
        majorCoreSubList.setListData(new String[0]);
        electiveSubList.clearSelection();
        electiveSubList.setListData(new String[0]);

        genderBG.clearSelection();

        this.coreCredit = 0;
        this.majorCredit = 0;
        this.electiveCredit=0;

        JOptionPane.showMessageDialog(
                StudentEnrolmentView.this,"The system is reset.",
                "System Reset",JOptionPane.INFORMATION_MESSAGE);
    }

    private class NoSelectionModel extends DefaultListSelectionModel{
        @Override
        public void setAnchorSelectionIndex(final int anchorIndex) {}
        @Override
        public void setLeadAnchorNotificationEnabled(final boolean flag) {}
        @Override
        public void setLeadSelectionIndex(final int leadIndex) {}
        @Override
        public void setSelectionInterval(final int index0, final int index1) {}
    }
}