import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Employee {

    // Data Members
    private int id;
    private String name;
    private double salary;

    // Constructor
    public Employee(int id, String name, double salary) {

        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Calculate Yearly Salary
    public double calculateYearlySalary() {

        return salary * 12;
    }

    // Calculate Bonus
    public double calculateBonus() {

        return calculateYearlySalary() * 0.10;
    }

    // Display Employee Details
    public String displayEmployee() {

        return "===== EMPLOYEE DETAILS =====\n\n" +
                "Employee ID      : " + id + "\n" +
                "Employee Name    : " + name + "\n" +
                "Monthly Salary   : ₹" + salary + "\n" +
                "Yearly Salary    : ₹" +
                calculateYearlySalary() + "\n" +
                "Bonus (10%)      : ₹" +
                calculateBonus();
    }
}

class EmployeePayrollGUI extends JFrame
        implements ActionListener {

    JLabel titleLabel, idLabel,
            nameLabel, salaryLabel;

    JTextField idField,
            nameField,
            salaryField;

    JButton createButton,
            yearlyButton,
            bonusButton,
            displayButton;

    JTextArea resultArea;

    Employee emp;

    public EmployeePayrollGUI() {

        // Frame Settings
        setTitle("Employee Payroll System");
        setSize(650, 650);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(
                new Color(240, 248, 255));

        // Heading
        titleLabel = new JLabel(
                "EMPLOYEE PAYROLL SYSTEM");

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 26));

        titleLabel.setBounds(120, 20, 400, 40);

        add(titleLabel);

        // Employee ID
        idLabel = new JLabel("Employee ID:");

        idLabel.setFont(
                new Font("Arial", Font.PLAIN, 18));

        idLabel.setBounds(60, 100, 150, 30);

        add(idLabel);

        idField = new JTextField();

        idField.setBounds(250, 100, 250, 35);

        add(idField);

        // Employee Name
        nameLabel = new JLabel("Employee Name:");

        nameLabel.setFont(
                new Font("Arial", Font.PLAIN, 18));

        nameLabel.setBounds(60, 160, 170, 30);

        add(nameLabel);

        nameField = new JTextField();

        nameField.setBounds(250, 160, 250, 35);

        add(nameField);

        // Salary
        salaryLabel = new JLabel("Monthly Salary:");

        salaryLabel.setFont(
                new Font("Arial", Font.PLAIN, 18));

        salaryLabel.setBounds(60, 220, 170, 30);

        add(salaryLabel);

        salaryField = new JTextField();

        salaryField.setBounds(250, 220, 250, 35);

        add(salaryField);

        // Create Button
        createButton = new JButton("Create Employee");

        createButton.setFont(
                new Font("Arial", Font.BOLD, 16));

        createButton.setBounds(180, 290, 220, 45);

        createButton.addActionListener(this);

        add(createButton);

        // Yearly Salary Button
        yearlyButton = new JButton("Yearly Salary");

        yearlyButton.setFont(
                new Font("Arial", Font.BOLD, 15));

        yearlyButton.setBounds(50, 370, 170, 45);

        yearlyButton.addActionListener(this);

        add(yearlyButton);

        // Bonus Button
        bonusButton = new JButton("Calculate Bonus");

        bonusButton.setFont(
                new Font("Arial", Font.BOLD, 15));

        bonusButton.setBounds(240, 370, 180, 45);

        bonusButton.addActionListener(this);

        add(bonusButton);

        // Display Button
        displayButton = new JButton("Display Details");

        displayButton.setFont(
                new Font("Arial", Font.BOLD, 15));

        displayButton.setBounds(440, 370, 160, 45);

        displayButton.addActionListener(this);

        add(displayButton);

        resultArea = new JTextArea();

        resultArea.setBounds(60, 450, 520, 120);

        resultArea.setFont(
                new Font("Monospaced", Font.BOLD, 16));

        resultArea.setEditable(false);

        add(resultArea);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == createButton) {

                int id =
                        Integer.parseInt(idField.getText());

                String name =
                        nameField.getText();

                double salary =
                        Double.parseDouble(
                                salaryField.getText());

                emp = new Employee(id, name, salary);

                resultArea.setText(
                        "Employee Created Successfully!");
            }

            else if (e.getSource() == yearlyButton) {

                if (emp != null) {

                    resultArea.setText(
                            "Yearly Salary : ₹" +
                            emp.calculateYearlySalary());

                } else {

                    resultArea.setText(
                            "Please Create Employee First!");
                }
            }

            else if (e.getSource() == bonusButton) {

                if (emp != null) {

                    resultArea.setText(
                            "Employee Bonus : ₹" +
                            emp.calculateBonus());

                } else {

                    resultArea.setText(
                            "Please Create Employee First!");
                }
            }

            else if (e.getSource() == displayButton) {

                if (emp != null) {

                    resultArea.setText(
                            emp.displayEmployee());

                } else {

                    resultArea.setText(
                            "Please Create Employee First!");
                }
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    "Please Enter Valid Details!");
        }
    }

    public static void main(String[] args) {

        new EmployeePayrollGUI();
    }
}