package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(0001,'Mohit Kirange', 'mohitkk@gmail.com','7584','7788621490', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(0002,'Aaditya Burujwale', 'aadi156@gmail.com','1258','9155641238', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(0003,'Sourabh Dalal', 'sourdal@gmail.com','8896','8595645800', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(0004,'Vikram Batra', 'shershaah@gmail.com','7752','9865279952', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(0005,'Sweta Patel', 'swetpatel@gmail.com','3669','8965163651', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(0006,'Roshan Verma', 'roshans@gmail.com','9985','6902640238', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(0007,'Sana Shaikh', 'sanass@gmail.com','1207','8099665730', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(0008,'Ujjwal Nautiyal', 'ujjwalnautiyal@gmail.com','4522','9812357005', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(0009,'Ritik Sharma', 'ritik@gmail.com','6582','9309565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(0010,'Yashpal Jammwal', 'Yashjammwal@gmail.com','5450','8292591201', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(0011,'Anuja Sharma', 'anusharma@gmail.com','2656','9015641200', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(0012,'Gitesh Chaudhari', 'gitish@gmail.com','1203','9995641999', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(0013,'Sagar Bonde', 'sagarb@gmail.com','5566','8119541401', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(0014,'Himali Reddy', 'reddyhimali@gmail.com','2236','9998362205', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(0015,'John Doe', 'johndoe@gmail.com','6692','8900341266', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}