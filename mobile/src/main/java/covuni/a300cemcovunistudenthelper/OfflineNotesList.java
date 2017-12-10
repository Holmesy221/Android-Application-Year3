package covuni.a300cemcovunistudenthelper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import covuni.a300cemcovunistudenthelper.Db.DbContract;
import covuni.a300cemcovunistudenthelper.Db.DbHelper;

import static covuni.a300cemcovunistudenthelper.Db.DbContract.OfflineNotes.TABLE_NAME;

/**
 * Created by Holmesy on 09/12/2017.
 */

public class OfflineNotesList extends AppCompatActivity {

    private DbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offline_notes_list);


        /*
        Floating Action Button on click listener to add a note
         */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.bringToFront();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OfflineNotesList.this, OfflineNotesAdd.class);
                startActivity(intent);
            }
        });

        // To access the database, instantiate the subclass of SQLiteOpenHelper:

                dbHelper = new DbHelper(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }

    /*
    Method to display the data
    Here we get the DB in read mode
    Define column projection
    quesrys the Db table and finally displays it in the listview.
     */


    private void displayDatabaseInfo() {
        //Get the Db is read mode
        SQLiteDatabase db = dbHelper.getReadableDatabase();



        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                DbContract.OfflineNotes._ID,
                DbContract.OfflineNotes.COLUMN_MODULE,
                DbContract.OfflineNotes.COLUMN_REVNOTES,
        };

        // Querys the DB table
        Cursor cursor = db.rawQuery(
                "SELECT rowid _id,* FROM offlinenotes", null);

        // find the Listview to populate
        ListView noteListView = (ListView) findViewById(R.id.list);
        //setup cursor adapter
        OfflineNotesAdapter adapter = new OfflineNotesAdapter(this, cursor);
        // attaches cursor adapter to listview
        noteListView.setAdapter(adapter);
        //change to new cursor , update listview
        adapter.changeCursor(cursor);


    }

    /*
        A method to delete all notes
         */
    public void deleteAllNotes() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.offline_notes, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_delete_all_entries:
                deleteAllNotes();
                displayDatabaseInfo();
                return true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}




