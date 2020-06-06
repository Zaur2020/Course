
package course.dao;

import course.model.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDaoInter{

    @Override
    public List<Teacher> getTeacherList() throws Exception {
        
        List<Teacher> teacherlist = new ArrayList<Teacher>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet r = null;
        

        String sql = "select id,name,Surname,Address,Email from teacher where Active=1;";

        try {
            c = Db_Helper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                r = ps.executeQuery();
                while (r.next()) {
                    Teacher t = new Teacher();
                    t.setId(r.getInt("id"));
                    t.setName(r.getString("Name"));
                    t.setSurname(r.getString("Surname"));
                    t.setAddress(r.getString("Address"));
                    t.setEmail(r.getString("Email"));

                    teacherlist.add(t);
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
        return teacherlist;
    }    
    
    
    
    @Override
    public boolean addTeacher(Teacher t) throws Exception {
        
        boolean result=false;
        Connection c = null;
        PreparedStatement ps = null;
        
        String sql ="insert into teacher (`Name`,Surname,Address,Email)\n" +"VALUES(?,?,?,?);";
        
         try {
            c = Db_Helper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1,t.getName());
                ps.setString(2, t.getSurname());
                ps.setString(3, t.getAddress());
                ps.setString(4, t.getEmail());
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
    public Teacher getTeacherById(int id) throws Exception {
        
        Teacher t = new Teacher();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet r = null;

        String sql = "SELECT id,Name,Surname,Address,Email from teacher where active=1 and id=?;";

        try {
            c = Db_Helper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                r = ps.executeQuery();
                if (r.next()) {
                    t.setId(r.getInt("id"));
                    t.setName(r.getString("Name"));
                    t.setSurname(r.getString("Surname"));
                    t.setAddress(r.getString("Address"));
                    t.setEmail(r.getString("Email"));

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
        return t;
    }
    
    
    
    
    @Override
    public boolean getUpdateTeacher(Teacher t, int id) throws Exception {
          
        Connection c = null;
        PreparedStatement ps = null;
        boolean result = false;
        
        String sql = " UPDATE teacher set  Name=?,Surname=?,Address=?,Email=?" + "where id=?";
        try {
            c = Db_Helper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, t.getName());
                ps.setString(2, t.getSurname());
                ps.setString(3, t.getAddress());
                ps.setString(4, t.getEmail());
                ps.setLong(5, id);

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
    public boolean deleteTeacher(int teacherId) throws Exception {
        
        Connection c = null;
        PreparedStatement ps = null;
        boolean result = false;
        
        String sql = " UPDATE teacher set active=0\r\n" + " where id=?\r\n";

        try {
            c = Db_Helper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, teacherId);

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
