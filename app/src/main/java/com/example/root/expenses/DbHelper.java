package com.example.root.expenses;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17/5/17.
 */
public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME="expense";
    public static final int Version=1;
    public static final String EXPENSES="expenses";
    public static final String SUBJECT="subject";
    public static final String DESCRIPTION="description";
    public static final String MONEY="money";
    public static final String DATE="date";
    public DbHelper(Context context) {
        super(context, DB_NAME, null, Version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String expenses="create table "+EXPENSES+" ( "+SUBJECT+" text, "+DESCRIPTION+" text, "+MONEY+" text, "+DATE+" text)";
        db.execSQL(expenses);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + EXPENSES);
        onCreate(db);
    }
    public void addExpense(String tit,String des,String mon,String dat) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SUBJECT, tit);
        values.put(DESCRIPTION, des);
        values.put(MONEY, mon);
        values.put(DATE, dat);

        // Inserting Row
        db.insert(EXPENSES, null, values);
        db.close();

    }

    // Getting single contact
    public Expense getExpense(int id) {

        return null;
    }

    // Getting All Contacts
    public List<Expense> getAllExpenses() {

        List<Expense> expenseList = new ArrayList<Expense>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + EXPENSES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Expense expense = new Expense();
                expense.setSubject(cursor.getString(0));
                expense.setDescription(cursor.getString(1));
                expense.setMoneyPaid(cursor.getString(2));
                expense.setDate(cursor.getString(3));
                // Adding contact to list
                expenseList.add(expense);
            } while (cursor.moveToNext());
        }
       // expenseList.add(new Expense("Example","example","300","20-05-17"));

        // return contact list
        return expenseList;
    }

    // Getting contacts Count
    public int getExpenseCount() {

        String countQuery = "SELECT  * FROM " + EXPENSES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}
