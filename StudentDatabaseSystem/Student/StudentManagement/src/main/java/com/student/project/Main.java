package com.student.project;

import com.student.project.DAO.StudentDAO;
import com.student.project.DTO.StudentDTO;
import com.student.project.Enums.Gender;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        while (true) {
            System.out.println("\nOPERATIONS\n1.Insert\n2.Delete\n3.Find\n4.Find All\n5.Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Name : ");
                    String name = sc.nextLine();
                    System.out.print("Gender : ");
                    String genderInput = sc.nextLine();
                    Gender gender;
                    try {
                        gender = Gender.valueOf(genderInput.toUpperCase());
                    } catch (Exception e) {
                        System.out.println("Invalid Gender");
                        break;
                    }
                    System.out.print("Register No: ");
                    String regNo = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("DOB (YYYY-MM-DD): ");
                    String dob = sc.nextLine();
                    StudentDTO s = new StudentDTO(0, name, gender, regNo, email, java.sql.Date.valueOf(dob));
                    dao.insertStudent(s);
                    break;
                case 2:
                    System.out.print("Enter Register No: ");
                    dao.deleteStudent(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter Register No: ");
                    dao.findStudent(sc.nextLine());
                    break;
                case 4:
                    dao.findAllStudents();
                    break;
                case 5:
                    System.out.println("Executed Successfully");
                    System.exit(0);
            }
        }
    }
}