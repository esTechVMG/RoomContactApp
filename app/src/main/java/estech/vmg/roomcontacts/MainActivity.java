package estech.vmg.roomcontacts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import estech.vmg.roomcontacts.Contacts.Contact;
import estech.vmg.roomcontacts.Contacts.ContactDatabase;
import estech.vmg.roomcontacts.Contacts.ContactRepo;
import estech.vmg.roomcontacts.ContactsUI.ContactAdapter;

public class MainActivity extends AppCompatActivity {

    ContactDatabase database;
    ArrayList<Contact> contactArrayList= new ArrayList<>();
    FloatingActionButton addButton;
    RecyclerView recyclerView;
    LinearLayoutManager llm;
    ContactAdapter adapter;
    ContactRepo repo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repo=new ContactRepo(this);

        recyclerView=findViewById(R.id.contact_recycler);
        addButton=findViewById(R.id.addContact);
        database = ContactDatabase.getDatabase(MainActivity.this);
        llm= new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(llm);
        adapter = new ContactAdapter(this,contactArrayList);
        recyclerView.setAdapter(adapter);
        Contact test=new Contact();
        repo.getAllContacts().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contacts) {
                adapter.updateList(contacts);
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getBaseContext(),CreateContactActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.fav_item:
                item.setChecked(!item.isChecked());
                if(item.isChecked()){
                    repo.getFavoriteContacts().observe(this, new Observer<List<Contact>>() {
                        @Override
                        public void onChanged(List<Contact> contacts) {
                            adapter.updateList(contacts);
                        }
                    });
                }else{
                    loadDatabase();
                }
                break;
            case R.id.remove_all:
                new AlertDialog.Builder(this)
                        .setTitle("Do you want to remove all contacts")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                repo.deleteAllContacts();
                                loadDatabase();
                            }
                        })
                        .setNegativeButton("No",null)
                        .setCancelable(true).show();
                break;
            default:
                Log.d("RoomContacts","Unexpected error");
        }
        return true;
    }
    public void loadDatabase(){
        repo.getAllContacts().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contacts) {
                adapter.updateList(contacts);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDatabase();
    }
}