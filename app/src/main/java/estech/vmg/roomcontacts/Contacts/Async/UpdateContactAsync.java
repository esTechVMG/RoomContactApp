package estech.vmg.roomcontacts.Contacts.Async;

import android.os.AsyncTask;

import estech.vmg.roomcontacts.Contacts.Contact;
import estech.vmg.roomcontacts.Contacts.ContactDao;

public class UpdateContactAsync extends AsyncTask<Contact,Void,Void> {
    private ContactDao dao;
    UpdateContactAsync(ContactDao dao){
        this.dao=dao;
    }
    @Override
    protected Void doInBackground(Contact... contacts) {
        dao.updateContact(contacts[0]);
        return null;
    }
}
