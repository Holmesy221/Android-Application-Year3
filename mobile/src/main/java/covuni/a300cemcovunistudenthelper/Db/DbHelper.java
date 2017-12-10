package covuni.a300cemcovunistudenthelper.Db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static covuni.a300cemcovunistudenthelper.Db.DbContract.OfflineNotes.TABLE_NAME;

/**
 * Created by Holmesy on 09/12/2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    //db name
    private static final String DATABASE_NAME = "personalnotes.db";

    // id
    private static final String _ID = "_id";

    //db version
    private static final int DATABASE_VERSION = 1;



    /*
    Creating the DB table
     */

    public DbHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String SQL_CREATE_NOTES_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + _ID + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DbContract.OfflineNotes.COLUMN_MODULE + " TEXT NOT NULL, "
                + DbContract.OfflineNotes.COLUMN_REVNOTES + " TEXT);";
        sqLiteDatabase.execSQL(SQL_CREATE_NOTES_TABLE);
    }


    /*
    upgrades the Db, if we change schema etc.
     */
    @Override
    public void onUpgrade (SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){

    }




}
