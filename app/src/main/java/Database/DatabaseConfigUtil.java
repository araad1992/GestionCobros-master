package Database;

import java.io.IOException;
import java.sql.SQLException;

import static com.j256.ormlite.android.apptools.OrmLiteConfigUtil.writeConfigFile;

/**
 * Created by ingan on 21/10/2017.
 */

public class DatabaseConfigUtil {

    public static void main(String[] args)throws IOException, SQLException {
        writeConfigFile("ormlite_config.txt");
    }
}
