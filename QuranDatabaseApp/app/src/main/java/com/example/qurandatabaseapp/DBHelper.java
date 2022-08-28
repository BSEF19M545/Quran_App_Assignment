package com.example.qurandatabaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

//    public static final String STUDENT_ID = "StudentID";
//    public static final String STUDENT_NAME = "StudentName";
//    public static final String STUDENT_ROLL = "StudentRollNumber";
//    public static final String STUDENT_ENROLL = "IsEnrolled";
//    public static final String STUDENT_TABLE = "StudentTable";

        public static final String SURAH_TABLE = "tsurah";
        public static final String AYAH_TABLE = "tayah";
        public static final String ARABIC_COLUMN = "Arabic Text";



    public DBHelper(@Nullable Context context) {
        super(context, "MyDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String createTableSTatementOne = "CREATE TABLE CustTable(CustomerID Integer PRIMARY KEY AUTOINCREMENT, " + CUSTOMER_NAME_FIRST + " Text, CustomerAge Int, ActiveCustomer BOOL) ";
//        String createTableSTatement = "CREATE TABLE " + STUDENT_TABLE + "(" +
//                STUDENT_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + STUDENT_NAME + " Text, "
//                + STUDENT_ROLL + " Int, " + STUDENT_ENROLL + " BOOL) ";
//        db.execSQL(createTableSTatement);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
//        onCreate(db);
    }

//    public ArrayList<String>  getSurahList(){
    public ArrayList<surahListModel>  getSurahList(){

        SQLiteDatabase db = this.getReadableDatabase();
        String Query = "Select * from " + SURAH_TABLE ;
        Cursor cursor = db.rawQuery(Query, null);
        ArrayList<surahListModel> rtn=new ArrayList<surahListModel>();
//        ArrayList<String> rtn=new ArrayList<String>();

        if(!(cursor.getCount() <= 0)){
            while(cursor.moveToNext()) {
//                rtn.add(cursor.getString(0)+"    "+cursor.getString(2)+"    "+cursor.getString(4));
                rtn.add(new surahListModel(Integer.parseInt(cursor.getString(0)),cursor.getString(2)));
            }
        }

        cursor.close();
        db.close();
        return rtn;
    }
        public ArrayList<QuranDisplayModelData>  getSurah(int suraId){

            SQLiteDatabase db = this.getReadableDatabase();
            String Query = "Select \""+ARABIC_COLUMN+"\" ,\"Dr Mohsin Khan\" from " + AYAH_TABLE+ " WHERE AyaId =0 or SuraID =" + suraId;
            Cursor cursor = db.rawQuery(Query, null);
            ArrayList<QuranDisplayModelData> rtn=new ArrayList<QuranDisplayModelData>();
            if(!(cursor.getCount() <= 0)){
                while(cursor.moveToNext()) {
                    rtn.add(new QuranDisplayModelData(cursor.getString(0),cursor.getString(1)));
                }
            }

            cursor.close();
            db.close();
            return rtn;
        }

//        public ArrayList<String> getParaList() {
        public ArrayList<surahListModel> getParaList() {
            SQLiteDatabase db = this.getReadableDatabase();
            String Query = "Select * from " + AYAH_TABLE ;
            Cursor cursor = db.rawQuery(Query, null);
            ArrayList<surahListModel> rtn=new ArrayList<surahListModel>();
//            ArrayList<String> rtn=new ArrayList<String>();
            //english urdu ka chakr hai abhi
            QDH qdh=new QDH();
            ArrayList<String> paraName = new ArrayList<>();
            paraName=qdh.GetParahNameEnglish();
            int i=0;
            /*if(!(cursor.getCount() <= 0)){
                while(cursor.moveToNext()) {
                    rtn.add(cursor.getString(10));
                }
            }*/
            while(i<paraName.size())
            {
//                rtn.add((i+1)+"   "+paraName.get(i));
                rtn.add(new surahListModel(i+1,paraName.get(i)));
                i++;
            }

            cursor.close();
            db.close();
            return rtn;

        }

    public ArrayList<QuranDisplayModelData> getPara(int paraId) {
        SQLiteDatabase db = this.getReadableDatabase();
        String Query = "Select \""+ARABIC_COLUMN+"\", \" Dr Mohsin Khan \" from " + AYAH_TABLE+ " WHERE AyaId =0 or ParaID =" + paraId;

        /*if(paraId==0)
        {
            Query = "Select \""+ARABIC_COLUMN+"\" from " + AYAH_TABLE+ " WHERE AyaId =0 or ParaID =" + paraId;
        }*/
        Cursor cursor = db.rawQuery(Query, null);
        ArrayList<QuranDisplayModelData> rtn=new ArrayList<QuranDisplayModelData>();
        if(!(cursor.getCount() <= 0)){
            while(cursor.moveToNext()) {
                rtn.add(new QuranDisplayModelData(cursor.getString(0),cursor.getString(1)));
            }
        }

        cursor.close();
        db.close();
        return rtn;
    }


//        cv.put(STUDENT_NAME, Student.getName());
//        cv.put(STUDENT_ROLL, Student.getRollNumber());
//        cv.put(STUDENT_ENROLL, Student.isEnroll());
//        db.insert(STUDENT_TABLE, null, cv);
//        db.close();


//        return true;

    }
    /*public boolean deleteRecord(int roll)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        boolean rtn=db.delete(STUDENT_TABLE, STUDENT_ROLL + "=" + roll, null) > 0;
        db.close();

        return rtn;
    }
    public boolean searchRecord(int roll)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String Query = "Select * from " + STUDENT_TABLE + " where " + STUDENT_ROLL + " = " + roll;
        Cursor cursor = db.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            db.close();
            return false;
        }
        cursor.close();
        db.close();
        return true;
    }

    public boolean updateRecord(int roll,String name,boolean enroll)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data=new ContentValues();
        data.put(STUDENT_NAME,name);
        data.put(STUDENT_ENROLL,enroll);
        int rtn=db.update(STUDENT_TABLE, data, STUDENT_ROLL+"=" + roll, null);
//        boolean rtn=db.delete(STUDENT_TABLE, STUDENT_ROLL + "=" + roll, null) > 0;
        db.close();
        if(rtn>0)
            return true;
        return false;
        //return rtn;
    }

    public ArrayList<Student> getAllStudents() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + STUDENT_TABLE, null);

        ArrayList<Student> studentArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {

                studentArrayList.add(new Student(cursorCourses.getString(1),
                        cursorCourses.getInt(2),
                        cursorCourses.getInt(3) == 1 ? true : false));
            } while (cursorCourses.moveToNext());

        }

        cursorCourses.close();
        return studentArrayList;
    }

    }*/
//}
