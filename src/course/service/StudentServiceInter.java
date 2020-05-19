package course.service;

import course.model.Student;
import java.util.List;

public interface StudentServiceInter {

    public List<Student> getStudentList() throws Exception;

    public boolean addStudent(Student s) throws Exception;

    public Student getStudentById(Long id) throws Exception;

    public boolean getUpdateStudent(Student s, Long id) throws Exception;

    public boolean deleteStudent(Long studentId) throws Exception;

}
