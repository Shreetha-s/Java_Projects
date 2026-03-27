package com.student.project.DAO;

import com.student.project.DTO.StudentDTO;
import com.student.project.DB.DBConnection;
import java.sql.*;

public class StudentDAO {
    Connection con = DBConnection.getConnection();
    // INSERT DATA
    public void insertStudent(StudentDTO s) {
        try {
            String query = "INSERT INTO students(name, gender, register_no, email, dob) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, s.getName());
            ps.setString(2, s.getGender().name());
            ps.setString(3, s.getRegNo());
            ps.setString(4, s.getEmail());
            ps.setDate(5, new java.sql.Date(s.getDateOfBirth().getTime()));
            ps.executeUpdate();
            System.out.println("Student Data Inserted Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE RECORD
    public void deleteStudent(String regNo) {
        try {
            String query = "DELETE FROM students WHERE register_no=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, regNo);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Deleted Successfully");
            else
                System.out.println("No Data Found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // FIND BY REG NO
    public void findStudent(String regNo) {
        try {
            String query = "SELECT * FROM students WHERE register_no=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, regNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("S.No: " + rs.getInt("s_no"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Gender: " + rs.getString("gender"));
                System.out.println("Register No: " + rs.getString("register_no"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("DOB: " + rs.getDate("dob"));
            } else {
                System.out.println("Invalid Data");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // FIND ALL DATA
    public void findAllStudents() {
        try {
            String query = "SELECT * FROM students";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("--------------------");
                System.out.println("S.No: " + rs.getInt("s_no"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Gender: " + rs.getString("gender"));
                System.out.println("Register No: " + rs.getString("register_no"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("DOB: " + rs.getDate("dob"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}