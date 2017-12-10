package covuni.a300cemcovunistudenthelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import covuni.a300cemcovunistudenthelper.Db.DbContract;
import covuni.a300cemcovunistudenthelper.Db.DbHelper;

import static org.junit.Assert.assertTrue;

/**
 * Created by Holmesy on 10/12/2017.
 */


/*
SqLite test to insert into the offline notes DB.
 */

@RunWith(MockitoJUnitRunner.class)
public class MySqlLiteUnitTest {

    private static String moduleName;
    private static String moduleNote;
    @Mock
    Context context;
    private static long dbAssignId;

    @Test
    public void testDatabase() throws Exception   {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
       moduleName = "300cem";
       moduleNote = "Test";

        ContentValues values = new ContentValues();
        values.put(DbContract.OfflineNotes.COLUMN_MODULE, moduleName);
        values.put(DbContract.OfflineNotes.COLUMN_REVNOTES, moduleNote);

        dbAssignId = db.insert(DbContract.OfflineNotes.TABLE_NAME, null, values);
        assertTrue(dbAssignId != -1);


    }




}
