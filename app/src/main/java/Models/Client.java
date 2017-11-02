package Models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by ingan on 21/10/2017.
 */

@DatabaseTable(tableName = "client")
public class Client {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String name;
    @DatabaseField(canBeNull = false)
    private String lastname;
    @DatabaseField(canBeNull = false)
    private int identification;
    @DatabaseField(canBeNull = false)
    private int status;

    public Client() {
    }

    public Client(int id, String name, String lastname, int identification, int status) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.identification = identification;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getIdentification() {
        return identification;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", identification=" + identification +
                ", status=" + status +
                '}';
    }
}
