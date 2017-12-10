package covuni.a300cemcovunistudenthelper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

import covuni.a300cemcovunistudenthelper.Db.DbContract;
import covuni.a300cemcovunistudenthelper.Db.DbHelper;

import static covuni.a300cemcovunistudenthelper.Db.DbContract.OfflineNotes.TABLE_NAME;
import static covuni.a300cemcovunistudenthelper.Db.DbContract.OfflineNotes._ID;

/**
 * Created by Holmesy on 09/12/2017.
 */

public class OfflineNotesAdapter extends CursorAdapter {

     DbHelper dbHelper;
     Context context;


/*
Gets the context and the cursor to get the data
 */

    public OfflineNotesAdapter (Context context, Cursor cursor){
        super(context,cursor,0);
        this.context = context;
        dbHelper = new DbHelper(context);

    }



    @Override
    public View newView  (Context context, Cursor cursor, ViewGroup parent){
        return LayoutInflater.from(context).inflate(R.layout.notes_list,parent,false);

    }

    /*
    Method to bind data to list item
     */


    @Override
    public void bindView(View view, Context context, Cursor cursor){

        // views we want to modify
        TextView nameTextView = (TextView) view.findViewById(R.id.name);
        TextView summaryTextView  = (TextView) view.findViewById(R.id.summary);
        Button delete = (Button) view.findViewById(R.id.deleteNote);


        // Find the columns of note attributes that we're interested in
        int moduleColumnIndex = cursor.getColumnIndex(DbContract.OfflineNotes.COLUMN_MODULE);
        int revNoteColumnIndex = cursor.getColumnIndex(DbContract.OfflineNotes.COLUMN_REVNOTES);
        int idColumnIndex = cursor.getColumnIndex(_ID);

        // Read the note attributes from the Cursor for the current note
        String moduleName = cursor.getString(moduleColumnIndex);
        String moduleNote = cursor.getString(revNoteColumnIndex);
        final String rowId = cursor.getString(idColumnIndex);

        // Update the views with the attributes for the current note
        nameTextView.setText(moduleName);
        summaryTextView.setText(moduleNote);


        //Anonymous class to delete a given row, upon selected the image in that row
        //dialog pops up asking to confirm delete, options for yes and no


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Delete record?");

                /*
                if click delete, get DB in writable mode
                perform deletion
                notify the data set has changed
                perform quesry to get updated
                change cursor and close connection
                 */

                builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        db.delete(TABLE_NAME, "_id" + "=" + rowId, null);
                        notifyDataSetChanged();
                        Cursor cursor = db.rawQuery("SELECT rowid _id,* FROM offlinenotes", null);
                        changeCursor(cursor);
                        db.close();
                    }
                });

                // if click cancel simply dismiss

                builder.setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        if (dialog != null) {
                            dialog.dismiss();
                        }

                    }
                });


                AlertDialog alertDialog = builder.create();
                alertDialog.show();


            }


        });


    }
}





