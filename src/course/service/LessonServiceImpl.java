
package course.service;

import course.dao.LessonDaoInter;
import course.model.Lesson;
import java.util.List;


public class LessonServiceImpl implements LessonServiceInter{
    
    private LessonDaoInter lessonDaoInter;
    
    public LessonServiceImpl(LessonDaoInter lessonDaoInter){
        this.lessonDaoInter=lessonDaoInter; 
    }
    
    

    @Override
    public List<Lesson> getLessonList() throws Exception {
        return lessonDaoInter.getLessonList();
    }

    @Override
    public boolean addLesson(Lesson l) throws Exception {
        return lessonDaoInter.addLesson(l);
    }

    @Override
    public Lesson getLessonById(int id) throws Exception {
        return lessonDaoInter.getLessonById(id);
    }

    @Override
    public boolean getUpdateLesson(Lesson l, int id) throws Exception {
        return lessonDaoInter.getUpdateLesson(l, id);
    }

    @Override
    public boolean deleteLesson(int lessonId) throws Exception {
        return lessonDaoInter.deleteLesson(lessonId);
    }
    
    
}
