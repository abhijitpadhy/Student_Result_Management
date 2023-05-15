import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JTextField;
import StudentResultManagement.dao.ResultDao;
import StudentResultManagement.Model.*;

public class StudentIndex {

	private JFrame frame;
	private JTextField enterrollno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentIndex window = new StudentIndex();
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
	public StudentIndex() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 255, 255));
		frame.setBounds(100, 100, 829, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ABHIJIT\\Downloads\\download.png"));
		lblNewLabel.setBounds(255, 11, 361, 170);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel enterrollnoLabel_1 = new JLabel("Enter Roll No");
		enterrollnoLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		enterrollnoLabel_1.setBounds(275, 227, 133, 32);
		frame.getContentPane().add(enterrollnoLabel_1);
		
		JButton search = new JButton("SEARCH");
		search.setFont(new Font("Times New Roman", Font.BOLD, 16));
		search.setBackground(new Color(255, 255, 255));
		search.setBounds(262, 339, 110, 23);
		frame.getContentPane().add(search);
		search.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Connection con = null;

		        try {
		            con = ResultDao.getConnection();

		            String sql = "SELECT student.rollNo, student.course, student.branch, student.name, student.gender, student.fatherName, result.java, result.DataStructure, result.webprogrammig, result.ComputerNetwork, result.OperatingSystem FROM result INNER JOIN student ON student.rollNo = result.rollNo WHERE student.rollNo = ?";
		            PreparedStatement pre = con.prepareStatement(sql);
		            pre.setString(1, enterrollno.getText());
		            ResultSet rs1 = pre.executeQuery();

		            if (rs1.next()) {
		                Result rt1 = new Result();
		                Student st = new Student();

		                st.setRollNo(rs1.getString("rollNo"));
		                st.setCourse(rs1.getString("course"));
		                st.setBranch(rs1.getString("branch"));
		                st.setName(rs1.getString("name"));
		                st.setGender(rs1.getString("gender"));
		                st.setFatherName(rs1.getString("fatherName"));
		                rt1.setJava(rs1.getString("java"));
		                rt1.setDataStructure(rs1.getString("DataStructure"));
		                rt1.setWebprogram(rs1.getString("webprogrammig"));
		                rt1.setComputerNetwork(rs1.getString("ComputerNetwork"));
		                rt1.setOperatingSystem(rs1.getString("OperatingSystem"));

		                String message = "Roll No: " + st.getRollNo()
		                        + "\nCourse: " + st.getCourse()
		                        + "\nBranch: " + st.getBranch()
		                        + "\nName: " + st.getName()
		                        + "\nGender: " + st.getGender()
		                        + "\nFather's Name: " + st.getFatherName()
		                        + "\nJava: " + rt1.getJava()
		                        + "\nData Structure: " + rt1.getDataStructure()
		                        + "\nWeb Programming: " + rt1.getWebprogram()
		                        + "\nComputer Network: " + rt1.getComputerNetwork()
		                        + "\nOperating System: " + rt1.getOperatingSystem();

		                JOptionPane.showMessageDialog(null, message, "Student Result", JOptionPane.INFORMATION_MESSAGE);

		                setVisible(false);
		                enterrollno.setText("");
		                
		                frame.dispose();
		            } else {
		                JOptionPane.showMessageDialog(null, "Incorrect rollNo");
		            }

		            rs1.close();
		            pre.close();
		            con.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});


		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  new Index();
			  frame.dispose();
			}
		});
		back.setFont(new Font("Times New Roman", Font.BOLD, 16));
		back.setBounds(547, 339, 119, 23);
		frame.getContentPane().add(back);
		
		enterrollno = new JTextField();
		enterrollno.setBounds(418, 235, 198, 20);
		frame.getContentPane().add(enterrollno);
		enterrollno.setColumns(10);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}