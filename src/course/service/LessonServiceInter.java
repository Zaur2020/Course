
package course.service;

import course.model.Lesson;
import course.model.Student;
import java.util.List;

public interface LessonServiceInter {
    
    public List <Lesson> getLessonList()throws Exception;
    
    public boolean addLesson(Lesson l)throws Exception;
    
    public Lesson getLessonById(int id)throws Exception;
    
    public boolean getUpdateLesson(Lesson l, int id)throws Exception;
    
    public boolean deleteLesson(int lessonId)throws Exception;
    
    
}
