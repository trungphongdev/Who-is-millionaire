package com.example.ailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ailatrieuphu.adapter.MyAdapter3;
import com.example.ailatrieuphu.object.DBHelper;
import com.example.ailatrieuphu.object.Infor_Millionaries;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 private Button btnStart,btnTrop;
 private  EditText edtName;
 private ImageView anim_coins;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


    }
    private  void initView() {
        btnStart = (Button) findViewById(R.id.button_start);
        edtName = (EditText) findViewById(R.id.edit_text_Name);
        anim_coins = (ImageView) findViewById(R.id.anim_coins_img);
        btnTrop = (Button) findViewById(R.id.button_trophy) ;
        btnTrop.setOnClickListener(this);
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.animation_translate);
        anim_coins.startAnimation(animation);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtName.setVisibility(View.VISIBLE);
                edtName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if(actionId == EditorInfo.IME_ACTION_DONE) {
                            Toast.makeText(MainActivity.this,edtName.getText().toString(),Toast.LENGTH_SHORT).show();
                            return true;

                        }
                        return false;
                    }
                });
                if ( edtName.getText().toString().length()== 0) {
                    Toast.makeText(MainActivity.this,"input your name before play",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtra("name",edtName.getText().toString().trim());
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
        startActivity(intent);
    }

}