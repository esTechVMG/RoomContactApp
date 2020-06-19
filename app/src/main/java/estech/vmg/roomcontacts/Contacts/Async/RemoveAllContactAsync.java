package estech.vmg.roomcontacts.Contacts.Async;

import android.os.AsyncTask;

import estech.vmg.roomcontacts.Contacts.ContactDao;

public class RemoveAllContactAsync extends AsyncTask<Void,Void,Void> {
    private ContactDao dao;
    public RemoveAllContactAsync(ContactDao dao){
        this.dao=dao;
    }
    @Override
    protected Void doInBackground(Void... voids) {
        dao.deleteAllContacts();
        return null;
    }
}
