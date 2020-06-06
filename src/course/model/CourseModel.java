
package course.model;

public class CourseModel {
    
    private int id;
    private int active;
    
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
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
