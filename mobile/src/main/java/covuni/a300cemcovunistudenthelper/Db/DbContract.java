package covuni.a300cemcovunistudenthelper.Db;

import android.provider.BaseColumns;

/**
 * Created by Holmesy on 09/12/2017.
 */

public class DbContract {
    private DbContract(){}


    /*
    By implementing the Base columns, the inner class inherits key field called _ID
    Cursor Adapter classes will expect to have.
     */

    public static final class OfflineNotes implements BaseColumns{

        /**
         * The Db Table / defines the table contents
         */

        public final static String TABLE_NAME = "offlinenotes";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_MODULE = "module";
        public final static String COLUMN_REVNOTES = "revnotes";


    }


}
