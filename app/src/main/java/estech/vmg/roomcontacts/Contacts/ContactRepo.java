package estech.vmg.roomcontacts.Contacts;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import estech.vmg.roomcontacts.Contacts.Async.AddContactAsync;
import estech.vmg.roomcontacts.Contacts.Async.RemoveAllContactAsync;
import estech.vmg.roomcontacts.Contacts.Async.RemoveContactAsync;
import estech.vmg.roomcontacts.Contacts.Async.UpdateContactAsync;

public class ContactRepo implements ContactDao{
    private ContactDao contactDao;
    private ContactDatabase contactDatabase;
    public ContactRepo(Context context){
        contactDatabase=ContactDatabase.getDatabase(context);
        contactDao=contactDatabase.userDao();
    }
    @Override
    public void addContact(Contact contact) {
        new AddContactAsync(contactDao).execute(contact);
    }

    @Override
    public void updateContact(Contact contact) {
        new UpdateContactAsync(contactDao).execute(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        new RemoveContactAsync(contactDao).execute(contact);
    }

    @Override
    public void deleteAllContacts() {
        new RemoveAllContactAsync(contactDao).execute();
    }
    @Override
    public LiveData<List<Contact>> getAllContacts() {
        return contactDao.getAllContacts();
    }

    @Override
    public LiveData<List<Contact>> getFavoriteContacts() {
        return contactDao.getFavoriteContacts();
    }
}
