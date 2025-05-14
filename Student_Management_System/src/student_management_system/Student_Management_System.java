package student_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

class Student extends JFrame implements ActionListener {

    JLabel l,l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;

    JButton B1, B2, B3, B4, B5;

    void Data() {
        setLayout(null);
        setSize(500,700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        l = new JLabel("Fill the Details Below:-");
        l1 = new JLabel("Enter Name:");
        l2 = new JLabel("Enter Roll number:");
        l3 = new JLabel("Enter Grade:");
        l4 = new JLabel("Enter Age:");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();

        B1 = new JButton("ADD Student");
        B2 = new JButton("Remove Student");
        B3 = new JButton("Search Student");
        B4 = new JButton("Display Student");
        B5 = new JButton("Clear");

        
        l1.setBounds(20, 20, 100, 20);
        t1.setBounds(130, 20, 150, 20);

        l2.setBounds(20, 60, 120, 20);
        t2.setBounds(150, 60, 150, 20);

        l3.setBounds(20, 100, 100, 20);
        t3.setBounds(130, 100, 150, 20);

        l4.setBounds(20, 140, 100, 20);
        t4.setBounds(130, 140, 150, 20);

        B1.setBounds(20, 180, 120, 30);
        B2.setBounds(150, 180, 140, 30);
        B3.setBounds(300, 180, 140, 30);
        B4.setBounds(20, 230, 140, 30);
        B5.setBounds(180, 230, 140, 30);

        add(l);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(B1);
        add(B2);
        add(B3);
        add(B4);
        add(B5);

        B1.addActionListener(this);
        B2.addActionListener(this);
        B3.addActionListener(this);
        B4.addActionListener(this);
        B5.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
   
    }
}

class Student_Management_System extends Student {
    Connection con; // Declare Connection here so it's accessible throughout the class

    Student_Management_System() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");
        } catch (Exception E) {
            System.out.println(E);
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/student_info", "root", "");
            System.out.println("Connected Successfully!!");
        } catch (Exception E) {
            System.out.println(E);
        }
    }

    void add_Student() 
    {
        try {
            String name = t1.getText();
            String roll_no = t2.getText();
            String Grade = t3.getText();
            String age = t4.getText();

            String query = "INSERT INTO `intern_java`(`name`, `roll_no`, `Grade`, `Age`) VALUES (?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, roll_no);
            pst.setString(3, Grade); // Fix the index from 1 to 3
            pst.setString(4, age);   // Fix the index from 1 to 4

            pst.executeUpdate();
            pst.close();


            String msg = "Name :" + name + "\n Roll No :" + roll_no + "\nGrade :" + Grade + "\nAge :" + age;
            JOptionPane.showMessageDialog(this, msg);

        } catch (Exception E) {
            System.out.println(E);
        }
    }
    
    void remove_Student()
    {
     try
     {
         String rollno_Delete = JOptionPane.showInputDialog(this, "Enter Roll No to Delete:");
         
         String query = "DELETE FROM `intern_java` WHERE `roll_no`=?";
         
         PreparedStatement pst = con.prepareStatement(query);
         pst.setString(1, rollno_Delete);
         
        int rows = pst.executeUpdate();
            pst.close();
           
            
         if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Student with Roll No " + rollno_Delete + " removed successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "No student found with Roll No " + rollno_Delete);
            }
     }
     catch(Exception E)
     {
      System.out.println(E);   
     }
        
    }
    
  void display_Student() 
  {
        try {
            String query = "SELECT * FROM `intern_java`";

            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            String[] columnNames = {"Name", "Roll No", "Grade", "Age"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

            while (rs.next()) {
                String name = rs.getString("name");
                String rollno = rs.getString("roll_no");
                String Grade = rs.getString("Grade");
                String Age = rs.getString("Age");

                Object[] rowData = {name, rollno, Grade, Age};
                model.addRow(rowData);
            }

            JTable table = new JTable(model);
            JOptionPane.showMessageDialog(this, new JScrollPane(table));

        } catch (Exception E) {
            System.out.println(E);
        }
    }
  
void search_Student() {
    try {
        String rollno_Search = JOptionPane.showInputDialog(this, "Enter Roll No to Search:");

        String query = "SELECT * FROM `intern_java` WHERE `roll_no`=?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, rollno_Search);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String name = rs.getString("name");
            String rollno = rs.getString("roll_no");
            String Grade = rs.getString("Grade");
            String Age = rs.getString("Age");

            String resultMsg = "Name: " + name + "\nRoll No: " + rollno + "\nGrade: " + Grade + "\nAge: " + Age;
            JOptionPane.showMessageDialog(this, resultMsg);
        } else {
            JOptionPane.showMessageDialog(this, "No student found with Roll No " + rollno_Search);
        }

        pst.close();
    } catch (Exception E) {
        System.out.println(E);
    }
}

     public void actionPerformed(ActionEvent e)
    {
        String S = e.getActionCommand();
        if(S.equals("ADD Student"))
        {
         add_Student();    
        }
        else if(S.equals("Remove Student"))
        {
         remove_Student();   
        }
        else if(S.equals("Display Student"))
        {
         display_Student();   
        }
        else if(S.equals("Search Student"))
        {
         search_Student();   
        }
        else if(S.equals("Clear"))
        {
         t1.setText(" ");         
         t2.setText(" ");   
         t3.setText(" ");   
         t4.setText(" ");   
   
        }
    }
    
    public static void main(String[] args) {
        Student_Management_System S = new Student_Management_System();
        S.Data();
    }
}