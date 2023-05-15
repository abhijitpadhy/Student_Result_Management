

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import StudentResultManagement.dao.StudentDao;
import javax.swing.JScrollPane;
import java.awt.Font;

public class registeredStudent {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registeredStudent window = new registeredStudent();
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
	public registeredStudent() {
		initialize();
		frame.setVisible(true);
		frame.setVisible(true);
		frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 825, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 238, 463);
		frame.getContentPane().add(panel);
		panel.setLayout(null); 
		
		JButton btnNewButton = new JButton("Add New Student");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(32, 74, 169, 23);
		panel.add(btnNewButton);
		 btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new AdminHome();
		        frame.dispose();
		    }
		});
		//Display the result in the table 
		 
		 
		JButton btnLoadtable = new JButton("Registered Students");
		btnLoadtable.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnLoadtable.setForeground(new Color(255, 0, 0));
		btnLoadtable.setBounds(32, 254, 169, 23);
		panel.add(btnLoadtable);
		btnLoadtable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent el) { 
				Connection con = null;
				ResultSet rs = null; // Added to fix error
				try {
					con = StudentDao.getConnection();
					PreparedStatement ps = con.prepareStatement("select * from student");
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

		
		JButton btnNewButton_2 = new JButton("Insert New Result");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_2.setBounds(32, 160, 169, 23);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new InsertNewResult();
		        frame.dispose();
		    }
		});
		
		JButton btnNewButton_3 = new JButton("All Students Result");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_3.setBounds(32, 326, 163, 23);
		panel.add(btnNewButton_3);
		 btnNewButton_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new AllStudentsResult();
		        frame.dispose();
		    }
		});

		
		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_4.setBounds(62, 405, 89, 23);
		panel.add(btnNewButton_4);
		 btnNewButton_4.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        new AdminIndex();
			        frame.dispose();
			    }
			});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(237, 0, 562, 463);
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
	
