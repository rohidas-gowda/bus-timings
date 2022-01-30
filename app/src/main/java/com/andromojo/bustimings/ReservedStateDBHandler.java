package com.andromojo.bustimings;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class ReservedStateDBHandler extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BusInfo.db";
    private static String DATABASE_PATH = "/data/user/0/com.andromojo.bustimings/databases/";
    private final Context reservedStateContext;
    SQLiteDatabase reservedStateDataBase;

    public ReservedStateDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        this.reservedStateContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private boolean checkDatabase(){
        try{
            final String mPath = DATABASE_PATH + DATABASE_NAME;
            final File file = new File(mPath);
            if (file.exists())
                return true;
            else
                return false;
        } catch (SQLiteException e){
            e.printStackTrace();
            return false;
        }
    }

    private void copyDatabase() throws IOException{
        try{
            InputStream mInputStream = reservedStateContext.getAssets().open(DATABASE_NAME);
            String outFileName = DATABASE_PATH + DATABASE_NAME;
            OutputStream mOutputStream = new FileOutputStream(outFileName);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = mInputStream.read(buffer)) > 0){
                mOutputStream.write(buffer, 0, length);
            }
            mOutputStream.flush();
            mOutputStream.close();
            mInputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void createDatabase() throws IOException{
        boolean mDatabaseExist = checkDatabase();
        if (!mDatabaseExist){
            this.getReadableDatabase();
            this.close();
            try{
                copyDatabase();
            } catch (IOException mIOException){
                mIOException.printStackTrace();
                throw new Error("Error copying Database");
            } finally {
                this.close();
            }
        }
    }

    @Override
    public synchronized void close(){
        if (reservedStateDataBase != null){
            reservedStateDataBase.close();
            SQLiteDatabase.releaseMemory();
            super.close();
        }
    }

    public ArrayList<ReservedStateParameters> reservedStateInfoFromDB(String filterState){
        try{
            createDatabase();
        } catch (IOException e){
            e.printStackTrace();
        }

        reservedStateDataBase = this.getReadableDatabase();

        ArrayList<ReservedStateParameters> reservedStateParametersArrayList = new ArrayList<>();
        Cursor cursor = reservedStateDataBase.rawQuery("SELECT * from reserved_state WHERE state_name ='"+filterState+"'", null);
        while (cursor.moveToNext()){
            ReservedStateParameters reservedStateParameters = new ReservedStateParameters(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            reservedStateParametersArrayList.add(reservedStateParameters);
        }
        cursor.close();
        reservedStateDataBase.close();

        return reservedStateParametersArrayList;
    }
}
