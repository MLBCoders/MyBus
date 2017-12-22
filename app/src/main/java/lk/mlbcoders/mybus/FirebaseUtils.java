package lk.mlbcoders.mybus;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by nirmal on 12/22/17.
 */

public class FirebaseUtils {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseRef = null;

    FirebaseUtils(String databaseRef){

    }

    public void setDatabaseRef(String databaseRef) {
        this.databaseRef = database.getReference(databaseRef);
    }

    public DatabaseReference getDatabaseRef() {
        return databaseRef;
    }
}
