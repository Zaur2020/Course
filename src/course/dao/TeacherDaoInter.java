
package course.dao;

import course.model.Teacher;
import java.util.List;


public interface TeacherDaoInter {
    
    public List <Teacher> getTeacherList()throws Exception;
    
    public boolean addTeacher(Teacher t)throws Exception;
    
    public Teacher getTeacherById(int id)throws Exception;
    
    public boolean getUpdateTeacher(Teacher t, int id)throws Exception;
    
    public boolean deleteTeacher(int teacherId)throws Exception;
}
