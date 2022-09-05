package com.example.qurandatabaseapp;

public class surahListModel_V2 {
    int surahNO;
    String surahNameEnglish,getSurahNameUrdu;//,getGetSurahNameArabic;

    public surahListModel_V2(int surahNO, String surahNameEnglish, String getSurahNameUrdu/*, String getGetSurahNameArabic*/) {
        this.surahNO = surahNO;
        this.surahNameEnglish = surahNameEnglish;
        this.getSurahNameUrdu = getSurahNameUrdu;
//        this.getGetSurahNameArabic = getGetSurahNameArabic;
    }

    public int getSurahNO() {
        return surahNO;
    }

    public void setSurahNO(int surahNO) {
        this.surahNO = surahNO;
    }

    public String getSurahNameEnglish() {
        return surahNameEnglish;
    }

    public void setSurahNameEnglish(String surahNameEnglish) {
        this.surahNameEnglish = surahNameEnglish;
    }

    public String getSurahNameUrdu() {
        return getSurahNameUrdu;
    }

    public void setSurahNameUrdu(String getSurahNameUrdu) {
        this.getSurahNameUrdu = getSurahNameUrdu;
    }

    /*public String getGetGetSurahNameArabic() {
        return getGetSurahNameArabic;
    }

    public void setGetGetSurahNameArabic(String getGetSurahNameArabic) {
        this.getGetSurahNameArabic = getGetSurahNameArabic;
    }*/
}