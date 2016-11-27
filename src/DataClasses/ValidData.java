package DataClasses;

/**
 * Created by kravlala on 20.11.16.
 */
import java.lang.String;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import com.google.appengine.api.datastore.Key;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class ValidData {

    //Persistent fields
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private String ID;

    @Persistent
    private String Password;

    public ValidData(){
        this.ID=new String();
        this.Password= new String();
    }

    public ValidData(String ID, String Password) {
        this.ID = ID;
        this.Password = Password;
    }

    // Accessors for the fields.
    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String getID(){
        return ID;
    }

    public void setID(String ID){
        this.ID=ID;
    }

    public String getPassword(){
        return this.Password;
    }

    public void setPassword(String Password){
        this.Password=Password;
    }

}
