package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import model.ModelEmployee;

public class ControllerEmployee {
    private Connection conn;

    public ControllerEmployee() {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/employee";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database successfully!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ModelEmployee> getListEmployee() {
        ArrayList<ModelEmployee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ModelEmployee e = new ModelEmployee();
                e.setID(rs.getString("ID"));
                e.setName(rs.getString("Name"));
                e.setAge(rs.getInt("Age"));
                e.setDepartment(rs.getString("Department"));
                e.setCode(rs.getString("Code"));
                e.setSalaryRate(rs.getInt("SalaryRate"));
                list.add(e);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void AddEmployee(ModelEmployee e) {
        String sql = "INSERT INTO employee (ID, Name, Age, Department, Code, SalaryRate) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, e.getID());
            ps.setString(2, e.getName());
            ps.setInt(3, e.getAge());
            ps.setString(4, e.getDepartment());
            ps.setString(5, e.getCode());
            ps.setInt(6, e.getSalaryRate());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void DelEmployee(String ID) {
        String sql = "DELETE FROM employee WHERE ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,ID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ControllerEmployee();
    }
}
