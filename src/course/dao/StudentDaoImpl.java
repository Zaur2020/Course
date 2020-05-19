package course.dao;

import course.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDaoInter {

    @Override
    public List<Student> getStudentList() throws Exception {

        List<Student> studentlist = new ArrayList<Student>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet r = null;
        

        String sql = "select id, name, surname,address, email,contact from student where active =1;";

        try {
            c = Db_Helper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                r = ps.executeQuery();
                while (r.next()) {
                    Student s = new Student();
                    s.setId(r.getLong("id"));
                    s.setName(r.getString("Name"));
                    s.setSurname(r.getString("Surname"));
                    s.setAddress(r.getString("Address"));
                    s.setEmail(r.getString("Email"));
                    s.setContact(r.getInt("Contact"));

                    studentlist.add(s);
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
        return studentlist;
    }

    @Override
    public boolean addStudent(Student s)throws Exception {

        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;

        String sql = "INSERT into student (Name,Surname,Address,Email,Contact)\r\n" + "values(?,?,?,?,?)";

        try {
            c = Db_Helper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, s.getName());
                ps.setString(2, s.getSurname());
                ps.setString(3, s.getAddress());
                ps.setString(4, s.getEmail());
                ps.setInt(5, s.getContact());
                ps.execute();
                result = true;
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
        }
        return result;
    }

    @Override
    public Student getStudentById(Long id)throws Exception {

        Student s = new Student();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet r = null;

        String sql = "SELECT id,Name,Surname,Address,Email,Contact from student where active=1 and id=?;";

        try {
            c = Db_Helper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                r = ps.executeQuery();
                if (r.next()) {
                    s.setId(r.getLong("id"));
                    s.setName(r.getString("Name"));
                    s.setSurname(r.getString("Surname"));
                    s.setAddress(r.getString("Address"));
                    s.setEmail(r.getString("Email"));
                    s.setContact(r.getInt("Contact"));

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
        return s;
    }

    @Override
    public boolean getUpdateStudent(Student s, Long id)throws Exception {
        
        Connection c = null;
        PreparedStatement ps = null;
        boolean result = false;
        
        String sql = " UPDATE student set  Name=?,Surname=?,Address=?,Contact=?,Email=?" + "where id=?";
        try {
            c = Db_Helper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, s.getName());
                ps.setString(2, s.getSurname());
                ps.setString(3, s.getAddress());
                ps.setInt(4, s.getContact());
                ps.setString(5, s.getEmail());
                ps.setLong(6, id);

                ps.execute();
                result = true;

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

        }

        return result;
    }

    @Override
    public boolean deleteStudent(Long studentId) throws Exception {

        Connection c = null;
        PreparedStatement ps = null;
        boolean result = false;
        
        String sql = " UPDATE student set active=0\r\n" + " where id=?\r\n";

        try {
            c = Db_Helper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, studentId);

                ps.execute();
                result = true;

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

        }

        return result;
    }


}
