
package course.model;


public class Teacher extends CourseModel{
    
    private String Name;
    private String Surname;
    private String Address;
    private String Email;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Teacher{" + "Name=" + Name + ", Surname=" + Surname + ", Address=" + Address + ", Email=" + Email + '}';
    }
   
    
}
