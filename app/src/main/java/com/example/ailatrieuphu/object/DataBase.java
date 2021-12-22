package com.example.ailatrieuphu.object;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;

public class DataBase extends SQLiteOpenHelper {
    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void Query(String Sql) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL(Sql);
    }
    public Question getData(int id) {
        ArrayList<Question> list = new ArrayList();
        Random random = new Random();
        SQLiteDatabase database = this.getReadableDatabase();
//        String sql = "SELECT * FROM tblQuestion Where NUMBER=?",new String[]{Integer.toString(id)}
        String sql = "SELECT * FROM tblQuestion Where NUMBER="+id;
        Cursor res = database.rawQuery(sql,null);
        while (res.moveToNext()) {
            String content = res.getString(2);
            String correct = res.getString(3);
            String incorrect = res.getString(4);
            list.add(createQuestion(content,correct,incorrect));
           // res.moveToFirst();
        }
        return list.get(random.nextInt(list.size()));

    }
    private  Question createQuestion(String question_content ,String correct , String incorrect) {
        Question question = new Question();
        question.setQuestions(question_content);
        question.setCorrect(correct);
        question.setIncorrect(incorrect);
        return question;
    }
    public void inSertTable() {
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("CREATE TABLE IF NOT EXISTS tblQuestion(ID INTEGER PRIMARY KEY AUTOINCREMENT , NUMBER INTEGER , CONTENT_QUESTION NVARCHAR(100) , CORRECT NVARCHAR(100), INCORRECT NVARCHAR(100))");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,1,'Vắng chủ nhà, gà...','Vọc niêu tôm','Mọc đuôi tôm&Ăn trộm tôm&Mổ chết tôm')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,1,'Loại củ nào giúp vết thương mau lành, không để lại sẹo?','Nghệ','Gừng&Giềng&Hành')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,1,' Mạnh vì..., bạo vì tiền','Gạo','Sâm&Kẹo&Bánh')");

        database.execSQL("INSERT INTO tblQuestion VALUES(null,2,' Thức ăn nào sau đây thuộc nhóm thức ăn chứa nhiều bột đường?','Gạo','Tôm&Cua&Cá')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,2,' Câu 2 : Đơn vị đo dung lượng bộ nhớ nào lớn nhất','TB','GB&MB&Bit')");

        database.execSQL("INSERT INTO tblQuestion VALUES(null,3,'Trong các số do dưới đây, số đo nào bằng 25,08 km ?','25080m','25080cm&25080dm&25080mm')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,3,'Giao điểm 3 đường trung trực của tam giác gọi là ?','Tâm đường tròn ngoại tiếp','Tâm đường tròn nội tiếp&Tâm đường tròn gián tiếp&Tâm đường tròn trực tiếp')");

        database.execSQL("INSERT INTO tblQuestion VALUES(null,4,' Ngọn núi nào cao nhất Nhật Bản ?','Phú Sĩ','Trường Sơn&Takao&Asahi')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,4,'Tác phẩm bắt đầu bằng tiếng trống thu không ','Hai đứa trẻ','Hai bạn trẻ&Hai ông cháu&Hai bạn')");

        database.execSQL("INSERT INTO tblQuestion VALUES(null,5,' Liên đoàn bóng đá Úc thuộc liên đoàn bóng đá nào ?','Châu Á','Châu Âu&Châu Phi&Châu Mĩ')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,5,'Thăng Long Hà Nội 1000 tuổi vào năm nào? ','2010','2011&2012&2013')");

        database.execSQL("INSERT INTO tblQuestion VALUES(null,6,'Thăng Long Hà Nội 1000 tuổi vào năm nào? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,6,'Thăng Long Hà Nội 1000 tuổi vào năm nào? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,7,'Thăng Long Hà Nội 1000 tuổi vào năm nào? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,8,'Thăng Long Hà Nội 1000 tuổi vào năm nào? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,9,'Thăng Long Hà Nội 1000 tuổi vào năm nào? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,10,'Thăng Long Hà Nội 1000 tuổi vào năm nào? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,11,'Thăng Long Hà Nội 1000 tuổi vào năm nào? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,12,'Thăng Long Hà Nội 1000 tuổi vào năm nào? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,13,'Thăng Long Hà Nội 1000 tuổi vào năm nào? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,14,'Thăng Long Hà Nội 1000 tuổi vào năm nào? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,15,'Thăng Long Hà Nội 1000 tuổi vào năm nào? ','2010','2011&2012&2013')");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
