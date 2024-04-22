package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import model.ModelEmployee;
import controller.ControllerEmployee;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewEmployee extends JFrame {
	private List<ModelEmployee> modelEmployeeList;
    private DefaultTableModel model;
	int selectIndex;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textID;
	private JTextField textName;
	private JTextField textAge;
	private JTextField textDepartment;
	private JTextField textCode;
	private JTextField textSalaryRate;
	private JTable table_employee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEmployee frame = new ViewEmployee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewEmployee() {
		setTitle("employee manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE MANAGER ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(166, 11, 243, 55);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 60, 570, 114);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(27, 11, 36, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(27, 41, 36, 20);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Age:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1.setBounds(27, 72, 36, 20);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Department:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_2.setBounds(295, 11, 78, 20);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Code:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_3.setBounds(295, 41, 36, 20);
		panel.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Salary rate:");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_4.setBounds(295, 72, 78, 20);
		panel.add(lblNewLabel_1_1_4);
		
		textID = new JTextField();
		textID.setBounds(83, 11, 164, 20);
		panel.add(textID);
		textID.setColumns(10);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(83, 41, 164, 20);
		panel.add(textName);
		
		textAge = new JTextField();
		textAge.setColumns(10);
		textAge.setBounds(83, 72, 164, 20);
		panel.add(textAge);
		
		textDepartment = new JTextField();
		textDepartment.setColumns(10);
		textDepartment.setBounds(379, 11, 164, 20);
		panel.add(textDepartment);
		
		textCode = new JTextField();
		textCode.setColumns(10);
		textCode.setBounds(379, 41, 164, 20);
		panel.add(textCode);
		
		textSalaryRate = new JTextField();
		textSalaryRate.setColumns(10);
		textSalaryRate.setBounds(379, 72, 164, 20);
		panel.add(textSalaryRate);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.setBounds(10, 346, 77, 23);
		contentPane.add(btnAdd);
		
		JButton btnDel = new JButton("DEL");
		btnDel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDel.setBounds(503, 346, 77, 23);
		contentPane.add(btnDel);
		
		btnDel.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btnDel();
		    }
		});
		
		table_employee = new JTable();
        table_employee.setBounds(10, 185, 570, 150);
        contentPane.add(table_employee);

        model = new DefaultTableModel(
            new Object[][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
            },
            new String[] {
                "ID", "Name", "Age", "Department", "Code", "Salary rate"
            }
        );
        table_employee.setModel(model);

        showTable();
	}
	private void showTable() {
        modelEmployeeList = new ControllerEmployee().getListEmployee();
        model.setRowCount(0);
        for (ModelEmployee e : modelEmployeeList) {
            model.addRow(new Object[] { e.getID(), e.getName(), e.getAge(),
                    e.getDepartment(), e.getCode(), e.getSalaryRate() });
        }
    }
	
	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
		ModelEmployee e = new ModelEmployee();

		e.setID(textID.getText());
		e.setName(textName.getText());
		int age = Integer.parseInt(textAge.getText());
		e.setAge(age);
		e.setDepartment(textDepartment.getText());
		e.setCode(textCode.getText());
		int salaryRate = Integer.parseInt(textSalaryRate.getText());
		e.setSalaryRate(salaryRate);
		
		boolean isOK = true;
		if(isOK) {
			new ControllerEmployee().AddEmployee(e);
			showTable();
			JOptionPane.showMessageDialog(this, "Add success");
		}	
	}
	private void btnDel() {
		selectIndex = table_employee.getSelectedRow();
		ModelEmployee e = modelEmployeeList.get(selectIndex);
		
		JOptionPane.showConfirmDialog(this,"Are you sure you want to delete it?");
		ControllerEmployee controller = new ControllerEmployee();
		controller.DelEmployee(e.getID());
		showTable();
	}
}
