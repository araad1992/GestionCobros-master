package Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import Models.Client;
import Models.User;

/**
 * Created by ingan on 21/10/2017.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "gestioncobros.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<Client, Integer> clientDao = null;
    private RuntimeExceptionDao<Client, Integer> clientRuntimeDao = null;

    private Dao<User, Integer> userDao = null;
    private RuntimeExceptionDao<User, Integer> userRuntimeDao = null;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource source) {
        try {
            TableUtils.createTable(source, User.class);
            TableUtils.createTable(source, Client.class);
        } catch (SQLException sqlEx) {
            Log.e("Helper onCreate", "Error: " + sqlEx.getMessage());
            throw new RuntimeException(sqlEx);
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource source, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(source, User.class, true);
            TableUtils.dropTable(source, Client.class, true);
            onCreate(database, source);
        } catch (SQLException sqlEx) {
            Log.e(DatabaseHelper.class.getSimpleName(), "Imposible eliminar la base de datos", sqlEx);
        }
    }

    public void onResetDataBase(){
        try {
            //Se eliminan las tablas existentes
            ConnectionSource source = this.getConnectionSource();
            TableUtils.dropTable(source, User.class, true);
            TableUtils.dropTable(source, Client.class, true);
            //Recreacion de las tablas
            TableUtils.createTable(source, User.class);
            TableUtils.createTable(source, Client.class);
        }catch (SQLException sqlEx){
            Log.e("Helper onResetDataBase", "Error: " + sqlEx.getMessage());
            throw new RuntimeException(sqlEx);
        }
    }

    public void close(){
        super.close();
        clientDao = null;
        clientRuntimeDao = null;
        userDao = null;
        userRuntimeDao = null;
    }

    public Dao<Client, Integer> getClientDao() throws SQLException {
        if(clientDao == null) clientDao = getDao(Client.class);
        return clientDao;
    }

    public RuntimeExceptionDao<Client, Integer> getClientRuntimeDao() {
        if(clientRuntimeDao == null) clientRuntimeDao = getRuntimeExceptionDao(Client.class);
        return clientRuntimeDao;
    }

    public Dao<User, Integer> getUserDao() throws SQLException {
        if(userDao == null) userDao = getDao(User.class);
        return userDao;
    }

    public RuntimeExceptionDao<User, Integer> getUserRuntimeDao() {
        if(userRuntimeDao == null) userRuntimeDao = getRuntimeExceptionDao(User.class);
        return userRuntimeDao;
    }
}
