import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import StudentResultManagement.dao.StudentDao;
import StudentResultManagement.Model.Student;

import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

@SuppressWarnings("unused")
public class AdminHome {

	private JFrame frame;
	private JTextField rolltextField;
	private JTextField nametextField_1;
	private JTextField fnametextField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome window = new AdminHome();
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
	public AdminHome() {
		initialize();
		frame.setVisible(true);
		frame.setVisible(true);
	
	}
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 255, 255));
		frame.setBounds(100, 100, 822, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 0, 254, 462);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton addnewbtn = new JButton("AddNewStudent");
		addnewbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		addnewbtn.setForeground(new Color(255, 0, 0));
		addnewbtn.setBounds(30, 83, 161, 23);
		panel.add(addnewbtn);
		
		
		JButton insertnewbtn = new JButton("InsertNewResult");
		insertnewbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		insertnewbtn.setBounds(30, 150, 161, 23);
		panel.add(insertnewbtn);
		insertnewbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new InsertNewResult();
		        frame.dispose();
		    }
		});

		
		JButton registeredstudentbtn = new JButton("RegisteredStudent");
		registeredstudentbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		registeredstudentbtn.setBounds(30, 227, 161, 23);
		panel.add(registeredstudentbtn);
		registeredstudentbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new registeredStudent();
		        frame.dispose();
		    }
		});
		
		JButton allstudentsresultsbtn = new JButton("AllStudentsResults");
		allstudentsresultsbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		allstudentsresultsbtn.setBounds(30, 302, 161, 23);
		panel.add(allstudentsresultsbtn);
		allstudentsresultsbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllStudentsResult();
				 frame.dispose();
			}
		});
		
		JButton logoutButton_4 = new JButton("Logout");
		logoutButton_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		logoutButton_4.setBounds(68, 393, 89, 23);
		panel.add(logoutButton_4);
		logoutButton_4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        new AdminIndex();
		        frame.dispose();
		    }
		});
			
		JLabel lblNewLabel = new JLabel("COURSE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(371, 56, 74, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BRANCH NAME");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(371, 101, 127, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ROLL NO");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_2.setBounds(371, 163, 74, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("NAME");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3.setBounds(371, 221, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("GENDER");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_4.setBounds(371, 268, 74, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("FATHER NAME");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_5.setBounds(363, 323, 108, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JComboBox coursecomboBox = new JComboBox();
		coursecomboBox.setModel(new DefaultComboBoxModel(new String[] {"MCA", "BCA"}));
		coursecomboBox.setBounds(545, 52, 96, 22);
		frame.getContentPane().add(coursecomboBox);
		
		rolltextField = new JTextField();
		rolltextField.setBounds(545, 160, 96, 20);
		frame.getContentPane().add(rolltextField);
		rolltextField.setColumns(10);
		
		JComboBox branchcomboBox_1 = new JComboBox();
		branchcomboBox_1.setModel(new DefaultComboBoxModel(new String[] {"MCA", "BCA"}));
		branchcomboBox_1.setBounds(545, 109, 96, 22);
		frame.getContentPane().add(branchcomboBox_1);
		
		nametextField_1 = new JTextField();
		nametextField_1.setBounds(545, 218, 93, 20);
		frame.getContentPane().add(nametextField_1);
		nametextField_1.setColumns(10);
		
		fnametextField_2 = new JTextField();
		fnametextField_2.setBounds(552, 320, 89, 20);
		frame.getContentPane().add(fnametextField_2);
		fnametextField_2.setColumns(10);
		
		JComboBox gendercomboBox_2 = new JComboBox();
		gendercomboBox_2.setModel(new DefaultComboBoxModel(new String[] {"MALE", "FEMALE", "OTHER"}));
		gendercomboBox_2.setBounds(551, 264, 90, 22);
		frame.getContentPane().add(gendercomboBox_2);
		
		JButton createButton_5 = new JButton("CREATE");
		createButton_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		createButton_5.setBounds(483, 411, 89, 23);
		frame.getContentPane().add(createButton_5);
		
		JLabel dislblNewLabel_6 = new JLabel("");
		dislblNewLabel_6.setBounds(323, 11, 137, 14);
		frame.getContentPane().add(dislblNewLabel_6);
	    createButton_5.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	    Student st = new Student();
	    	    st.setCourse((String) coursecomboBox.getSelectedItem()); // Cast selected item to String
	    	    st.setBranch((String) branchcomboBox_1.getSelectedItem()); // Cast selected item to String
	    	    st.setRollNo(rolltextField.getText());
	    	    st.setName(nametextField_1.getText());
	    	    st.setGender((String) gendercomboBox_2.getSelectedItem()); // Cast selected item to String
	    	    st.setFatherName(fnametextField_2.getText());
	    	    StudentDao dao = new StudentDao(null);
	    	    int i=0;
	    	    try {
	    	        i = dao.addStudent(st);
	    	    } catch (SQLException e1) {
	    	        e1.printStackTrace();
	    	    }
	    	    if(i!=0) {
	    	        dislblNewLabel_6.setText("Added successfully.....");
	    	    } else {
	    	        dislblNewLabel_6.setText("Not added");
	    	        
	    	    }
	    	}
	    });

		
		
	}

}
