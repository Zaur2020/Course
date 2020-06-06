
package course.model;

import java.sql.Date;

public class Payment extends CourseModel{
    
    private Student studentid;
    private Teacher teacherid;
    private Lesson lessonid;
    private Integer amount;
    private Date startdate;
    private Date enddate;

    public Student getStudentid() {
        return studentid;
    }

    public void setStudentid(Student studentid) {
        this.studentid = studentid;
    }

    public Teacher getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Teacher teacherid) {
        this.teacherid = teacherid;
    }

    public Lesson getLessonid() {
        return lessonid;
    }

    public void setLessonod(Lesson lessonid) {
        this.lessonid = lessonid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @Override
    public String toString() {
        return "Payment{" + "studentid=" + studentid + ", teacherid=" + teacherid + ", lessonid=" + lessonid + ", amount=" + amount + ", startdate=" + startdate + ", enddate=" + enddate + '}';
    }
    
    
    
    
    
}
