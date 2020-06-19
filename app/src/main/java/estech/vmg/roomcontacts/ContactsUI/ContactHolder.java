package estech.vmg.roomcontacts.ContactsUI;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import estech.vmg.roomcontacts.R;

public class ContactHolder extends RecyclerView.ViewHolder {
    TextView tName,tPhone;
    Button tRemove;
    public ContactHolder(@NonNull View itemView) {
        super(itemView);
        tName= itemView.findViewById(R.id.contact_name);
        tPhone=itemView.findViewById(R.id.contact_phone);
        tRemove=itemView.findViewById(R.id.contact_remove);
    }
}
