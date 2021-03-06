package covuni.a300cemcovunistudenthelper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import covuni.a300cemcovunistudenthelper.Db.DbContract;
import covuni.a300cemcovunistudenthelper.Db.DbHelper;

/**
 * Created by Holmesy on 09/12/2017.
 */

public class OfflineNotesAdd extends AppCompatActivity {


    private EditText moduleEditText;
    private EditText revNotesEditText;
    String moduleString, revNoteString;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offline_notes_add);
        moduleEditText = (EditText) findViewById(R.id.edit_text_module);
        revNotesEditText = (EditText) findViewById(R.id.edit__text_revnotes);
    }

    /*
    Method to insert values into the DB
    Get the input
    create the Db helper and get it into write mode
     */

    private void insertNote() {
         moduleString = moduleEditText.getText().toString().trim();
         revNoteString = revNotesEditText.getText().toString().trim();

        //instantiate the subclass of SQLiteOpenHelper
        dbHelper = new DbHelper(this);

        // Get the database in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //create a new map of vaules, where the column names are the keys

        ContentValues values = new ContentValues();
        values.put(DbContract.OfflineNotes.COLUMN_MODULE, moduleString);
        values.put(DbContract.OfflineNotes.COLUMN_REVNOTES, revNoteString);


        // Insert a new row , return primary key value of the new row
        long newRowId = db.insert(DbContract.OfflineNotes.TABLE_NAME, null, values);

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.offline_add, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.save:

                insertNote();

                finish();
                return true;

            case android.R.id.home:

                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);









    }


}







