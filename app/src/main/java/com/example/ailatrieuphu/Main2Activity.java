package com.example.ailatrieuphu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ailatrieuphu.adapter.MyAdapter2;
import com.example.ailatrieuphu.adapter.MyAdapter3;
import com.example.ailatrieuphu.object.DBHelper;
import com.example.ailatrieuphu.object.DataBase;
import com.example.ailatrieuphu.object.FakeData;
import com.example.ailatrieuphu.object.Infor_Millionaries;
import com.example.ailatrieuphu.object.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main2Activity extends AppCompatActivity  {
    RecyclerView recyclerViewMain2;
    MyAdapter2 myAdapter2;
    String question_number[], coin_number[];
    Question question;
    TextView tvQuestions, tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4,
            tvQuestionsNumber, tvResult, tvName, tvCoins_current, tvCount_Down_Timer,
            tvReminder;
    int vitricauhoi = 1,vitri_score=-1;
    int coins = 10;
    ArrayList<TextView> arrAnswer_textview;
    String result, playername;
    ImageView imgCoin_anim;
    FakeData fakeData;
    boolean choose5050 = true, changQuestion, reminder;
    View.OnClickListener listener;
    Button btnSaveScore, btnHome2;
    LinearLayout layoutResult2;
    AlertDialog.Builder builder;
    private final long SET_TIMER = 30000;
    int format_time = (int) SET_TIMER;
    CountDownTimer countDownTimer ,timeShowquestion;
    DBHelper db;
    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        initView();
        reCycleView();
        showQuestion();
        setClick();
        getNameFromIntent();
        anim();
    }
    private void init() {
        question_number = getResources().getStringArray(R.array.question_number);
        coin_number = getResources().getStringArray(R.array.coin_number);
        arrAnswer_textview = new ArrayList<>();
        fakeData = new FakeData();
        db = new DBHelper(this);
        dataBase = new DataBase(this,"Questiondb.sqlite",null,1);
        dataBase.inSertTable();
    }

    private void initView() {
        recyclerViewMain2 = (RecyclerView) findViewById(R.id.recyclerview_item);
        tvQuestions = (TextView) findViewById(R.id.text_view_question);
        tvAnswer1 = (TextView) findViewById(R.id.text_view_A);
        tvAnswer2 = (TextView) findViewById(R.id.text_view_B);
        tvAnswer3 = (TextView) findViewById(R.id.text_view_C);
        tvAnswer4 = (TextView) findViewById(R.id.text_view_D);
        tvQuestionsNumber = (TextView) findViewById(R.id.text_view_question_number);
        tvName = (TextView) findViewById(R.id.text_view_name);
        imgCoin_anim = (ImageView) findViewById(R.id.img_coins_rotate);
        tvResult = (TextView) findViewById(R.id.text_view_result2);
        tvCoins_current = (TextView) findViewById(R.id.text_view_coins_current);
        btnHome2 = (Button) findViewById(R.id.button_home2);
        btnSaveScore = (Button) findViewById(R.id.button_savescore2);
        layoutResult2 = (LinearLayout) findViewById(R.id.linearlayout_result2);
        tvCount_Down_Timer = (TextView) findViewById(R.id.text_view_count_down);
        tvReminder = (TextView) findViewById(R.id.text_view_reminder);
        arrAnswer_textview.add(tvAnswer1);
        arrAnswer_textview.add(tvAnswer2);
        arrAnswer_textview.add(tvAnswer3);
        arrAnswer_textview.add(tvAnswer4);
    }

    private void reCycleView() {
        myAdapter2 = new MyAdapter2(Main2Activity.this, question_number, coin_number, R.drawable.icon_question, R.drawable.coin);
        recyclerViewMain2.setAdapter(myAdapter2);
        recyclerViewMain2.setLayoutManager(new LinearLayoutManager(this));
        myAdapter2.setViTriCauHoi(vitricauhoi);
        myAdapter2.notifyDataSetChanged();

    }


    private void setClick() {
        // create Listenr
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTime();
                checkResult((TextView) v);
            }
        };

        // set event click listener
        for (TextView views : arrAnswer_textview) {
            views.setOnClickListener(listener);
        }
    }

    private void showQuestion() {
        //question = fakeData.createQuestion(vitricauhoi);
        question = dataBase.getData(vitricauhoi);
        tvQuestions.setText(question.getQuestions());
        ArrayList<String> arrAnswer_String = new ArrayList<>(question.getIncorrect());
    /*    for(int i = 0 ; i< question.getIncorrect().size() ; i++) {
            arrAnswer_String.add(i,question.getIncorrect().get(i));
        }*/
        arrAnswer_String.add(question.getCorrect());
        Collections.shuffle(arrAnswer_String);  // random anser text arr
   /*     Random random = new Random();
            int vt1 = random.nextInt(arrAnswer.size());
            int vt2 = random.nextInt(arrAnswer.size());
            arrAnswer.set(vt1,arrAnswer.get(vt2));
            arrAnswer.set(vt2,arrAnswer.get(vt1));*/
        for (int i = 0; i < arrAnswer_textview.size(); i++) {
            arrAnswer_textview.get(i).setOnClickListener(listener);
            arrAnswer_textview.get(i).setVisibility(View.VISIBLE);
            String anwser_text = arrAnswer_String.get(i);
            arrAnswer_textview.get(i).setText(anwser_text);
            arrAnswer_textview.get(i).setBackgroundResource(R.drawable.design_answer);
        }
        tvReminder.setVisibility(View.INVISIBLE);
        format_time = 30000;
        CountDown();

    }


    private void checkResult(final TextView viewchoose) {
        result = viewchoose.getText().toString();
        viewchoose.setBackgroundResource(R.drawable.design_choose_answer);
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if (result.equals(question.getCorrect())) {
                    viewchoose.setBackgroundResource(R.drawable.design_right_answer);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f,0.3f);
                    alphaAnimation.setDuration(100);
                    alphaAnimation.setRepeatMode(alphaAnimation.REVERSE);
                    alphaAnimation.setRepeatCount(6);
                    viewchoose.startAnimation(alphaAnimation);
                    vitricauhoi++;
                    vitri_score++;
                    coins = coins + 10;
                    if (vitricauhoi > 15) {
                        vitricauhoi = 15;
                        myAdapter2.setViTriCauHoi(vitricauhoi);
                        myAdapter2.notifyDataSetChanged();
                        layoutResult2.setVisibility(View.VISIBLE);
                        tvResult.setText("Congratulations winner is player " + playername + "you are Millionare" + coins);
                        vitri_score++;
                        db.insertInfor(playername,String.valueOf(coins),String.valueOf(vitricauhoi));
                        ButtonHome_SaveScore();
                        return;

                    }
                    tvQuestionsNumber.setText("Ques:" + vitricauhoi);
                    tvCoins_current.setText("" + (coins));

                } else {
                    viewchoose.setBackgroundResource(R.drawable.design_false_answer);
                    timeShowquestion.cancel();
                  //  vitricauhoi--;
                    Toast.makeText(Main2Activity.this, "You choose wrong", Toast.LENGTH_SHORT).show();
                    if (vitricauhoi <= 0) {
                        vitricauhoi = 1;
                    }
                    tvQuestionsNumber.setText("Ques:"+ vitricauhoi);
                    new CountDownTimer(2000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }
                        @Override
                        public void onFinish() {

                            for (TextView views : arrAnswer_textview) {
                                if (views.getText().toString().equals(question.getCorrect())) {
                                    views.setBackgroundResource(R.drawable.design_right_answer);
                                }
                            }
                            new CountDownTimer(2000,1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {

                                }

                                @Override
                                public void onFinish() {
                                    layoutResult2.setVisibility(View.VISIBLE);
                                    tvResult.setText("Congratulations player " + playername + "has won" + coins);
                                    vitri_score++;
                                    ButtonHome_SaveScore();
                                }
                            }.start();

                        }
                    }.start();


                }
            }
        }.start();
        timeShowquestion  = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                showQuestion();
            }
        }.start();


    }

    private void getNameFromIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("name")) {
            playername = intent.getStringExtra("name");
            tvName.setText(playername);
        }
    }

    private void anim() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.coin_anim);
        imgCoin_anim.startAnimation(animation);
    }

    private void ButtonHome_SaveScore() {
        btnHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnSaveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("name",playername);
                intent.putExtra("ques",String.valueOf(vitricauhoi));
                intent.putExtra("coin",String.valueOf(coins));
                db.insertInfor(playername,String.valueOf(coins),String.valueOf(vitricauhoi));
                startActivity(intent);
            }
        });
    }


    private void CountDown() {

        countDownTimer = new CountDownTimer(format_time, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                format_time = (int) (millisUntilFinished);
                timeFormat();
            }

            @Override
            public void onFinish() {
                layoutResult2.setVisibility(View.VISIBLE);

                tvResult.setText(" Time out !!!!! \n  Congratulations player " + playername + "has won" + coins);
            }
        }.start();
    }

    private void stopTime() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void timeFormat() {
        int second = format_time / 1000;
        tvCount_Down_Timer.setText(second + "");
    }


    // choose item select help
    public void choose5050(View view) {

        if (choose5050 == false) {
            view.setClickable(false);
            Toast.makeText(this, "You had used this item before", Toast.LENGTH_LONG).show();
            return;
        }
        int remove2Answer = 2;
        do {
            Random random = new Random();
            int position_random = random.nextInt(arrAnswer_textview.size());
            TextView textView = arrAnswer_textview.get(position_random);
            if (textView.getVisibility() != View.INVISIBLE && textView.getText().equals(question.getCorrect()) != true) {
                textView.setVisibility(View.INVISIBLE);
                textView.setClickable(false);
                remove2Answer--;
            }

        } while (remove2Answer > 0);
        choose5050 = !choose5050;


    }

    public void changeQuestions(View view) {
        if (changQuestion == true) {
            view.setClickable(false);
            Toast.makeText(this, "You had used this item before", Toast.LENGTH_LONG).show();
            return;
        } else {
            stopTime();
            builder = new AlertDialog.Builder(this)
                    .setTitle("Change Questions Item")
                    .setIcon(R.drawable.icon_question)
                    .setMessage("Do you want to change questions" + vitricauhoi)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            showQuestion();
                            changQuestion = true;
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            changQuestion = false;
                            CountDown();
                        }
                    });
            builder.create();
            builder.show();
        }
    }

    public void chooseReminder(View view) {
        if (reminder == true) {
            view.setClickable(false);
            Toast.makeText(this, "You had used this item before", Toast.LENGTH_LONG).show();
            return;
        } else {
            stopTime();
            builder = new AlertDialog.Builder(this)
                    .setTitle("Reminder Questions Item")
                    .setIcon(R.drawable.icon_question)
                    .setMessage("Do you want to reveal questions" + vitricauhoi)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                           dialog_reminder();
                           CountDown();
                            reminder = true;
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            reminder = false;
                            CountDown();
                        }
                    });
            builder.create();
            builder.show();
        }
    }

    public void asked_the_Audience(View v) {
        String result =dataBase.getData(vitricauhoi).getCorrect();
        Dialog dialog = new Dialog(Main2Activity.this);
        dialog.setContentView(R.layout.asked_advice_audience);
        TextView tvA = (TextView) dialog.findViewById(R.id.tvA_dialog);
        TextView tvB = (TextView) dialog.findViewById(R.id.tvB_dialog);
        TextView tvC = (TextView) dialog.findViewById(R.id.tvC_dialog);
        TextView tvD = (TextView) dialog.findViewById(R.id.tvD_dialog);

            for(int i = 0 ;i < 4 ;i++) {
                Random r = new Random();
                int pcA ,pcB,pcC ,pcD;
                if (result.equals(arrAnswer_textview.get(0).getText().toString())) {
                    do {
                        pcA = r.nextInt(100);
                        pcB = r.nextInt(100);
                        pcC = r.nextInt(100);
                        pcD = r.nextInt(100);
                        if (pcA < pcB && pcA < pcC && pcA < pcD) {
                            continue;
                        }
                    } while ((pcA + pcB + pcC + pcD) != 100);
                    Log.d("check", (pcA + pcB + pcC + pcD) + result);
                    tvA.setText("" + pcA);
                    tvB.setText("" + pcB);
                    tvC.setText("" + pcC);
                    tvD.setText("" + pcD);
                }  if (result.equals(arrAnswer_textview.get(1).getText().toString())) {
                    do {
                        pcA = r.nextInt(100);
                        pcB = r.nextInt(100);
                        pcC = r.nextInt(100);
                        pcD = r.nextInt(100);
                        if (pcB < pcC && pcB < pcA && pcB < pcD) {
                            continue;
                        }
                    } while ((pcA + pcB + pcC + pcD) != 100);
                    Log.d("check", (pcA + pcB + pcC + pcD) + result);

                    tvA.setText("" + pcA);
                    tvB.setText("" + pcB);
                    tvC.setText("" + pcC);
                    tvD.setText("" + pcD);

                } if (result.equals(arrAnswer_textview.get(2).getText().toString())) {
                    do {
                        pcA = r.nextInt(100);
                        pcB = r.nextInt(100);
                        pcC = r.nextInt(100);
                        pcD = r.nextInt(100);
                        if (pcC < pcB && pcC < pcA && pcC < pcD) {
                            continue;
                        }
                    } while ((pcA + pcB + pcC + pcD) != 100);
                    Log.d("check", (pcA + pcB + pcC + pcD) + result);

                    tvA.setText("" + pcA);
                    tvB.setText("" + pcB);
                    tvC.setText("" + pcC);
                    tvD.setText("" + pcD);
                } if(result.equals(arrAnswer_textview.get(3).getText().toString())){
                    do {
                        pcA = r.nextInt(100);
                        pcB = r.nextInt(100);
                        pcC = r.nextInt(100);
                        pcD = r.nextInt(100);
                        if (pcD < pcB && pcD < pcC && pcD < pcA) {
                            continue;
                        }
                    } while ((pcA + pcB + pcC + pcD) != 100);
                    tvA.setText("" + pcA);
                    tvB.setText("" + pcB);
                    tvC.setText("" + pcC);
                    tvD.setText("" + pcD);
                    Log.d("check", (pcA + pcB + pcC + pcD) + result);

                }
            }
        dialog.show();
}

    private void dialog_reminder() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.reminder_dialog);
        dialog.setTitle("Choose Who you wanne take advice");
        final ImageView img_zukerberg =  dialog.findViewById(R.id.image_view_zukerberg);
        final ImageView img_trump =  dialog.findViewById(R.id.image_view_trump);
        final ImageView img_steavjob =  dialog.findViewById(R.id.image_view_steavjob);
        final ImageView img_putin =  dialog.findViewById(R.id.image_view_putin);
        final TextView tv_reminder = dialog.findViewById(R.id.textview_reminder_dialog);
        img_zukerberg.setClickable(true);
        img_putin.setClickable(true);
        img_steavjob.setClickable(true);
        img_trump.setClickable(true);
        View.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.image_view_zukerberg :
                    tv_reminder.setText("Mark Zukerberg say : "+ question.getCorrect());
                    img_putin.setClickable(false);
                    img_steavjob.setClickable(false);
                    img_trump.setClickable(false);
                    break;
                case R.id.image_view_steavjob :
                    tv_reminder.setText("Steav Job say : "+ question.getCorrect());
                    img_putin.setClickable(false);
                    img_zukerberg.setClickable(false);
                    img_trump.setClickable(false);
                    break;
                case R.id.image_view_trump:
                    tv_reminder.setText("Donald Trump say : "+ question.getCorrect());
                    img_putin.setClickable(false);
                    img_steavjob.setClickable(false);
                    img_zukerberg.setClickable(false);
                    break;
                case R.id.image_view_putin :
                    tv_reminder.setText("Vladimir Putin say : "+ question.getCorrect());
                    img_steavjob.setClickable(false);
                    img_steavjob.setClickable(false);
                    img_trump.setClickable(false);
                    break;
                default: break;
            }
        }
    };
        img_putin.setOnClickListener(listener1);
        img_steavjob.setOnClickListener(listener1);
        img_trump.setOnClickListener(listener1);
        img_zukerberg.setOnClickListener(listener1);
        dialog.create();
        dialog.show();

}


}