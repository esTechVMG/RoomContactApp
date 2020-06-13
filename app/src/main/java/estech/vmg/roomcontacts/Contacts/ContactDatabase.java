package estech.vmg.roomcontacts.Contacts;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class},version = 1)
public abstract class ContactDatabase  extends RoomDatabase {
    public static final String DB_NAME="db_contact";
    public static ContactDatabase instance;
    public abstract ContactDao userDao();
    public static ContactDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (ContactDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context,
                            ContactDatabase.class, DB_NAME)
                            .build();
                }
            }
        }
        return instance;
    }

}
