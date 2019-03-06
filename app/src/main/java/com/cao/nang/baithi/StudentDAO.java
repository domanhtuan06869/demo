package com.cao.nang.baithi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    DataBase dataBase;
    public StudentDAO(Context context) {
       this.dataBase=new DataBase(context);
    }
    public  long insert(Student student){
        long result=-1;
        ContentValues  cv= new ContentValues();
        cv.put("masv",student.masv);
        cv.put("tensv",student.tensv);
        cv.put("tuoi",student.tuoi);
        cv.put("email",student.email);
        SQLiteDatabase sqLiteDatabase=dataBase.getWritableDatabase();
       result= sqLiteDatabase.insert("SinhVien",null,cv);
        sqLiteDatabase.close();

    return  result;
    }
    public boolean update (Student student){
        ContentValues  cv= new ContentValues();
        cv.put("masv",student.masv);
        cv.put("tensv",student.tensv);
        cv.put("tuoi",student.tuoi);
        cv.put("email",student.email);
        SQLiteDatabase sqLiteDatabase=dataBase.getWritableDatabase();
        sqLiteDatabase.update("Sinhvien",cv, "masv = ?", new String[] { String.valueOf(student.masv) });
        sqLiteDatabase.close();
        return true;
    }
    public long remove(String masv){
        long result = -1;

        SQLiteDatabase sqLiteDatabase = dataBase.getWritableDatabase();
        result = sqLiteDatabase.delete("SinhVien", "masv =?", new String[]{masv});
        sqLiteDatabase.close();

        return result;
    }
    public List<Student> getAllstudent(){
        List<Student> list = new ArrayList<>();

        String query = "select * from Sinhvien";
        SQLiteDatabase db = dataBase.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);

        if(c != null){
            if(c.getCount() > 0){
                while (c.moveToNext()){
                    String masv = c.getString(0);
                    String tensv = c.getString(1);
                    int tuoi = Integer.parseInt(c.getString(2));
                    String email = c.getString(3);

                    Student student = new Student(masv,tensv,tuoi,email);
                    list.add(student);
                }
                c.close();
                db.close();
            }
        }

        return list;
    }
}
