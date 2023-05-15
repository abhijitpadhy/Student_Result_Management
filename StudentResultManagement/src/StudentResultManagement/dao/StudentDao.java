package StudentResultManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import StudentResultManagement.Model.Student;

public class StudentDao {
	@SuppressWarnings("unused")
	private Connection con;
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/srm", "root", "1234");
    }
    public StudentDao(Connection con) {
        this.con = con;
    }


    public int addStudent(Student st) throws SQLException {
        int res = 0;

        try (Connection con = StudentDao.getConnection();
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO student (rollNo, course, branch, name, gender, fatherName) VALUES (?, ?, ?, ?, ?, ?)")) {

            ps.setString(1, st.getRollNo());
            ps.setString(2, st.getCourse());
            ps.setString(3, st.getBranch());
            ps.setString(4, st.getName());
            ps.setString(5, st.getGender());
            ps.setString(6, st.getFatherName());

            res = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    public Student getResult(String rollNo) throws SQLException, ClassNotFoundException {
        @SuppressWarnings("unused")
		int res = 0;

        try (Connection con = StudentDao.getConnection();
                PreparedStatement ps = con.prepareStatement("SELECT student.rollNo,student.course,student.branch,student.name,student.gender,student.fatherName,result.java,result.DataStructure,result.webprogrammig,result.ComputerNetwork,result.OperatingSystem FROM resultINNER JOIN student on student.rollNo=result.rollNo")) {

            ps.setString(1, rollNo);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res = rs.getInt("your_column_name_here");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

	
}
