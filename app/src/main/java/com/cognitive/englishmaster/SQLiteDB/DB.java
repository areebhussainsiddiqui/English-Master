package com.cognitive.englishmaster.SQLiteDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;
import com.cognitive.englishmaster.model_classes.Word_Model_Class;
import com.cognitive.englishmaster.model_classes.model_Question_class;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DB  extends SQLiteOpenHelper {


    public static String DATABASE = "English.db";
    //table Word
    private static String table_word = "word_table";
    private static String Col_Word_id = "id";
    private static String Col_Word = "Word";
    private static String Col_Word_Defination = "Defination";
    private static String Col_Word_Example = "Example";


    //table Category
    private static String Table_Category = "categories";
    private static String cat_id ="id";
    private static String cat_image = "cat_image";
    private static String cat_status = "cat_status";
    private static String cat_name = "cat_name";

    //table CategoryTable
    private static String categorytables = "categorytables";
    private static String cattab_id ="id";
    private static String catName = "catName";
    private static String catImage = "catImage";

    //table Image

    private static String Table_Image = "images";
    private static String TabI_Image_id ="id";
    private static String TabI_word_image_id ="word_image_id";
    private static String TabI_word_mob_image ="word_mob_image";
    private static String TabI_word_web_image ="word_web_image";
    private static String TabI_word_web_image_url ="word_web_image_url";

    //table SubCategory
    private static String Table_subcategories = "subcategories";
    private static String TabI__subcategories_id ="id";
    private static String TabI_subcat_image ="subcat_image";
    private static String TabI_cat_id ="cat_id";
    private static String subcat_name ="subcat_name";
    private static String subcat_status ="subcat_status";



    //table QUESTION ANSWER
    private static String table_question = "Question_No";
    private static String Col_queston_id = "Question_id";
    private static String Col_queston = "Question";
    private static String Col_Answer1 = "Answer_1";
    private static String Col_Answer2 = "Answer_2";
    private static String Col_Answer3 = "Answer_3";
    private static String Col_Answer4 = "Answer_4";
    private static String Col_Right_Answer = "Right_Answer";


    //Table Tarnslation
    private static String table_translations = "translations";
    private static String Col_translation_id = "id";
    private static String Col_word_id = "word_id";
    private static String Col_word_trans_name = "word_trans_name";
    private static String Col_trans_urdu = "trans_urdu";
    private static String Col_trans_roman_urdu = "trans_roman_urdu";
    private static String Col_trans_hindi = "trans_hindi";
    private static String Col_is_inserted_urdu = "is_inserted_urdu";
    private static String Col_is_inserted_hindi = "is_inserted_hindi";

    //Table Words
    private static String Table_words = "words";
    private static String TabI_words_id ="id";
    private static String word_name ="word_name";
    private static String word_urdu ="word_urdu";
    private static String word_defination ="word_defination";
    private static String word_sentence ="word_sentence";
    private static String subcat_id ="subcat_id";
    private static String is_inserted ="is_inserted";


    //Table Word Images
    private static String Table_word_images = "word_images";
    private static String TabI_word_Image_id ="id";
    private static String word_id ="word_id";
    private static String word_name_Image ="word_name";
    private static String is_insert ="is_insert";




    String word_table,Question_Answer;

    public DB(Context context) {
        super(context, DATABASE, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        word_table = "create table "
                + table_word + "(" + Col_Word_id + " integer primary key autoincrement, "
                + Col_Word + " Text not null, "
                + Col_Word_Defination + " Text not null, "
                + Col_Word_Example + " Text not null);";//, "
              //  + Col_Word_Image + " INTEGER );";


        Question_Answer = "create table "
                + table_question + "(" + Col_queston_id + " integer primary key autoincrement, "
                + Col_queston + " Text not null, "
                + Col_Answer1 + " Text not null, "
                + Col_Answer2 + " Text not null, "
                + Col_Answer3 + " Text not null, "
                + Col_Answer4 + " Text not null, "
                + Col_Right_Answer + " Text not null );";



        db.execSQL(word_table);
        db.execSQL(Question_Answer);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_word + " ;");
        db.execSQL("DROP TABLE IF EXISTS " + table_question + " ;");


        onCreate(db);
    }

    //WORD TABLE
    int id=0;
    public void Insert_Word( String Word,String Defination, String Examples ) {
        id=id+1;

        System.out.print("Hello " + word_table);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_Word_id, id);
        contentValues.put(Col_Word, Word);
        contentValues.put(Col_Word_Defination,Defination);
        contentValues.put(Col_Word_Example, Examples);
        db.insert(table_word,null, contentValues);

    }

    public List<Word_Model_Class> wordTable_getdata() {
        // DataModel dataModel = new DataModel();
        List<Word_Model_Class> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + table_word + " ;", null);
        StringBuffer stringBuffer = new StringBuffer();
        Word_Model_Class dataModel = null;
        if (cursor.moveToFirst()) {
            do {

                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String    word = cursor.getString(cursor.getColumnIndexOrThrow("Word"));
                String    word_Defination = cursor.getString(cursor.getColumnIndexOrThrow("Defination"));
                String    word_Example = cursor.getString(cursor.getColumnIndexOrThrow("Example"));
               // String    urdu_Meaning = cursor.getString(cursor.getColumnIndexOrThrow("Urdu_Meaning"));
             //   int    word_Image = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow("Word_Image")));
                dataModel = new Word_Model_Class();
                dataModel.setId(id);
                dataModel.setWord(word);
                dataModel.setDefination(word_Defination);
                dataModel.setExample(word_Example);
              //  dataModel.setUrdu_Meaning(urdu_Meaning);
              //  dataModel.setWord_Image(word_Image);
                stringBuffer.append(dataModel);

                // adding to todo list
                data.add(dataModel);
            } while (cursor.moveToNext());
        }

        return data;
    }
    Context context;

    public int Delete_Word(int id){
        SQLiteDatabase db = getWritableDatabase();
        String where="ID=?";
        int numberOFEntriesDeleted= db.delete(table_word, where, new String[]{String.valueOf(id)}) ;
        Toast.makeText(context,"Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted,Toast.LENGTH_SHORT).show();
        return numberOFEntriesDeleted;
    }


    //QUESTION TABLE
    public void Insert_Quest_n_Ans( String Question,String Ans1, String Ans2, String Ans3,  String Ans4, String RightAns ) {
        id=id+1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_queston_id, id);
        contentValues.put(Col_queston, Question);
        contentValues.put(Col_Answer1,Ans1);
        contentValues.put(Col_Answer2, Ans2);
        contentValues.put(Col_Answer3,Ans3);
        contentValues.put(Col_Answer4,Ans4);
        contentValues.put(Col_Right_Answer,RightAns);
        db.insert(table_word,null, contentValues);

    }

    public List<model_Question_class> Question_getdata() {
        List<model_Question_class> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + table_question + " ;", null);
        StringBuffer stringBuffer = new StringBuffer();
        model_Question_class dataModel = null;
        if (cursor.moveToFirst()) {
            do {

                id = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow("Question_id")));
                String    Question = cursor.getString(cursor.getColumnIndexOrThrow("Question"));
                String    Answer_1 = cursor.getString(cursor.getColumnIndexOrThrow("Answer_1"));
                String    Answer_2 = cursor.getString(cursor.getColumnIndexOrThrow("Answer_2"));
                String    Answer_3 = cursor.getString(cursor.getColumnIndexOrThrow("Answer_3"));
                String    Answer_4 = cursor.getString(cursor.getColumnIndexOrThrow("Answer_4"));
                String    Right_Answer = cursor.getString(cursor.getColumnIndexOrThrow("Right_Answer"));
                dataModel = new model_Question_class();
                dataModel.setId(id);
                dataModel.setQuestion(Question);
                dataModel.setAns1(Answer_1);
                dataModel.setAns2(Answer_2);
                dataModel.setAns3(Answer_3);
                dataModel.setAns4(Answer_4);
                dataModel.setRightAns(Right_Answer);
                stringBuffer.append(dataModel);

                // adding to todo list
                data.add(dataModel);
            } while (cursor.moveToNext());
        }


        for (model_Question_class mo : data) {

            Log.i("Hellomo", "" + mo.getQuestion());
        }

        return data;
    }


}
