package estech.vmg.roomcontacts.Contacts.Async;

import android.os.AsyncTask;

import estech.vmg.roomcontacts.Contacts.Contact;
import estech.vmg.roomcontacts.Contacts.ContactDao;

public class AddContactAsync extends AsyncTask<Contact,Void,Void> {
    private ContactDao dao;
    AddContactAsync(ContactDao dao){
        this.dao=dao;
    }
    @Override
    protected Void doInBackground(Contact... contacts) {
        dao.addContact(contacts[0]);
        return null;
    }
}
