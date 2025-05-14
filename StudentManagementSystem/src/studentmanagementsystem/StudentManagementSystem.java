package studentmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


     class Student extends JFrame implements ActionListener {
    public JLabel L, L1, L2, L3, L4, L5, L6;
    public JTextField T1, T2, T3, T4;
    public JTextArea ta1;
    public JRadioButton rb1, rb2;
    public JButton B1, B2, B3, B4;
    public JFrame frame;
    public ButtonGroup bg = new ButtonGroup();

    

    public Student() {
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 100, 400, 400);

        L = new JLabel("STUDENT MANAGEMENT SYSTEM");
        L.setBounds(100, 10, 300, 20);

        L1 = new JLabel("Name :-");
        L1.setBounds(30, 40, 80, 20);
        T1 = new JTextField();
        T1.setBounds(180, 40, 150, 20);

        L2 = new JLabel("Roll Number :-");
        L2.setBounds(30, 70, 80, 20);
        T2 = new JTextField();
        T2.setBounds(180, 70, 150, 20);

        L3 = new JLabel("Age :- ");
        L3.setBounds(30, 100, 80, 20);
        T3 = new JTextField();
        T3.setBounds(180, 100, 150, 20);

        L4 = new JLabel("Gender :- ");
        L4.setBounds(30, 130, 80, 20);
        rb1 = new JRadioButton("MALE");
        rb1.setBounds(180, 130, 80, 20);
        rb2 = new JRadioButton("FEMALE");
        rb2.setBounds(260, 130, 80, 20);

        bg.add(rb1);
        bg.add(rb2);

        L5 = new JLabel("Grade :- ");
        L5.setBounds(30, 160, 80, 20);
        T4 = new JTextField();
        T4.setBounds(180, 160, 150, 20);

        L6 = new JLabel("ADDRESS :- ");
        L6.setBounds(30, 190, 80, 20);
        ta1 = new JTextArea();
        ta1.setBounds(180, 190, 150, 50);

        B1 = new JButton("ADD STUDENT");
        B1.setBounds(50, 270, 120, 30);
        B1.addActionListener(this);

        B2 = new JButton("REMOVE STUDENT");
        B2.setBounds(180, 270, 140, 30);
        B2.addActionListener(this);

        B3 = new JButton("SEARCH STUDENT");
        B3.setBounds(50, 310, 120, 30);
        B3.addActionListener(this);

        B4 = new JButton("DISPLAY STUDENT");
        B4.setBounds(180, 310, 140, 30);
        B4.addActionListener(this);

        add(L);
        add(L1);
        add(T1);
        add(L2);
        add(T2);
        add(L3);
        add(T3);
        add(L4);
        add(rb1);
        add(rb2);
        add(L5);
        add(T4);
        add(L6);
        add(ta1);
        add(B1);
        add(B2);
        add(B3);
        add(B4);
        getContentPane().setBackground(new Color(230, 230, 250));
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        // Implement action handling for buttons
    }
}
    

 class StudentManagementSystem extends Student {
    private Connection conn;

    StudentManagementSystem() {
        super();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/bhavesh", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String action = e.getActionCommand();
            if (action.equals("ADD STUDENT")) {
                Add();
            } else if (action.equals("REMOVE STUDENT")) {
                Remove();
            } else if (action.equals("SEARCH STUDENT")) {
                Search();
            } else if (action.equals("DISPLAY STUDENT")) {
                Display();
            }

            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void Add() {
        try {
            String Name = T1.getText();
            String RN = T2.getText();
            int Roll_No = Integer.parseInt(RN);
            String A = T3.getText();
            int Age = Integer.parseInt(A);
            String Gender = "";

            if (rb1.isSelected()) {
                Gender = "Male";
            }
            if (rb2.isSelected()) {
                Gender = "Female";
            }
            String Grade = T4.getText();
            String Address = ta1.getText();

            if (Name.isEmpty() || RN.isEmpty() || A.isEmpty() || Gender.isEmpty()
                    || Grade.isEmpty() || Address.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "!!!___ Input Field cannot be empty, please check all the fields are filled or not ___!!!");
            } else {
                PreparedStatement pst = conn.prepareStatement("INSERT INTO stud_record VALUES (?, ?, ?, ?, ?, ?)");
                pst.setString(1, Name);
                pst.setInt(2, Roll_No);
                pst.setInt(3, Age);
                pst.setString(4, Gender);
                pst.setString(5, Grade);
                pst.setString(6, Address);
                pst.executeUpdate();
                pst.close();

                JOptionPane.showMessageDialog(frame, "!_____ Particular Student Record has been Added Successfully _____!");
                T1.setText("");
                T2.setText("");
                T3.setText("");
                T4.setText("");
                ta1.setText("");
                bg.clearSelection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void Remove() {
        try {
            String no = JOptionPane.showInputDialog(frame, "Enter Roll Number :- ");

            try {
                int r1 = Integer.parseInt(no);
                PreparedStatement pst = conn.prepareStatement("Delete from stud_record where Roll_No =?");
                pst.setInt(1, r1);

                int rowsAffected = pst.executeUpdate();
                pst.close();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(frame, "!_____ Particular Student Record has been Removed _____!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Student with Roll Number " + r1 + " does not Exist.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    T2.setText("");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please Enter a valid Roll Number.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void Search() {
        try {
            T1.setText("");
            T3.setText("");
            T4.setText("");
            ta1.setText("");
            bg.clearSelection();

            String no = JOptionPane.showInputDialog(frame, "Enter Roll Number :- ");

            try {
                int r1 = Integer.parseInt(no);
                PreparedStatement pst = conn.prepareStatement("Select * from stud_record where Roll_No =?");
                pst.setInt(1, r1);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    T1.setText(rs.getString("Name"));
                    T2.setText(String.valueOf(rs.getInt("Roll_No")));
                    T3.setText(String.valueOf(rs.getInt("Age")));
                    String gender = rs.getString("Gender");
                    if (gender.equals("Male")) {
                        rb1.setSelected(true);
                    } else if (gender.equals("Female")) {
                        rb2.setSelected(true);
                    }
                    T4.setText(rs.getString("Grade"));
                    ta1.setText(rs.getString("Address"));
                } else {
                    JOptionPane.showMessageDialog(frame, "Student with Roll Number " + r1 + " does not Exist.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    T2.setText("");
                }

                pst.close();
                rs.close();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please Enter a valid Roll Number.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void Display() {
        try {
            T1.setText("");
            T2.setText("");
            T3.setText("");
            T4.setText("");
            ta1.setText("");
            bg.clearSelection();

            PreparedStatement pst = conn.prepareStatement("Select * from stud_record");
            ResultSet rs = pst.executeQuery();

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            while (rs.next()) {
                textArea.append("Name: " + rs.getString("Name") + "\n");
                textArea.append("Roll Number: " + rs.getInt("Roll_No") + "\n");
                textArea.append("Age: " + rs.getInt("Age") + "\n");
                textArea.append("Gender: " + rs.getString("Gender") + "\n");
                textArea.append("Grade: " + rs.getString("Grade") + "\n");
                textArea.append("Address: " + rs.getString("Address") + "\n\n");
            }

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(frame, scrollPane, "Student Records", JOptionPane.PLAIN_MESSAGE);

            pst.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 
public static void main(String[] args) {
        StudentManagementSystem obj = new StudentManagementSystem();
    }
        }