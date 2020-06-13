package estech.vmg.roomcontacts.Contacts;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contact")
public class Contact {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name,lastName,eMail;
    public int phone,age;
    public boolean favorite;
}
