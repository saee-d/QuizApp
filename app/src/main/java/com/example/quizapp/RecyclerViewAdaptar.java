package com.example.quizapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdaptar extends RecyclerView.Adapter<RecyclerViewAdaptar.ViewHolder>{

    private final Context context;
    private final List<Questions> quizResults;

    public RecyclerViewAdaptar(Context context, List<Questions> l){
        this.context = context;
        quizResults = l;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_result_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Questions quizResult = quizResults.get(position);
//        holder.bind(quizResult);

        holder.data=quizResults.get(position);
        holder.question.setText(holder.data.getQuestion());
        holder.cAns.setText(String.valueOf(holder.data.getCorrectAnswer()));
        holder.yAns.setText(holder.data.getUserAnswer());
    }

    @Override
    public int getItemCount() {
        return quizResults.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView question, cAns, yAns;
        Questions data;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.question);
            cAns = itemView.findViewById(R.id.correctans);
            yAns = itemView.findViewById(R.id.yourans);
        }

//        @SuppressLint("SetTextI18n")
//        public void bind(Questions quizResult) {
//            String q = quizResult.getQuestion();
//            String cns = quizResult.getCorrectAnswer();
//            String yns = quizResult.getUserAnswer();
//            question.setText(q);
//            cAns.setText(cns);
//            yAns.setText(yns);
//        }
    }
}
