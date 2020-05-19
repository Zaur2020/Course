package course.main;

import course.dao.StudentDaoImpl;
import course.dao.StudentDaoInter;
import course.model.Student;
import course.service.StudentServiceImpl;
import course.service.StudentServiceInter;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            StudentDaoInter stuDaoInter = new StudentDaoImpl();
            StudentServiceInter stuServInter = new StudentServiceImpl(stuDaoInter);
            List<Student> studentlist = null;

            System.out.println("which model ?? 1.Student 2.teacher 3.lesson ");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("which method ? 1.view 2.add 3.update 4.delete");
                    switch (sc.nextInt()) {
                        case 1:
                            studentlist = stuServInter.getStudentList();
                            for (Student st : studentlist) {
                                System.out.println(st.getId() + "   " + st.getName() + " " + st.getSurname() + "   "
                                        + st.getAddress() + "   " + st.getEmail() + "   " + st.getContact());
                            }
                            break;
                        case 2:
                            System.out.println("enter name");
                            sc.nextLine();
                            String name = sc.nextLine();
                            System.out.println("enter surname");
                            String surname = sc.nextLine();
                            System.out.println("enter address");
                            String address = sc.nextLine();
                            System.out.println("enter email");
                            String email = sc.nextLine();
                            System.out.println("enter contact");
                            int contact = sc.nextInt();
                            Student student = new Student();
                            student.setName(name);
                            student.setSurname(surname);
                            student.setAddress(address);
                            student.setEmail(email);
                            student.setContact(contact);
                            boolean result = stuServInter.addStudent(student);
                            if (result) {
                                System.out.println("You are registered");
                            } else {
                                System.out.println("There was a problem with the record");

                            }

                            break;
                        case 3:
                            studentlist = stuServInter.getStudentList();
                            for (Student st : studentlist) {
                                System.out.println(st.getId() + " " + st.getName() + " " + st.getSurname() + " "
                                        + st.getAddress() + " " + st.getEmail() + " " + st.getContact());
                            }
                            System.out.println("enter student id which you want update");

                            Long id = sc.nextLong();

                            Student s = stuServInter.getStudentById(id);

                            System.out.println("old name = " + s.getName());
                            System.out.println("old surname = " + s.getSurname());
                            System.out.println("old address = " + s.getAddress());
                            System.out.println("old email = " + s.getEmail());
                            System.out.println("old contact = " + s.getContact());

                            System.out.println("enter new name");
                            sc.nextLine();
                            String newname = sc.nextLine();
                            System.out.println("enter new surname");
                            String newsurname = sc.nextLine();
                            System.out.println("enter new address");
                            String newaddress = sc.nextLine();
                            System.out.println("enter new email");
                            String newemail = sc.nextLine();
                            System.out.println("enter new contact");
                            int newcontact = sc.nextInt();
                            Student st = new Student();
                            st.setName(newname);
                            st.setSurname(newsurname);
                            st.setAddress(newaddress);
                            st.setEmail(newemail);
                            st.setContact(newcontact);
                            boolean update = stuServInter.getUpdateStudent(st, id);
                            if (update) {
                                System.out.println("Student has been succesfully update");
                            } else {
                                System.out.println("There was a problem student hasnot been update");

                            }

                            break;
                        case 4:
                            studentlist = stuServInter.getStudentList();
                            for (Student stu : studentlist) {
                                System.out.println(stu.getId() + " " + stu.getName() + " " + stu.getSurname() + " "
                                        + stu.getAddress() + " " + stu.getEmail() + " " + stu.getContact());
                            }
                            System.out.println("enter student id which you want delete");

                            Long id1 = sc.nextLong();

                            boolean delete = stuServInter.deleteStudent(id1);
                            if (delete) {
                                System.out.println("deleted succesfully");
                            } else {
                                System.out.println("no delete");
                            }

                            break;
                    }

                    break;

                case 4:
                    break;

                default:
                    break;

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        main(args);
    }

}
