package course.dao;

import course.model.Lesson;
import course.model.Payment;
import course.model.Student;
import course.model.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImpl implements PaymentDaoInter {

    @Override
    public List<Payment> getPaymentList() throws Exception {

        List<Payment> paymetlist = new ArrayList<Payment>();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet r = null;

        String sql = "SELECT p.id,s.name, s.surname ,t.name ,t.surname ,l.Lesson_name,p.payment,\n"
                + "                p.start_date, p.end_date from payment p \n"
                + "                INNER JOIN student s on p.student_id=s.id \n"
                + "                INNER JOIN teacher t on p.teacher_id=t.id\n"
                + "                INNER JOIN lesson l on p.lesson_id=l.id";

        try {
            c = Db_Helper.getconnection();

            if (c != null) {
                ps = c.prepareStatement(sql);
                r = ps.executeQuery();
                while (r.next()) {

                    Payment p = new Payment();
                    Student s = new Student();
                    Teacher t = new Teacher();
                    Lesson l = new Lesson();

                    p.setId(r.getInt("id"));
                    s.setName(r.getString("name"));
                    s.setSurname(r.getString("surname"));
                    t.setName(r.getString("name"));
                    t.setSurname(r.getString("surname"));
                    l.setLesson_name(r.getString("Lesson_name"));
                    p.setAmount(r.getInt("payment"));
                    p.setStartdate(r.getDate("start_date"));
                    p.setEnddate(r.getDate("end_date"));

                    p.setStudentid(s);
                    p.setTeacherid(t);
                    p.setLessonod(l);

                    paymetlist.add(p);

                }

            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (c != null) {
                c.close();
            }

            if (ps != null) {
                ps.close();
            }

            if (r != null) {
                r.close();
            }

        }
        return paymetlist;
    }

    @Override
    public List<Payment> getSearchPayment(String keyword) throws Exception {

        List<Payment> paymetlist = new ArrayList<Payment>();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet r = null;

        String sql = "SELECT p.id,s.name, s.surname ,t.name ,t.surname ,l.Lesson_name,p.payment,\n" +
"                                p.start_date, p.end_date from payment p \n" +
"                                INNER JOIN student s on p.student_id=s.id \n" +
"                               INNER JOIN teacher t on p.teacher_id=t.id\n" +
"                                INNER JOIN lesson l on p.lesson_id=l.id\n" +
"                		where p.active=1 and s.name like (?) or s.surname like(?) or t.name like(?) or t.surname like(?)";

        try {

            c = Db_Helper.getconnection();
            if (c != null) {

                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
              //  ps.setString(5, "%" + keyword + "%");
                
                r=ps.executeQuery();
                
                while(r.next()){
                    
                    Payment p = new Payment();
                    Student s =new Student();
                    Teacher t =new Teacher();
                    Lesson l =new Lesson();
                    
                    p.setId(r.getInt("id"));
                    s.setName(r.getString("name"));
                    s.setSurname(r.getString("surname"));
                    t.setName(r.getString("name"));
                    l.setLesson_name(r.getString("Lesson_name"));
                    p.setAmount(r.getInt("payment"));
                    p.setStartdate(r.getDate("start_date"));
                    p.setEnddate(r.getDate("end_date"));

                    p.setStudentid(s);
                    p.setTeacherid(t);
                    p.setLessonod(l);
                    
                    
                    paymetlist.add(p);
                    
                    
                    
                }

            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (c != null) {
                c.close();
            }

            if (ps != null) {
                ps.close();
            }

            if (r != null) {
                r.close();
            }

        }

        return paymetlist;
    }

}
