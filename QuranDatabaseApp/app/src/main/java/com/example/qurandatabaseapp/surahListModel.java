package com.example.qurandatabaseapp;

public class surahListModel {
    int surahNO;
    String surahName;

    public int getSurahNO() {
        return surahNO;
    }

    public surahListModel(int surahNO, String surahName) {
        this.surahNO = surahNO;
//        this.surahNameArabic = surahNameArabic;
        this.surahName = surahName;
    }

    public void setSurahNO(int surahNO) {
        this.surahNO = surahNO;
    }


    public String getSurahName() {
        return surahName;
    }

    public void setSurahName(String surahName) {
        this.surahName = surahName;
    }
}
