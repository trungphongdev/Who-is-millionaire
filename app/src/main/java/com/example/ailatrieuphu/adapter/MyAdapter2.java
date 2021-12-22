package com.example.ailatrieuphu.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ailatrieuphu.R;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
    String arr_Question[];
    String arr_NumberCoins[];
    Context contText;
    int myImgQuestion, myImgCoins;
    int viTriCauHoi =1;
    int coins = 10;
    public MyAdapter2(Context mcontText, String arr_Question[] , String arr_NumberCoins[], int myImgQuestion, int myImgCoins) {
        this.contText = mcontText;
        this.arr_Question = arr_Question;
        this.arr_NumberCoins = arr_NumberCoins;
        this.myImgQuestion = myImgQuestion;
        this.myImgCoins = myImgCoins;
    }

    public void setViTriCauHoi(int viTriCauHoi) {
        this.viTriCauHoi = viTriCauHoi;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(contText);
        View view = layoutInflater.inflate(R.layout.layout_row_item_drawerlayout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        int pos = 15-position;
            if ((pos) % 5 != 0) {
                holder.imgQuestion.setImageResource(myImgQuestion);
                holder.imgCoins.setImageResource(myImgCoins);
                holder.tvCoins.setText(arr_NumberCoins[position]);
                holder.tvQuestion.setText(arr_Question[position]);
                holder.tvQuestion.setTextColor(Color.YELLOW);
                holder.tvCoins.setTextColor(Color.YELLOW);
            }
        else {
            holder.imgQuestion.setImageResource(myImgQuestion);
            holder.imgCoins.setImageResource(myImgCoins);
            holder.tvCoins.setText(arr_NumberCoins[position]);
            holder.tvQuestion.setText(arr_Question[position]);
        }
        if(pos == viTriCauHoi) {
            holder.tvQuestion.setBackgroundColor(Color.GRAY);
            holder.tvCoins.setBackgroundColor(Color.GRAY);

        }


    }

    @Override
    public int getItemCount() {
        return arr_Question.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgQuestion, imgCoins;
        private TextView tvQuestion, tvCoins;
        LinearLayout linearLayoutAdapter;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgQuestion = itemView.findViewById(R.id.image_icon_question_row);
            tvQuestion = (TextView) itemView.findViewById(R.id.text_view_number_quesion_row);
            imgCoins = (ImageView) itemView.findViewById(R.id.image_view_icon_coins_row);
            tvCoins = (TextView) itemView.findViewById(R.id.text_view_coins_number_row);
            linearLayoutAdapter = (LinearLayout) itemView.findViewById(R.id.linear_layout_adapter_row);
        }
    }
}
