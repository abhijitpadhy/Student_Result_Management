package StudentResultManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import StudentResultManagement.Model.Result;
import StudentResultManagement.Model.Student;
public class ResultDao {
	@SuppressWarnings("unused")
	private Connection con;
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/srm", "root", "1234");
    }
    public ResultDao(Connection con) {
        this.con = con;
    }

    public int addResult(Result rl) throws SQLException {
        int res = 0;

        try (Connection con = ResultDao.getConnection();
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO result (rollNo, java, dataStructure, webprogrammig, computerNetwork, operatingSystem) VALUES (?, ?, ?, ?, ?, ?)")) {

            ps.setString(1, rl.getRollNo());
            ps.setString(2, rl.getJava());
            ps.setString(3, rl.getDataStructure());
            ps.setString(4, rl.getWebprogram());
            ps.setString(5, rl.getComputerNetwork());
            ps.setString(6, rl.getOperatingSystem());

            res = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    public Result getResult(String rollNo) throws Exception {
        

        try (
        		Connection con = ResultDao.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT student.rollNo, student.course, student.branch, student.name, student.gender, student.fatherName, result.java, result.DataStructure, result.webprogrammig, result.ComputerNetwork, result.OperatingSystem " +
                     "FROM result " +
                     "INNER JOIN student ON student.rollNo = result.rollNo " +
                     "WHERE result.rollNo = ?")) {

            ps.setString(1, rollNo);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Result rt1 = new Result();
                Student st =new Student();
                st.setRollNo(rs.getString("rollNo"));
                st.setCourse(rs.getString("course"));
                st.setBranch(rs.getString("branch"));
                st.setName(rs.getString("name"));
                st.setGender(rs.getString("gender"));
                st.setFatherName(rs.getString("fatherName"));
                rt1.setJava(rs.getString("java"));
                rt1.setDataStructure(rs.getString("DataStructure"));
                rt1.setWebprogram(rs.getString("webprogrammig"));
                rt1.setComputerNetwork(rs.getString("ComputerNetwork"));
                rt1.setOperatingSystem(rs.getString("OperatingSystem"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
