package estech.vmg.roomcontacts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import estech.vmg.roomcontacts.Contacts.Contact;
import estech.vmg.roomcontacts.Contacts.ContactRepo;

public class CreateContactActivity extends AppCompatActivity {
    EditText first,last,phone,email,age;
    CheckBox fav;
    Button addButton;
    ContactRepo repo;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_add);
        repo= new ContactRepo(this);
        first=findViewById(R.id.firstNameInput);
        last=findViewById(R.id.lastNameInput);
        age=findViewById(R.id.ageInput);
        phone=findViewById(R.id.phoneInput);
        email=findViewById(R.id.mailInput);
        fav=findViewById(R.id.favCheckBox);
        addButton=findViewById(R.id.addContactButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String
                        firstName=first.getText().toString(),
                        lastName=last.getText().toString(),
                        eMail=email.getText().toString();
                int
                        phoneNum=Integer.parseInt(0 + phone.getText().toString()),
                        ageNum=Integer.parseInt(0 + age.getText().toString());
                if(firstName.isEmpty()){
                    Toast toast=Toast. makeText(getApplicationContext(),"Please enter a name", Toast. LENGTH_SHORT);
                }else{
                    repo.addContact(new Contact(firstName,lastName,eMail,phoneNum,ageNum,fav.isChecked()));
                    finish();
                }
            }
        });
    }
}
