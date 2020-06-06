
package course.dao;

import course.model.Lesson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zbnf8
 */
public class LessonDaoImpl implements LessonDaoInter{
    private Object lessontlist;

    @Override
    public List<Lesson> getLessonList() throws Exception {
        
        List<Lesson> lessonlist = new ArrayList<Lesson>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet r = null;
        

        String sql = "select id, Lesson_name from lesson where active =1;";

        try {
            c = Db_Helper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                r = ps.executeQuery();
                while (r.next()) {
                    Lesson l = new Lesson();
                    l.setId(r.getInt("id"));
                    l.setLesson_name(r.getString("Lesson_name"));

                    lessonlist.add(l);
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
        return lessonlist;
    }
    
    
    @Override
    public boolean addLesson(Lesson l) throws Exception {
        
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;

        String sql = "INSERT into lesson (Lesson_name)\r\n" + "values(?)";

        try {
            c = Db_Helper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, l.getLesson_name());
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
    public Lesson getLessonById(int id) throws Exception {
        
        Lesson l = new Lesson();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet r = null;

        String sql = "SELECT id,Lesson_name from lesson where active=1 and id=?;";

        try {
            c = Db_Helper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, id);
                r = ps.executeQuery();
                if (r.next()) {
                    l.setId(r.getInt("id"));
                    l.setLesson_name(r.getString("Lesson_name"));

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
        return l;
    }

    @Override
    public boolean getUpdateLesson(Lesson l, int id) throws Exception {
        
        Connection c = null;
        PreparedStatement ps = null;
        boolean result = false;
        
        String sql = " UPDATE lesson set  Lesson_name=?" + "where id=?";
        try {
            c = Db_Helper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, l.getLesson_name());
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
    public boolean deleteLesson(int lessonId) throws Exception {
        
        Connection c = null;
        PreparedStatement ps = null;
        boolean result = false;
        
        String sql = " UPDATE student set active=0\r\n" + " where id=?\r\n";

        try {
            c = Db_Helper.getconnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, lessonId);

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
