package estech.vmg.roomcontacts.ContactsUI;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import estech.vmg.roomcontacts.Contacts.Contact;
import estech.vmg.roomcontacts.Contacts.ContactRepo;
import estech.vmg.roomcontacts.R;

public class ContactAdapter extends RecyclerView.Adapter<ContactHolder>{
    List<Contact> contacts;
    Context context;
    ContactRepo repo;
    public ContactAdapter(Context context, List<Contact> contacts){
        this.context=context;
        this.contacts=contacts;
        repo=new ContactRepo(context);
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactHolder holder;
        View v= LayoutInflater.from(context).inflate(R.layout.contact_item,parent,false);
        holder= new ContactHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        final Contact c = contacts.get(position);
        holder.tName.setText(String.format("%s %s", c.getFirstName(), c.getLastName()));
        holder.tPhone.setText(String.valueOf(c.getPhone()));
        holder.tRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Do you want to remove these contact?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                repo.deleteContact(c);
                                repo.getAllContacts().observe((LifecycleOwner) context, new Observer<List<Contact>>() {
                                    @Override
                                    public void onChanged(List<Contact> contacts) {
                                        updateList(contacts);
                                    }
                                });
                            }
                        })
                        .setNegativeButton("No",null)
                        .setCancelable(true).show();
            }
        });
    }



    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void updateList(List<Contact> contacts) {
        this.contacts = (List<Contact>) contacts;
        notifyDataSetChanged();
    }

}
