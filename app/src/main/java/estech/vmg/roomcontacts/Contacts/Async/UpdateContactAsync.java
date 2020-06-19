package estech.vmg.roomcontacts.Contacts.Async;

import android.os.AsyncTask;

import estech.vmg.roomcontacts.Contacts.Contact;
import estech.vmg.roomcontacts.Contacts.ContactDao;

public class UpdateContactAsync extends AsyncTask<Contact,Void,Void> {
    private ContactDao dao;
    public UpdateContactAsync(ContactDao dao){
        this.dao=dao;
    }
    @Override
    protected Void doInBackground(Contact... contacts) {
        for(Contact a: contacts){
            dao.updateContact(a);
        }
        return null;
    }
}
