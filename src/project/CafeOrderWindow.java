package project;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.InputMismatchException;
import java.util.List;

public class CafeOrderWindow extends JFrame{
    private CafeShop cafeShop;
    private JTextField customerNameTF;
    private JTextField tableIDTF;
    private JTextField quantityTF;
    private JList<String> categoryList;
    private JList<Food> itemList;
//    private JScrollPane itemListScrollPane;
    private JTextArea descriptionTA;
    private JTextArea orderTA;
    private JButton addBTN;
    private JButton submitBTN;
    private JButton resetBTN;

    public static void main(String[] args) {
        CafeShop cafeShop=new CafeShop();
    }

    public CafeOrderWindow(CafeShop cafeShop) {
        this.cafeShop=cafeShop;
        this.initGUI();
        this.initEventHandler();
    }

    private void initGUI(){
        this.setLayout(new BorderLayout());
        this.setTitle("Cafe Order System");
        this.setSize(900,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel northPanel=new JPanel();
        northPanel.setLayout(new FlowLayout());

        northPanel.add(new JLabel("Customer Name: "));
        customerNameTF=new JTextField(16);
        northPanel.add(customerNameTF);
        northPanel.add(new JLabel("Table ID: "));
        tableIDTF=new JTextField(16);
        northPanel.add(tableIDTF);

        JPanel centerPanel=new JPanel();
        centerPanel.setLayout(new FlowLayout());
//        centerPanel.setLayout(new GridLayout(2,1));
//        JPanel gridUpPanel=new JPanel();
//        gridUpPanel.setLayout(new FlowLayout());
//        centerPanel.add(gridUpPanel);
//        JPanel gridDownPanel=new JPanel();
//        centerPanel.add(gridDownPanel);

        JPanel tempPanel;

//        categoryList=new JList<>(new String[]{"Pizza","Burgers","Sides"});
        categoryList=new JList<>(cafeShop.getFoodCategoryMap().keySet().toArray(new String[]{}));
        categoryList.setFixedCellWidth(180);
        categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tempPanel=new JPanel();
        tempPanel.add(categoryList);
        JPanel categoryPanel=new TitlePanel(new JLabel("Category:"),tempPanel);
        centerPanel.add(categoryPanel);

        itemList=new JList<>(new Food[]{});
//        itemList.setFixedCellWidth(180);
        itemList.setVisibleRowCount(7);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        tempPanel=new JPanel();
//        itemListScrollPane=new JScrollPane(itemList);
//        tempPanel.add(itemListScrollPane);
        JPanel itemPanel=new TitlePanel(new JLabel("Item:"),new JScrollPane(itemList));
        centerPanel.add(itemPanel);

        descriptionTA=new JTextArea();
        descriptionTA.setColumns(15);
        descriptionTA.setRows(7);
        descriptionTA.setEditable(false);
        tempPanel=new JPanel();
        tempPanel.add(descriptionTA);
        JPanel descriptionPanel=new TitlePanel(new JLabel("Description:"),tempPanel);
        centerPanel.add(descriptionPanel);

        quantityTF=new JTextField(7);
        addBTN=new JButton("Add");
        tempPanel=new JPanel();
        tempPanel.setLayout(new FlowLayout());
        tempPanel.add(new JLabel("Quantity:     "));
        tempPanel.add(quantityTF);
        tempPanel.add(addBTN);
        JPanel quantityPanel=new TitlePanel(new JLabel(""),tempPanel);
        centerPanel.add(quantityPanel);

        orderTA=new JTextArea();
        orderTA.setColumns(72);
        orderTA.setRows(20);
        orderTA.setEditable(false);
        tempPanel=new JPanel();
        tempPanel.add(orderTA);
        JPanel orderPanel=new TitlePanel(new JLabel("Order:"),tempPanel);
        centerPanel.add(orderPanel);

        JPanel southPanel=new JPanel();
        southPanel.setLayout(new FlowLayout());
        submitBTN=new JButton("Submit");
        southPanel.add(submitBTN);
        resetBTN=new JButton("Reset");
        southPanel.add(resetBTN);

        this.add(northPanel,BorderLayout.NORTH);
        this.add(centerPanel,BorderLayout.CENTER);
        this.add(southPanel,BorderLayout.SOUTH);

        this.setVisible(true);
    }

    private void initEventHandler(){
        this.categoryList.addListSelectionListener(this::selectCategory);

        this.itemList.addListSelectionListener(this::selectFood);

        this.addBTN.addActionListener(this::addNewItem);

        this.resetBTN.addActionListener(this::resetAll);

        this.submitBTN.addActionListener(this::saveOrder);
    }

    private void resetAll(ActionEvent e) {
        this.categoryList.clearSelection();
        this.itemList.clearSelection();
        this.itemList.setListData(new Food[]{});
        this.descriptionTA.setText("");
        this.orderTA.setText("");
        this.customerNameTF.setText("");
        this.tableIDTF.setText("");
        this.quantityTF.setText("");
    }

    private void saveOrder(ActionEvent e) {
        try{
            String customerName = this.customerNameTF.getText();
            int tableID = Integer.parseInt(this.tableIDTF.getText());
            cafeShop.saveOrder(customerName, tableID);
            resetAll(e);
            JOptionPane.showMessageDialog(
                    CafeOrderWindow.this,"The customer's order is saved.",
                    "Save Order",JOptionPane.INFORMATION_MESSAGE);
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(
                    CafeOrderWindow.this,ex,
                    "Validation Checking",JOptionPane.ERROR_MESSAGE);
        }catch (InputMismatchException ex){
            JOptionPane.showMessageDialog(
                    CafeOrderWindow.this,ex,
                    "Validation Checking",JOptionPane.ERROR_MESSAGE);
        }

    }

    private void addNewItem(ActionEvent e) {
        try{
            if(itemList.getSelectedValue() == null)
                throw new InputMismatchException("Please select one food.");
            if(categoryList.getSelectedValue()==null)
                throw new InputMismatchException("Please select one category.");

            int quantity = Integer.parseInt(this.quantityTF.getText());
            cafeShop.addFood(itemList.getSelectedValue(), quantity);
            this.orderTA.setText(cafeShop.getOrder().toString());
            this.quantityTF.setText("");
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(
                    CafeOrderWindow.this,ex,
                    "Validation Checking",JOptionPane.ERROR_MESSAGE);
        }catch (InputMismatchException ex){
            JOptionPane.showMessageDialog(
                    CafeOrderWindow.this,ex,
                    "Validation Checking",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void selectCategory(ListSelectionEvent e) {
        if(categoryList.getSelectedValue()==null){
            return;
        }
        this.descriptionTA.setText("");
        this.itemList.clearSelection();
        List<Food> list = cafeShop.getFoodListByCategory(categoryList.getSelectedValue());
        this.itemList.setListData(list.toArray(new Food[]{}));
    }

    private void selectFood(ListSelectionEvent e) {
        if (itemList.getSelectedValue() == null) {
            return;
        }
        this.descriptionTA.setText(itemList.getSelectedValue().getDest());
    }
}
