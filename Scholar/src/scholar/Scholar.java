package scholar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Scholar extends JFrame implements ActionListener {

    JLabel L, L1, L2, L3, L4, L5, L6, L7, L8;
    JComboBox<String> categoryComboBox;
    JRadioButton rb1, rb2;
    JCheckBox cb1, cb2;
    JTextField T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11;
    ButtonGroup BP = new ButtonGroup();
    JButton B, B2;

    public Scholar() {

        setSize(700, 700);
        setLayout(null);
        setBounds(400, 50, 600, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        B = new JButton("Submit");
        B2 = new JButton("Clear");

        Font font = new Font("Arial", Font.PLAIN, 22);

        L4 = new JLabel("______Scholarship Application Form_______");
        L = new JLabel("Student Name :-");
        T1 = new JTextField(20);
        T2 = new JTextField(20);

        L1 = new JLabel("Gender :-");
        rb1 = new JRadioButton("Male");
        rb2 = new JRadioButton("Female");
        BP.add(rb1);
        BP.add(rb2);

        L6 = new JLabel("Category:");
        String[] categories = {"General", "OBC", "SC", "ST", "EWS"};
        categoryComboBox = new JComboBox<>(categories);

        L2 = new JLabel("Email Address :-");
        T3 = new JTextField(20);

        L3 = new JLabel("Mailing Address :-");
        T4 = new JTextField(20);
        T5 = new JTextField(20);
        T6 = new JTextField("City");
        T7 = new JTextField("Region");
        T8 = new JTextField("Pin Code");
        T9 = new JTextField("Country");

        L8 = new JLabel("Family Income :-");
        T11 = new JTextField("");

        L5 = new JLabel("Your current study :-");
        T10 = new JTextField(20);

        L7 = new JLabel("Have you applied for other scholarships ?");
        cb1 = new JCheckBox("Yes");
        cb2 = new JCheckBox("No");

        B.setBounds(100, 527, 100, 30);
        B2.setBounds(220, 527, 100, 30);

        L4.setBounds(70, 30, 350, 30);
        L.setBounds(50, 80, 100, 30);
        T1.setBounds(170, 85, 180, 25);
        T2.setBounds(370, 85, 180, 25);

        L1.setBounds(50, 120, 100, 30);
        rb1.setBounds(170, 125, 60, 25);
        rb2.setBounds(270, 125, 80, 25);

        L6.setBounds(50, 160, 100, 30);
        categoryComboBox.setBounds(170, 165, 180, 25);

        L2.setBounds(50, 200, 150, 30);
        T3.setBounds(170, 205, 350, 25);

        L3.setBounds(50, 240, 150, 30);
        T4.setBounds(170, 245, 350, 25);
        T5.setBounds(170, 280, 350, 25);
        T6.setBounds(170, 315, 180, 25);
        T7.setBounds(370, 315, 150, 25);
        T8.setBounds(170, 350, 180, 25);
        T9.setBounds(370, 350, 150, 25);

        L8.setBounds(50, 390, 150, 30);
        T11.setBounds(170, 395, 180, 25);

        L5.setBounds(50, 430, 150, 30);
        T10.setBounds(170, 435, 350, 25);

        L7.setBounds(50, 470, 300, 30);
        cb1.setBounds(170, 495, 50, 25);
        cb2.setBounds(230, 495, 50, 25);

        add(L4);
        add(L);
        add(T1);
        add(T2);
        add(L1);
        add(rb1);
        add(rb2);
        add(L6);
        add(categoryComboBox);
        add(L2);
        add(T3);
        add(L3);
        add(T4);
        add(T5);
        add(T6);
        add(T7);
        add(T8);
        add(T9);
        add(L8);
        add(T11);
        add(L5);
        add(T10);
        add(L7);
        add(cb1);
        add(cb2);
        add(B);
        add(B2);

        B.addActionListener(this);
        B2.addActionListener(this);
        getContentPane().setBackground(new Color(255, 239, 213));
        setFontColor(Color.BLACK); // Font color in cream

        setVisible(true);
    }

    private void setFontColor(Color color) {
        // Set font color for labels
        L.setForeground(color);
        L1.setForeground(color);
        L2.setForeground(color);
        L3.setForeground(color);
        L4.setForeground(color);
        L5.setForeground(color);
        L6.setForeground(color);
        L7.setForeground(color);
        L8.setForeground(color);

        // Set font color for text fields
        T1.setForeground(color);
        T2.setForeground(color);
        T3.setForeground(color);
        T4.setForeground(color);
        T5.setForeground(color);
        T6.setForeground(color);
        T7.setForeground(color);
        T8.setForeground(color);
        T9.setForeground(color);
        T10.setForeground(color);
        T11.setForeground(color);

        // Set font color for radio buttons
        rb1.setForeground(color);
        rb2.setForeground(color);

        // Set font color for buttons
        B.setForeground(color);
        B2.setForeground(color);
    }

    public void actionPerformed(ActionEvent ae) {
        String S = ae.getActionCommand();
        if (S.equals("Submit")) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student_info", "root", "");
                String FName = T1.getText();
                String LName = T2.getText();
                String Gender ="";
                if(rb1.isSelected())
                {
                 Gender = "Male";   
                }
                else if(rb2.isSelected())
                {
                 Gender = "Female";   
                }
                String Category = (String) categoryComboBox.getSelectedItem();
                String Email = T3.getText();
                String SAddress1 = T4.getText();
                String SAddress2 = T5.getText();
                String City = T6.getText();
                String Region = T7.getText();
                String PinCode = T8.getText();
                String Country = T9.getText();
                String Study = T10.getText();
                String FamilyIncome = T11.getText();

                String appliedScholarship = cb1.isSelected() ? "Yes" : "No";
                String message = "Student Name: " + FName + " " + LName + "\n" +
                        "Gender: " + Gender + "\n" +
                        "Category: " + Category + "\n" +
                        "Email: " + Email + "\n" +
                        "Mailing Address: " + SAddress1 + ", " + SAddress2 + ", " + City + ", " + Region + ", " + PinCode + ", " + Country + "\n" +
                        "Current Study: " + Study + "\n" +
                        "Family Income: " + FamilyIncome + "\n" +
                        "Applied for other scholarships: " + appliedScholarship;

                JOptionPane.showMessageDialog(this, message, "Submission Successful", JOptionPane.INFORMATION_MESSAGE);

                String query = "INSERT INTO `scholar`(`Fname`, `Lname`, `Gender`, `Category`, `Email`, `Address1`, `Address`, `City`, `Region`, `Pin`, `Country`, `Income`, `year`, `applied`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, FName);
                pst.setString(2, LName);
                pst.setString(3, Gender);
                pst.setString(4, Category);
                pst.setString(5, Email);
                pst.setString(6, SAddress1);
                pst.setString(7, SAddress2);
                pst.setString(8, City);
                pst.setString(9, Region);
                pst.setString(10, PinCode);
                pst.setString(11, Country);
                pst.setString(12, Study);
                pst.setString(13, FamilyIncome);
                pst.setString(14, appliedScholarship);

                pst.executeUpdate(); // Use executeUpdate() for INSERT operations
                pst.close();
                con.close();

                
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (S.equals("Clear")) {
            clearForm();
        }
    }

    private void clearForm() {
        T1.setText("First");
        T2.setText("Last");
        T3.setText("Email ");
        T4.setText("Street Address ");
        T5.setText("Street Address line 2");
        T6.setText("City");
        T7.setText("Region");
        T8.setText("Pin Code");
        T9.setText("Country");
        T10.setText("");
        T11.setText("");

        BP.clearSelection();
        categoryComboBox.setSelectedIndex(0);
        cb1.setSelected(false);
        cb2.setSelected(false);
    }

    private String getSelectedButtonText(ButtonGroup buttonGroup) {
        ButtonModel selectedButton = buttonGroup.getSelection();
        if (selectedButton != null) {
            return selectedButton.getActionCommand();
        }
        return null;
    }

    public static void main(String args[]) {
        new Scholar();
    }
}
