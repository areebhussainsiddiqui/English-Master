package com.cognitive.englishmaster.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.cognitive.englishmaster.R;
import com.cognitive.englishmaster.model_classes.VocabularyDetail;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    final static private String DB_NAME = "English_DB";
    final static private int DB_VERSION = 1;

    final String table_name = "Vocabulary_Details";
    final String col_id = "id";
    final String col_vocabulary_title = "Vocabulary_Name";
    final String col_vocabulary_definition = "Vocabulary_Definition";
    final String col_vocabulary_example = "Vocabulary_Example";

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "create table " + table_name +
                "(" + col_id + " integer primary key AUTOINCREMENT, " + col_vocabulary_title + " text, "
                + col_vocabulary_definition + " text, " + col_vocabulary_example + " text)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + table_name);
        onCreate(db);
    }

    public long insert(VocabularyDetail vocab) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(col_vocabulary_title, vocab.getTitle());
        cv.put(col_vocabulary_definition, vocab.getDefinition());
        cv.put(col_vocabulary_example, vocab.getExample());

        long id = db.insert(table_name, null, cv);
        db.close();

        return id;

    }

    public List<VocabularyDetail> read() {
        List<VocabularyDetail> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from " + table_name + " order by " + col_vocabulary_title + " desc", null);

        if (cursor.moveToFirst()) {
            do {
                VocabularyDetail vocab = new VocabularyDetail();
          //      vocab.setIcon(R.drawable.rabbit_icon);
                vocab.setIcon(R.drawable.idea_icon);

                vocab.setTitle(cursor.getString(cursor.getColumnIndex(col_vocabulary_title)));
                vocab.setDefinition(cursor.getString(cursor.getColumnIndex(col_vocabulary_definition)));
                vocab.setExample(cursor.getString(cursor.getColumnIndex(col_vocabulary_example)));

                data.add(vocab);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return data;
    }

    public int update (int searchId, VocabularyDetail vocab)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(col_vocabulary_title, vocab.getTitle());
        cv.put(col_vocabulary_definition, vocab.getDefinition());
        cv.put(col_vocabulary_example, vocab.getExample());

        int updates = db.update(table_name, cv, col_id + " = ?", new String[]{String.valueOf(searchId)});
        db.close();

        return updates;
    }

    public int delete(int searchId)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        int deletes = db.delete(table_name, col_id + " = ?", new String[]{String.valueOf(searchId)});
        db.close();

        return deletes;
    }
}
