package com.example.ailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ailatrieuphu.adapter.MyAdapter3;
import com.example.ailatrieuphu.object.DBHelper;
import com.example.ailatrieuphu.object.Infor_Millionaries;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView3;
    MyAdapter3 myAdapter3;
    Button btnHome3;
    int i = 0;
    private DBHelper db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        db = new DBHelper(this);
        recyclerView3 = (RecyclerView) findViewById(R.id.recyclerView3);
        btnHome3 = (Button) findViewById(R.id.buttonHome3);
        ArrayList<Infor_Millionaries> list = new ArrayList<>();
        list = db.getDataInfor();
        myAdapter3  = new MyAdapter3(this,list);
        recyclerView3.setAdapter(myAdapter3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        myAdapter3.notifyDataSetChanged();
        btnHome3.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
    //    db.dropTable();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);

    }

}