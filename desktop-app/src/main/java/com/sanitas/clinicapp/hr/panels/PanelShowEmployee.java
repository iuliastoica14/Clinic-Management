package com.sanitas.clinicapp.hr.panels;

import com.sanitas.clinicapp.hr.Employee;
import com.sanitas.clinicapp.hr.HrModel;
import com.sanitas.clinicapp.mr.MrModel;
import com.sanitas.clinicapp.mr.Patient;
import com.sanitas.clinicapp.ui.Colors;
import com.sanitas.clinicapp.ui.StyledJButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelShowEmployee extends JPanel{
    private JTextField TxtFirst = new JTextField(10);
    private JTextField TxtLast = new JTextField(10);
    private JTextField TxtPosition = new JTextField(10);


    private JButton btnSearch = new StyledJButton("Cauta").getButton();
    private JButton btnModify = new StyledJButton("Editeaza").getButton();
    private JButton btnDelete = new StyledJButton("Sterge").getButton();

    private JTable employeeTable;

    public PanelShowEmployee(HrModel model) {
        super(new BorderLayout());

        btnSearch.setBackground(Colors.MAIN_COLOR.getColor());

        employeeTable = initializeTable(model);

        JScrollPane jScrollPane = new JScrollPane(employeeTable);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setPreferredSize(new Dimension(540, 240));
        JPanel tablePanel = new JPanel(new FlowLayout());
        tablePanel.add(jScrollPane);

        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.add(new JLabel("Nume:"));
        searchPanel.add(TxtLast);
        searchPanel.add(new JLabel("Prenume:"));
        searchPanel.add(TxtFirst);
        searchPanel.add(new JLabel("Position: "));
        searchPanel.add(TxtPosition);
        searchPanel.add(btnSearch);

        JPanel editPanel = new JPanel(new FlowLayout());
        editPanel.add(btnModify);
        editPanel.add(btnDelete);

        add(searchPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
        add(editPanel, BorderLayout.SOUTH);

        setVisible(false);
    }

    private JTable initializeTable(HrModel model) {
        String[] columns = { "Nume", "Prenume","Functie","CNP" };
        java.util.List<Employee> employees = model.getAllData("", "","");

        Object[][] employeesData = new Object[employees.size()][columns.length];
        for (int i = 0; i < employees.size(); ++i) {
            Employee employee = employees.get(i);

            employeesData[i][0] = employee.getLastname();
            employeesData[i][1] = employee.getFirstname();
            employeesData[i][2] = employee.getPosition();
            employeesData[i][3] = employee.getCnp();
        }

        JTable table = new JTable();
        table.setModel(new DefaultTableModel(employeesData, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);

        return table;
    }

    public void updateTable(List<Employee> employee) {
        String[] columns = { "Nume", "Prenume", "Functie","CNP" };

        Object[][] employeeData = new Object[employee.size()][columns.length];
        for (int i = 0; i < employee.size(); ++i) {
            Employee employee1 = employee.get(i);

            employeeData[i][0] = employee1.getLastname();
            employeeData[i][1] = employee1.getFirstname();
            employeeData[i][2] = employee1.getPosition();
            employeeData[i][3] = employee1.getCnp();
        }

        employeeTable.setModel(new DefaultTableModel(employeeData, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }

    public JTextField getTxtFirst() {
        return TxtFirst;
    }

    public JTextField getTxtLast() {
        return TxtLast;
    }

    public JTextField getTxtPosition() {
        return TxtPosition;
    }

    public JTable getJTable() {
        return employeeTable;
    }

    public void addSearchButtonListener(ActionListener actionListener) {
        btnSearch.addActionListener(actionListener);
    }

    public void addModifyButtonListener(ActionListener actionListener) {
        btnModify.addActionListener(actionListener);
    }

    public void addDeleteButtonListener(ActionListener actionListener) {
        btnDelete.addActionListener(actionListener);
    }

}