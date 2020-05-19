package course.service;

import course.dao.StudentDaoInter;
import course.model.Student;
import java.util.List;

public class StudentServiceImpl implements StudentServiceInter {

    private StudentDaoInter studentdaointer;

    public StudentServiceImpl(StudentDaoInter studentdaointer) {
        this.studentdaointer = studentdaointer;
    }

    @Override
    public List<Student> getStudentList() throws Exception {
        return studentdaointer.getStudentList();
    }
    @Override
    public boolean addStudent(Student s) throws Exception {
        return studentdaointer.addStudent(s);
    }

    @Override
    public Student getStudentById(Long id) throws Exception {
        return studentdaointer.getStudentById(id);
    }

    @Override
    public boolean getUpdateStudent(Student s, Long id) throws Exception {

        return studentdaointer.getUpdateStudent(s, id);
    }

    @Override
    public boolean deleteStudent(Long studentId) throws Exception {

        return studentdaointer.deleteStudent(studentId);
    }

    

}
