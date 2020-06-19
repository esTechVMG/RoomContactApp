package estech.vmg.roomcontacts.Contacts;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "contact")
public class Contact {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String firstName;
    private String lastName;
    private String eMail;
    private int phone;
    private int age;
    private boolean favorite;

    public Contact(String firstName, String lastName, String eMail, int phone, int age, boolean favorite){
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.phone = phone;
        this.age = age;
        this.favorite = favorite;
    }
    @Ignore
    public Contact(){
        firstName="First Name";
        lastName="Last Name";
        eMail="example@test.com";
        phone=0;
        favorite=false;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public int getPhone() {
        return phone;
    }

    public String getEMail() {
        return eMail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public boolean isFavorite() {
        return favorite;
    }
}
