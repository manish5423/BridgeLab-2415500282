package com.jdbc.student_jdbc;

import java.sql.*;
import java.util.Scanner;

public class Studentimplement implements IStudent {

    private Connection conn;
    private Scanner sc = new Scanner(System.in);

    public Studentimplement() {
        conn = new ConnectionImpl().getConnection();
    } 

    @Override
    public void insertStudent() {
        try {
            
            Statement st = conn.createStatement();

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            
            

            String query = "INSERT INTO student (id, name, age, email) VALUES ("
                         + id + ", '" + name + "', " + age + ", '" + email + "')";

            int rows = st.executeUpdate(query);

            if (rows > 0) {
                System.out.println("Student inserted successfully!");
            } else {
                System.out.println("Student not inserted!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    @Override
    public void insertMultipleStudents() {
    	System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            insertStudent();
        }
    }
    
    @Override
    public void updateStudent() {
    	try {
            System.out.print("Enter ID to update: ");
            int id = sc.nextInt();
            System.out.print("Enter new name: ");
            String name = sc.next();
            System.out.print("Enter new age: ");
            int age = sc.nextInt();

            PreparedStatement ps = conn.prepareStatement("UPDATE student SET name=?, age=? WHERE id=?");
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Student updated successfully.");
            else
                System.out.println("Student not found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    @Override
    public void updateMultipleStudents() {
    	System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
        	updateStudent();
        }
    }
    
    @Override
    public void deleteStudent() {
    	try {
            System.out.print("Enter ID to delete: ");
            int id = sc.nextInt();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM student WHERE id=?");
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Student deleted successfully.");
            else
                System.out.println("Student not found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    @Override
    public void deleteMultipleStudents() {
    	System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
        	deleteStudent();
        }
    }
    
    @Override
    public void showStudents() {
    	try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");
            System.out.println("Student List:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) +
                        " | Name: " + rs.getString(2) +
                        " | Age: " + rs.getInt(3) +
                        " | Email: " + rs.getString(4)
                        );
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    }