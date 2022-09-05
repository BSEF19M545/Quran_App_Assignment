package com.example.qurandatabaseapp;

public class QuranDisplayModelData_V2 {
    String Arabic,TranslationUrdu,TranslationEnglish;

    public QuranDisplayModelData_V2(String arabic, String translationUrdu,String translationEnglish) {
        Arabic = arabic;
        TranslationUrdu = translationUrdu;
        TranslationEnglish=translationEnglish;
    }

    public String getArabic() {
        return Arabic;
    }

    public void setArabic(String arabic) {
        Arabic = arabic;
    }

    public String getTranslationUrdu() {
        return TranslationUrdu;
    }

    public void setTranslationUrdu(String translationUrdu) {
        TranslationUrdu = translationUrdu;
    }

    public String getTranslationEnglish() {
        return TranslationEnglish;
    }

    public void setTranslationEnglish(String translationEnglish) {
        TranslationEnglish = translationEnglish;
    }
}
