
package course.model;

public class Lesson extends CourseModel{
    
    private String Lesson_name;

    public String getLesson_name() {
        return Lesson_name;
    }

    public void setLesson_name(String Lesson_name) {
        this.Lesson_name = Lesson_name;
    }

    @Override
    public String toString() {
        return "Lesson{" + "Lesson_name=" + Lesson_name + '}';
    }

   

    
}
