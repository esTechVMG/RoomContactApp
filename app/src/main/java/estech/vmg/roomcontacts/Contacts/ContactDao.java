package estech.vmg.roomcontacts.Contacts;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import estech.vmg.roomcontacts.Contacts.Contact;

@Dao
public interface ContactDao {
    @Insert
    void addContact(Contact contact);

    @Update
    void updateContact(Contact contact);

    @Delete
    void deleteContact(Contact contact);

    @Query("DELETE FROM contact")
    void deleteAllContacts();

    @Query("SELECT * FROM contact")
    List<Contact> getAllContacts();

    @Query("SELECT * FROM contact WHERE name LIKE :search OR lastName LIKE :search")
    List<Contact> searchContact(String search);


}
