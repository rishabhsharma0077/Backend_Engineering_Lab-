package com.student.management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n1. Add Student\n2. View All\n3. Update\n4. Delete\n5. Exit");
            System.out.print("Choose option: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    service.addStudent(new Student(id, name, marks));
                    break;
                case 2:
                    service.viewAllStudents();
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    System.out.print("New Name: ");
                    String uname = sc.next();
                    System.out.print("New Marks: ");
                    double umarks = sc.nextDouble();
                    service.updateStudent(uid, uname, umarks);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    service.deleteStudent(did);
                    break;
                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
