package com.example.ailatrieuphu.object;

import java.util.ArrayList;

public class Question {
    private  String questions;
    private  String correct;
    private ArrayList<String> arrincorrect;

    public  Question() {}

    public Question(String questions, String correct, ArrayList<String> incorrect) {
        this.questions = questions;
        this.correct = correct;
        this.arrincorrect = incorrect;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public ArrayList<String> getIncorrect() {
        return arrincorrect;
    }

    public void setIncorrect(String incorrect) {
        String[] split_incorrect = incorrect.split("&");
        arrincorrect = new ArrayList<>();
        for(String s : split_incorrect) {
            arrincorrect.add(s);
        }
    }
}
