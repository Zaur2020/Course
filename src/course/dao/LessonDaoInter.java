
package course.dao;

import course.model.Lesson;
import java.util.List;

public interface LessonDaoInter {
    
    public List <Lesson> getLessonList()throws Exception;
    
    public boolean addLesson(Lesson l)throws Exception;
    
    public Lesson getLessonById(int id)throws Exception;
    
    public boolean getUpdateLesson(Lesson s, int id)throws Exception;
    
    public boolean deleteLesson(int lessonId)throws Exception;
    
    
}
