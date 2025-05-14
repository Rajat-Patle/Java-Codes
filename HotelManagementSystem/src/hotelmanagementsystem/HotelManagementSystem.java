package hotelmanagementsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class HotelManagementSystem extends JFrame {
    private JTextField roomNoField, proofIdField, nameField, checkInField, checkOutField;
    private JButton addButton, searchButton;
    private JTextArea resultArea;

    public HotelManagementSystem() {
        super("Hotel Management System");

        roomNoField = new JTextField(10);
        proofIdField = new JTextField(10);
        nameField = new JTextField(20);
        checkInField = new JTextField(10);
        checkOutField = new JTextField(10);

        addButton = new JButton("Add Guest");
        searchButton = new JButton("Search");

        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new JLabel("Room No:"));
        add(roomNoField);

        add(new JLabel("Proof ID:"));
        add(proofIdField);

        add(new JLabel("Name:"));
        add(nameField);

        add(new JLabel("Check-in Date:"));
        add(checkInField);

        add(new JLabel("Check-out Date:"));
        add(checkOutField);

        add(addButton);
        add(searchButton);

        add(new JScrollPane(resultArea));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addGuest();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchGuest();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addGuest() {
        String roomNo = roomNoField.getText();
        String proofId = proofIdField.getText();
        String name = nameField.getText();
        String checkInDate = checkInField.getText();
        String checkOutDate = checkOutField.getText();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/guests", "root", "")) {
            String query = "INSERT INTO `guests`(`room_no`, `proof_id`, `name`, `check_in`, `check_out`) VALUES (?, ?, ?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, roomNo);
                preparedStatement.setString(2, proofId);
                preparedStatement.setString(3, name);
                preparedStatement.setString(4, checkInDate);
                preparedStatement.setString(5, checkOutDate);

                int rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Guest added successfully!");
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to add guest.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void searchGuest() {
        String roomNo = roomNoField.getText();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/guests", "root", "")) {
            String query = "SELECT * FROM guests WHERE room_no = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, roomNo);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String result = "Room No: " + resultSet.getString("room_no") +
                            "\nProof ID: " + resultSet.getString("proof_id") +
                            "\nName: " + resultSet.getString("name") +
                            "\nCheck-in Date: " + resultSet.getString("check_in") +
                            "\nCheck-out Date: " + resultSet.getString("check_out");

                    resultArea.setText(result);
                } else {
                    JOptionPane.showMessageDialog(this, "Guest not found.");
                    resultArea.setText("");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void clearFields() {
        roomNoField.setText("");
        proofIdField.setText("");
        nameField.setText("");
        checkInField.setText("");
        checkOutField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HotelManagementSystem();
            }
        });
    }
}