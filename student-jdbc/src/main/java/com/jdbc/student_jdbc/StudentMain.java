package com.jdbc.student_jdbc;


public class StudentMain {
    public static void main(String[] args) {
        System.out.println("Student Database");
        IMenu menu = new MenuImpl();
        menu.showMenu();
    }
}