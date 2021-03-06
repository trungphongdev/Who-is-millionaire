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
        database.execSQL("INSERT INTO tblQuestion VALUES(null,1,'V???ng ch??? nh??, g??...','V???c ni??u t??m','M???c ??u??i t??m&??n tr???m t??m&M??? ch???t t??m')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,1,'Lo???i c??? n??o gi??p v???t th????ng mau l??nh, kh??ng ????? l???i s???o?','Ngh???','G???ng&Gi???ng&H??nh')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,1,' M???nh v??..., b???o v?? ti???n','G???o','S??m&K???o&B??nh')");

        database.execSQL("INSERT INTO tblQuestion VALUES(null,2,' Th???c ??n n??o sau ????y thu???c nh??m th???c ??n ch???a nhi???u b???t ???????ng?','G???o','T??m&Cua&C??')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,2,' C??u 2 : ????n v??? ??o dung l?????ng b??? nh??? n??o l???n nh???t','TB','GB&MB&Bit')");

        database.execSQL("INSERT INTO tblQuestion VALUES(null,3,'Trong c??c s??? do d?????i ????y, s??? ??o n??o b???ng 25,08 km ?','25080m','25080cm&25080dm&25080mm')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,3,'Giao ??i???m 3 ???????ng trung tr???c c???a tam gi??c g???i l?? ?','T??m ???????ng tr??n ngo???i ti???p','T??m ???????ng tr??n n???i ti???p&T??m ???????ng tr??n gi??n ti???p&T??m ???????ng tr??n tr???c ti???p')");

        database.execSQL("INSERT INTO tblQuestion VALUES(null,4,' Ng???n n??i n??o cao nh???t Nh???t B???n ?','Ph?? S??','Tr?????ng S??n&Takao&Asahi')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,4,'T??c ph???m b???t ?????u b???ng ti???ng tr???ng thu kh??ng ','Hai ?????a tr???','Hai b???n tr???&Hai ??ng ch??u&Hai b???n')");

        database.execSQL("INSERT INTO tblQuestion VALUES(null,5,' Li??n ??o??n b??ng ???? ??c thu???c li??n ??o??n b??ng ???? n??o ?','Ch??u ??','Ch??u ??u&Ch??u Phi&Ch??u M??')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,5,'Th??ng Long H?? N???i 1000 tu???i v??o n??m n??o? ','2010','2011&2012&2013')");

        database.execSQL("INSERT INTO tblQuestion VALUES(null,6,'Th??ng Long H?? N???i 1000 tu???i v??o n??m n??o? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,6,'Th??ng Long H?? N???i 1000 tu???i v??o n??m n??o? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,7,'Th??ng Long H?? N???i 1000 tu???i v??o n??m n??o? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,8,'Th??ng Long H?? N???i 1000 tu???i v??o n??m n??o? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,9,'Th??ng Long H?? N???i 1000 tu???i v??o n??m n??o? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,10,'Th??ng Long H?? N???i 1000 tu???i v??o n??m n??o? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,11,'Th??ng Long H?? N???i 1000 tu???i v??o n??m n??o? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,12,'Th??ng Long H?? N???i 1000 tu???i v??o n??m n??o? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,13,'Th??ng Long H?? N???i 1000 tu???i v??o n??m n??o? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,14,'Th??ng Long H?? N???i 1000 tu???i v??o n??m n??o? ','2010','2011&2012&2013')");
        database.execSQL("INSERT INTO tblQuestion VALUES(null,15,'Th??ng Long H?? N???i 1000 tu???i v??o n??m n??o? ','2010','2011&2012&2013')");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
