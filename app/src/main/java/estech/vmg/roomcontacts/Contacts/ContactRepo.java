package estech.vmg.roomcontacts.Contacts;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ContactRepo implements ContactDao{
    private ContactDao contactDao;
    private ContactDatabase contactDatabase;
    public ContactRepo(Context c){
        contactDatabase=ContactDatabase.getDatabase(c);
        contactDao=contactDatabase.userDao();
    }


    @Override
    public void addContact(Contact contact) {
        contactDao.addContact(contact);
    }

    @Override
    public void updateContact(Contact contact) {
        contactDao.updateContact(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        contactDao.deleteContact(contact);
    }

    @Override
    public void deleteAllContacts() {
        contactDao.deleteAllContacts();
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactDao.getAllContacts();
    }

    @Override
    public List<Contact> searchContact(String search) {
        return contactDao.searchContact(search);
    }
}
