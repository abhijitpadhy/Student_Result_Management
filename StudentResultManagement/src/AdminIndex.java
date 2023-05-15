import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;

public class AdminIndex {

    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminIndex window = new AdminIndex();
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
    public AdminIndex() {
        initialize();
        frame.setVisible(true);
        frame.setVisible(true);
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
        frame.getContentPane().setBackground(new Color(128, 255, 255));
        frame.setBounds(100, 100, 827, 494);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ABHIJIT\\Downloads\\download (1).png"));
        lblNewLabel.setBounds(313, 0, 199, 228);
        frame.getContentPane().add(lblNewLabel);
        
        usernameField = new JTextField();
        usernameField.setBounds(452, 252, 123, 20);
        frame.getContentPane().add(usernameField);
        usernameField.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(452, 283, 123, 20);
        frame.getContentPane().add(passwordField);
        
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        loginButton.setBounds(241, 373, 89, 23);
        frame.getContentPane().add(loginButton);
        loginButton.addActionListener(new ActionListener() {
          
			public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                @SuppressWarnings("deprecation")
				String password = passwordField.getText();
                
                // Check login credentials (replace this with your own code)
                try {
                    if (username.equals("admin") && password.equals("pass")) {
                        new AdminHome();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid username or password");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "An error occurred: " + ex.getMessage());
                }
            }
        });
    
        
        JLabel userid = new JLabel("UserId");
        userid.setFont(new Font("Times New Roman", Font.BOLD, 18));
        userid.setBounds(317, 253, 73, 14);
        frame.getContentPane().add(userid);
        
        JLabel passwordLabel_2 = new JLabel("Password");
        passwordLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
        passwordLabel_2.setBounds(313, 284, 81, 14);
        frame.getContentPane().add(passwordLabel_2);
        
        JButton backbtn = new JButton("BACK");
        backbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Index();
        		frame.dispose();
        	}
        });
        backbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
        backbtn.setBounds(552, 373, 89, 23);
        frame.getContentPane().add(backbtn);
        
    }
}
