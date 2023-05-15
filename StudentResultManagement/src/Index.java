import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;

public class Index {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index window = new Index();
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
	public Index() {
		initialize();
		frame.setVisible(true);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 255, 255));
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 16));
		frame.setBounds(100, 100, 826, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ABHIJIT\\Downloads\\download (3).jpeg"));
		lblNewLabel.setBounds(262, 143, 329, 146);
		frame.getContentPane().add(lblNewLabel);
		
		JButton studentbtn = new JButton("Student");
		studentbtn.setBackground(new Color(192, 192, 192));
		studentbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		studentbtn.setBounds(155, 388, 105, 23);
		frame.getContentPane().add(studentbtn);
		studentbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        StudentIndex studentindex = new StudentIndex();
		        studentindex.setVisible(true);
		        frame.dispose();
		    }
		});

		
		JButton adminbtn1 = new JButton("Admin");
		adminbtn1.setForeground(new Color(0, 0, 0));
		adminbtn1.setBackground(new Color(192, 192, 192));
		adminbtn1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		adminbtn1.setBounds(561, 388, 105, 23);
		frame.getContentPane().add(adminbtn1);
		
		JLabel lblNewLabel_1 = new JLabel("CENTURION UNIVERSITY");
		lblNewLabel_1.setBackground(new Color(128, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 31));
		lblNewLabel_1.setBounds(231, 54, 416, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(210, 54, 437, 35);
		frame.getContentPane().add(panel);
		adminbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminIndex();
	                frame.dispose();
			}
		});
	}
}                                        


