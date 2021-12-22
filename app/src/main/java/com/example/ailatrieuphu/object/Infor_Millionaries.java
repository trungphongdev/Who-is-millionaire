package com.example.ailatrieuphu.object;

public class Infor_Millionaries {
    private String name;
    private int number_coins;
    private String number_ques;

    public Infor_Millionaries( String name, int coins, String ques) {
        this.name = name;
        this.number_coins = coins;
        this.number_ques = ques;
    }

    public String getNumber_ques() {
        return  number_ques;
    }

    public void setNumber_ques(String number_ques) {
        this.number_ques = number_ques;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber_coins() {
        return number_coins;
    }

    public void setNumber_coins(int number_coins) {
        this.number_coins = number_coins;
    }
}
