
package course.model;

public class CourseModel {
    
    private Long id;
    private int active;
    
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id=id;
    }
    
    public int getActive(){
        return active;
    }
    
    public  void setActive(int active){
        this.active=active;
    }

    @Override
    public String toString() {
        return "CourseModel{" + "id=" + id + ", active=" + active + '}';
    }
    
    
    
            
    
    
}
