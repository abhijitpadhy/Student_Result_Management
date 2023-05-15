import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import StudentResultManagement.dao.ResultDao;
import StudentResultManagement.Model.Result;
import java.awt.Font;

public class InsertNewResult {

	private JFrame frame;
	private JTextField textFieldRollno;
	private JTextField textField_1java;
	private JTextField textField_2dataStructure;
	private JTextField textField_3webprogram;
	private JTextField textField_4computernetwork;
	private JTextField textField_5os;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertNewResult window = new InsertNewResult();
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
	public InsertNewResult() {
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
		frame.getContentPane().setBackground(new Color(128, 255, 255));
		frame.setBounds(100, 100, 825, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 235, 452);
		panel.setBackground(new Color(192, 192, 192));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//All New Students
		
		JButton btnNewButton = new JButton("All New Student");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(25, 70, 170, 23);
		panel.add(btnNewButton);
		btnNewButton .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminHome();
				 frame.dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Insert New Result");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(25, 149, 170, 23);
		panel.add(btnNewButton_1);
		
		
		//For registered button
		
		JButton registeredbtn2 = new JButton("Registered Student");
		registeredbtn2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		registeredbtn2.setBounds(25, 218, 170, 23);
		panel.add(registeredbtn2);
		registeredbtn2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new registeredStudent();
		        frame.dispose();
		    }
		});
		
		//for All Students result
		
		JButton btnNewButton_3 = new JButton("All Students Result");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_3.setBounds(25, 290, 170, 23);
		panel.add(btnNewButton_3);
		 btnNewButton_3.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        new AllStudentsResult();
			        frame.dispose();
			    }
			});

		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_4.setBounds(65, 402, 89, 23);
		panel.add(btnNewButton_4);
		 btnNewButton_4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new AdminIndex();
		        frame.dispose();
		    }
		});
		
		JLabel lblNewLabel = new JLabel("RollNo");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(305, 69, 86, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Java");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(316, 118, 65, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DataStructure");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_2.setBounds(316, 177, 86, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("WebProgramming");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3.setBounds(305, 229, 114, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ComputerNetwork");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_4.setBounds(305, 277, 114, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		textFieldRollno = new JTextField();
		textFieldRollno.setBounds(507, 66, 86, 20);
		frame.getContentPane().add(textFieldRollno);
		textFieldRollno.setColumns(10);
		
		textField_1java = new JTextField();
		textField_1java.setBounds(507, 115, 86, 20);
		frame.getContentPane().add(textField_1java);
		textField_1java.setColumns(10);
		
		textField_2dataStructure = new JTextField();
		textField_2dataStructure.setBounds(507, 174, 86, 20);
		frame.getContentPane().add(textField_2dataStructure);
		textField_2dataStructure.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("OperatingSystem");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_5.setBounds(305, 338, 114, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_3webprogram = new JTextField();
		textField_3webprogram.setBounds(507, 226, 86, 20);
		frame.getContentPane().add(textField_3webprogram);
		textField_3webprogram.setColumns(10);
		
		textField_4computernetwork = new JTextField();
		textField_4computernetwork.setBounds(507, 274, 86, 20);
		frame.getContentPane().add(textField_4computernetwork);
		textField_4computernetwork.setColumns(10);
		
		textField_5os = new JTextField();
		textField_5os.setBounds(507, 335, 86, 20);
		frame.getContentPane().add(textField_5os);
		textField_5os.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Save");
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_5.setBounds(453, 415, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_6dis = new JLabel("");
		lblNewLabel_6dis.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_6dis.setBounds(411, 26, 211, 29);
		frame.getContentPane().add(lblNewLabel_6dis);
		btnNewButton_5.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Result rl=new Result();
		    	rl.setRollNo((String) textFieldRollno .getText());
		    	rl.setJava((String) textField_1java .getText());
		    	rl.setDataStructure((String)textField_2dataStructure .getText());
		    	rl.setWebprogram((String) textField_3webprogram.getText());
		    	rl.setComputerNetwork((String)textField_4computernetwork.getText());
		    	rl.setOperatingSystem((String)textField_5os.getText());
		    	  ResultDao dao = new ResultDao(null);
		    	    int i=0;
		    	    try {
		    	        i = dao.addResult(rl);
		    	    } catch (SQLException e1) {
		    	        e1.printStackTrace();
		    	    }
		    	    if(i!=0) {
		    	    	lblNewLabel_6dis.setText("Added successfully.....");
		    	    } else {
		    	    	lblNewLabel_6dis.setText("Not added");
		    	    }
		   
		    	
		        
		    	
		    	
}
});
	}
}
		