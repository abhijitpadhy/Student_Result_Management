import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import StudentResultManagement.dao.StudentDao;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.Font;

public class AllStudentsResult {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllStudentsResult window = new AllStudentsResult();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AllStudentsResult() {
		initialize();
		frame.setVisible(true);
		frame.setVisible(true);
		frame.setVisible(true);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 827, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 238, 469);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton addNewStudentsbtnNewButton = new JButton("Add New Students");
		addNewStudentsbtnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		addNewStudentsbtnNewButton.setBounds(40, 94, 164, 23);
		panel.add(addNewStudentsbtnNewButton);
		addNewStudentsbtnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new AdminHome();
		        frame.dispose();
		    }
		});
		
		JButton insertNewResultbtnNewButton_1 = new JButton("Insert New Result");
		insertNewResultbtnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		insertNewResultbtnNewButton_1.setBounds(40, 161, 164, 23);
		panel.add(insertNewResultbtnNewButton_1);
		insertNewResultbtnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new InsertNewResult();
		        frame.dispose();
		    }
		});
		
		JButton btnNewButton_2 = new JButton("Registered Students");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_2.setBounds(40, 238, 164, 23);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new registeredStudent();
		        frame.dispose();
		    }
		});
		
		JButton allStudentsResultbtn = new JButton("All Students Result");
		allStudentsResultbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		allStudentsResultbtn.setForeground(new Color(255, 0, 0));
		allStudentsResultbtn.setBounds(40, 316, 164, 23);
		panel.add(allStudentsResultbtn);
		allStudentsResultbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent el) { 
			Connection con = null;
			ResultSet rs = null; // Added to fix error
			try {
				con = StudentDao.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from result");
				ResultSet rs1 = ps.executeQuery(); // Executing query and getting result set
				table.setModel(DbUtils.resultSetToTableModel(rs1));
				
			}
			catch(Exception e1) {
				JOptionPane.showMessageDialog(null, "Connection error: " + e1.getMessage());
			}
			finally {
				try {
					if(rs != null) rs.close(); // Closing result set
					if(con != null) con.close(); // Closing connection
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error while closing connection: " + ex.getMessage());
				}
			}
			table.setEnabled(false);
		}
		});

		
		JButton logoutbtnNewButton_4 = new JButton("Logout");
		logoutbtnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		logoutbtnNewButton_4.setBounds(70, 391, 89, 23);
		panel.add(logoutbtnNewButton_4);
		logoutbtnNewButton_4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new AdminIndex();
		        frame.dispose();
		    }
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(238, 0, 563, 469);
		frame.getContentPane().add(scrollPane);
	
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
	}
}
