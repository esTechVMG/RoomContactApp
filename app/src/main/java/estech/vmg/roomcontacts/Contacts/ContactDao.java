package estech.vmg.roomcontacts.Contacts;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

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
    LiveData<List<Contact>> getAllContacts();

    @Query("SELECT * FROM contact where favorite = 1")
    LiveData<List<Contact>> getFavoriteContacts();

    /*@Query("SELECT * FROM contact WHERE firstName LIKE :search OR lastName LIKE :search")
    LiveData<List<Contact>> searchContact(String search);*/
}
