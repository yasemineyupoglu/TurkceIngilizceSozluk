package com.example.sozlukuygulamasi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class KelimelerDao {
    public ArrayList<Kelimeler> tümKelimeler(Veritabani vt){
        ArrayList<Kelimeler> kelimelerArrayList=new ArrayList<>();

        SQLiteDatabase db=vt.getWritableDatabase();

        Cursor c=db.rawQuery("SELECT * FROM kelimeler",null);
        while (c.moveToNext()){
            Kelimeler k =new Kelimeler(c.getInt(c.getColumnIndex("kelime_id"))
            ,c.getString(c.getColumnIndex("ingilizce"))
            ,c.getString(c.getColumnIndex("turkce")));

            kelimelerArrayList.add(k);
        }
        return kelimelerArrayList;
    }

    public ArrayList<Kelimeler> kelimeAra(Veritabani vt, String araKelime){
        ArrayList<Kelimeler> kelimelerArrayList=new ArrayList<>();

        SQLiteDatabase db=vt.getWritableDatabase();

        Cursor c=db.rawQuery("SELECT * FROM kelimeler WHERE ingilizce like '%"+araKelime+"%'",null);
        while (c.moveToNext()){
            Kelimeler k =new Kelimeler(c.getInt(c.getColumnIndex("kelime_id"))
                    ,c.getString(c.getColumnIndex("ingilizce"))
                    ,c.getString(c.getColumnIndex("turkce")));

            kelimelerArrayList.add(k);
        }
        return kelimelerArrayList;
    }
}
