package com.example.ailatrieuphu.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ailatrieuphu.R;
import com.example.ailatrieuphu.object.Infor_Millionaries;

import java.util.List;

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.ViewHoler> {
    List<Infor_Millionaries> millionariesList;
    Context context;
    public MyAdapter3( Context context , List<Infor_Millionaries> millionariesList) {
        this.context = context;
        this.millionariesList = millionariesList;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.layout_score_3,null);
        ViewHoler viewHoler = new ViewHoler(v);
        return viewHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
         Infor_Millionaries infor =millionariesList.get(position);
        holder.tvName.setText(infor.getName());
        holder.tvQues.setText(infor.getNumber_ques().toString());
        holder.tvCoins.setText(""+infor.getNumber_coins());

    }

    @Override
    public int getItemCount() {
        return millionariesList.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        TextView tvStt , tvName,tvCoins,tvQues;
        public ViewHoler(@NonNull View itemView) {
            super(itemView);
           // tvStt = (TextView) itemView.findViewById(R.id.text_view_stt3);
            tvName = (TextView) itemView.findViewById(R.id.textview_name3);
            tvCoins = (TextView) itemView.findViewById(R.id.textview_coin3);
            tvQues = (TextView) itemView.findViewById(R.id.textview_ques3);

        }
    }
}
