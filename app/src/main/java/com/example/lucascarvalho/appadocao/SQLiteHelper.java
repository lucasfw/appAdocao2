package com.example.lucascarvalho.appadocao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by Lucas Carvalho on 16/10/2017.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String name, String descricao, byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO ANIMAIS VALUES (NULL, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindString(2, descricao);
        statement.bindBlob(3, image);

        statement.executeInsert();
    }

    public void updateData (String name, String descricao, byte[] image, int id){
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE ANIMAIS SET name = ?, descricao = ?, image = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1,name);
        statement.bindString(2,descricao);
        statement.bindBlob(3,image);
        statement.bindDouble(4,(double)id);

        statement.execute();
        database.close();
    }

    public Animal selectData(int id){
        String sql = "SELECT * FROM ANIMAIS WHERE id =" + id;
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();

        String nome = cursor.getString(cursor.getColumnIndex("name"));
        String descricao = cursor.getString(cursor.getColumnIndex("descricao"));
        byte[] image = cursor.getBlob(cursor.getColumnIndex("image"));
        StringBuilder conversor1 = new StringBuilder();
        StringBuilder conversor2 = new StringBuilder();
        StringBuilder conversor3 = new StringBuilder();
        conversor1.append(nome);
        conversor2.append(descricao);
        conversor3.append(image);
        Animal a = new Animal(id, conversor1.toString(), conversor2.toString(), image);
        return a;
    }

    public void deleteData(int id){
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM ANIMAIS WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double) id);

        statement.execute();
        database.close();
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
