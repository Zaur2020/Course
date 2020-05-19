
package course.model;

public class Student extends CourseModel{
    
    private String Name;
    private String Surname;
    private String Address;
    private String Email;
    private int Contact;
    
    
    public String getName(){
        return Name;
    }
    
    public void setName(String name){
        this.Name=name;
    }
    
    public String getSurname(){
        return Surname;
    }
    
    public void setSurname(String surname){
        this.Surname=surname;
    }
    
    public String getAddress(){
        return Address;
    }
    
    public void setAddress(String address){
        this.Address=address;
    }
    
    public String getEmail(){
        return Email;
    }
    
    public void setEmail(String email){
        this.Email=email;
    }
    
    public int getContact(){
        return Contact;
    }
    
    public void setContact(int contact){
        this.Contact=contact;
    }

    @Override
    public String toString() {
        return "Student{" + "Name=" + Name + ", Surname=" + Surname + ", Address=" + Address + ", Email=" + Email + ", Contact=" + Contact + '}';
    }
    
    
   
}
