package course.main;

import course.dao.LessonDaoImpl;
import course.dao.LessonDaoInter;
import course.dao.PaymentDaoImpl;
import course.dao.PaymentDaoInter;
import course.dao.StudentDaoImpl;
import course.dao.StudentDaoInter;
import course.dao.TeacherDaoImpl;
import course.dao.TeacherDaoInter;
import course.model.Lesson;
import course.model.Payment;
import course.model.Student;
import course.model.Teacher;
import course.service.LessonServiceImpl;
import course.service.LessonServiceInter;
import course.service.PaymentServiceImpl;
import course.service.PaymentServiceInter;
import course.service.StudentServiceImpl;
import course.service.StudentServiceInter;
import course.service.TeacherServiceImpl;
import course.service.TeacherServiceInter;
import static java.util.Collections.list;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            StudentDaoInter stuDaoInter = new StudentDaoImpl();
            StudentServiceInter stuServInter = new StudentServiceImpl(stuDaoInter);

            TeacherDaoInter teaDaoInter = new TeacherDaoImpl();
            TeacherServiceInter teaServInter = new TeacherServiceImpl(teaDaoInter);

            LessonDaoInter lesDaoInter = new LessonDaoImpl();
            LessonServiceInter lesServInter = new LessonServiceImpl(lesDaoInter);
            
            PaymentDaoInter payDaoInter = new PaymentDaoImpl();
            PaymentServiceInter payServInter = new PaymentServiceImpl(payDaoInter);

            

            List<Student> studentlist = null;
            List<Teacher> teacherlist = null;
            List<Lesson> lessonlist = null;
            List<Payment> paymentlist = null;

            System.out.println("which model ?? 1.Student 2.teacher 3.lesson 4. payment");
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

                            int id = sc.nextInt();

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

                            int id1 = sc.nextInt();

                            boolean delete = stuServInter.deleteStudent(id1);
                            if (delete) {
                                System.out.println("deleted succesfully");
                            } else {
                                System.out.println("no delete");
                            }

                            break;
                    }

                    break;

                case 2:

                    System.out.println("which method ? 1.view 2.add 3.update 4.delete");

                    switch (sc.nextInt()) {

                        case 1:
                            teacherlist = teaServInter.getTeacherList();
                            for (Teacher te : teacherlist) {
                                System.out.println(te.getId() + "   " + te.getName() + " " + te.getSurname() + "   "
                                        + te.getAddress() + "   " + te.getEmail());
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
                            Teacher teacher = new Teacher();
                            teacher.setName(name);
                            teacher.setSurname(surname);
                            teacher.setAddress(address);
                            teacher.setEmail(email);
                            boolean result = teaServInter.addTeacher(teacher);
                            if (result) {
                                System.out.println("You are registered");
                            } else {
                                System.out.println("There was a problem with the record");

                            }

                            break;
                        case 3:

                            teacherlist = teaServInter.getTeacherList();
                            for (Teacher te : teacherlist) {
                                System.out.println(te.getId() + " " + te.getName() + " " + te.getSurname() + " "
                                        + te.getAddress() + " " + te.getEmail());
                            }
                            System.out.println("enter teacher id which you want update");

                            int id = sc.nextInt();

                            Teacher te = teaServInter.getTeacherById(id);

                            System.out.println("old name = " + te.getName());
                            System.out.println("old surname = " + te.getSurname());
                            System.out.println("old address = " + te.getAddress());
                            System.out.println("old email = " + te.getEmail());

                            System.out.println("enter new name");
                            sc.nextLine();
                            String newname = sc.nextLine();
                            System.out.println("enter new surname");
                            String newsurname = sc.nextLine();
                            System.out.println("enter new address");
                            String newaddress = sc.nextLine();
                            System.out.println("enter new email");
                            String newemail = sc.nextLine();
                            Teacher t = new Teacher();
                            t.setName(newname);
                            t.setSurname(newsurname);
                            t.setAddress(newaddress);
                            t.setEmail(newemail);
                            boolean update = teaServInter.getUpdateTeacher(t, id);
                            if (update) {
                                System.out.println("Teacher has been succesfully update");
                            } else {
                                System.out.println("There was a problem student hasnot been update");

                            }
                            break;

                        case 4:
                            teacherlist = teaServInter.getTeacherList();
                            for (Teacher teac : teacherlist) {
                                System.out.println(teac.getId() + " " + teac.getName() + " " + teac.getSurname() + " "
                                        + teac.getAddress() + " " + teac.getEmail());
                            }
                            System.out.println("enter teacher id which you want delete");

                            int id1 = sc.nextInt();

                            boolean delete = teaServInter.deleteTeacher(id1);
                            if (delete) {
                                System.out.println("deleted succesfully");
                            } else {
                                System.out.println("no delete");
                            }

                            break;

                    }
                break;
                case 3:

                    System.out.println("which method ? 1.view 2.add 3.update 4.delete");

                    switch (sc.nextInt()) {
                        case 1:
                            lessonlist = lesServInter.getLessonList();
                            for (Lesson l : lessonlist) {
                                System.out.println(l.getId()+"  "+ l.getLesson_name());
                            }
                            break;
                        case 2:
                            System.out.println("enter name");
                            sc.nextLine();
                            String name = sc.nextLine();
                            Lesson lesson = new Lesson();
                            lesson.setLesson_name(name);
                            boolean result = lesServInter.addLesson(lesson);
                            if (result) {
                                System.out.println("You are registered");
                            } else {
                                System.out.println("There was a problem with the record");

                            }
                        case 3:
                            
                            lessonlist = lesServInter.getLessonList();
                              
                            for (Lesson l : lessonlist) {
                                System.out.println(l.getId() + " " + l.getLesson_name());
                            }
                            System.out.println("enter lesson id which you want update");

                            int id = sc.nextInt();

                            Lesson l = lesServInter.getLessonById(id);

                            System.out.println("old name = " + l.getLesson_name());
                            
                            System.out.println("enter new name");
                            sc.nextLine();
                            String newname = sc.nextLine();
                            
                            Lesson le = new Lesson();
                            le.setLesson_name(newname);
                            boolean update = lesServInter.getUpdateLesson(le, id);
                            if (update) {
                                System.out.println("Lesson has been succesfully update");
                            } else {
                                System.out.println("There was a problem Lesson hasnot been update");

                            }
                        case 4:
                            
                            lessonlist = lesServInter.getLessonList();
                            for (Lesson les : lessonlist) {
                                System.out.println(les.getId() + " " + les.getLesson_name());
                            }
                            System.out.println("enter lesson id which you want delete");

                            int id1 = sc.nextInt();

                            boolean delete = lesServInter.deleteLesson(id1);
                            if (delete) {
                                System.out.println("deleted succesfully");
                            } else {
                                System.out.println("no delete");
                            }


                            break;

                        default:
                            break;
                        
                    }
                break;
                case 4:
                    System.out.println("which method ? 1.view 2.search");
                    switch (sc.nextInt()) {
                        case 1:
                            paymentlist = payServInter.getPaymentList();
                            for (Payment p : paymentlist) {
                                System.out.println(p.getId()+" "+p.getStudentid().getName()+" "+p.getStudentid().getSurname()+" "+p.getTeacherid().getName()+" "+p.getTeacherid().getSurname()+" "+
                                        p.getLessonid().getLesson_name()+" "+p.getAmount()+" "+p.getStartdate()+" "+p.getEnddate());
                            }
                       break;
                        case 2:
                            
                            paymentlist = payServInter.getPaymentList();
                            for(Payment p : paymentlist) {
                                System.out.println(p.getId()+" "+p.getStudentid().getName()+" "+p.getStudentid().getSurname()+" "+p.getTeacherid().getName()+" "+p.getTeacherid().getSurname()+" "+
                                        p.getLessonid().getLesson_name()+" "+p.getAmount()+" "+p.getStartdate()+" "+p.getEnddate());
                            }
                             
                            
                        Scanner s = new Scanner(System.in);
                            System.out.println("Please enter keyword");
                            String keyword=s.nextLine();
                            List <Payment> payments = payServInter.getSearchPayment(keyword);
                            for(Payment payments2: payments){
                            System.out.println(payments2.getId()+" "+payments2.getStudentid().getName()+" "+payments2.getStudentid().getSurname()+" "+payments2.getTeacherid().getName()+" "+payments2.getTeacherid().getSurname()+" "+
                                        payments2.getLessonid().getLesson_name()+" "+payments2.getAmount()+" "+payments2.getStartdate()+" "+payments2.getEnddate());
                        };
                            
                            
                          

                            
                            
                    }
                    
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        main(args);
    }

}
