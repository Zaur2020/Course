
package course.service;

import course.dao.TeacherDaoInter;
import course.model.Teacher;
import java.util.List;

public class TeacherServiceImpl implements TeacherServiceInter{
    
    private TeacherDaoInter teacherdaointer;
    
    public TeacherServiceImpl(TeacherDaoInter teacherdaointer){
        this.teacherdaointer=teacherdaointer;
    }

    @Override
    public List<Teacher> getTeacherList() throws Exception {
      return teacherdaointer.getTeacherList();
    }

    @Override
    public boolean addTeacher(Teacher t) throws Exception {
        return teacherdaointer.addTeacher(t);
    }

    @Override
    public Teacher getTeacherById(int id) throws Exception {
        return teacherdaointer.getTeacherById(id);
    }

    @Override
    public boolean getUpdateTeacher(Teacher t, int id) throws Exception {
        return teacherdaointer.getUpdateTeacher(t, id);
    }

    @Override
    public boolean deleteTeacher(int teacherId) throws Exception {
        return teacherdaointer.deleteTeacher(teacherId);
    }
    
    
    
}
